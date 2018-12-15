import os
import urllib.request as urllib2

import requests
from bs4 import BeautifulSoup
from tqdm import tqdm


def GetPaperDataFromLink(url, publication_folder_name, output_folder_name):

    url_whole = url + publication_folder_name

    html_page = urllib2.urlopen(url_whole)
    soup = BeautifulSoup(html_page, 'html.parser', from_encoding="iso-8859-1")
    name_box = soup.find_all(['a'], href=True)
    pub_links = [element for element in [
        str(url + element.attrs['href']) for element in name_box] if ".pdf" in element]

    if not os.path.exists(output_folder_name):
        os.makedirs(output_folder_name)

    downloaded_file_paths = []

    for link in pub_links:
        response = requests.get(link, stream=True)
        file_name = link.split("/")[-1]
        full_path = output_folder_name + "/" + file_name
        downloaded_file_paths.append(full_path)

        if not os.path.exists(full_path) or os.path.getsize(full_path) <= 0:
            with open(full_path, "wb") as handle:
                for data in tqdm(response.iter_content()):
                    handle.write(data)

    return downloaded_file_paths

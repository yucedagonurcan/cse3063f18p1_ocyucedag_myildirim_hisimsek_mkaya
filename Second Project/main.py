import glob
import itertools
import os
import pickle
import re

import pandas as pd
import PyPDF2

import GenerateWordCloud
from DownloadPapers import GetPaperDataFromLink
from TfIdfCalculation import (CleanText, ComputeInverseDocumentFrequency,
                              ComputeTermFrequency, ComputeTFIDF,
                              SortReturnMostFromDataFrame)


def create_doc_text_dict():

    doc_text_dict = []
    pickle_file_name = "pickles/doc_text_dict_pickle"
    if not os.path.exists(pickle_file_name):
        for index, file in enumerate(file_paths, 0):

            pdfFileObj = open(file, 'rb')
            pdfReader = PyPDF2.PdfFileReader(pdfFileObj)

            doc_id = "doc_" + str(index)

            new_dict = {"doc_id": doc_id,
                        "text": ""}

            for page in range(pdfReader.numPages):
                pageObj = pdfReader.getPage(page)

                new_dict["text"] += (pageObj.extractText())

            doc_text_dict.append(new_dict)
            pdfFileObj.close()

        pickle_file = open(pickle_file_name, 'wb')
        pickle.dump(doc_text_dict, pickle_file)
        pickle_file.close()
        return doc_text_dict

    else:
        pickle_file = open(pickle_file_name, 'rb')
        doc_text_dict = pickle.load(pickle_file)
        return doc_text_dict


def create_corpus_tf():
    pickle_corpus_tf_file_name = "pickles/corpus_tf"
    if os.path.exists(pickle_corpus_tf_file_name):
        pickle_file = open(pickle_corpus_tf_file_name, 'rb')
        corpus_tf = pickle.load(pickle_file)
        pickle_file.close()
        return corpus_tf
    else:
        csv_folder_name = "csv_files"
        if not os.path.exists(csv_folder_name):
            os.makedirs(csv_folder_name)
        tf_csv_folder_path = "csv_files/tf"
        if not os.path.exists(tf_csv_folder_path):
            os.makedirs(tf_csv_folder_path)

        corpus_words = []
        corpus_tf = []
        for index, element in enumerate(doc_text_dict, 0):
            cleaned_word_array = CleanText(element)
            corpus_words.append(cleaned_word_array)

        word_set = set(itertools.chain.from_iterable(corpus_words))

        for index, element in enumerate(corpus_words, 0):

            term_frequency_values = ComputeTermFrequency(element, word_set)

            fifty_most_tf_values = SortReturnMostFromDataFrame(
                dataframe=term_frequency_values, sortby="Term Frequency", most_num_rows=50)

            corpus_tf.append(term_frequency_values)
            csv_file_path = tf_csv_folder_path + "/tf_list_" + \
                doc_text_dict[index]["doc_id"] + ".csv"
            fifty_most_tf_values.to_csv(
                csv_file_path, sep=',', encoding='utf-8', index=None)

        pickle_file = open(pickle_corpus_tf_file_name, 'wb')
        pickle.dump(corpus_tf, pickle_file)
        pickle_file.close()
        return corpus_tf


def create_tf_idf_matrix():
    picle_tf_idf_matrix_file_name = "pickles/tf_idf_matrix"
    if os.path.exists(picle_tf_idf_matrix_file_name):
        pickle_file = open(picle_tf_idf_matrix_file_name, 'rb')
        tf_idf_matrix = pickle.load(pickle_file)
        pickle_file.close()

        return tf_idf_matrix
    else:
        tf_idf_matrix = []
        tf_idf_csv_folder_path = "csv_files/tf_idf"
        if not os.path.exists(tf_idf_csv_folder_path):
            os.makedirs(tf_idf_csv_folder_path)

        for index, df_tf in enumerate(corpus_tf, 0):
            tf_idf_df = ComputeTFIDF(df_tf, idf_dict)
            document_name = "tf_idf_list_doc_" + str(index) + ".csv"
            tf_idf_df = SortReturnMostFromDataFrame(
                tf_idf_df, "TF-IDF Value", 50)
            tf_idf_df.to_csv(tf_idf_csv_folder_path + "/" +
                             document_name, sep=',', encoding='utf-8', index=None)
            tf_idf_matrix.append(tf_idf_df)

        pickle_file = open(picle_tf_idf_matrix_file_name, "wb")
        pickle.dump(tf_idf_matrix, pickle_file)
        pickle_file.close()
        return tf_idf_matrix


if os.getcwd().split("/")[-1] != "Second Project":
    os.chdir("Second Project")

file_paths = GetPaperDataFromLink(url="https://www.muratcanganiz.com",
                                  publication_folder_name="/publications",
                                  output_folder_name="data")
file_paths.pop(1)
file_paths.pop(4)
file_paths.pop(7)
file_paths.pop(8)
file_paths.pop(7)

pickle_folder_path = "pickles"
if not os.path.exists(pickle_folder_path):
    os.makedirs(pickle_folder_path)

doc_text_dict = create_doc_text_dict()
corpus_tf = create_corpus_tf()
idf_dict = ComputeInverseDocumentFrequency(corpus=corpus_tf)
tf_idf_matrix = create_tf_idf_matrix()

tf_files_list = glob.glob("csv_files/tf/*.csv")
tf_idf_files_list = glob.glob("csv_files/tf_idf/*.csv")
cloud_folder_name = "wordclouds"

if not os.path.exists(cloud_folder_name):
    os.makedirs(cloud_folder_name)

# Word Clouds for Term Frequencies
tf_cloud_folder_name = cloud_folder_name + "/tf"
tf_cloud_file_prefix = "tf_wordcloud_"
if not os.path.exists(tf_cloud_folder_name):
    os.makedirs(tf_cloud_folder_name)
for tf_file_path in tf_files_list:

    save_path = tf_cloud_folder_name + "/" +\
        tf_cloud_file_prefix +\
        re.findall("\d+", tf_file_path)[0] + ".pdf"

    generate_wc = GenerateWordCloud.WordCloudGenerator(
        from_file_path=tf_file_path)
    # generate_wc.show_cloud()
    generate_wc.save(save_path)

# Word Clouds for Term Frequencies*Inverse Term Frequencies : TF-IDF
tf_idf_cloud_folder_name = cloud_folder_name + "/tf_idf"
tf_idf_cloud_file_prefix = "tf_idf_wordcloud_"
if not os.path.exists(tf_idf_cloud_folder_name):
    os.makedirs(tf_idf_cloud_folder_name)
for tf_idf_file_path in tf_idf_files_list:

    # GenerateWordCloud.show_cloud(word_cloud_object)
    save_path = tf_idf_cloud_folder_name + "/" +\
        tf_idf_cloud_file_prefix +\
        re.findall("\d+", tf_idf_file_path)[0] + ".pdf"

    generate_wc = GenerateWordCloud.WordCloudGenerator(
        from_file_path=tf_idf_file_path)
    # generate_wc.show_cloud()
    generate_wc.save(save_path)
pass

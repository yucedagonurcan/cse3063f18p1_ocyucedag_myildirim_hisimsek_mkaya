import os
from os import path

import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from PIL import Image
from wordcloud import STOPWORDS, ImageColorGenerator, WordCloud


class WordCloudGenerator:
    def __init__(self, from_file_path):
        self.wordcloud_obj = WordCloud()

        df = pd.read_csv(from_file_path)
        column_list = df.columns.values.tolist()
        dict = pd.Series(df[column_list[1]].values,
                         index=df[column_list[0]]).to_dict()

        self.dict_to_cloud = dict
        self.fit()

    def save(self, save_path):
        self.wordcloud_obj.to_file(save_path)

    def fit(self):
        self.wordcloud_obj.generate_from_frequencies(
            frequencies=self.dict_to_cloud)

    def show_cloud(self):

        plt.figure(figsize=(20, 10))
        plt.imshow(self.wordcloud_obj, interpolation="bilinear")
        plt.axis("off")
        plt.show()

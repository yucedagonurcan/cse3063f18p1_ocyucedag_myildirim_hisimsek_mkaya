import collections
import string
from math import log10

import pandas as pd
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
import os


def getStopWordsList():
    file = open("stopwords.txt", "r+")
    stop_list = set(file.read().split("\n"))
    return stop_list


def CleanText(document_dict):
    text = document_dict['text']
    tokens = word_tokenize(text)
    # convert to lower case
    tokens = [w.lower() for w in tokens]
    # remove punctuation from each word
    table = str.maketrans('', '', string.punctuation)
    stripped = [w.translate(table) for w in tokens]
    # remove remaining tokens that are not alphabetic
    words = [word for word in stripped if word.isalpha()]
    # filter out stop words
    stop_words = getStopWordsList()
    words = [w for w in words if not w in stop_words and len(w) > 1]
    return words


def ComputeTermFrequency(doc_words, word_set):

    tf_dict = dict.fromkeys(word_set, 0)
    word_count = collections.Counter(doc_words)
    num_of_words = len(doc_words)

    for word, count in word_count.items():
        tf_dict[word] = count / num_of_words

    tf_df = pd.DataFrame({"Word": list(tf_dict.keys()),
                          "Term Frequency": list(tf_dict.values())})
    return tf_df


def ComputeTFIDF(df_tf, dict_idf):

    tf_idf = {}
    for index, row in df_tf.iterrows():
        current_word = row['Word']
        # TF-IDF Value = Term_frequency * Inverse_term_frequency
        tf_idf[current_word] = row['Term Frequency'] * dict_idf[current_word]

    tf_idf_df = pd.DataFrame({"Word": list(tf_idf.keys()),
                              "TF-IDF Value": list(tf_idf.values())})
    return tf_idf_df


def ComputeInverseDocumentFrequency(corpus):

    num_of_docs = len(corpus)
    idf_dict = dict.fromkeys((corpus[0]['Word']), 0)
    for df in corpus:
        for index, row in df.iterrows():
            if row['Term Frequency'] <= 0:
                break
            idf_dict[row['Word']] += 1

    for word, count in idf_dict.items():
        idf_dict[word] = log10(num_of_docs / float(count) + 1)
    return idf_dict


def SortReturnMostFromDataFrame(dataframe, sortby, most_num_rows):

    dataframe.sort_values(by=sortby, ascending=False,
                          na_position='last', inplace=True)
    return dataframe.iloc[:most_num_rows]

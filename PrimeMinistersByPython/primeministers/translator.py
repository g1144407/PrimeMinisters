#! /usr/bin/env python
# -*- coding: utf-8 -*-

import datetime
import os
import re

import table
import tuple

class Translator(object):
	"""トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。"""

	def __init__(self, input_table):
		"""トランスレータのコンストラクタ。"""
		self._csv_table = input_table
		self._html_table = table.Table("人目,代,氏名,ふりがな,在位期間,在位日数,出身校,政党,出身地,画像")
		return

	def compute_string_of_days(self, period):
		"""在位日数を計算して、それを文字列にして応答する。"""
		return None

	def compute_string_of_image(self, tuple):
		"""サムネイル画像から画像へ飛ぶためのHTML文字列を作成して、それを応答する。"""
		return None

	def table(self):
		"""総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、それを応答する。"""
		return self._html_table

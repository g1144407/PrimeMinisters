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
		period_list = period.split("〜")
		before_y = period_list[0].split("年")
		before_m = before_y[1].split("月")
		before_d = before_m[1].split("日")
		if period_list[1] == "":
			today = datetime.date.today()
			after_y = [today.year,""]
			after_m = [today.month,""]
			after_d = [today.day,""]
		else:
			after_y = period_list[1].split("年")
			after_m = after_y[1].split("月")
			after_d = after_m[1].split("日")
		before = datetime.date(int(before_y[0]), int(before_m[0]), int(before_d[0]))
		after = datetime.date(int(after_y[0]), int(after_m[0]), int(after_d[0]))
		period = after-before
		period = str(period.days+1)
		if len(period) > 3:
#lambda式使ってみた：文字列を配列とみなし1文字後にコンマを追加、最後に残りの要素を加える
			dot = lambda period : period[0]+","+period[1:]
			period = dot(period)
		return period

	def compute_string_of_image(self, a_tuple):
		"""サムネイル画像から画像へ飛ぶためのHTML文字列を作成して、それを応答する。"""
		values = a_tuple.values()
		names = a_tuple.attributes().names()
		tag = "<a name=\""+values[names.index("人目")]+"\" href=\""+values[names.index("画像")]+"\"><img class=\"borderless\" src=\""+values[names.index("縮小画像")]+"\" width=\"25\" height=\"32\" alt=\"0"+values[names.index("人目")]+".jpg\"></a>";
		return tag

	def table(self):
		"""総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、それを応答する。"""
#csvのattributeを持ってきて
#そのattributeのnamesリストへ各要素は何番目？って聞いて
#csvの各タプルを一つづつ取り出し、要素のリストへ上記の何番目？をぶち込んでる
		attribute_list = self._csv_table.attributes().names()
		for var in self._csv_table.tuples():
			tuple_value = var.values()
			values = [tuple_value[attribute_list.index("人目")],
					tuple_value[attribute_list.index("代")],
					tuple_value[attribute_list.index("氏名")],
					tuple_value[attribute_list.index("ふりがな")],
					tuple_value[attribute_list.index("在位期間")],
					self.compute_string_of_days(tuple_value[attribute_list.index("在位期間")]),
					tuple_value[attribute_list.index("出身校")],
					tuple_value[attribute_list.index("政党")],
					tuple_value[attribute_list.index("出身地")],
					self.compute_string_of_image(var)]
			self._html_table.add(tuple.Tuple(self._html_table.attributes(), values))
		return self._html_table
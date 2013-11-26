#! /usr/bin/env python
# -*- coding: utf-8 -*-

import csv


class IO(object):
	"""入出力：リーダ・ダウンローダ・ライタを抽象する。"""

	def read_csv(self, filename):
		"""指定されたファイルをCSVとして読み込む。"""
		f = open(filename, 'rU')
		
		u_csv_file = []
		try:
			csv_file = csv.reader(f)
			for row in csv_file:
				u_csv_file.append(unicode(row))
		finally:
			f.close()
		return u_csv_file

	def write_csv(self, filename, rows):
		"""指定されたファイルにCSVとして行たち(rows)を書き出す。"""
		return

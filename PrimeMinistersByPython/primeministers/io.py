#! /usr/bin/env python
# -*- coding: utf-8 -*-

import csv

class IO(object):
	"""入出力：リーダ・ダウンローダ・ライタを抽象する。"""

	def read_csv(self, filename):
		"""指定されたファイルをCSVとして読み込む。"""
		f = open(filename, 'rU')
		
		try:
#csvモジュールを使うと一行の[,]でもリストにしてくれる
#つまりReaderで用いるsprit(",")を行う必要がなくなる
#が、csvのreader()は返り値がunicode型であるため２バイト文字の場合バイトコードが格納されている
#decodeするにもリスト単位であるため難しい？
#http://qiita.com/laco0416/items/7895f4ab0aaebfa2afca
#現状は妥協案だが、標準のopenを用いている
#			reader = csv.reader(f)
#			for foo in reader:
#				print str(foo).decode('utf-8')
			csv_list = []
			for row in f:
				csv_list.append(row[:-1])
		finally:
			f.close()
			
		return csv_list

	def write_csv(self, filename, rows):
		"""指定されたファイルにCSVとして行たち(rows)を書き出す。"""
		return

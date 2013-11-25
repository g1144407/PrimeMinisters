#! /usr/bin/env python
# -*- coding: utf-8 -*-

import os
import shutil
import urllib

import io
import reader

class Downloader(io.IO):
	"""ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。"""

	def __init__(self, base_directory):
		"""ダウンローダのコンストラクタ。"""
		self._base_directory = base_directory
		self.download_all()
		return

	def download_all(self):
		"""すべて（総理大臣の情報を記したCSVファイル・画像ファイル群・縮小画像ファイル群）をダウンロードし、テーブルを応答する。"""
		self.download_csv()
		reader.Reader(self._base_directory+"PrimeMinisters.csv")
		for i in range(39, 63):
			self.download_images(i)
		return reader.table

	def download_csv(self):
		"""総理大臣の情報を記したCSVファイルをダウンロードする。"""
		url = "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/PrimeMinisters.csv"
		
		if not os.path.isdir(self._base_directory):
			os.makedirs(self._base_directory)
		
		path = self._base_directory+"PrimeMinisters.csv"
		print path
		urllib.urlretrieve(url,path)
		return None

	def download_images(self, image_filenames):
		"""画像ファイル群または縮小画像ファイル群をダウンロードする。"""
		image_url = "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/images/"+"0"+str(image_filenames)+".jpg"
		thumbnail_url = "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/thumbnails/"+"0"+str(image_filenames)+".jpg"
		image_dirpath = self._base_directory+"images/"
		thumbnail_dirpath = self._base_directory+"thumbnails/"
		
		if not os.path.isdir(image_dirpath):
			os.makedirs(image_dirpath)
		if not os.path.isdir(thumbnail_dirpath):
			os.makedirs(thumbnail_dirpath)
		image_path = image_dirpath+"0"+str(image_filenames)+".jpg"
		thumbnail_path = thumbnail_dirpath+"0"+str(image_filenames)+".jpg"	
		urllib.urlretrieve(image_url,image_path)
		urllib.urlretrieve(thumbnail_url,thumbnail_path)
		return

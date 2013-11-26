#! /usr/bin/env python
# -*- coding: utf-8 -*-

class Tuple(object):
	"""タプル：総理大臣の情報テーブルの中の各々のレコード。"""

	def __init__(self, attributes, values):
		"""属性リストと値リストからタプルを作るコンストラクタ。"""
		self._attributes = attributes
		self._values = self.set_values(values)
		return

	def __str__(self):
		"""自分自身を文字列にして、それを応答する。"""
		res = self.__class__.__name__
		res += " = "
		res += "\nvalues - "
		for var in self.values():
			res += var+", "
		return res

	def attributes(self):
		"""属性リストを応答する。"""
		return self._attributes

	def values(self):
		"""値リストを応答する。"""
		return self._values

	def set_values(self, values):
		"""値リストを設定する。"""
		a_list = values.split(",")
		value_list = []
		for var in a_list:
			value_list.append(var)
		return value_list

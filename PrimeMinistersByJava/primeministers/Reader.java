package primeministers;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * リーダ：総理大臣の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。
 *
 * スタブ作成
 * 10/23 橋坂侑汰
 */
public class Reader extends IO 
{

	/**
	 * 総理大臣の情報を記したCSVファイルを記憶するフィールド
	 *  10/26 橋坂侑汰
	 */
	private File filename;

	/**
	 * コンストラクタ
	 * filenameを初期化する
	 * 10/26 橋坂侑汰
	 */
	public Reader() 
	{
		super();
		filename = null;
	}

	/**
	 * コンストラクタ
	 * filenameを初期化する
	 * 10/26 橋坂侑汰
	 * @param csvfile
	 * 与えられたcsvファイル
	 */
	public Reader(File csvfile) 
	{
		super();
		filename = csvfile;
	}

	/**
	 * ダウンロードしたCSVファイルのローカルなファイルを応答する
	 * 10/26 橋坂侑汰
	 * @return file
	 * File型のローカルなCSVファイル
	 */
	public File filenameOfCSV() 
	{
		return filename.getAbsoluteFile();
	}

	/**
	 * ダウンロードしたCSVファイルを応答する
	 * 10/26 橋坂侑汰
	 * @return filename
	 * File型のCSVファイル
	 */
	public File filename() 
	{
		return filename;
	}

	/**
	 * ダウンロードしたCSVファイルを読み込んでテーブルを応答する。
	 *  10/26 橋坂侑汰
	 * @return tempTable
	 * CSVファイルをTupleへと変換した変換物群を格納したTable
	 */
	public Table table()
	{
		boolean first = true;
		String temp = null;
		Table tempTable = new Table();
		Iterator<String> ite = super.readTextFromFile(filename).iterator();
		int elements = 0;
		while (ite.hasNext())
		{
			if(first)
			{
				String line = ite.next();
				elements = super.splitString(line, ",").size();
				Attributes tempAttributes = new Attributes(line);
				tempTable.attributes(tempAttributes);
				first=false;
			}
			else
			{
				String line=ite.next();
				ArrayList<String> list = super.splitString(line, ",");
				if(list.size() < elements){
					line += " "+ite.next();
				}
				line = line.replaceAll("\"", "");
				Tuple tempTuple = new Tuple(tempTable.attributes(), super.splitString(line, ","));
				tempTable.add(tempTuple);
			}
		}
		return tempTable;
	}
}
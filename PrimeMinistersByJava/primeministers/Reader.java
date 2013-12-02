package primeministers;

import java.io.File;
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
		Table tempTable = new Table();
		Iterator<String> ite = super.readTextFromFile(filename).iterator();
		while (ite.hasNext())
		{
			if(first)
			{
				Attributes tempAttributes = new Attributes(ite.next());
				tempTable.attributes(tempAttributes);
				first=false;
			}
			else
			{
				Tuple tempTuple = new Tuple(tempTable.attributes(), super.splitString(ite.next(), ","));
				tempTable.add(tempTuple);
			}
		}
		return tempTable;
	}
}

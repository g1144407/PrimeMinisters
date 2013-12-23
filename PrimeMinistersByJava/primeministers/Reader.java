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
	 * 同期用オブジェクト
	 * @author sueSama
	 * 12/15
	 */
	private Object lock;
	 /** 処理完了フラグ
	  * @author sueSama
	  * 12/15
	  */

    private boolean flag;
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
		lock = new Object();
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
				if(list.size() < elements)
				{
					line += " "+ite.next();
				}
				line = line.replaceAll("\"", "");
				Tuple tempTuple = new Tuple(tempTable.attributes(), super.splitString(line, ","));
				tempTable.add(tempTuple);
			}
		}
		return tempTable;
	}

	/**
	 * csvファイルのこのクラスのfilenameへと保持させるメソッド
	 * @param csvFile 保持させたいcsvファイル
	 * @author sueSama
	 * 12/15
	 */
	public void setFilename(File csvFile)
	{
		this.filename = csvFile;
		super.setTableStatus(super.table, 2);
	}

	/**
	 * スレッド処理を行うメソッド
	 * @author sueSama
	 * 12/15
	 */
	public void run()
	{
		while(true)
		{
			if(super.getTableStatus()==2)break;
		}
		super.setTableStatus(this.table(), 3);
		synchronized(this.lock)
		{
			this.flag = true;		// 終了フラグを立てる
            this.lock.notifyAll();	// wait()しているスレッドを起こす
        }
	}

	/**
	 * スレッド処理によりcsvファイルからのtableが作成され次第応答するメソッド
	 * @return table csvファイルからのtable
	 * @throws InterruptedException 同期処理失敗？
	 * @author sueSama
	 * 12/15
	 */
	public Table retrunTable() throws InterruptedException
	{
		synchronized(this.lock)
		{
			while (!this.flag)
			{
				this.lock.wait();
			}
			return super.table;
		}
	}
}
package primeministers;

import java.io.File;
import java.util.Iterator;
/**
 * リーダ：総理大臣の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。
 *
 * スタブ作成
 * @author 10/23 橋坂侑汰
 */
public class Reader extends IO {

	/**
	 * 総理大臣の情報を記したCSVファイルを記憶するフィールド
	 * @author 10/26 橋坂侑汰
	 */
	private File filename;

	/**
	 * コンストラクタ
	 * filenameを初期化する
	 * @author 10/26 橋坂侑汰
	 */
	public Reader() {
		super();
		filename = null;
	}
	
	/**
	 * コンストラクタ
	 * filenameを初期化する
	 * @param csvfile
	 * 与えられたcsvファイル
	 * @author 10/26 橋坂侑汰
	 */
	public Reader(File csvfile) {
		super();
		filename = csvfile;
	}

	/**
	 * ダウンロードしたCSVファイルのローカルなファイルを応答する
	 * @return file
	 * File型のローカルなCSVファイル
	 * @author 10/26 橋坂侑汰
	 */
	public File filenameOfCSV() {
		return filename.getAbsoluteFile();
	}

	/**
	 * ダウンロードしたCSVファイルを応答する
	 * @return filename
	 * File型のCSVファイル
	 * @author 10/26 橋坂侑汰
	 */
	public File filename() {
		return filename;
	}

	/**
	 * ダウンロードしたCSVファイルを読み込んでテーブルを応答する。
	 * @return tempTable
	 * CSVファイルをTupleへと変換した変換物群を格納したTable
	 * @author 10/26 橋坂侑汰
	 */
	//*未完成*IOのTableメソッドをオーバーライドしているので...?
	//DownloadにもTableメソッドがあるので複数のTableが作成されてしまう？
	//IOのprivate Tableフィールドを使い回すのかなぁ
	public Table table(Table aTable) {
		boolean first = true;
		Table tempTable = aTable;
		if(tempTable==null)tempTable = new Table();
		Iterator<String> ite = super.readTextFromFile(filename).iterator();
		//String型にTuple一行が詰まっている > カンマやダブルクウォーツで分割してArrayList型へと変換 > Tuple(Attributes ArrayList)作成
		while (ite.hasNext()) {
			if(first){
				Attributes tempAttributes = new Attributes(ite.next());
				tempTable.attributes(tempAttributes);
				first=false;
			}
			else{
				Tuple tempTuple = new Tuple(tempTable.attributes(), super.splitString(ite.next(), ","));
				tempTable.add(tempTuple);
			}
		}
		return tempTable;
	}

}

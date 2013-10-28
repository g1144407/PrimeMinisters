package primeministers;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
/**
 * ライタ：総理大臣の情報のテーブルをHTMLページとして書き出す。
 *
 * スタブ作成
 * @author 10/23 橋坂侑汰
 */
public class Writer extends IO {

	/**
	 * ライタのコンストラクタ。
	 * @author 10/29 和田祥吾
	 */
	public Writer() {

	}

	/**
	 * 属性リストを応答する。
	 * @return Attributes
	 * @author 10/29 和田祥吾
	 */
	public Attributes attributes() {
		return null;
	}

	/**
	 * ローカルなHTMLのインデックスファイル(index.html)を応答するクラスメソッド。
	 * @return File
	 * @author 10/29 和田祥吾
	 */
	public static File filnameOfHTML() {
		return null;
	}

	/**
	 * HTMLページを基にするテーブルを受け取って、インデックスファイル(index.html)に書き出す。
	 * @param aTable
	 * @return 
	 * @author 10/29 和田祥吾
	 */
	public Table table(Table aTable) {
		return null;
	}

	/**
	 * タプル群を応答する。
	 * @return ArrayList<Tuple>
	 * @author 10/29 和田祥吾
	 */
	public ArrayList<Tuple> tuples() {
		return null;
	}

	/**
	 * 属性リストを書き出す。
	 * @param outputWriter
	 * @author 10/29 和田祥吾
	 */
	public void writeAttributesOn(BufferedWriter outputWriter) {

	}

	/**
	 * フッタを書き出す。
	 * @param outputWriter
	 * @author 10/29 和田祥吾
	 */
	public void writeFooterOn(BufferedWriter outputWriter) {

	}

	/**
	 * ヘッダを書き出す。
	 * @param outputWriter
	 * @author 10/19 和田祥吾
	 */
	public void writeHeaderOn(BufferedWriter outputWriter) {

	}

	/**
	 * ボディを書き出す。
	 * @param outputWriter
	 * @author 10/29 和田祥吾
	 */
	public void writeTableBodyOn(BufferedWriter outputWriter) {

	}

	/**
	 * タプル群を書き出す。
	 * @param outputWriter
	 * @author 10/29 和田祥吾
	 */
	public void writeTuplesOn(BufferedWriter outputWriter) {

	}

}

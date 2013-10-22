package primeministers;

import java.util.ArrayList;


/**
 * タプル：総理大臣の情報テーブルの中の各々のレコード。
 */
public class Tuple extends Object
{
	/**
	 * ここを作成してください。
	 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */
	//属性リストを記憶するフィールド。
	private Attributes attributes = new Attributes();
	//値リストを記憶するフィールド。
	private ArrayList<String> value;
	/*スタブ作成　10月22日　北川裕基
	 * 属性リストと値リストからタプルを作るコンストラクタ。
	 * */
	Tuple(Attributes instanceOfAttributes, ArrayList<String> valueCollection){}
	/*スタブ作成　10月22日　北川裕基
	 * 属性リストを応答する。
	 * */
	public Attributes attributes(){
		return null;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 自分自身を文字列にして、それを応答する。
	 * */
	public String toString(){
		return "";
	}
	/*スタブ作成　10月22日　北川裕基
	 * 値リストを応答する。
	 * */
	public ArrayList<String> values(){
		return null;
	}
}
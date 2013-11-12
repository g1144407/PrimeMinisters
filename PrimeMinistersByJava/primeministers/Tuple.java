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
	private Attributes attributes;
	//値リストを記憶するフィールド。
	private ArrayList<String> value;
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 属性リストと値リストからタプルを作るコンストラクタ。
	 */
	Tuple(Attributes instanceOfAttributes, ArrayList<String> valueCollection){
		this.attributes = instanceOfAttributes;
		this.value = valueCollection;
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 属性リストを応答する。
	 */
	public Attributes attributes(){
		return attributes;
	}
	@Override
	public String toString() {
		return "Tuple [attributes=" + attributes + ", value=" + value + "]";
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 値リストを応答する。
	 */
	public ArrayList<String> values(){
		return value;
	}
}
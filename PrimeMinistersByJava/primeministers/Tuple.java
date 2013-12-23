package primeministers;
import java.util.ArrayList;

/**
 * タプル：総理大臣の情報テーブルの中の各々のレコード。
 */
public class Tuple extends Object
{
	/**
	 * 属性リストを記憶するフィールド。
	 */
	private Attributes attributes;
	/**
	 * 値リストを記憶するフィールド。
	 */
	private ArrayList<String> value;
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 属性リストと値リストからタプルを作るコンストラクタ。
	 */
	public Tuple(Attributes instanceOfAttributes, ArrayList<String> valueCollection)
	{
		this.attributes = instanceOfAttributes;
		this.value = valueCollection;
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 属性リストを応答する。
	 */
	public Attributes attributes()
	{
		return attributes;
	}
	@Override
	/**
	 * 12月2日 和田祥吾
	 * 自分自身を文字列にして、それを応答する。
	 */
	public String toString()
	{
		return "Tuple [attributes=" + attributes + ", value=" + value + "]";
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 値リストを応答する。
	 */
	public ArrayList<String> values()
	{
		return value;
	}
}
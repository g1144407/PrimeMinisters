package primeministers;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 表：総理大臣の情報テーブル。
 */
public class Table extends Object
{
	/**
	 * 属性リストを記憶するフィールド。
	 */
	private Attributes attribures;
	/**
	 * 画像群を記憶するフィールド。
	 */
	private ArrayList<BufferedImage> images;
	/**
	 * サムネイルが画像群を記憶するフィールド。
	 */
	private ArrayList<BufferedImage> thumbnails;
	/**
	 * タプル群を記憶するフィールド。
	 */
	private ArrayList<Tuple> tuples;
	/**
	 * スタブ作成　10月22日　北川裕基
	 * テーブルのコンストラクタ
	 */
	public Table()
	{
		images = new ArrayList<>();
		thumbnails = new ArrayList<>();
		tuples = new ArrayList<>();
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 *　タプルを追加する。
	 *	@param tuple タプル
	 */
	public void add(Tuple tuple)
	{
		tuples.add(tuple);
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 属性リストを応答する。
	 * @return attributes 属性リスト
	 */
	public Attributes attributes()
	{
		return attribures;
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 属性リストを設定する。
	 * @param instanceOfAttributes 属性リスト
	 */
	public void attributes(Attributes instanceOfAttributes)
	{
		this.attribures = instanceOfAttributes;
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 画像群を応答する。
	 * @return 画像群
	 */
	public ArrayList<BufferedImage> images()
	{
		return images;
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 画像またはサムネイル画像の文字列を受け取って当該画像を応答する。
	 */
	private BufferedImage picture(String aString)
	{
		return null;
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * サムネイル画像群を応答する。
	 * @return thumbnails サムネイル群
	 */
	public ArrayList<BufferedImage> thumbnails()
	{
		return thumbnails;
	}
	/**
	 * 自分自身を文字列にして、それを応答する。
	 *  11/12 和田祥吾
	 */
	public String toString()
	{
		return "Table [attribures=" + attribures + ", images=" + images
				+ ", thumbnails=" + thumbnails + ", tuples=" + tuples + "]";
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * タプル群を応答する。
	 * @return tuples タプル群
	 */
	public ArrayList<Tuple> tuples()
	{
		return tuples;
	}
}

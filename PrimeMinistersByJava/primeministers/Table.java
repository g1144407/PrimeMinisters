package primeministers;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 表：総理大臣の情報テーブル。
 */
public class Table extends Object
{
	/**
	 * ここを作成してください。
	 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */
	//属性リストを記憶するフィールド。
	private Attributes attribures;
	//画像群を記憶するフィールド。
	private ArrayList<BufferedImage> images;
	//サムネイルが画像群を記憶するフィールド。
	private ArrayList<BufferedImage> thumbnails;
	//タプル群を記憶するフィールド。
	private ArrayList<Tuple> tuples;
	/*スタブ作成　10月22日　北川裕基
	 * テーブルのコンストラクタ
	 * */
	Table(){
		images = new ArrayList<>();
		thumbnails = new ArrayList<>();
		tuples = new ArrayList<>();
	}
	/*スタブ作成　10月22日　北川裕基
	 *　タプルを追加する。
	 * */
	public void add(Tuple tuple){
		tuples.add(tuple);
	}
	/*スタブ作成　10月22日　北川裕基
	 * 属性リストを応答する。
	 * */
	public Attributes attributes(){
		return attribures;
	}	
	/*スタブ作成　10月22日　北川裕基
	 * 属性リストを設定する。
	 * */
	public void attributes(Attributes instanceOfAttributes){
		this.attribures = instanceOfAttributes;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 画像群を応答する。
	 * */
	ArrayList<BufferedImage> images(){
		return images;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 画像またはサムネイル画像の文字列を受け取って当該画像を応答する。
	 * */
	private BufferedImage picture(String aString){
		return null;
	}
	/*スタブ作成　10月22日　北川裕基
	 * サムネイル画像群を応答する。
	 * */
	public ArrayList<BufferedImage> thumbnails(){
		return thumbnails;
	}
	
	public String toString() {
		return "Table [attribures=" + attribures + ", images=" + images
				+ ", thumbnails=" + thumbnails + ", tuples=" + tuples + "]";
	}
	/*スタブ作成　10月22日　北川裕基
	 * タプル群を応答する。
	 * */
	public ArrayList<Tuple> tuples(){
		return tuples;
	}
}

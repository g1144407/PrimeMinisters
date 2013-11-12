package primeministers;
import java.util.ArrayList;
import java.util.List;

/**
 * 属性群：総理大臣の情報テーブルを入出力する際の属性情報を記憶。
 */
public class Attributes extends Object
{
	/**
	 * ここを作成してください。
	 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */
	//属性リストのキー群を記憶するフィールド。
	private ArrayList<Integer> keys = new ArrayList<>();
	//属性リストの名前群を記憶するフィールド。
	private ArrayList<String> names = new ArrayList<>();
	/** スタブ作成　10月22日　北川裕基
	 * 入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。
	 * */
	Attributes(String aString){
		String[] split = aString.split(",");
		for(int i = 0; i< split.length; i++){
			keys.add(i);
			names.add(split[i]);
			//System.out.println("int > " + i + " 	String >" + split[i]);
		}
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 指定されたインデックスに対応する名前を応答する。名前が無いときはキーを応答する。
	 * */
	protected String at(int index){
		return names.get(index);
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 指定されたキー文字列のインデックスを応答する。
	 * */
	private int indexOf(String aString){
		//System.out.println(aString+ ">>" + names.indexOf(aString));
		return names.indexOf(aString);
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 在位日数のインデックスを応答する。
	 * */
	public int indexOfDays(){
		return indexOf("在位日数");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 画像のインデックスを応答する。
	 * */
	public int indexImage(){
		return indexOf("画像");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * ふりがなのインデックスを応答する。
	 * */
	public int indexOfKana(){
		return indexOf("ふりがな");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 氏名のインデックスを応答する。
	 * */
	public int indexOfName(){
		return indexOf("氏名");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 番号のインデックスを応答する。
	 * */
	public int indexOfNo(){
		return indexOf("人目");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 代のインデックスを応答する。
	 * */
	public int indexOfOrder(){
		return indexOf("代");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 政党のインデックスを応答する。
	 * */
	public int indexOfParty(){
		return indexOf("政党");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 在位期間のインデックスを応答する。
	 * */
	public int indexOfPeriod(){
		return indexOf("在位期間");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 出身地のインデックスを応答する。
	 * */
	public int indexPlace(){
		return indexOf("出身地");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 出身校のインデックスを応答する。
	 * */
	public int indexOfSchool(){
		return indexOf("出身校");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 画像のインデックスを応答する。
	 * */
	public int indexOfThumbnail(){
		return indexOf("縮小画像");
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 指定されたインデックスに対応するキーを応答する。
	 * */
	protected String keyAt(int index){
		return names.get(index);
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * キー群を応答する。
	 * */
	public ArrayList<Integer> keys(){
		return keys;
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 指定されたインデックスに対応する名前を応答する。
	 * */
	protected String nameAt(int index){
		return names.get(index);
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 名前群を応答する。
	 * */
	public ArrayList<String> names(){
		return names;
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 名前群を設定する。
	 * */
	public void names(ArrayList<String> aCollection){
		names.addAll(aCollection);
	}
	/**
	 * スタブ作成　10月22日　北川裕基
	 * 属性リストの長さを応答する。
	 * */
	public int size(){
		return keys.size();
	}
	@Override
	public String toString() {
		return "Attributes [keys=" + keys + ", names=" + names + "]";
	}
}
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
	private List<String> keys = new ArrayList<>();
	//属性リストの名前軍を記憶するフィールド。
	private List<String> names = new ArrayList<>();
	/*スタブ作成　10月22日　北川裕基
	 * 入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。
	 * */
	Attributes(String aString){}
	Attributes(){}
	/*スタブ作成　10月22日　北川裕基
	 * 指定されたインデックスに対応する名前を応答する。名前が無いときはキーを応答する。
	 * */
	protected String at(int index){
		return "";
	}
	/*スタブ作成　10月22日　北川裕基
	 * 指定されたキー文字列のインデックスを応答する。
	 * */
	private int indexOf(String aString){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 在位日数のインデックスを応答する。
	 * */
	public int indexOfDays(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 画像のインデックスを応答する。
	 * */
	public int indexOfKana(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * ふりがなのインデックスを応答する。
	 * */
	public int indexOfName(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 氏名のインデックスを応答する。
	 * */
	public int indexOfNo(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 番号のインデックスを応答する。
	 * */
	public int indexOfOrder(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 代のインデックスを応答する。
	 * */
	public int indexOfParty(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 政党のインデックスを応答する。
	 * */
	public int indexOfPeriod(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 在位期間のインデックスを応答する。
	 * */
	public int indexPlace(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 出身地のインデックスを応答する。
	 * */
	public int indexOfSchool(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 画像のインデックスを応答する。
	 * */
	public int indexOfThumbnail(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 指定されたインデックスに対応するキーを応答する。
	 * */
	protected String keyAt(int index){
		return "";
	}
	/*スタブ作成　10月22日　北川裕基
	 * キー群を応答する。
	 * */
	public ArrayList<String> keys(){
		return null;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 指定されたインデックスに対応する名前を応答する。
	 * */
	protected String nameAt(int index){
		return "";
	}
	/*スタブ作成　10月22日　北川裕基
	 * 名前群を応答する。
	 * */
	public ArrayList<String> names(){
		return null;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 名前群を設定する。
	 * */
	public void names(ArrayList<String> aCollection){
	}
	/*スタブ作成　10月22日　北川裕基
	 * 属性リストの長さを応答する。
	 * */
	public int size(){
		return 0;
	}
	/*スタブ作成　10月22日　北川裕基
	 * 自分自身を文字列にして、それを応答する。
	 * */
	public String toString(){
		return "";
	}
}
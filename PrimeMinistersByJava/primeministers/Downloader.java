package primeministers;
/**
 * ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 *
 * スタブ作成
 * @author 10/23 橋坂侑汰
 */
public class Downloader extends IO {

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL文字列)を記憶するフィールド。
	 */
	private String url;

	/**
	 * ダウンローダのコンストラクタ。
	 * @author 10/26 橋坂侑汰
	 */
	public Downloader() {
		super();
		url=null;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードする。
	 * @author 10/26 橋坂侑汰
	 * 
	 */
	public void downloadCSV() {
		//http://d.hatena.ne.jp/nacookan/20071113/1194918002が参考になるかと
		//DL先はsuperクラスIO、directoryOfPagesが使えるかなと
		
	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 * @author 10/26 橋坂侑汰
	 */
	public void downloadImages() {
		//画像群はcsvファイルを変換後に行うかな
	}

	/**
	 * 総理大臣の画像をダウンロードする。
	 * @param indexOfPicture
	 * @author 10/26 橋坂侑汰
	 */
	private void downloadPictures(int indexOfPicture) {
		//privateだから上記Imagesで何度も呼ぶ感じかな
	}

	/**
	 * 総理大臣のサムネイルをダウンロードする。
	 * @author 10/26 橋坂侑汰
	 */
	public void downloadThumbnails() {
		//downloadPicturesのサムネイル版だと思うけどpublicなのがひっかかる
	}

	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群をダウロードし、テーブルで応答する。
	 * @author 10/26 橋坂侑汰
	 */
	public Table table() {
		//IOのテーブルを使い回す？オーバーライドなので要検証
		return null;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答する。
	 * @return
	 * @author 10/26 橋坂侑汰
	 */
	public String url() {
		return null;
	}

	/**
	 * 総理大臣の情報の在処(URL)を文字列で応答するクラスメソッド。
	 * @return
	 * @author 10/26 橋坂侑汰
	 */
	public String urlString() {
		return null;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答するクラスメソッド。
	 * @return
	 * @author 10/26 橋坂侑汰
	 */
	public String urlStringOfCSV() {
		return null;
	}

}

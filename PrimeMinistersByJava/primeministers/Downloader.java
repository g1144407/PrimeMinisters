package primeministers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

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
	 * @author 10/26 和田祥吾
	 * 
	 */
	public void downloadCSV() {

		try{
			url = urlStringOfCSV();
			URL aURL = new URL(url);
	
			URLConnection conn = aURL.openConnection();
			InputStream in = conn.getInputStream();

			File aFile=new File(IO.directoryOfPages(),"PrimeMinisters.csv");
			FileOutputStream out = new FileOutputStream(aFile,false);
			

			int b;
			while((b = in.read()) != -1){
				out.write(b);
			}

			out.close();
			in.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 * @author 10/26 橋坂侑汰
	 */
	public void downloadImages() {
		//画像群はcsvファイルを変換後に行うかな
		String aString = "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/images/";
		BufferedImage anImage=null;
		try
		{	
			URL url = new URL(aString);	   
			anImage = ImageIO.read(url);
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace() ;
		}
		catch(IOException e)
		{
			e.printStackTrace() ;	
		}
	}

	/**
	 * 総理大臣の画像をダウンロードする。
	 * @param indexOfPicture
	 * @author 10/26 橋坂侑汰
	 */
	private void downloadPictures(int indexOfPicture) {
		//privateだから上記Imagesで何度も呼ぶ感じかな	
		this.downloadImages();
		this.downloadThumbnails();
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
		this.downloadCSV();
		this.downloadPictures(indexOfPicture);
		return null;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答する。
	 * @return url
	 * CSVの在処
	 * @author 10/26 和田祥吾
	 */
	public String url() {
		return url;
	}

	/**
	 * 総理大臣の情報の在処(URL)を文字列で応答するクラスメソッド。
	 * @return
	 * @author 10/26 和田祥吾
	 * 何をするかが謎？？？
	 */
	public static String urlString() {
		return null;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答するクラスメソッド。
	 * @return
	 * @author 10/26 和田祥吾
	 */
	public static String urlStringOfCSV() {
		return "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/PrimeMinisters.csv";
	}

}

package primeministers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 *
 * スタブ作成
 * @author 10/23 橋坂侑汰
 */
public class Downloader extends IO {

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を記憶するフィールド。
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
			url = Downloader.urlStringOfCSV();
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
	 * @author 10/30 和田祥吾
	 */
	public void downloadImages() {
		url = "images/";
		for(int i=39;i<=62;i++){
			this.downloadPictures(i);
		}
	}
	
	/**
	 * 総理大臣の画像をダウンロードする。
	 * @param indexOfPicture
	 * 画像の番号
	 * @author 10/30 和田祥吾
	 */
	private void downloadPictures(int indexOfPicture) {
		try{
			File picturesDir = null;
			URL aURL = new URL("http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/"+url+"0"+indexOfPicture+".jpg");

			URLConnection conn = aURL.openConnection();
			InputStream in = conn.getInputStream();

			if(url == "images/"){
				picturesDir = new File(IO.directoryOfPages(),"images");
				if(picturesDir.exists());
				else picturesDir.mkdirs();
			}
			else if(url == "thumbnails/"){
				picturesDir = new File(IO.directoryOfPages(),"thumbnails");
				if(picturesDir.exists());
				else picturesDir.mkdirs();
			}
			File aFile = new File(picturesDir,"0"+indexOfPicture+".jpg");
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
	 * 総理大臣のサムネイルをダウンロードする。
	 * @author 10/30 和田祥吾
	 */
	public void downloadThumbnails() {
		url = "thumbnails/";
		for(int i=39;i<=62;i++){
			this.downloadPictures(i);
		}
	}

	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群をダウロードし、テーブルで応答する。
	 * @author 10/30 和田祥吾
	 */
	public Table table() {
		/*
		 *恐らくここではダウンロードした画像群をTableのimages,thumbnailsに追加して、画像群が記憶されたtableを応答する
		 *でもtableクラスにaddimages的なメソッドがない
		 *どうやって追加する？
		 */
		this.downloadCSV();
		Reader aReader = new Reader(new File(Downloader.urlString()));
		super.table = aReader.table();
		this.downloadImages();
		this.downloadThumbnails();
		return super.table;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(相対パス)を文字列で応答する。
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
	 * @author 10/30 和田祥吾
	 */
	public static String urlString() {
		return IO.directoryOfPages()+"/PrimeMinisters.csv";
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

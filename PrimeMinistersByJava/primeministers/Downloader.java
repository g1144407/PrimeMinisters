package primeministers;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 *
 * スタブ作成
 * 10/23 橋坂侑汰
 */
public class Downloader extends IO
{

	/** 
	 * 同期用オブジェクト
	 * @author sueSama
	 * 12/15
	 */
	private Object lock;
	 /** 処理完了フラグ
	  * @author sueSama
	  * 12/15
	  */
    private boolean flag;
	
	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を記憶するフィールド。
	 */
	private String url;

	/**
	 * ダウンローダのコンストラクタ。
	 *  10/26 橋坂侑汰
	 */
	public Downloader() 
	{
		super();
		url = null;
		lock = new Object();
	}

	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードする。
	 *  10/26 和田祥吾
	 * 
	 */
	public void downloadCSV()
	{

		try
		{
			url = Downloader.urlStringOfCSV();
			URL aURL = new URL(url);
			
			InputStream inputStream = aURL.openStream();
		
			File aFile=new File(IO.directoryOfPages(),"PrimeMinisters.csv");
			FileOutputStream outputStream = new FileOutputStream(aFile,false);

			byte[] bytes = new byte[512];
			int b;
			while((b = inputStream.read(bytes)) != -1)
			{
				outputStream.write(bytes,0,b);
			}
			outputStream.close();
			inputStream.close();
		}
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (MalformedURLException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();} 
		catch (Exception e) {e.printStackTrace();}
	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 *  10/30 和田祥吾
	 */
	public void downloadImages() 
	{
		url = "images/";
		for(int i=39;i<=62;i++)
		{
			this.downloadPictures(i);
		}
	}

	/**
	 * 総理大臣の画像をダウンロードする。
	 * 10/30 和田祥吾
	 * @param indexOfPicture　画像の番号
	 */
	private void downloadPictures(int indexOfPicture) 
	{
		try
		{
			File picturesDir = null;
			URL aURL = new URL("http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/"+url+"0"+indexOfPicture+".jpg");

			InputStream inputStream = aURL.openStream();

			if(url == "images/")
			{
				picturesDir = new File(IO.directoryOfPages(),"images");
				if(picturesDir.exists());
				else picturesDir.mkdirs();
			}
			else if(url == "thumbnails/")
			{
				picturesDir = new File(IO.directoryOfPages(),"thumbnails");
				if(picturesDir.exists());
				else picturesDir.mkdirs();
			}
			File aFile = new File(picturesDir,"0"+indexOfPicture+".jpg");
			FileOutputStream outputStream = new FileOutputStream(aFile,false);

			byte[] bytes = new byte[512];
			int b;
			while((b = inputStream.read(bytes)) != -1)
			{
				outputStream.write(bytes,0,b);
			}
			outputStream.close();
			inputStream.close();
		}
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (MalformedURLException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();} 
		catch (Exception e) {e.printStackTrace();}
	}

	/**
	 * 総理大臣のサムネイルをダウンロードする。
	 *  10/30 和田祥吾
	 */
	public void downloadThumbnails() 
	{
		url = "thumbnails/";
		for(int i=39;i<=62;i++)
		{
			this.downloadPictures(i);
		}
	}

	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群をダウロードし、テーブルで応答する。
	 *  10/30 和田祥吾
	 * @return table 総理大臣の情報をダウンロードしたテーブル
	 */
	public Table table() 
	{
		this.downloadCSV();
		Reader aReader = new Reader(new File(Downloader.urlString()));
		super.table = aReader.table();
		this.downloadImages();
		this.downloadThumbnails();
		return super.table;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(相対パス)を文字列で応答する。
	 * 10/26 和田祥吾
	 * @return url CSVの在処
	 */
	public String url() 
	{
		return url;
	}

	/**
	 * 総理大臣の情報の在処(URL)を文字列で応答するクラスメソッド。
	 * 10/30 和田祥吾
	 * @return url 総理大臣の情報の在処
	 */
	public static String urlString() 
	{
		return IO.directoryOfPages()+"/PrimeMinisters.csv";
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答するクラスメソッド。
	 * 10/26 和田祥吾
	 * @return url CSVのファイルの在処
	 */
	public static String urlStringOfCSV() 
	{
		return "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/PrimeMinisters2.csv";
	}

	/**
	 * スレッド処理を行うメソッド
	 * @author sueSama
	 * 12/15
	 */
	public void run() {
		this.downloadCSV();
		super.setTableStatus(new Table(), 1);
		synchronized(this.lock) {
			this.flag = true;		// 終了フラグを立てる
            this.lock.notifyAll();	// wait()しているスレッドを起こす
        }
		this.downloadImages();
		this.downloadThumbnails();
	}
	
	/**
	 * tableの作成完了後、ダウンロードしたCSVファイルを応答するスレッド用メソッド
	 * @author sueSama
	 * 12/15
	 */
	public File returnCSV() throws InterruptedException{
		synchronized(this.lock) {
			while (!this.flag) {
				this.lock.wait();
			}
			return new File(Downloader.urlString());
		}
	}
}

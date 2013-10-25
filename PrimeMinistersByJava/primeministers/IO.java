package primeministers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
/**
 * 入出力：リーダ・ダウンローダ・ライタを抽象する。
 * 
 * スタブ作成
 * @author 10/23 橋坂侑汰
 */
public class IO {

	/**
	 * テーブル（表：スプレッドシート）を記憶するフィールド。
	 */
	private Table table;

	/**
	 * 入出力のコンストラクタ。
	 */
	public void IO() {

	}

	/**
	 * ファイルやディレクトリを削除するクラスメソッド。
	 * @param aFile
	 */
	public static void deleteFileOrDirectory(File aFile) {

	}

	/**
	 * 総理大臣ページのためのディレクトリ（存在しなければ作成して）を応答するクラスメソッド。
	 * @return
	 */
	public static File directoryOfPages() {
		return null;
	}

	/**
	 * 入出力する際の文字コードを応答するクラスメソッド。
	 * @return
	 */
	public static String encodingSymbol() {
		return "UTF-8";
	}
	/**
	 * 10月25日 和田祥吾
	 * 指定されたファイルからテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param aFile
	 * @return
	 */
	public static ArrayList<String> readTextFromFile(File aFile) {
		ArrayList<String> aCollection = new ArrayList<String>();

		try
		{
			FileInputStream inputStream = new FileInputStream(aFile);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, IO.encodingSymbol());
			BufferedReader inputReader = new BufferedReader(inputStreamReader);

			String aString = null;
			while ((aString = inputReader.readLine()) != null)
			{
				aCollection.add(aString);
			}

			inputReader.close();
		}
		catch (FileNotFoundException anException) { anException.printStackTrace(); }
		catch (UnsupportedEncodingException anException) { anException.printStackTrace(); }
		catch (IOException anException) { anException.printStackTrace(); }
		System.out.println(aCollection);
		return aCollection;
	}
	/**
	 * 10月25日 和田祥吾
	 * 指定されたファイル文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param fileString
	 * @return
	 */
	public static ArrayList<String> readTextFromFile(String fileString) {
		File aFile = new File(fileString);
		ArrayList<String> aCollection = IO.readTextFromFile(aFile);
		return aCollection;
	}

	/**
	 * 10月25日 和田祥吾
	 * 指定されたURL文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param urlString
	 * @return
	 */
	public static ArrayList<String> readTextFromURL(String urlString) {
		URL aURL = null;
		try { aURL = new URL(urlString); }
		catch (MalformedURLException anException) { anException.printStackTrace(); }
		ArrayList<String> aCollection = IO.readTextFromURL(aURL);
		return aCollection;
	}

	/**
	 * 10月25日 和田祥吾
	 * 指定されたURLからテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * @param aURL
	 * @return
	 */
	public static ArrayList<String> readTextFromURL(URL aURL) {
		ArrayList<String> aCollection = new ArrayList<String>();

		try
		{
			InputStream inputStream = aURL.openStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, IO.encodingSymbol());
			BufferedReader inputReader = new BufferedReader(inputStreamReader);

			String aString = null;
			while ((aString = inputReader.readLine()) != null)
			{
				aCollection.add(aString);
			}

			inputReader.close();
		}
		catch (UnsupportedEncodingException anException) { anException.printStackTrace(); }
		catch (IOException anException) { anException.printStackTrace(); }
		return aCollection;
	}

	/**
	 * 10月25日 和田祥吾
	 * 文字列をセパレータで分割したトークン列を応答するクラスメソッド。
	 * @param string
	 * @param separators
	 * @return
	 */
	public static ArrayList<String> splitString(String string, String separators) {
		ArrayList<Integer> indexes;
		int stop;
		int index;
		ArrayList<String> result;

		indexes = new ArrayList<Integer>();
		indexes.add(-1);
		stop = string.length();
		for (index = 0; index < stop; index++)
		{
			if ((separators.indexOf(string.charAt(index))) >= 0)
			{
				indexes.add(index);
			}
		}
		indexes.add(stop);
		stop = indexes.size() - 1;
		result = new ArrayList<String>();
		for (index = 0; index < stop; index++)
		{
			int start;
			int end;

			start = indexes.get(index) + 1;
			end = indexes.get(index + 1) - 1;
			if (end >= start)
			{
				result.add(string.substring(start, end + 1));
			}
		}
		return result;
	}

	/**
	 * テーブルを応答する。
	 * @return
	 */
	public Table table() {
		return null;
	}

	/**
	 * 10月25日 和田祥吾
	 * 指定された行リストを、指定されたファイルに書き出すクラスメソッド。
	 * @param aCollection
	 * @param aFile
	 */
	public static void writeText(ArrayList<String> aCollection, File aFile) {
		try
		{
			FileOutputStream outputStream = new FileOutputStream(aFile);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, IO.encodingSymbol());
			BufferedWriter outputWriter = new BufferedWriter(outputStreamWriter);

			for (String aString : aCollection)
			{
				outputWriter.write(aString + "\n");
			}

			outputWriter.close();
		}
		catch (IOException anException) { anException.printStackTrace(); }
		return;
	}

	/**
	 * 10月25日 和田祥吾
	 * 指定された行リストを、指定されたファイル名のファイルに書き出すクラスメソッド。
	 * @param aCollection
	 * @param fileString
	 */
	public static void writeText(ArrayList<String> aCollection, String fileString) {
		File aFile = new File(fileString);
		IO.writeText(aCollection, aFile);
		return;
	}

}

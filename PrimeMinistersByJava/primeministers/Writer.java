package primeministers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
/**
 * ライタ：総理大臣の情報のテーブルをHTMLページとして書き出す。
 *
 * スタブ作成
 *  10/23 橋坂侑汰
 */
public class Writer extends IO
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
	 * ライタのコンストラクタ。
	 *  10/29 和田祥吾
	 */
	public Writer()
	{
		lock = new Object();
	}

	/**
	 * 属性リストを応答する。
	 *  10/29 和田祥吾
	 * @return Attributes 属性リスト
	 */
	public Attributes attributes()
	{
		return super.table.attributes();
	}

	/**
	 * ローカルなHTMLのインデックスファイル(index.html)を応答するクラスメソッド。
	 * 10/29 和田祥吾
	 * @return File ローカルなファイル
	 */
	public static File filnameOfHTML()
	{
		return new File(directoryOfPages().toString()+"/index.html");
	}

	/**
	 * HTMLページを基にするテーブルを受け取って、インデックスファイル(index.html)に書き出す。
	 * 10/29 和田祥吾
	 * @param aTable テーブル
	 * @return Table テーブル
	 */
	public Table table(Table aTable)
	{
		super.table = aTable;
		try
		{
			OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(Writer.filnameOfHTML()),IO.encodingSymbol());
			BufferedWriter outputWriter = new BufferedWriter(outputStream);
			writeHeaderOn(outputWriter);
			writeTableBodyOn(outputWriter);
			writeFooterOn(outputWriter);
			outputWriter.close();
		}
		catch (IOException e) {e.printStackTrace();}
		return super.table;
	}

	/**
	 * タプル群を応答する。
	 * 10/29 和田祥吾
	 * @return ArrayList<Tuple>  タプル群
	 */
	public ArrayList<Tuple> tuples()
	{
		return super.table.tuples();
	}

	/**
	 * 属性リストを書き出す。
	 * 10/29 和田祥吾
	 * @param outputWriter
	 */
	public void writeAttributesOn(BufferedWriter outputWriter)
	{
		try
		{
			outputWriter.write("\t\t\t\t\t\t<tr>\n");
			Iterator<String> ite = this.attributes().names().iterator();
			while(ite.hasNext())
			{
				outputWriter.write("\t\t\t\t\t\t\t<td class=\"center-pink\"><strong>"+ite.next()+"</strong></td>\n");
			}
			outputWriter.write("\t\t\t\t\t\t</tr>\n");
		}
		catch (IOException e) {e.printStackTrace();}
	}

	/**
	 * フッタを書き出す。
	 * 10/29 和田祥吾
	 * @param outputWriter
	 */
	public void writeFooterOn(BufferedWriter outputWriter)
	{
		try
		{
			outputWriter.write("\t\t\t\t\t</tbody>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</tbody>\n</table>\n<hr>\n<div class=\"right-small\">Created by Prime Ministers (PrimeMinisters written by Java) ");
			Calendar now = Calendar.getInstance();  //(1)オブジェクトの生成
			String year = Integer.toString(now.get(Calendar.YEAR));        //(2)現在の年を取得
			String month = Integer.toString(now.get(Calendar.MONTH) + 1);  //(3)現在の月を取得
			String day = Integer.toString(now.get(Calendar.DATE));         //(4)現在の日を取得
			String hour = Integer.toString(now.get(Calendar.HOUR_OF_DAY)); //(5)現在の時を取得
			String minute = Integer.toString(now.get(Calendar.MINUTE));    //(6)現在の分を取得
			String second = Integer.toString(now.get(Calendar.SECOND));    //(7)現在の秒を取得
			if(month.length()==1)month="0"+month;
			if(day.length()==1)day="0"+day;
			if(hour.length()==1)hour="0"+hour;
			if(minute.length()==1)minute="0"+minute;
			if(second.length()==1)second="0"+second;
			outputWriter.write(year+"/"+month+"/"+day+" "+hour+":"+minute+":"+second);
			outputWriter.write("</div>\n</body>\n</html>\n");
		}
		catch (IOException e) {e.printStackTrace();}
	}

	/**
	 * ヘッダを書き出す。
	 * 10/29 和田祥吾
	 * @param outputWriter
	 */
	public void writeHeaderOn(BufferedWriter outputWriter)
	{
		try
		{
			outputWriter.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html lang=\"ja\">\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n<meta http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<meta http-equiv=\"Content-Script-Type\" content=\"text/javascript\">\n<meta name=\"keywords\" content=\"Java,Oriented,Programming\">\n<meta name=\"description\" content=\"Prime Ministers\">\n<meta name=\"author\" content=\"PrimeMinisters\">\n<link rev=\"made\" href=\"http://www.cc.kyoto-su.ac.jp/\">\n<link rel=\"index\" href=\"index.html\">\n<style type=\"text/css\">\n<!--\nbody {\n\tbackground-color : #ffffff;\n\tmargin : 20px;\n\tpadding : 10px;\n\tfont-family : serif;\n\tfont-size : 10pt;\n}\na {\n\ttext-decoration : underline;\n\tcolor : #000000;\n}\na:link {\n\tbackground-color : #ffddbb;\n}\na:visited {\n\tbackground-color : #ccffcc;\n}\na:hover {\n\tbackground-color : #dddddd;\n}\na:active {\n\tbackground-color : #dddddd;\n}\ndiv.belt {\n\tbackground-color : #eeeeee;\n\tpadding : 0px 4px;\n}\ndiv.right-small {\n\ttext-align : right;\n\tfont-size : 8pt;\n}\nimg.borderless {\n\tborder-width : 0px;\n\tvertical-align : middle;\n}\ntable.belt {\n\tborder-style : solid;\n\tborder-width : 0px;\n\tborder-color : #000000;\n\tbackground-color : #ffffff;\n\tpadding : 0px 0px;\n\twidth : 100%;\n}\ntable.content {\n\tborder-style : solid;\n\tborder-width : 0px;\n\tborder-color : #000000;\n\tpadding : 2px 2px;\n}\ntd.center-blue {\n\tpadding : 2px 2px;\n\ttext-align : center;\n\tbackground-color : #ddeeff;\n}\ntd.center-pink {\n\tpadding : 2px 2px;\n\ttext-align : center;\n\tbackground-color : #ffddee;\n}\ntd.center-yellow {\n\tpadding : 2px 2px;\n\ttext-align : center;\n\tbackground-color : #ffffcc;\n}\n-->\n</style>\n<title>Prime Ministers</title>\n</head>\n");
		}
		catch (IOException e) {e.printStackTrace();}
	}

	/**
	 * ボディを書き出す。
	 *  10/29 和田祥吾
	 * @param outputWriter
	 */
	public void writeTableBodyOn(BufferedWriter outputWriter)
	{
		try
		{
			outputWriter.write("<body>\n<div class=\"belt\">\n<h2>Prime Ministers</h2>\n</div>\n<table class=\"belt\" summary=\"table\">\n\t<tbody>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<table class=\"content\" summary=\"table\">\n\t\t\t\t\t<tbody>\n");
		}
		catch (IOException e) {e.printStackTrace();}
		writeAttributesOn(outputWriter);
		writeTuplesOn(outputWriter);
	}

	/**
	 * タプル群を書き出す。
	 * 10/29 和田祥吾
	 * @param outputWriter
	 */
	public void writeTuplesOn(BufferedWriter outputWriter)
	{
		int count=0;
		try
		{
			Iterator<Tuple> ite = this.tuples().iterator();
			while(ite.hasNext())
			{
				outputWriter.write("\t\t\t\t\t\t<tr>\n");
				Iterator<String> ite2 = ite.next().values().iterator();
				while(ite2.hasNext())
				{
					if(count%2==0)outputWriter.write("\t\t\t\t\t\t\t<td class=\"center-blue\">"+ite2.next()+"</td>\n");
					else outputWriter.write("\t\t\t\t\t\t\t<td class=\"center-yellow\">"+ite2.next()+"</td>\n");
				}
				outputWriter.write("\t\t\t\t\t\t</tr>\n");
				count++;
			}
		}
		catch (IOException e) {e.printStackTrace();}
	}

	/**
	 * スレッド処理を行うメソッド
	 * @author sueSama
	 * 12/15
	 */
	public void run()
	{
		try
		{
			OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(Writer.filnameOfHTML()),IO.encodingSymbol());
			BufferedWriter outputWriter = new BufferedWriter(outputStream);
			writeHeaderOn(outputWriter);
			while(true)
			{
				if(super.getTableStatus() == 4)break;
			}
			writeTableBodyOn(outputWriter);
			writeFooterOn(outputWriter);
			outputWriter.close();
		}
		catch (IOException e) {e.printStackTrace();}
		synchronized(this.lock)
		{
			this.flag = true;		// 終了フラグを立てる
            this.lock.notifyAll();	// wait()しているスレッドを起こす
        }
	}

	/**
	 * html用tableを設定するメソッド（スレッド用）
	 * @param outputTable html用table
	 * @author sueSama
	 * 12/15
	 */
	public void setTable(Table outputTable)
	{
		super.setTableStatus(outputTable, 4);
	}

	/**
	 * 出力の完了を応答するメソッド（スレッド用）
	 * @author sueSama
	 * 12/15
	 * @throws InterruptedException 同期処理失敗？
	 */
	public void completeWrite() throws InterruptedException
	{
		synchronized(this.lock)
		{
			while (!this.flag)
			{
				this.lock.wait();
			}
		}
	}
}

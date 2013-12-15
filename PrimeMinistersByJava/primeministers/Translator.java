package primeministers;

import java.awt.Desktop;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.JOptionPane;
/**
 * トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。
 *
 * スタブ作成
 *  10/23 橋坂侑汰
 */
public class Translator extends Object
{

	/**
	 * CSVに由来するテーブルを記憶するフィールド。
	 *  10/27 橋坂侑汰
	 */
	private Table inputTable;

	/**
	 * HTMLに由来するテーブルを記憶するフィールド。
	 *  10/27 橋坂侑汰
	 */
	private Table outputTable;

	/**
	 * トランスレータのコンストラクタ。
	 *  10/27 橋坂侑汰
	 */
	public Translator() 
	{
		super();
		return;
	}

	/**
	 * 在位日数を計算して、それを文字列にして応答する。
	 * 10/27 橋坂侑汰
	 * @param periodString
	 * 在位期間の文字列、(1982年11月27日〜1987年11月6日)のような形
	 * @return days
	 * 在位日数、(3桁目にピリオドが入る)
	 */
	public String computeNumberOfDays(String periodString) 
	{
		String[] period = periodString.split("〜");
		int begin, end;
		begin = period[0].indexOf("年");
		int yearFrom = Integer.valueOf(period[0].substring(0,begin));
		end = period[0].indexOf("月");
		int monthFrom = Integer.valueOf(period[0].substring(begin+1, end));
		begin=end;
		end = period[0].indexOf("日");
		int dayFrom = Integer.valueOf(period[0].substring(begin+1, end));

		int yearTo=0,monthTo=0,dayTo=0;
		try
		{
			begin = period[1].indexOf("年");
			yearTo = Integer.valueOf(period[1].substring(0,begin));
			end = period[1].indexOf("月");
			monthTo = Integer.valueOf(period[1].substring(begin+1, end));
			begin=end;
			end = period[1].indexOf("日");
			dayTo = Integer.valueOf(period[1].substring(begin+1, end));
		} 
		catch (ArrayIndexOutOfBoundsException e)
		{
			//在位期間は2012年12月26日〜,となっている、現在の日時を補間
			Calendar now = Calendar.getInstance();  //(1)オブジェクトの生成
			yearTo = now.get(Calendar.YEAR);        //(2)現在の年を取得
			monthTo = now.get(Calendar.MONTH) + 1;  //(3)現在の月を取得
			dayTo = now.get(Calendar.DATE);         //(4)現在の日を取得
		}
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(yearTo, monthTo-1, dayTo, 0, 0, 0);
		cal2.set(yearFrom, monthFrom-1, dayFrom, 0, 0, 0);
		String days = Long.toString(( cal1.getTimeInMillis() - cal2.getTimeInMillis() ) / (24 * 60 * 60 * 1000 ) + 1);

		int length;
		if((length=days.length()) >3)
		{
			String before = days.substring(0, length-3);
			String after = days.substring(length-3);
			days = before+","+after;
		}
		return days;
	}

	/**
	 * サムネイル画像から画像へ飛ぶためのHTML文字列を作成して、それを応答する。
	 * 10/27 橋坂侑汰
	 * @param aString
	 * サムネイル画像と画像のString文字列で参照？
	 * @param aTuple
	 * HTMLタグを作成するためのタプル
	 * @param no
	 * int型で何人目かで参照する？
	 * @return imgTag
	 * HTMLのタグとなる文字列、構文は下記(リサイズ等のオプションは省略)
	 * <a href="images/***.jpg"><img src="thumbnails/***.jpg"></a></td>
	 */
	public String computeStringOfImage(String aString, Tuple aTuple, int no) 
	{
		String imgTag=null;
		if(aString!=null);
		else if(aTuple!=null)imgTag = "<a name=\""+aTuple.values().get(aTuple.attributes().indexOfNo())+"\" href=\""+aTuple.values().get(aTuple.attributes().indexImage())+"\"><img class=\"borderless\" src=\""+aTuple.values().get(aTuple.attributes().indexOfThumbnail())+"\" width=\"25\" height=\"32\" alt=\"0"+aTuple.values().get(aTuple.attributes().indexOfNo())+".jpg\"></a>";
		else imgTag = "<a name=\""+no+"\" href=\"images/0"+no+".jpg\"><img class=\"borderless\" src=\"thumbnails/0"+no+".jpg\" width=\"25\" height=\"32\" alt=\"0"+no+".jpg\"></a>";
		return imgTag;
	}

	/** 
	 * 総理大臣のCSVファイルをHTMLページへ変換する
	 *  10/27 橋坂侑汰
	 */
	public void perform()
	{
		try
		{
			Downloader aDownloader = new Downloader();
			inputTable = aDownloader.table();
			outputTable = this.table(inputTable);
			Writer aWriter = new Writer();
			aWriter.table(outputTable);

			Desktop desktop = Desktop.getDesktop();
			desktop.open(Writer.filnameOfHTML());
		}
		catch (IOException e) {e.printStackTrace();}
		String aString = "総理大臣のCSVファイルからHTMLページへの変換を無事に完了しました。\n";
		JOptionPane.showMessageDialog(null, aString, "報告", JOptionPane.PLAIN_MESSAGE);
		return;
	}
	
	/**
	 * 総理大臣のCSVファイルをHTMLページへ変換する（IO周りのスレッド化）
	 * 12/15
	 * @author sueSama
	 */
	/*
	 * IO3種(D/R/W)をスレッド化する
	 * 現在は逐次処理に
	 * １：ダウンローダーがリーダーを呼びtableを作成
	 * ２：tableをこのクラスで処理しhtmltableを作成
	 * ３：ライターがhtmltableを書き出し
	 * となっている。
	 * 平行同期制御をさせるとなると、モニタになるであろうtableの状態を持たせる？
	 * たとえば『tableがnull』『Downloaderからのtable』とか
	 * 新たにそれを制御する変数とsyncronizedなgetterを用意
	 * Readerを予め作成しておき、downloaderがtableとcsvファイルのダウンローダーを完了次第それをこのクラスで受け取る
	 * Readerからtableを受け取りこのクラスで処理するなら下記サイトを参考
	 * http://blogs.wankuma.com/nagise/archive/2007/08/21/91284.aspx
	 * Writerは予めtable依存しない部分を出力させておく
	 * Writerインスタンスへとhtml用tableを投げ、受け取り次第出力させる
	 */
	public void threadPerform(){
		try
		{
			Downloader aThreadDownloader = new Downloader();
			Reader aThreadReader = new Reader();
			Writer aThreadWriter = new Writer();
			aThreadDownloader.start();
			aThreadReader.start();
			aThreadWriter.start();
			
			aThreadReader.setFilename(aThreadDownloader.returnCSV());
			inputTable = aThreadReader.retrunTable();
			outputTable = this.table(inputTable);
			aThreadWriter.setTable(outputTable);
			
			aThreadWriter.completeWrite();
			
			Desktop desktop = Desktop.getDesktop();
			desktop.open(Writer.filnameOfHTML());
		}
		catch (IOException | InterruptedException e) {e.printStackTrace();}
		String aString = "総理大臣のCSVファイルからHTMLページへの変換を無事に完了しました。\n";
		JOptionPane.showMessageDialog(null, aString, "報告", JOptionPane.PLAIN_MESSAGE);
		return;
	}

	/**
	 * 総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、それを応答する。
	 * 10/27 橋坂侑汰
	 * @param csvTable
	 * CSVファイルより作成されたテーブル
	 * @return htmlTabel
	 * HTMLファイル向けに作成されたテーブル
	 */
	public Table table(Table csvTable) 
	{
		Table htmlTable = new Table();
		Attributes htmlAttributes = new Attributes("人目,代,氏名,ふりがな,在位期間,在位日数,出身校,政党,出身地,画像");
		htmlTable.attributes(htmlAttributes);
		Iterator<Tuple> ite = inputTable.tuples().iterator();
		Attributes csvAttributes = csvTable.attributes();
		while (ite.hasNext())
		{
			Tuple csvTuple = ite.next();
			ArrayList<String> csvValues = csvTuple.values();
			ArrayList<String> htmlValues = new ArrayList<String>();
			
			htmlValues.add(csvValues.get(csvAttributes.indexOfNo()));//人目
			htmlValues.add(csvValues.get(csvAttributes.indexOfOrder()));//代
			htmlValues.add(csvValues.get(csvAttributes.indexOfName()));//氏名
			htmlValues.add(csvValues.get(csvAttributes.indexOfKana()));//ふりがな
			htmlValues.add(csvValues.get(csvAttributes.indexOfPeriod()));//在位期間
			htmlValues.add(this.computeNumberOfDays(csvValues.get(csvAttributes.indexOfPeriod())));//在位日数
			htmlValues.add(csvValues.get(csvAttributes.indexOfSchool()));//出身校
			htmlValues.add(csvValues.get(csvAttributes.indexOfParty()));//政党
			htmlValues.add(csvValues.get(csvAttributes.indexPlace()));//出身地
			htmlValues.add(this.computeStringOfImage(null, csvTuple, Integer.valueOf(csvValues.get(csvAttributes.indexOfNo()))));//画像
			
			Tuple tempTuple = new Tuple(htmlTable.attributes(), htmlValues);
			htmlTable.add(tempTuple);
		}
		return htmlTable;
	}
}

package primeministers;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.JOptionPane;
/**
 * トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。
 *
 * スタブ作成
 * @author 10/23 橋坂侑汰
 */
public class Translator extends Object{

	/**
	 * CSVに由来するテーブルを記憶するフィールド。
	 * @author 10/27 橋坂侑汰
	 */
	private Table inputTable;

	/**
	 * HTMLに由来するテーブルを記憶するフィールド。
	 * @author 10/27 橋坂侑汰
	 */
	private Table outputTable;

	/**
	 * トランスレータのコンストラクタ。
	 * @author 10/27 橋坂侑汰
	 */
	public Translator() {
		super();
		return;
	}

	/**
	 * 在位日数を計算して、それを文字列にして応答する。
	 * @param periodString
	 * 在位期間の文字列、(1982年11月27日〜1987年11月6日)のような形
	 * @return days
	 * 在位日数、(3桁目にピリオドが入る)
	 * @author 10/27 橋坂侑汰
	 */
	public String computeNumberOfDays(String periodString) {
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
		try{
			begin = period[1].indexOf("年");
			yearTo = Integer.valueOf(period[1].substring(0,begin));
			end = period[1].indexOf("月");
			monthTo = Integer.valueOf(period[1].substring(begin+1, end));
			begin=end;
			end = period[1].indexOf("日");
			dayTo = Integer.valueOf(period[1].substring(begin+1, end));
		} catch (ArrayIndexOutOfBoundsException e){
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
		if((length=days.length()) >3){
			String before = days.substring(0, length-3);
			String after = days.substring(length-3);
			days = before+","+after;
		}
		return days;
	}

	/**
	 * サムネイル画像から画像へ飛ぶためのHTML文字列を作成して、それを応答する。
	 * 全ての引数を使う実装が思い浮かばない...
	 * ３種類の動作を実装する？だったらオーバーロードだし謎
	 * @param aString
	 * サムネイル画像と画像のString文字列で参照？
	 * @param aTuple
	 * HTMLタグを作成するためのタプル
	 * @param no
	 * int型で何人目かで参照する？
	 * @return imgTag
	 * HTMLのタグとなる文字列、構文は下記(リサイズ等のオプションは省略)
	 * <a href="images/***.jpg"><img src="thumbnails/***.jpg"></a></td>
	 * @author 10/27 橋坂侑汰
	 */
	public String computeStringOfImage(String aString, Tuple aTuple, int no) {
		String imgTag=null;
		if(aString!=null);
		else if(aTuple!=null)imgTag = "<a name=\""+aTuple.values().get(aTuple.attributes().indexOfNo())+"\" href=\""+aTuple.values().get(aTuple.attributes().indexImage())+"\"><img class=\"borderless\" src=\""+aTuple.values().get(aTuple.attributes().indexOfThumbnail())+"\" width=\"25\" height=\"32\" alt=\"0"+aTuple.values().get(aTuple.attributes().indexOfNo())+".jpg\"></a>";
		else imgTag = "<a name=\""+no+"\" href=\"images/0"+no+".jpg\"><img class=\"borderless\" src=\"thumbnails/0"+no+".jpg\" width=\"25\" height=\"32\" alt=\"0"+no+".jpg\"></a>";
		return imgTag;
	}

	/** 
	 * 総理大臣のCSVファイルをHTMLページへ変換する
	 * @author 10/27 橋坂侑汰
	 */
	public void perform() {
		Downloader aDownloader = new Downloader();
		Table aTable = aDownloader.table();
		Reader aReader = new Reader(new File(Downloader.urlString()));
		inputTable = aReader.table(aTable);
		//↑これでCSVからのTableが完成する
		outputTable = this.table(inputTable);
		Writer aWriter = new Writer();
		aWriter.table(outputTable);
		String aString = "総理大臣のCSVファイルからHTMLページへの変換を無事に完了しました。\n";
		JOptionPane.showMessageDialog(null, aString, "報告", JOptionPane.PLAIN_MESSAGE);
		return;
	}

	/**
	 * 総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、それを応答する。
	 * @param aTable
	 * CSVファイルより作成されたテーブル
	 * @return htmlTabel
	 * HTMLファイル向けに作成されたテーブル
	 * @author 10/27 橋坂侑汰
	 */
	public Table table(Table csvTable) {
		Table htmlTable = new Table();
		Attributes htmlAttributes = new Attributes("人目,代,氏名,ふりがな,在位期間,在位日数,出身校,政党,出身地,画像");
		htmlTable.attributes(htmlAttributes);
		Iterator<Tuple> ite = inputTable.tuples().iterator();
		while (ite.hasNext()) {
			Tuple csvTuple = ite.next();
			ArrayList<String> values = new ArrayList<String>();
			values.add(csvTuple.values().get(csvTuple.attributes().indexOfNo()));//人目
			values.add(csvTuple.values().get(csvTuple.attributes().indexOfOrder()));//代
			values.add(csvTuple.values().get(csvTuple.attributes().indexOfName()));//氏名
			values.add(csvTuple.values().get(csvTuple.attributes().indexOfKana()));//ふりがな
			values.add(csvTuple.values().get(csvTuple.attributes().indexOfPeriod()));//在位期間
			values.add(this.computeNumberOfDays(csvTuple.values().get(csvTuple.attributes().indexOfPeriod())));//在位日数
			values.add(csvTuple.values().get(csvTuple.attributes().indexOfSchool()));//出身校
			values.add(csvTuple.values().get(csvTuple.attributes().indexOfParty()));//政党
			values.add(csvTuple.values().get(csvTuple.attributes().indexPlace()));//出身地
			values.add(this.computeStringOfImage(null, csvTuple, Integer.valueOf(csvTuple.values().get(csvTuple.attributes().indexOfNo()))));//画像
			Tuple tempTuple = new Tuple(htmlTable.attributes(), values);
			htmlTable.add(tempTuple);
		}
		return htmlTable;
	}

}

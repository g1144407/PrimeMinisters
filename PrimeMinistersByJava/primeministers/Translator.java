package primeministers;

import javax.swing.JOptionPane;
/**
 * トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。
 *
 * スタブ作成
 * @author 10/23 橋坂侑汰
 */
public class Translator extends Object{

    private Table inputTable;

    private Table outputTable;

    public Translator() {
        super();
        return;
    }

    public String computeNumberOfDays(String periodString) {
        return null;
    }

    public String computeStringOfImage(String aString, Tuple aTuple, int no) {
        return null;
    }

    /* 総理大臣のCSVファイルをHTMLページへ変換する */
    public void perform() {
        String aString = "総理大臣のCSVファイルからHTMLページへの変換を無事に完了しました。\n";
        JOptionPane.showMessageDialog(null, aString, "報告", JOptionPane.PLAIN_MESSAGE);
        return;

    }

    public Table table(Table aTable) {
        return null;
    }

}

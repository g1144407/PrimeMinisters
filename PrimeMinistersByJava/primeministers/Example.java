package primeministers;

/**
 * 例題プログラム：総理大臣のCSVファイルをHTMLページへと変換する。
 */
public class Example extends Object
{
	/**
	 * サンプルのメインプログラム。
	 * 第一引数：threadならばスレッド処理、2ならばレベル２の処理
	 * 第二引数：第一引数がthreadでかつ第二引数が2ならば、レベル２のスレッド処理
	 * それ以外ならば通常処理
	 */
	public static void main(String[] arguments)
	{
		// トランスレータのインスタンスを生成する。
		Translator aTranslator = new Translator();
		// トランスレータに総理大臣のCSVファイルをHTMLページへ（スレッドを用いて）変換するように依頼する。
		try{
			if(arguments[0].equals("thread")){
				if(arguments[1].equals("2"))aTranslator.threadPerform(2);
				else aTranslator.threadPerform(1);
			}
		// トランスレータに総理大臣のCSVファイルをHTMLページへ変換するように依頼する。
			else {
				if(arguments[0].equals("2")){
					aTranslator.perform(2);
				}
				else aTranslator.perform(1);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			aTranslator.perform(1);
		}
		return;
	}
}

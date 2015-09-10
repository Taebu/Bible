import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class BibleTest{

 public static void main(String[] args)  throws java.io.IOException{
  Hashtable<String, String> ht = new Hashtable<String, String>();
  
try {
	String[][] tmp = {{"1-01Ã¢¼¼±â",
"1-02Ãâ¾Ö±Á±â",
"1-03·¹À§±â",
"1-04¹Î¼ö±â",
"1-05½Å¸í±â",
"1-06¿©È£¼ö¾Æ",
"1-07»ç»ç±â",
"1-08·í±â",
"1-09»ç¹«¿¤»ó",
"1-10»ç¹«¿¤ÇÏ",
"1-11¿­¿Õ±â»ó",
"1-12¿­¿Õ±âÇÏ",
"1-13¿ª´ë»ó",
"1-14¿ª´ëÇÏ",
"1-15¿¡½º¶ó",
"1-16´ÀÇì¹Ì¾ß",
"1-17¿¡½º´õ",
"1-18¿é±â",
"1-19½ÃÆí",
"1-20Àá¾ð",
"1-21Àüµµ¼­",
"1-22¾Æ°¡",
"1-23ÀÌ»ç¾ß",
"1-24¿¹·¹¹Ì¾ß",
"1-25¿¹·¹¹Ì¾ß¾Ö°¡",
"1-26¿¡½º°Ö",
"1-27´Ù´Ï¿¤",
"1-28È£¼¼¾Æ",
"1-29¿ä¿¤",
"1-30¾Æ¸ð½º",
"1-31¿À¹Ù´ô",
"1-32¿ä³ª",
"1-33¹Ì°¡",
"1-34³ªÈÉ",
"1-35ÇÏ¹Ú±¹",
"1-36½º¹Ù³Ä",
"1-37ÇÐ°³",
"1-38½º°¡·ª",
"1-39¸»¶ó±â",
"2-01¸¶ÅÂº¹À½",
"2-02¸¶°¡º¹À½",
"2-03´©°¡º¹À½",
"2-04¿äÇÑº¹À½",
"2-05»çµµÇàÀü",
"2-06·Î¸¶¼­",
"2-07°í¸°µµÀü¼­",
"2-08°í¸°µµÈÄ¼­",
"2-09°¥¶óµð¾Æ¼­",
"2-10¿¡º£¼Ò¼­",
"2-11ºô¸³º¸¼­",
"2-12°ñ·Î»õ¼­",
"2-13µ¥»ì·Î´Ï°¡Àü¼­",
"2-14µ¥»ì·Î´Ï°¡ÈÄ¼­",
"2-15µð¸ðµ¥Àü¼­",
"2-16µð¸ðµ¥ÈÄ¼­",
"2-17µðµµ¼­",
"2-18ºô·¹¸ó¼­",
"2-19È÷ºê¸®¼­",
"2-20¾ß°íº¸¼­",
"2-21º£µå·ÎÀü¼­",
"2-22º£µå·ÎÈÄ¼­",
"2-23¿äÇÑÀÏ¼­",
"2-24¿äÇÑÀÌ¼­",
"2-25¿äÇÑ»ï¼­",
"2-26À¯´Ù¼­",
"2-27¿äÇÑ°è½Ã·Ï"},
{"Ã¢",
"Ãâ",
"·¹",
"¹Î",
"½Å",
"¼ö",
"»ñ",
"·í",
"»ï»ó",
"»ïÇÏ",
"¿Õ»ó",
"¿ÕÇÏ",
"´ë»ó",
"´ëÇÏ",
"½º",
"´À",
"¿¡",
"¿é",
"½Ã",
"Àá",
"Àü",
"¾Æ",
"»ç",
"·½",
"¾Ö",
"°Ö",
"´Ü",
"È£",
"¿ç",
"¾Ï",
"¿É",
"¿æ",
"¹Ì",
"³ª",
"ÇÕ",
"½À",
"ÇÐ",
"½»",
"¸»",
"¸¶",
"¸·",
"´ª",
"¿ä",
"Çà",
"·Ò",
"°íÀü",
"°íÈÄ",
"°¥",
"¿¦",
"ºô",
"°ñ",
"»ìÀü",
"»ìÈÄ",
"µõÀü",
"µõÈÄ",
"µó",
"¸ó",
"È÷",
"¾à",
"º¦Àü",
"º¦ÈÄ",
"¿äÀÏ",
"¿äÀÌ",
"¿ä»ï",
"À¯",
"°è"}};
	String tmpA = args[0];
	String tmpB = "";
	String searchStr = tmpA.replaceAll("([°¡-ÆR]+)([0-9]+):([0-9 ]+)","$1");
	String searchStr2 = tmpA.replaceAll("([°¡-ÆR]+)([0-9]+):([0-9 ]+)","$2");
	String verse = new String("Ã¢1:1 2");
	String versek = new String("Ã¢1:1 2");
	verse = tmpA.replaceAll("([°¡-ÆR]+)([0-9]+):([0-9 ]+)?([0-9]+)","$3");
	versek = tmpA.replaceAll("([°¡-ÆR]+)([0-9]+):([0-9 ]+)?([0-9]+)","$4");

	//int num = Integer.parseInt(number);
	searchStr = searchStr.trim(); 
	for (int i=0;i < 66 ;i++ )
	{
		if (searchStr.equals(tmp[1][i]))
			tmpB = tmp[0][i]; //À§Ä¡¸¦ Ã£¾Æ ÆÄÀÏ¸íÀ» ¹ÝÈ¯ÇÑ´Ù.
	}
	
	BufferedReader in = new BufferedReader(new FileReader("C:\\Bible\\GAE\\"+tmpB+".txt")); //ÆÄÀÏÀ» ºÒ·¯ µéÀÎ´Ù.
	String s;
	while ((s = in.readLine()) != null) {
		if (s.equals("") || s.charAt(0) == '#') { continue; }  //¶óÀÎÀÌ °ø¹éÀÌ°Å³ª Ã¹±ÛÀÚ°¡ #ÀÌ¸é ÆÐ½º
		String temp[] = s.split("\t"); // ÅÇÀ» ±âÁØÀ¸·Î ³ª´«´Ù.
		ht.put(temp[0],temp[1]); // ÀÐ¾îµéÀº ÆÄÀÏ ¸ðµç ³»¿ëÀ» hashÅ×ÀÌºí¿¡ ³Ö´Â´Ù.
	}
	in.close();
} catch(ArrayIndexOutOfBoundsException e){
	System.err.println("ÇØ´ç °á°ú°¡ nullÀÌ ³ª¿Ô´Ù¸é txt¿¡ Àß¸øµÈ ÅÇ ±¸ºÐÀÌ ÀÖÀ» ¼ö ÀÖ½À´Ï´Ù. ÇØ´ç±Ç¿¡ ÆÄÀÏÀ» ÂüÁ¶ÇÏ¼¼¿ä.");
}catch (IOException e) {
	System.err.println("ÇØ´ç ÆÄÀÏÀ» Ã£À» ¼ö ¾ø½À´Ï´Ù. °³¹ßÀÚ¿¡°Ô ¹®ÀÇÇÏ¼¼¿ä.");
	e.printStackTrace();
}
	String kor = "";

	
  if(args.length ==1)
  {
	kor = ht.get(args[0]);
  }else if(args.length ==2){
	//kor = ht.get("Ã¢1:1");
	for (int i=verse;i<= versek;i++ )
	{
		 System.out.println(i);
	}

  }
//String kkk=Integer.toString();
 System.out.println(args[0]+" "+kor);
// System.out.pirntln(kkk);
 /*
System.out.print("chapter"+searchStr2);
System.out.print("verse1"+verse1);
System.out.print("verse1"+verse2);
*/

 }//end main 
}//end Bible class
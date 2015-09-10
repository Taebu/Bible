import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class BibleTest{

 public static void main(String[] args)  throws java.io.IOException{
  Hashtable<String, String> ht = new Hashtable<String, String>();
  
try {
	String[][] tmp = {{"1-01창세기",
"1-02출애굽기",
"1-03레위기",
"1-04민수기",
"1-05신명기",
"1-06여호수아",
"1-07사사기",
"1-08룻기",
"1-09사무엘상",
"1-10사무엘하",
"1-11열왕기상",
"1-12열왕기하",
"1-13역대상",
"1-14역대하",
"1-15에스라",
"1-16느헤미야",
"1-17에스더",
"1-18욥기",
"1-19시편",
"1-20잠언",
"1-21전도서",
"1-22아가",
"1-23이사야",
"1-24예레미야",
"1-25예레미야애가",
"1-26에스겔",
"1-27다니엘",
"1-28호세아",
"1-29요엘",
"1-30아모스",
"1-31오바댜",
"1-32요나",
"1-33미가",
"1-34나훔",
"1-35하박국",
"1-36스바냐",
"1-37학개",
"1-38스가랴",
"1-39말라기",
"2-01마태복음",
"2-02마가복음",
"2-03누가복음",
"2-04요한복음",
"2-05사도행전",
"2-06로마서",
"2-07고린도전서",
"2-08고린도후서",
"2-09갈라디아서",
"2-10에베소서",
"2-11빌립보서",
"2-12골로새서",
"2-13데살로니가전서",
"2-14데살로니가후서",
"2-15디모데전서",
"2-16디모데후서",
"2-17디도서",
"2-18빌레몬서",
"2-19히브리서",
"2-20야고보서",
"2-21베드로전서",
"2-22베드로후서",
"2-23요한일서",
"2-24요한이서",
"2-25요한삼서",
"2-26유다서",
"2-27요한계시록"},
{"창",
"출",
"레",
"민",
"신",
"수",
"삿",
"룻",
"삼상",
"삼하",
"왕상",
"왕하",
"대상",
"대하",
"스",
"느",
"에",
"욥",
"시",
"잠",
"전",
"아",
"사",
"렘",
"애",
"겔",
"단",
"호",
"욜",
"암",
"옵",
"욘",
"미",
"나",
"합",
"습",
"학",
"슥",
"말",
"마",
"막",
"눅",
"요",
"행",
"롬",
"고전",
"고후",
"갈",
"엡",
"빌",
"골",
"살전",
"살후",
"딤전",
"딤후",
"딛",
"몬",
"히",
"약",
"벧전",
"벧후",
"요일",
"요이",
"요삼",
"유",
"계"}};
	String tmpA = args[0];
	String tmpB = "";
	String searchStr = tmpA.replaceAll("([가-힣]+)([0-9]+):([0-9 ]+)","$1");
	String searchStr2 = tmpA.replaceAll("([가-힣]+)([0-9]+):([0-9 ]+)","$2");
	String verse = new String("창1:1 2");
	String versek = new String("창1:1 2");
	verse = tmpA.replaceAll("([가-힣]+)([0-9]+):([0-9 ]+)?([0-9]+)","$3");
	versek = tmpA.replaceAll("([가-힣]+)([0-9]+):([0-9 ]+)?([0-9]+)","$4");

	//int num = Integer.parseInt(number);
	searchStr = searchStr.trim(); 
	for (int i=0;i < 66 ;i++ )
	{
		if (searchStr.equals(tmp[1][i]))
			tmpB = tmp[0][i]; //위치를 찾아 파일명을 반환한다.
	}
	
	BufferedReader in = new BufferedReader(new FileReader("C:\\Bible\\GAE\\"+tmpB+".txt")); //파일을 불러 들인다.
	String s;
	while ((s = in.readLine()) != null) {
		if (s.equals("") || s.charAt(0) == '#') { continue; }  //라인이 공백이거나 첫글자가 #이면 패스
		String temp[] = s.split("\t"); // 탭을 기준으로 나눈다.
		ht.put(temp[0],temp[1]); // 읽어들은 파일 모든 내용을 hash테이블에 넣는다.
	}
	in.close();
} catch(ArrayIndexOutOfBoundsException e){
	System.err.println("해당 결과가 null이 나왔다면 txt에 잘못된 탭 구분이 있을 수 있습니다. 해당권에 파일을 참조하세요.");
}catch (IOException e) {
	System.err.println("해당 파일을 찾을 수 없습니다. 개발자에게 문의하세요.");
	e.printStackTrace();
}
	String kor = "";

	
  if(args.length ==1)
  {
	kor = ht.get(args[0]);
  }else if(args.length ==2){
	//kor = ht.get("창1:1");
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
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class BibleTest{

 public static void main(String[] args)  throws java.io.IOException{
  Hashtable<String, String> ht = new Hashtable<String, String>();
  
try {
	String[][] tmp = {{"1-01â����",
"1-02��ֱ���",
"1-03������",
"1-04�μ���",
"1-05�Ÿ��",
"1-06��ȣ����",
"1-07����",
"1-08���",
"1-09�繫����",
"1-10�繫����",
"1-11���ձ��",
"1-12���ձ���",
"1-13�����",
"1-14������",
"1-15������",
"1-16����̾�",
"1-17������",
"1-18���",
"1-19����",
"1-20���",
"1-21������",
"1-22�ư�",
"1-23�̻��",
"1-24�����̾�",
"1-25�����̾߾ְ�",
"1-26������",
"1-27�ٴϿ�",
"1-28ȣ����",
"1-29�俤",
"1-30�Ƹ�",
"1-31���ٴ�",
"1-32�䳪",
"1-33�̰�",
"1-34����",
"1-35�Ϲڱ�",
"1-36���ٳ�",
"1-37�а�",
"1-38������",
"1-39�����",
"2-01���º���",
"2-02��������",
"2-03��������",
"2-04���Ѻ���",
"2-05�絵����",
"2-06�θ���",
"2-07��������",
"2-08�����ļ�",
"2-09�����Ƽ�",
"2-10�����Ҽ�",
"2-11��������",
"2-12��λ���",
"2-13����δϰ�����",
"2-14����δϰ��ļ�",
"2-15�������",
"2-16����ļ�",
"2-17�𵵼�",
"2-18������",
"2-19���긮��",
"2-20�߰���",
"2-21���������",
"2-22������ļ�",
"2-23�����ϼ�",
"2-24�����̼�",
"2-25���ѻＭ",
"2-26���ټ�",
"2-27���Ѱ�÷�"},
{"â",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"���",
"����",
"�ջ�",
"����",
"���",
"����",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"ȣ",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"��",
"����",
"����",
"��",
"��",
"��",
"��",
"����",
"����",
"����",
"����",
"��",
"��",
"��",
"��",
"����",
"����",
"����",
"����",
"���",
"��",
"��"}};
	String tmpA = args[0];
	String tmpB = "";
	String searchStr = tmpA.replaceAll("([��-�R]+)([0-9]+):([0-9 ]+)","$1");
	String searchStr2 = tmpA.replaceAll("([��-�R]+)([0-9]+):([0-9 ]+)","$2");
	String verse = new String("â1:1 2");
	String versek = new String("â1:1 2");
	verse = tmpA.replaceAll("([��-�R]+)([0-9]+):([0-9 ]+)?([0-9]+)","$3");
	versek = tmpA.replaceAll("([��-�R]+)([0-9]+):([0-9 ]+)?([0-9]+)","$4");

	//int num = Integer.parseInt(number);
	searchStr = searchStr.trim(); 
	for (int i=0;i < 66 ;i++ )
	{
		if (searchStr.equals(tmp[1][i]))
			tmpB = tmp[0][i]; //��ġ�� ã�� ���ϸ��� ��ȯ�Ѵ�.
	}
	
	BufferedReader in = new BufferedReader(new FileReader("C:\\Bible\\GAE\\"+tmpB+".txt")); //������ �ҷ� ���δ�.
	String s;
	while ((s = in.readLine()) != null) {
		if (s.equals("") || s.charAt(0) == '#') { continue; }  //������ �����̰ų� ù���ڰ� #�̸� �н�
		String temp[] = s.split("\t"); // ���� �������� ������.
		ht.put(temp[0],temp[1]); // �о���� ���� ��� ������ hash���̺� �ִ´�.
	}
	in.close();
} catch(ArrayIndexOutOfBoundsException e){
	System.err.println("�ش� ����� null�� ���Դٸ� txt�� �߸��� �� ������ ���� �� �ֽ��ϴ�. �ش�ǿ� ������ �����ϼ���.");
}catch (IOException e) {
	System.err.println("�ش� ������ ã�� �� �����ϴ�. �����ڿ��� �����ϼ���.");
	e.printStackTrace();
}
	String kor = "";

	
  if(args.length ==1)
  {
	kor = ht.get(args[0]);
  }else if(args.length ==2){
	//kor = ht.get("â1:1");
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
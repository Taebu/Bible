import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/*

오류유형: 2014.12.19
오류1: ?오류
오류2: 탭으로 구분되지 않는 부분이 있었음.
오류3: 절이 순차적으로 증가되지 않은 부분이 있었음.

*/
public class Bible {

	final static String[][] arrTables = {
		{ "1-01창세기", "1-02출애굽기", "1-03레위기", "1-04민수기", "1-05신명기",
			"1-06여호수아", "1-07사사기", "1-08룻기", "1-09사무엘상", "1-10사무엘하",
			"1-11열왕기상", "1-12열왕기하", "1-13역대상", "1-14역대하", "1-15에스라",
			"1-16느헤미야", "1-17에스더", "1-18욥기", "1-19시편", "1-20잠언",
			"1-21전도서", "1-22아가", "1-23이사야", "1-24예레미야", "1-25예레미야애가",
			"1-26에스겔", "1-27다니엘", "1-28호세아", "1-29요엘", "1-30아모스",
			"1-31오바댜", "1-32요나", "1-33미가", "1-34나훔", "1-35하박국",
			"1-36스바냐", "1-37학개", "1-38스가랴", "1-39말라기", "2-01마태복음",
			"2-02마가복음", "2-03누가복음", "2-04요한복음", "2-05사도행전", "2-06로마서",
			"2-07고린도전서", "2-08고린도후서", "2-09갈라디아서", "2-10에베소서",
			"2-11빌립보서", "2-12골로새서", "2-13데살로니가전서", "2-14데살로니가후서",
			"2-15디모데전서", "2-16디모데후서", "2-17디도서", "2-18빌레몬서",
			"2-19히브리서", "2-20야고보서", "2-21베드로전서", "2-22베드로후서",
			"2-23요한일서", "2-24요한이서", "2-25요한삼서", "2-26유다서", "2-27요한계시록" },
			{ "창", "출", "레", "민", "신", "수", "삿", "룻", "삼상", "삼하", "왕상", "왕하",
				"대상", "대하", "스", "느", "에", "욥", "시", "잠", "전", "아", "사",
				"렘", "애", "겔", "단", "호", "욜", "암", "옵", "욘", "미", "나", "합",
				"습", "학", "슥", "말", "마", "막", "눅", "요", "행", "롬", "고전",
				"고후", "갈", "엡", "빌", "골", "살전", "살후", "딤전", "딤후", "딛", "몬",
				"히", "약", "벧전", "벧후", "요일", "요이", "요삼", "유", "계" } };

//	final static String location=new java.io.File( "." ).getCanonicalPath().replace("\\", "\\\\");
	
//	location=location;
//	final static String BIBLE_DB_PATH = "C:\\Bible\\GAE\\";
	String keyword;	//검색어
	String book;			//책
	int chapter;			//장
	int verse;				//절

	final static String BIBLE_DB_PATH = "D:\\local\\Bible\\GAE\\";
	String location=BIBLE_DB_PATH;

	final static String FIND_PATTERN = "([가-힣]+)\\s*([0-9]+):([0-9]+)-([0-9]+)";
	final static String FIND_PATTERN2 = "[0-9\\.tx\\-]";
	final static String FIND_PATTERN3 = "\\<[^\\>]+\\>";
	final static String FIND_PATTERN4 = "[0-9]";
	int search_cnt=0;	
	
	/*객체 지향 형으로 변경 
	2015-09-10 (목)
	getGroup
	*/
	String getTest(){
		String str="get Test String";
		return str;
	}
	
	int getSearch_cnt(){
		return this.search_cnt;
	}

	void setSearch_cnt(int v){
		this.search_cnt=v;
	}

	/* getKeyword 
	검색어로 된 구절을 반환 합니다.
	@key
	*/
	String getKeyword(String key){
		return key;
	}
	
	/* getWord 
	구절로 된 위치를 반환 합니다.
	@key
	*/
	String getWord(String key){
		return key;
	}

	/*객체 지향 형으로 변경 
	2015-09-10 (목)
	setGroup
	*/

	/* 구현부 (implement)*/
	public static void main(String[] args) throws java.io.IOException {

		String tmpA = "";
		String s = "";

		String searchStr1="",searchStr2="",searchStr3="",searchStr4="";
		String searchKeyWord1="", searchKeyWord2="", searchKeyWord3="", searchKeyWord4="";

		/**
		* 키워드 검색 인지 구절 검색인지 판단, 
		* 기본값은 'false'로 구절 검색이다. 
		*/
		boolean isKeywordSearch = false;
		
		Bible bi = new Bible();

		if (args.length == 0) {
			// throw new RuntimeException("");
//			System.out.println("왜 안되??");
//			System.out.println(bi.getTest());
			showUsage();

			return;
		}
		
		if(args.length==1)
		{
			searchKeyWord1 = args[0];
			if(searchKeyWord1.replaceAll(FIND_PATTERN4,"").equals(searchKeyWord1)) {
				isKeywordSearch = true;
			}
		}
		else if(args.length==2)
		{
			searchKeyWord1 = args[0];
			searchKeyWord2 = args[1];
			
			if(searchKeyWord1.replaceAll(FIND_PATTERN4,"").equals(searchKeyWord1)) {
				isKeywordSearch = true;
			}
			if(isKeywordSearch == false && searchKeyWord2.replaceAll(FIND_PATTERN4,"").equals(searchKeyWord2)) {
				isKeywordSearch = true;
			}
		}
		else if(args.length==3)
		{
			searchKeyWord1 = args[0];
			searchKeyWord2 = args[1];
			searchKeyWord3 = args[2];
			
			if(searchKeyWord1.replaceAll(FIND_PATTERN4,"").equals(searchKeyWord1)) {
				isKeywordSearch = true;
			}
			if(isKeywordSearch == false && searchKeyWord2.replaceAll(FIND_PATTERN4,"").equals(searchKeyWord2)) {
				isKeywordSearch = true;
			}
			if(isKeywordSearch == false && searchKeyWord3.replaceAll(FIND_PATTERN4,"").equals(searchKeyWord3)) {
				isKeywordSearch = true;
			}
		}
		else if(4 <= args.length)
		{
			searchKeyWord1 = args[0];
			searchKeyWord2 = args[1];
			searchKeyWord3 = args[2];
			searchKeyWord4 = args[3];
			
			if(searchKeyWord1.replaceAll(FIND_PATTERN4,"").equals(searchKeyWord1)) {
				isKeywordSearch = true;
			}
			if(isKeywordSearch == false && searchKeyWord2.replaceAll(FIND_PATTERN4,"").equals(searchKeyWord2)) {
				isKeywordSearch = true;
			}
			if(isKeywordSearch == false && searchKeyWord3.replaceAll(FIND_PATTERN4,"").equals(searchKeyWord3)) {
				isKeywordSearch = true;
			}
			if(isKeywordSearch == false && searchKeyWord4.replaceAll(FIND_PATTERN4,"").equals(searchKeyWord4)) {
				isKeywordSearch = true;
			}
		}
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		
		if(isKeywordSearch)
		{
			//키워드 검색
			if (args.length == 1) {
				for(int j=0;j<66;j++) {
					String strFileName=arrTables[0][j];
					int old_i1=0,old_i2=0,i1,i2;
					BufferedReader in = new BufferedReader(new FileReader(BIBLE_DB_PATH + strFileName + ".txt"));
					int i=0;
					while ((s = in.readLine()) != null) {
						if (s.equals("")){
							continue;
						} // 라인이 공백이거나 첫글자가 #이면 패스
						if(-1 < s.indexOf(args[0])) {//해당절만 메모리에 넣는다.
							ht.put("" +i++, s); // ht에 넣음
						}
					}
					in.close();
				}
				 
			} else if (args.length == 2) {
				for(int j=0;j<66;j++) {
					String strFileName=arrTables[0][j];
					int old_i1=0,old_i2=0,i1,i2;
					BufferedReader in = new BufferedReader(new FileReader(BIBLE_DB_PATH + strFileName + ".txt"));
					int i=0;
					while ((s = in.readLine()) != null) {
						if (s.equals("")){
							continue;
						} // 라인이 공백이거나 첫글자가 #이면 패스
						if(-1 < s.indexOf(args[0]) && -1 < s.indexOf(args[1])) {//해당절만 메모리에 넣는다.
							ht.put("" +i++, s); // ht에 넣음

						}
					}
					in.close();
				}
			} else if (args.length == 3) {
				for(int j=0;j<66;j++) {
					String strFileName=arrTables[0][j];
					int old_i1=0,old_i2=0,i1,i2;
					BufferedReader in = new BufferedReader(new FileReader(BIBLE_DB_PATH + strFileName + ".txt"));
					int i=0;
					while ((s = in.readLine()) != null) {
						if (s.equals("")){
							continue;
						} // 라인이 공백이거나 첫글자가 #이면 패스
						if(-1 < s.indexOf(args[0]) && -1 < s.indexOf(args[1]) && -1 < s.indexOf(args[2])) {//해당절만 메모리에 넣는다.
							ht.put("" +i++, s); // ht에 넣음
						}
					}
					in.close();
				}
			} else {
				for(int j=0;j<66;j++) {
					String strFileName=arrTables[0][j];
					int old_i1=0,old_i2=0,i1,i2;
					BufferedReader in = new BufferedReader(new FileReader(BIBLE_DB_PATH + strFileName + ".txt"));
					int i=0;
					while ((s = in.readLine()) != null) {
						if (s.equals("")){
							continue;
						} // 라인이 공백이거나 첫글자가 #이면 패스
						if(-1 < s.indexOf(args[0]) && -1 < s.indexOf(args[1]) && -1 < s.indexOf(args[2]) && -1 < s.indexOf(args[3])) {//해당절만 메모리에 넣는다.
							ht.put("" +i++, s); // ht에 넣음
						}
					}
					in.close();
				}
			} 
			int search_cnt=0;
			for(int i = 0;i<ht.size();i++) {
				System.out.println(ht.get(""+i));
				search_cnt++;
			}
			bi.setSearch_cnt(search_cnt);
			System.out.println("검색어 \""+args[0]+"\"로 총 "+bi.getSearch_cnt()+"개가 검색 되었습니다.");
		}
		else{
			//장:절 검색
			if (args.length == 1) {
				tmpA = args[0].trim();
				if (-1 < tmpA.indexOf("-")) {
					if (tmpA.indexOf(":") == -1) {
						showUsage();// -이 있는데 :이 없다면 포맷 오류이다.
						return;
					} else {
						// 창3:4-4 이런식이다. OK
					}
				} else {
					int posColone = tmpA.indexOf(":");
					if (-1 < posColone) {
						// 창3:4 이런식이다.
						tmpA = tmpA + "-" + tmpA.substring(posColone + 1);// 창3:4-4
						// 이렇게
						// 바꾼다.
					} else {
						// 창4 이런식이다.
						tmpA = args[0] + ":1-999";
					}
				}
			} else if (args.length == 2) {
				if (-1 < args[0].indexOf(":")) {// 창1:3 4
					tmpA = args[0] + "-" + args[1];
				} else {// 창 1 인경우, 창 1:1, 창 1:3-4
					if (-1 < args[1].indexOf("-") && -1 < args[1].indexOf(":")) {
						tmpA = args[0] + args[1];
					} else if (-1 == args[1].indexOf("-")
							&& -1 < args[1].indexOf(":")) {// 창 1:3
						tmpA = args[0] + args[1];
	
						int posColone = tmpA.indexOf(":");
						if (-1 < posColone) {
							// 창3:4 이런식이다.
							tmpA = tmpA + "-" + tmpA.substring(posColone + 1);// 창3:4-4
							// 이렇게
							// 바꾼다.
						} else {
							// 창4 이런식이다.
							tmpA = args[0] + ":1-999";
						}
					} else {
						tmpA = args[0] + args[1] + ":1-999";
					}
				}
			} else if (args.length == 3) {
				tmpA = args[0] + args[1] + "-" + args[2];
			} else {
				showUsage();// 인자가 너무 많아도 오류이다.
				return;
			}

			String strFileName = "";
			String strBookIndexName = "";
			try {
				strBookIndexName = tmpA.replaceAll(FIND_PATTERN, "$1");

				strBookIndexName = strBookIndexName.trim();
				for (int i = 0; i < 66; i++) {
					if (strBookIndexName.equals(arrTables[1][i])
							|| strBookIndexName.equals(arrTables[0][i].replaceAll(
									FIND_PATTERN2, ""))) {
						strBookIndexName = arrTables[1][i];// 약어로 변경한다.
						strFileName = arrTables[0][i];
						break;
					}
				}

				if ("".equals(strFileName)) {// 파일이름을 못찾았다는 것은 format이 일치하지 않다는 것이다.
					showUsage();
					return;
				}

				searchStr1 = strBookIndexName;// tmpA.replaceAll(FIND_PATTERN,
				// "$1");
				searchStr2 = tmpA.replaceAll(FIND_PATTERN, "$2");
				searchStr3 = tmpA.replaceAll(FIND_PATTERN, "$3");
				searchStr4 = tmpA.replaceAll(FIND_PATTERN, "$4");

				boolean bFinded=false;
				//			 for(int j=0;j<66;j++) {
				//			 strFileName=arrTables[0][j];
				//			int old_i1=0,old_i2=0,i1,i2;
				BufferedReader in = new BufferedReader(new FileReader(BIBLE_DB_PATH + strFileName + ".txt"));

				while ((s = in.readLine()) != null) {
					if (s.equals("")/*|| s.charAt(0) == '#'*/) {
						continue;
					} // 라인이 공백이거나 첫글자가 #이면 패스
					if(s.startsWith(strBookIndexName+searchStr2+":")){//해당절만 메모리에 넣는다.
						String temp[] = s.split("\t");
						//				String str1 = temp[0].replaceAll("[ㄱ-힣]+([0-9]+):[0-9]+","$1");
						//				String str2 = temp[0].replaceAll("[ㄱ-힣]+[0-9]+:([0-9]+)","$1");
						//
						//				i1 = Integer.parseInt(str1);
						//				i2 = Integer.parseInt(str2);
						//				
						//				if(!((i1==i2 && i1==1) || old_i1+1==i1 || old_i2+1==i2 )){
						//					throw new RuntimeException(strFileName+s);
						//				}
						//				old_i1 = i1;
						//				old_i2 = i2;
						ht.put(temp[0], temp[1]); // ht에 넣음
						bFinded = true;
					}
					else {
						if(bFinded) {
							break;
						}
					}
				}
				in.close();
				//			 }

				// String location = new java.io.File(".").getCanonicalPath();
				// location = location.replace("\\", "\\\\");

			} catch (ArrayIndexOutOfBoundsException e) {
				System.err
				.println("해당 결과가 null이 나왔다면 txt에 잘못된 탭구분이 있을 수 있습니다. 해당권에 파일을 참조하세요."
						+ s);
			} catch (IOException e) {
				System.err.println("해당 파일을 찾을 수 없습니다." + e.getMessage());

				e.printStackTrace();
			}
			catch (Exception e) {
				System.err.println("[Error]" + e.getMessage());
				e.printStackTrace();
			}

			String kor = "";

			try {
				// String tmpB =args[1];
			} catch (ArrayIndexOutOfBoundsException e) {
				// String tmpB ="";
				System.err
				.println("해당 결과가 null이 나왔다면 txt에 잘못된 탭구분이 있을 수 있습니다. 해당권에 파일을 참조하세요.");
			}

			StringBuilder c = new StringBuilder();
			String tmp2thValue = "";

			int lstNum = 0;

			for (int i = Integer.parseInt(searchStr3); i <= Integer.parseInt(searchStr4); i++) {
				kor = ht.get(searchStr1 + searchStr2 + ":" + i);
				if (kor == null || kor == "") {
					break;
				}
				c.append(i + (" " + kor.replaceAll(FIND_PATTERN3,"")).replaceAll("  "," ") + "\n");
				lstNum = i;
			}

			if(Integer.parseInt(searchStr3) == lstNum) {
				System.out.println(strBookIndexName + searchStr2 + ":" + searchStr3);
				System.out.println(strFileName.replaceAll(FIND_PATTERN2, "") + searchStr2 + ":" + searchStr3);
			}else {
				System.out.println(strBookIndexName + searchStr2 + ":" + searchStr3 + "-" + Integer.toString(lstNum));
				System.out.println(strFileName.replaceAll(FIND_PATTERN2, "") + searchStr2 + ":" + searchStr3 + "-" + Integer.toString(lstNum));
			}
			System.out.println(c);
		}
	}

	/**
	 * 
	 */
	public static void showUsage() {
		System.out.println("성경 요절이나 성구의 키워드만 넣으면 검색이 됩니다.");
		System.out.println("");
		System.out.println("java Bible[성경이름 or 약어 이름][경로 장[:]절]");

		System.out.println("  /A          주석 및 등장인물의 이름을 출력 합니다.");
		System.out.println("인자가 1개 이상 숫자를 포함하는 경우");
		System.out.println("사용예2:java Bible 창1:2");
		System.out.println("사용예3:java Bible 창1:2-3");
		System.out.println("사용예4:java Bible 창세기1");
		System.out.println("사용예5:java Bible 창세기1:2");
		System.out.println("사용예6:java Bible 창세기1:2-3");
		System.out.println("사용예7:java Bible 창 1");
		System.out.println("사용예8:java Bible 창 1:2");
		System.out.println("사용예9:java Bible 창 1:2-3");
		System.out.println("사용예10:java Bible 창세기 1");
		System.out.println("사용예11:java Bible 창세기 1:2");
		System.out.println("사용예12:java Bible 창세기 1:2-3");
		System.out.println("사용예13:java Bible 동방 박사");

/*		
C:\Users\Taebu>dir /?
디렉터리에 있는 파일과 하위 디렉터리 목록을 보여 줍니다.

DIR [드라이브:][경로][파일 이름] [/A[[:]특성]] [/B] [/C] [/D] [/L] [/N]
  [/O[[:]정렬 순서]] [/P] [/Q] [/R] [/S] [/T[[:]시간 필드]] [/W] [/X] [/4]

  [드라이브:][경로][파일 이름]
              나타낼 드라이브, 디렉터리 및/또는 파일을 지정합니다.

  /A          지정된 특성을 가진 파일을 보여 줍니다.
  특성         D  디렉터리                R  읽기 전용 파일
               H  숨김 파일               A  기록 파일
               S  시스템 파일             I  콘텐츠가 인덱싱되지 않은 파일
               L  재분석 지점             -  부정을 뜻하는 접두사
  /B          최소 형식을 사용합니다(머리말 정보나 요약 없음).
  /C          파일 크기에 1000단위로 분리 기호를 보여 줍니다.  이것은 기본값
              입니다. 분리 기호를 표시하지 않으려면 /-C를 사용하십시오.
  /D          /W와 같으나 세로로 배열하여 보여 줍니다.
  /L          소문자를 사용합니다.
  /N          파일 이름이 제일 오른쪽에 오도록 새로운 긴 목록 형식을 사용합니다.
  /O          파일을 정렬된 순서로 보여 줍니다.
  정렬 순서    N  이름순(문자 순서)        S  크기순(작은 것 먼저)
               E  확장명순(문자 순서)      D  날짜/시간순(가장 이전 것 먼저)
               G  그룹 디렉터리 먼저       -  순서를 반대로 하는 접두사
  /P          정보가 한 화면에 꽉 차면 잠깐 멈춥니다.
  /Q          파일 소유자를 보여 줍니다.
  /R          파일의 대체 데이터 스트림을 표시합니다.
  /S          지정한 디렉터리와 하위 디렉터리를 포함하여 보여 줍니다.
  /T          정렬에 사용할 시간 필드를 지정합니다.
  시간 필드   C  작성한 시간
              A 마지막 액세스한 시간
              W  마지막 기록한 시간
  /W          이름만 가로로 배열하여 보여 줍니다.
  /X          8.3 파일 이름이 아닌 파일에 대한 짧은 이름을 보여 줍니다.
              이 형식은 긴 이름 앞에 짧은 이름이 추가된 것으로 /N 형식과
              같습니다. 짧은 이름이 없으면
              공백을 보여 줍니다.
  /4          4자릿수 연도를 표시합니다.

스위치를 DIRCMD 환경 변수로 미리 설정할 수 있습니다. 하이픈(-)을
스위치 앞에 접두 기호로 주면 미리 설정된 스위치에 우선합니다(예, /-W).
git ...
*/
	}	
}
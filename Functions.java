package taebu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Functions extends Valiables{
	String get_where(String str)
	{
		String retVal="1";
		String chapter="";

		chapter = str;

		for (int i = 0; i < arrTables[1].length; i++) {
			if(chapter.equals(arrTables[1][i]))
			{
				retVal=String.valueOf(i);;
				this.strBookIndexFullName=arrTables[0][i];
			}
		}
		return retVal;
	}


	
	String get_version(String[] args)
	{
		String retVal="KORNKRV.sqlite";

		try{

		String key=args[0].substring(0, 2);

		Map<String, String> bibleMap = new HashMap<String, String>();
		/* 현대어 성경 */
		bibleMap.put("kh" ,"KORTKV.sqlite");
		/* 새번역 성경 */
		bibleMap.put("kn" ,"kornrsv.sqlite");
		/* 쉬운 성경 */
		bibleMap.put("ke" ,"koreasy.sqlite");
		/* 개역 한글 국한문 성경 */
		bibleMap.put("ko" ,"korHChV.sqlite");
		/* 킹제임스흠정역 성경 */
		bibleMap.put("kk" ,"KORHKJV.sqlite");
		/* KJV */
		bibleMap.put("ek" ,"ENGKJV.sqlite");
		/* NewKJV */
		bibleMap.put("en" ,"ENGNKJV.sqlite");
		
		/* Eng ESV */
		bibleMap.put("ee" ,"ENGESV.sqlite");
		/* Eng NIV */
		bibleMap.put("ei" ,"ENGNIV.sqlite");
		
		/* Hebrew */
		bibleMap.put("hb" ,"bible_hebrew.sqlite");
		/* Hebrew */
		bibleMap.put("gr" ,"bible_greek.sqlite");

			retVal=bibleMap.get(key);

			if(retVal==null){
				retVal="KORNKRV.sqlite";
			}else{
//				args[0]=args[0].replaceAll(key, "");
			}
		}catch(ArrayIndexOutOfBoundsException e){
		/*개역개정*/
		retVal="KORNKRV.sqlite";
		}
		return retVal; 
	}
	


	String get_version_name(String[] args)
	{
		String originVal="개역개정";
		String retVal="개역개정";
		stringArgs = args;
		try{

		String key=args[0].substring(0, 2);

		Map<String, String> bibleMap = new HashMap<String, String>();
		/* 현대어 성경 */
		bibleMap.put("kh" ,"현대어");
		/* 새번역 성경 */
		bibleMap.put("kn" ,"새번역");
		/* 쉬운 성경 */
		bibleMap.put("ke" ,"쉬운 성경");
		/* 개역 한글 국한문 성경 */
		bibleMap.put("ko" ,"개역 한글 국한문");
		/* 킹제임스흠정역 성경 */
		bibleMap.put("kk" ,"킹제임스흠정역");
		/* KJV */
		bibleMap.put("ek" ,"KJV");
		/* NewKJV */
		bibleMap.put("en" ,"NewKJV");
		/* Hebrew */
		bibleMap.put("hb" ,"Hebrew");

		/* Eng ESV */
		bibleMap.put("ee" ,"영문ESV");
		/* Eng NIV */
		bibleMap.put("ei" ,"영문NIV");
		
		/* Greek */
		bibleMap.put("gr" ,"Greek");
		
			retVal=bibleMap.get(key);
			if(retVal==null) {
				retVal= originVal;
			}else if(!originVal.equals(retVal)) {
				stringArgs = removeFirstElement(args);
			}
		}catch(ArrayIndexOutOfBoundsException e){
		/*개역개정*/
		retVal="개역개정";
		}
		return retVal; 
	}
	
	public static String[] removeFirstElement(String[] arr) {
	        return Arrays.copyOfRange(arr, 1, arr.length);
		}
	
	String get_chapter(String[] args)
	{
		String retVal="1";
		try{
		retVal=args[0].replaceAll(FIND_PATTERN, "$2");
		}catch(ArrayIndexOutOfBoundsException e){
		}
		return retVal;
	}
	
	//장:절 검색
	String search_verse(String[] args)
	{
		String retVal="";
		if (args.length == 1) {
			retVal = args[0].trim();
			if (-1 < retVal.indexOf("-")) {
				if (retVal.indexOf(":") == -1) {
					showUsage();// -이 있는데 :이 없다면 포맷 오류이다.
				} else {
					// 창3:4-4 이런식이다. OK
				}
			} else {
				int posColone = retVal.indexOf(":");
				if (-1 < posColone) {
					// 창3:4 이런식이다.
					retVal = retVal + "-" + retVal.substring(posColone + 1);// 창3:4-4
					// 이렇게
					// 바꾼다.
				} else {
					// 창4 이런식이다.
					retVal = args[0] + ":1-999";
				}
			}
		} else if (args.length == 2) {
			if (-1 < args[0].indexOf(":")) {// 창1:3 4
				retVal = args[0] + "-" + args[1];
			} else {// 창 1 인경우, 창 1:1, 창 1:3-4
				if (-1 < args[1].indexOf("-") && -1 < args[1].indexOf(":")) {
					retVal = args[0] + args[1];
				} else if (-1 == args[1].indexOf("-")
						&& -1 < args[1].indexOf(":")) {// 창 1:3
					retVal = args[0] + args[1];

					int posColone = retVal.indexOf(":");
					if (-1 < posColone) {
						// 창3:4 이런식이다.
						retVal = retVal + "-" + retVal.substring(posColone + 1);// 창3:4-4
						// 이렇게
						// 바꾼다.
					} else {
						// 창4 이런식이다.
						retVal = args[0] + ":1-999";
					}
				} else {
					retVal = args[0] + args[1] + ":1-999";
				}
			}
		} else if (args.length == 3) {
			retVal = args[0] + args[1] + "-" + args[2];
		} else {
			showUsage();// 인자가 너무 많아도 오류이다.
		}
		/* 장절 검색 끝*/
		return retVal;
	}


	/* iskeyword
	키워드인지 구분
	*/
	boolean isKeyword(String[] args)
	{
		boolean isKeywordSearch=false;
		String searchKeyWord1="", searchKeyWord2="", searchKeyWord3="", searchKeyWord4="";	
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
		return isKeywordSearch;
	}


	/**
	 * 
	 */
	public static void showUsage() {
		System.out.println("성경 요절이나 성구의 키워드만 넣으면 검색이 됩니다.");
		System.out.println("");
		System.out.println("java  -cp \".;c:\\Bible\\sqlite-jdbc-3.16.1.jar\" Program[성경버전성경이름 or 약어 이름][경로 장[:]절]");

		System.out.println("  /A          주석 및 등장인물의 이름을 출력 합니다.");
		System.out.println("인자가 1개 이상 숫자를 포함하는 경우");
		System.out.println("사용예2:java Program 창1:2");
		System.out.println("사용예3:java Program 창1:2-3");
		System.out.println("사용예4:java Program 창세기1");
		System.out.println("사용예5:java Program 창세기1:2");
		System.out.println("사용예6:java Program 창세기1:2-3");
		System.out.println("사용예7:java Program 창 1");
		System.out.println("사용예8:java Program 창 1:2");
		System.out.println("사용예9:java Program 창 1:2-3");
		System.out.println("사용예10:java Program 창세기 1");
		System.out.println("사용예11:java Program 창세기 1:2");
		System.out.println("사용예12:java Program 창세기 1:2-3");
		System.out.println("사용예13:java Program 동방 박사");
		System.out.println("사용예15[개역개정한글]:java Program 창1:1 ");
		System.out.println("사용예14[현대어]:java Program kh창1:1 ");
		System.out.println("사용예15[새번역]:java Program kn창1:1 ");
		System.out.println("사용예16[쉬운성경]:java Program ke창1:1 ");
		System.out.println("사용예17[개역한글국한문]:java Program ko창1:1 ");
		System.out.println("사용예18[킹제임스흠정역]:java Program kk창1:1 ");
		System.out.println("사용예19[킹제임스영문]:java Program ek창1:1 ");
		System.out.println("사용예20[뉴킹제임스영문]:java Program en창1:1 ");
		System.out.println("사용예21[웨스터민스터 신앙고백서 1장1항]:java Program 웨1:1 ");

	}	

	public static void searchKeyword(String[] args) throws SQLException {
		String sql;
		String searchstr="";
		Statement statement = getStatement();
		int i=0;
		for(i=0;i<args.length;i++){
		searchstr+=" "+args[i].trim();
		}
		searchstr=searchstr.trim();
		sql="select *,replace(content,'"+searchstr+"','\""+searchstr+"\"') content2 from bible where content like '%"+searchstr+"%';";
		ResultSet rs=statement.executeQuery(sql);
		i=0;
		while(rs.next())
		{
			
		int  ibook = rs.getInt("book");
		
		String  chapters = rs.getString("chapter");
		String  verse = rs.getString("verse");
		String  content2 = rs.getString("content2");

		System.out.print("[ "+version_name+" ]");
		System.out.print(arrTables[1][ibook]+" ");
		 System.out.print(chapters+":"+verse+" ");
		 System.out.print(content2);
		 System.out.println();
		 i++;
		}
		System.out.println("총 검색 결과 "+i+"개가 검색 되었습니다.");
	}
	
	public static void getBible() throws SQLException {
		String sql;
		Connection connection = getConnection();
		Statement statement = getStatement();
		if(version_name.equals("Hebrew"))
		{
			sql="select c1content as content,";
			sql+="c5chapter_no as chapter,";
			sql+="c6verse_no as verse ";
			sql+="from bible_hebrew ";
			sql+="where c4book_no='"+book+"' ";
			sql+="and c5chapter_no='"+chapter+"' ";
			sql+=" and c6verse_no>='"+start_a_verse;
			sql+="' and c6verse_no<='"+end_of_verse+"';";

		}else if(version_name.equals("Greek")){
			sql="select c1content as content,";
			sql+="c5chapter_no as chapter,";
			sql+="c6verse_no as verse ";
			sql+="from bible_greek ";
			sql+="where c4book_no='"+book+"' ";
			sql+="and c5chapter_no='"+chapter+"' ";
			sql+=" and c6verse_no>='"+start_a_verse;
			sql+="' and c6verse_no<='"+end_of_verse+"';";
		}else{
			sql="select * from bible where book='"+book;
			sql+="' and chapter='"+chapter;
			sql+="' and verse>='"+start_a_verse;
			sql+="' and verse<='"+end_of_verse+"';";
		}
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next())
		{
			String  chapters = rs.getString("chapter");
			String  verse = rs.getString("verse");

			
			 System.out.print(verse+" ");
			 System.out.print(rs.getString("content"));
			 
			 System.out.println();
			
		}
		/* resultSet 닫기 */
		rs.close();
		/* DB와의 연결 닫기 */
		connection.close();
	}

	public static void getWestminster() throws SQLException {
		
		Connection connection = getConnection(); 
		Statement statement = getStatement();
		
		
		String sql;
		sql="select * from westminster_confession where 1=1 ";
		sql+=" and wm_chapter="+chapter;
		sql+=" and wm_clause="+start_a_verse;
		sql+=";";

		ResultSet rs = statement.executeQuery(sql);
		/* 결과를 첫 행부터 끝 행까지 반복하며 출력합니다. */
		
		while(rs.next())
		{

			String  wm_subject = rs.getString("wm_subject");
			String  content = rs.getString("wm_content");

			 System.out.println("제 "+chapter+"장 "+start_a_verse+"항");
			 System.out.println(wm_subject);
			 System.out.print(content);
			 System.out.println();
			
		}
		/* resultSet 닫기 */
		rs.close();
		/* DB와의 연결 닫기 */
		connection.close();
	}
	
	public static String getTitle(Functions ft) throws SQLException {
		String mainTitle;
		String sql;
		Valiables bv = new Valiables();
		Statement statement = bv.getStatement();
		if(end_of_verse.equals("999")){
			if(version_name.equals("Hebrew"))
			{

			sql="select c1content as content,c6verse_no as verse from bible_hebrew where c4book_no='"+book+"' and c5chapter_no='"+chapter+"' order by c6verse_no desc limit 1;";
			}else if(version_name.equals("Greek")){
			sql="select c1content as content,c6verse_no as verse from bible_greek where c4book_no='"+book+"' and c5chapter_no='"+chapter+"' order by c6verse_no desc limit 1;";
			}else{
			sql="select verse from bible where book='"+book+"' and chapter='"+chapter+"' order by verse desc limit 1;";
			}
			ResultSet rsv=statement.executeQuery(sql);
			while(rsv.next())
			{
				 end_of_verse=rsv.getString("verse");
			}
			/* resultSet 닫기 */
			rsv.close();
		    mainTitle=ft.strBookIndexFullName+" "+chapter+"장 "+start_a_verse+"~"+end_of_verse+"절 ["+version_name+"]";	
		}else if(start_a_verse.equals(end_of_verse)){
			/* 1절 검색 */
			mainTitle=ft.strBookIndexFullName+" "+chapter+"장 "+start_a_verse+"절 ["+version_name+"]";
		}else{
			mainTitle=ft.strBookIndexFullName+" "+chapter+"장 "+start_a_verse+"~"+end_of_verse+"절 ["+version_name+"]";
		}
		return mainTitle;
	}	

	public static void connectSqlite(Functions ft) throws IOException, SQLException {
		Valiables bv = new Valiables();
		strBookIndexName = tmpA.replaceAll(FIND_PATTERN, "$1");
		
		strBookIndexName = strBookIndexName.trim();
		strBookIndexName = strBookIndexName.trim();

		searchStr1 = strBookIndexName;
		// tmpA.replaceAll(FIND_PATTERN,"$1");
		book=ft.get_where(searchStr1);
		
		is_west=searchStr1.equals("웨");  
		/**/
		if(is_west)
		{
			version_filename="WESTMIN.sqlite";
			version_name="웨스터민스터 신앙고백서";
		}
		chapter = tmpA.replaceAll(FIND_PATTERN, "$2");
		start_a_verse = tmpA.replaceAll(FIND_PATTERN, "$3");
		end_of_verse = tmpA.replaceAll(FIND_PATTERN, "$4");

		try
		{
			/* SQLite JDBC 클래스가 있는지 검사하는 부분입니다. */
			Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("org.sqlite.JDBC를 찾지 못했습니다.");
		}

		/* Program.class와 같은 디렉터리에 있는 test.db를 엽니다. */
		String location=new java.io.File( "." ).getCanonicalPath();

		location=location.replaceAll("\\\\", "/");
//	     connection = DriverManager.getConnection("jdbc:sqlite:"+location+"/KORTKV.db");
	    
		Valiables.setConnection(DriverManager.getConnection("jdbc:sqlite:"+location+"/db/"+version_filename));
			

		
		/* 연결 성공했을 때, connection으로부터 statement 인스턴스를 얻습니다. 여기서 SQL 구문을 수행합니다. */
		try {
			setStatement(getConnection().createStatement());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

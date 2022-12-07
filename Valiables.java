package taebu;

import java.sql.Connection;
import java.sql.Statement;

public class Valiables {
	final static String[][] arrVersion={
	{
	"개역한글판(korHRV)",  
	"개역개정판(korNKRV)", 
	"새번역(korNRSV)", 
	"공동번역개정판(korNKCB)", 
	"개역개정 국한문(kchNRKV)", 
	"개역한글판 국한문(kchHRV)", 
	"바른성경(korKTV)", 
	"바른성경국한문(kchKTV)", 
	"가톨릭성경(korCath)", 
	"우리말성경(korDOB)", 
	"쉬운성경(korEASY)", 
	"킹제임스흠정역(korHKJV)", 
	"한글킹제임스(korKKJV)", 
	"현대인의 성경(korKLB)", 
	"현대어성경(korTKV)", 
	"ESV", 
	"GNT", 
	"HCSB", 
	"KJV", 
	"MSG", 
	"ISV", 
	"NASB", 
	"NIV", 
	"NKJV", 
	"NLT", 
	"NRSV", 
	"TNIV"
	},
	{
	"korHRV",
	"korNKRV", 
	"korNRSV", 
	"korNKCB", 
	"kchNRKV", 
	"kchHRV", 
	"korKTV", 
	"kchKTV", 
	"korCath", 
	"korDOB", 
	"korEASY", 
	"korHKJV", 
	"korKKJV", 
	"korKLB", 
	"korTKV", 
	"engESV", 
	"engGNT", 
	"engHCSB", 
	"engKJV", 
	"engMSG", 
	"engISV", 
	"engNASB", 
	"engNIV", 
	"engNKJV", 
	"engNLT", 
	"engNRSV", 
	"engTNIV"
	}
	};

	
	final static String[][] arrTables = {
	{ "0","창세기", "출애굽기", "레위기", "민수기", "신명기",
		"여호수아", "사사기", "룻기", "사무엘상", "사무엘하",
		"열왕기상", "열왕기하", "역대상", "역대하", "에스라",
		"느헤미야", "에스더", "욥기", "시편", "잠언",
		"전도서", "아가", "이사야", "예레미야", "예레미야애가",
		"에스겔", "다니엘", "호세아", "요엘", "아모스",
		"오바댜", "요나", "미가", "나훔", "하박국",
		"스바냐", "학개", "스가랴", "말라기", "마태복음",
		"마가복음", "누가복음", "요한복음", "사도행전", "로마서",
		"고린도전서", "고린도후서", "갈라디아서", "에베소서",
		"빌립보서", "골로새서", "데살로니가전서", "데살로니가후서",
		"디모데전서", "디모데후서", "디도서", "빌레몬서",
		"히브리서", "야고보서", "베드로전서", "베드로후서",
		"요한일서", "요한이서", "요한삼서", "유다서", "요한계시록","새교독문","웨스터민스터 신앙고백서"},
		{ "0","창", "출", "레", "민", "신", "수", "삿", "룻", "삼상", "삼하", "왕상", "왕하",
			"대상", "대하", "스", "느", "에", "욥", "시", "잠", "전", "아", "사",
			"렘", "애", "겔", "단", "호", "욜", "암", "옵", "욘", "미", "나", "합",
			"습", "학", "슥", "말", "마", "막", "눅", "요", "행", "롬", "고전",
			"고후", "갈", "엡", "빌", "골", "살전", "살후", "딤전", "딤후", "딛", "몬",
			"히", "약", "벧전", "벧후", "요일", "요이", "요삼", "유", "계","교","웨"} };

	

	final static String FIND_PATTERN = "([가-힣]+)\\s*([0-9]+):([0-9]+)-([0-9]+)";
	final static String FIND_PATTERN2 = "[0-9\\.tx\\-]";
	final static String FIND_PATTERN3 = "(\\<[^\\>]+\\>)";
	final static String FIND_PATTERN4 = "[0-9]";	
	
	public static String strBookIndexName="";
	public static String strBookIndexFullName="";
	public static String strBookIndexChapter="";

	private static Connection connection = null;
	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		Valiables.connection = connection;
	}
	
	private static Statement statement = null;

	public static Statement getStatement() {
		return statement;
	}

	public static void setStatement(Statement statement) {
		Valiables.statement = statement;
	}

	

	public static String version;
	
	public static String version_name;
	
	public static String book="";
	public static String chapter;

	public static String s = "";
	public static String searchStr1="",searchStr2="",searchStr3="",searchStr4="";
	public static boolean is_west=false;		
	
	public static String tmpA="";

	/**
	* 키워드 검색 인지 구절 검색인지 판단, 
	* 기본값은 'false'로 구절 검색이다. 
	*/
	public static boolean isKeywordSearch = false;
	
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Bible {

	final static String[][] arrTables = {
		{ "1-01Ã¢¼¼±â", "1-02Ãâ¾Ö±Á±â", "1-03·¹À§±â", "1-04¹Î¼ö±â", "1-05½Å¸í±â",
			"1-06¿©È£¼ö¾Æ", "1-07»ç»ç±â", "1-08·í±â", "1-09»ç¹«¿¤»ó", "1-10»ç¹«¿¤ÇÏ",
			"1-11¿­¿Õ±â»ó", "1-12¿­¿Õ±âÇÏ", "1-13¿ª´ë»ó", "1-14¿ª´ëÇÏ", "1-15¿¡½º¶ó",
			"1-16´ÀÇì¹Ì¾ß", "1-17¿¡½º´õ", "1-18¿é±â", "1-19½ÃÆí", "1-20Àá¾ð",
			"1-21Àüµµ¼­", "1-22¾Æ°¡", "1-23ÀÌ»ç¾ß", "1-24¿¹·¹¹Ì¾ß", "1-25¿¹·¹¹Ì¾ß¾Ö°¡",
			"1-26¿¡½º°Ö", "1-27´Ù´Ï¿¤", "1-28È£¼¼¾Æ", "1-29¿ä¿¤", "1-30¾Æ¸ð½º",
			"1-31¿À¹Ù´ô", "1-32¿ä³ª", "1-33¹Ì°¡", "1-34³ªÈÉ", "1-35ÇÏ¹Ú±¹",
			"1-36½º¹Ù³Ä", "1-37ÇÐ°³", "1-38½º°¡·ª", "1-39¸»¶ó±â", "2-01¸¶ÅÂº¹À½",
			"2-02¸¶°¡º¹À½", "2-03´©°¡º¹À½", "2-04¿äÇÑº¹À½", "2-05»çµµÇàÀü", "2-06·Î¸¶¼­",
			"2-07°í¸°µµÀü¼­", "2-08°í¸°µµÈÄ¼­", "2-09°¥¶óµð¾Æ¼­", "2-10¿¡º£¼Ò¼­",
			"2-11ºô¸³º¸¼­", "2-12°ñ·Î»õ¼­", "2-13µ¥»ì·Î´Ï°¡Àü¼­", "2-14µ¥»ì·Î´Ï°¡ÈÄ¼­",
			"2-15µð¸ðµ¥Àü¼­", "2-16µð¸ðµ¥ÈÄ¼­", "2-17µðµµ¼­", "2-18ºô·¹¸ó¼­",
			"2-19È÷ºê¸®¼­", "2-20¾ß°íº¸¼­", "2-21º£µå·ÎÀü¼­", "2-22º£µå·ÎÈÄ¼­",
			"2-23¿äÇÑÀÏ¼­", "2-24¿äÇÑÀÌ¼­", "2-25¿äÇÑ»ï¼­", "2-26À¯´Ù¼­", "2-27¿äÇÑ°è½Ã·Ï" },
			{ "Ã¢", "Ãâ", "·¹", "¹Î", "½Å", "¼ö", "»ñ", "·í", "»ï»ó", "»ïÇÏ", "¿Õ»ó", "¿ÕÇÏ",
				"´ë»ó", "´ëÇÏ", "½º", "´À", "¿¡", "¿é", "½Ã", "Àá", "Àü", "¾Æ", "»ç",
				"·½", "¾Ö", "°Ö", "´Ü", "È£", "¿ç", "¾Ï", "¿É", "¿æ", "¹Ì", "³ª", "ÇÕ",
				"½À", "ÇÐ", "½»", "¸»", "¸¶", "¸·", "´ª", "¿ä", "Çà", "·Ò", "°íÀü",
				"°íÈÄ", "°¥", "¿¦", "ºô", "°ñ", "»ìÀü", "»ìÈÄ", "µõÀü", "µõÈÄ", "µó", "¸ó",
				"È÷", "¾à", "º¦Àü", "º¦ÈÄ", "¿äÀÏ", "¿äÀÌ", "¿ä»ï", "À¯", "°è" } };

	final static String BIBLE_DB_PATH = "C:\\Bible\\GAE\\";
	final static String FIND_PATTERN = "([°¡-ÆR]+)\\s*([0-9]+):([0-9]+)-([0-9]+)";
	final static String FIND_PATTERN2 = "[0-9\\.tx\\-]";
	final static String FIND_PATTERN3 = "\\<[^\\>]+\\>";


	void showUsage2() {
		System.out.println("»ç¿ë¿¹1:java Bible Ã¢1");
		System.out.println("»ç¿ë¿¹2:java Bible Ã¢1:2");
		System.out.println("»ç¿ë¿¹3:java Bible Ã¢1:2-3");
		System.out.println("»ç¿ë¿¹4:java Bible Ã¢¼¼±â1");
		System.out.println("»ç¿ë¿¹5:java Bible Ã¢¼¼±â1:2");
		System.out.println("»ç¿ë¿¹6:java Bible Ã¢¼¼±â1:2-3");
		System.out.println("»ç¿ë¿¹7:java Bible Ã¢ 1");
		System.out.println("»ç¿ë¿¹8:java Bible Ã¢ 1:2");
		System.out.println("»ç¿ë¿¹9:java Bible Ã¢ 1:2-3");
		System.out.println("»ç¿ë¿¹10:java Bible Ã¢¼¼±â 1");
		System.out.println("»ç¿ë¿¹11:java Bible Ã¢¼¼±â 1:2");
		System.out.println("»ç¿ë¿¹12:java Bible Ã¢¼¼±â 1:2-3");
	}

	public static void main(String[] args) throws java.io.IOException {

		String tmpA = "";
		if (args.length == 0) {
			// throw new RuntimeException("");
			showUsage();
			return;
		} else if (args.length == 1) {
			tmpA = args[0].trim();
			if (-1 < tmpA.indexOf("-")) {
				if (tmpA.indexOf(":") == -1) {
					showUsage();// -ÀÌ ÀÖ´Âµ¥ :ÀÌ ¾ø´Ù¸é Æ÷¸Ë ¿À·ùÀÌ´Ù.
					return;
				} else {
					// Ã¢3:4-4 ÀÌ·±½ÄÀÌ´Ù. OK
				}
			} else {
				int posColone = tmpA.indexOf(":");
				if (-1 < posColone) {
					// Ã¢3:4 ÀÌ·±½ÄÀÌ´Ù.
					tmpA = tmpA + "-" + tmpA.substring(posColone + 1);// Ã¢3:4-4
					// ÀÌ·¸°Ô
					// ¹Ù²Û´Ù.
				} else {
					// Ã¢4 ÀÌ·±½ÄÀÌ´Ù.
					tmpA = args[0] + ":1-999";
				}
			}
		} else if (args.length == 2) {
			if (-1 < args[0].indexOf(":")) {// Ã¢1:3 4
				tmpA = args[0] + "-" + args[1];
			} else {// Ã¢ 1 ÀÎ°æ¿ì, Ã¢ 1:1, Ã¢ 1:3-4
				if (-1 < args[1].indexOf("-") && -1 < args[1].indexOf(":")) {
					tmpA = args[0] + args[1];
				} else if (-1 == args[1].indexOf("-")
						&& -1 < args[1].indexOf(":")) {// Ã¢ 1:3
					tmpA = args[0] + args[1];

					int posColone = tmpA.indexOf(":");
					if (-1 < posColone) {
						// Ã¢3:4 ÀÌ·±½ÄÀÌ´Ù.
						tmpA = tmpA + "-" + tmpA.substring(posColone + 1);// Ã¢3:4-4
						// ÀÌ·¸°Ô
						// ¹Ù²Û´Ù.
					} else {
						// Ã¢4 ÀÌ·±½ÄÀÌ´Ù.
						tmpA = args[0] + ":1-999";
					}
				} else {
					tmpA = args[0] + args[1] + ":1-999";
				}
			}
		} else if (args.length == 3) {
			tmpA = args[0] + args[1] + "-" + args[2];
		} else {
			showUsage();// ÀÎÀÚ°¡ ³Ê¹« ¸¹¾Æµµ ¿À·ùÀÌ´Ù.
			return;
		}

		Hashtable<String, String> ht = new Hashtable<String, String>();

		String s = "";
		String strFileName = "";
		String strBookIndexName = "";
		try {
			strBookIndexName = tmpA.replaceAll(FIND_PATTERN, "$1");

			strBookIndexName = strBookIndexName.trim();
			for (int i = 0; i < 66; i++) {
				if (strBookIndexName.equals(arrTables[1][i])
						|| strBookIndexName.equals(arrTables[0][i].replaceAll(
								FIND_PATTERN2, ""))) {
					strBookIndexName = arrTables[1][i];// ¾à¾î·Î º¯°æÇÑ´Ù.
					strFileName = arrTables[0][i];
					break;
				}
			}

			if ("".equals(strFileName)) {// ÆÄÀÏÀÌ¸§À» ¸øÃ£¾Ò´Ù´Â °ÍÀº formatÀÌ ÀÏÄ¡ÇÏÁö ¾Ê´Ù´Â °ÍÀÌ´Ù.
				showUsage();
				return;
			}

			//			 for(int j=0;j<66;j++) {
			//			 strFileName=arrTables[0][j];
			//			int old_i1=0,old_i2=0,i1,i2;
			BufferedReader in = new BufferedReader(new FileReader(BIBLE_DB_PATH
					+ strFileName + ".txt"));

			while ((s = in.readLine()) != null) {
				if (s.equals("") || s.charAt(0) == '#') {
					continue;
				} // ¶óÀÎÀÌ °ø¹éÀÌ°Å³ª Ã¹±ÛÀÚ°¡ #ÀÌ¸é ÆÐ½º
				String temp[] = s.split("\t");
				//				String str1 = temp[0].replaceAll("[¤¡-ÆR]+([0-9]+):[0-9]+","$1");
				//				String str2 = temp[0].replaceAll("[¤¡-ÆR]+[0-9]+:([0-9]+)","$1");
				//
				//				i1 = Integer.parseInt(str1);
				//				i2 = Integer.parseInt(str2);
				//				
				//				if(!((i1==i2 && i1==1) || old_i1+1==i1 || old_i2+1==i2 )){
				//					throw new RuntimeException(strFileName+s);
				//				}
				//				old_i1 = i1;
				//				old_i2 = i2;
				ht.put(temp[0], temp[1]); // ht¿¡ ³ÖÀ½
			}
			in.close();
			//			 }

			// String location = new java.io.File(".").getCanonicalPath();
			// location = location.replace("\\", "\\\\");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.err
			.println("ÇØ´ç °á°ú°¡ nullÀÌ ³ª¿Ô´Ù¸é txt¿¡ Àß¸øµÈ ÅÇ±¸ºÐÀÌ ÀÖÀ» ¼ö ÀÖ½À´Ï´Ù. ÇØ´ç±Ç¿¡ ÆÄÀÏÀ» ÂüÁ¶ÇÏ¼¼¿ä."
					+ s);
		} catch (IOException e) {
			System.err.println("ÇØ´ç ÆÄÀÏÀ» Ã£À» ¼ö ¾ø½À´Ï´Ù." + e.getMessage());

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
			.println("ÇØ´ç °á°ú°¡ nullÀÌ ³ª¿Ô´Ù¸é txt¿¡ Àß¸øµÈ ÅÇ±¸ºÐÀÌ ÀÖÀ» ¼ö ÀÖ½À´Ï´Ù. ÇØ´ç±Ç¿¡ ÆÄÀÏÀ» ÂüÁ¶ÇÏ¼¼¿ä.");
		}

		String searchStr1 = strBookIndexName;// tmpA.replaceAll(FIND_PATTERN,
		// "$1");
		String searchStr2 = tmpA.replaceAll(FIND_PATTERN, "$2");
		String searchStr3 = tmpA.replaceAll(FIND_PATTERN, "$3");
		String searchStr4 = tmpA.replaceAll(FIND_PATTERN, "$4");

		StringBuilder c = new StringBuilder();
		String tmp2thValue = "";

		int lstNum = 0;

		for (int i = Integer.parseInt(searchStr3); i <= Integer
				.parseInt(searchStr4); i++) {
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
		}
		else {
			System.out.println(strBookIndexName + searchStr2 + ":" + searchStr3 + "-" + Integer.toString(lstNum));
			System.out.println(strFileName.replaceAll(FIND_PATTERN2, "") + searchStr2 + ":" + searchStr3 + "-" + Integer.toString(lstNum));
		}
		System.out.println(c);

	}

	/**
	 * 
	 */
	public static void showUsage() {
		System.out.println("»ç¿ë¿¹1:java Bible Ã¢1");
		System.out.println("»ç¿ë¿¹2:java Bible Ã¢1:2");
		System.out.println("»ç¿ë¿¹3:java Bible Ã¢1:2-3");
		System.out.println("»ç¿ë¿¹4:java Bible Ã¢¼¼±â1");
		System.out.println("»ç¿ë¿¹5:java Bible Ã¢¼¼±â1:2");
		System.out.println("»ç¿ë¿¹6:java Bible Ã¢¼¼±â1:2-3");
		System.out.println("»ç¿ë¿¹7:java Bible Ã¢ 1");
		System.out.println("»ç¿ë¿¹8:java Bible Ã¢ 1:2");
		System.out.println("»ç¿ë¿¹9:java Bible Ã¢ 1:2-3");
		System.out.println("»ç¿ë¿¹10:java Bible Ã¢¼¼±â 1");
		System.out.println("»ç¿ë¿¹11:java Bible Ã¢¼¼±â 1:2");
		System.out.println("»ç¿ë¿¹12:java Bible Ã¢¼¼±â 1:2-3");
	}
}
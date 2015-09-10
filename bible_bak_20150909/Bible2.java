import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Bible {

	final static String[][] arrTables = {
		{ "1-01â����", "1-02��ֱ���", "1-03������", "1-04�μ���", "1-05�Ÿ��",
			"1-06��ȣ����", "1-07����", "1-08���", "1-09�繫����", "1-10�繫����",
			"1-11���ձ��", "1-12���ձ���", "1-13�����", "1-14������", "1-15������",
			"1-16����̾�", "1-17������", "1-18���", "1-19����", "1-20���",
			"1-21������", "1-22�ư�", "1-23�̻��", "1-24�����̾�", "1-25�����̾߾ְ�",
			"1-26������", "1-27�ٴϿ�", "1-28ȣ����", "1-29�俤", "1-30�Ƹ�",
			"1-31���ٴ�", "1-32�䳪", "1-33�̰�", "1-34����", "1-35�Ϲڱ�",
			"1-36���ٳ�", "1-37�а�", "1-38������", "1-39�����", "2-01���º���",
			"2-02��������", "2-03��������", "2-04���Ѻ���", "2-05�絵����", "2-06�θ���",
			"2-07��������", "2-08�����ļ�", "2-09�����Ƽ�", "2-10�����Ҽ�",
			"2-11��������", "2-12��λ���", "2-13����δϰ�����", "2-14����δϰ��ļ�",
			"2-15�������", "2-16����ļ�", "2-17�𵵼�", "2-18������",
			"2-19���긮��", "2-20�߰���", "2-21���������", "2-22������ļ�",
			"2-23�����ϼ�", "2-24�����̼�", "2-25���ѻＭ", "2-26���ټ�", "2-27���Ѱ�÷�" },
			{ "â", "��", "��", "��", "��", "��", "��", "��", "���", "����", "�ջ�", "����",
				"���", "����", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ȣ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "����",
				"����", "��", "��", "��", "��", "����", "����", "����", "����", "��", "��",
				"��", "��", "����", "����", "����", "����", "���", "��", "��" } };

	final static String BIBLE_DB_PATH = "C:\\Bible\\GAE\\";
	final static String FIND_PATTERN = "([��-�R]+)\\s*([0-9]+):([0-9]+)-([0-9]+)";
	final static String FIND_PATTERN2 = "[0-9\\.tx\\-]";
	final static String FIND_PATTERN3 = "\\<[^\\>]+\\>";


	void showUsage2() {
		System.out.println("��뿹1:java Bible â1");
		System.out.println("��뿹2:java Bible â1:2");
		System.out.println("��뿹3:java Bible â1:2-3");
		System.out.println("��뿹4:java Bible â����1");
		System.out.println("��뿹5:java Bible â����1:2");
		System.out.println("��뿹6:java Bible â����1:2-3");
		System.out.println("��뿹7:java Bible â 1");
		System.out.println("��뿹8:java Bible â 1:2");
		System.out.println("��뿹9:java Bible â 1:2-3");
		System.out.println("��뿹10:java Bible â���� 1");
		System.out.println("��뿹11:java Bible â���� 1:2");
		System.out.println("��뿹12:java Bible â���� 1:2-3");
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
					showUsage();// -�� �ִµ� :�� ���ٸ� ���� �����̴�.
					return;
				} else {
					// â3:4-4 �̷����̴�. OK
				}
			} else {
				int posColone = tmpA.indexOf(":");
				if (-1 < posColone) {
					// â3:4 �̷����̴�.
					tmpA = tmpA + "-" + tmpA.substring(posColone + 1);// â3:4-4
					// �̷���
					// �ٲ۴�.
				} else {
					// â4 �̷����̴�.
					tmpA = args[0] + ":1-999";
				}
			}
		} else if (args.length == 2) {
			if (-1 < args[0].indexOf(":")) {// â1:3 4
				tmpA = args[0] + "-" + args[1];
			} else {// â 1 �ΰ��, â 1:1, â 1:3-4
				if (-1 < args[1].indexOf("-") && -1 < args[1].indexOf(":")) {
					tmpA = args[0] + args[1];
				} else if (-1 == args[1].indexOf("-")
						&& -1 < args[1].indexOf(":")) {// â 1:3
					tmpA = args[0] + args[1];

					int posColone = tmpA.indexOf(":");
					if (-1 < posColone) {
						// â3:4 �̷����̴�.
						tmpA = tmpA + "-" + tmpA.substring(posColone + 1);// â3:4-4
						// �̷���
						// �ٲ۴�.
					} else {
						// â4 �̷����̴�.
						tmpA = args[0] + ":1-999";
					}
				} else {
					tmpA = args[0] + args[1] + ":1-999";
				}
			}
		} else if (args.length == 3) {
			tmpA = args[0] + args[1] + "-" + args[2];
		} else {
			showUsage();// ���ڰ� �ʹ� ���Ƶ� �����̴�.
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
					strBookIndexName = arrTables[1][i];// ���� �����Ѵ�.
					strFileName = arrTables[0][i];
					break;
				}
			}

			if ("".equals(strFileName)) {// �����̸��� ��ã�Ҵٴ� ���� format�� ��ġ���� �ʴٴ� ���̴�.
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
				} // ������ �����̰ų� ù���ڰ� #�̸� �н�
				String temp[] = s.split("\t");
				//				String str1 = temp[0].replaceAll("[��-�R]+([0-9]+):[0-9]+","$1");
				//				String str2 = temp[0].replaceAll("[��-�R]+[0-9]+:([0-9]+)","$1");
				//
				//				i1 = Integer.parseInt(str1);
				//				i2 = Integer.parseInt(str2);
				//				
				//				if(!((i1==i2 && i1==1) || old_i1+1==i1 || old_i2+1==i2 )){
				//					throw new RuntimeException(strFileName+s);
				//				}
				//				old_i1 = i1;
				//				old_i2 = i2;
				ht.put(temp[0], temp[1]); // ht�� ����
			}
			in.close();
			//			 }

			// String location = new java.io.File(".").getCanonicalPath();
			// location = location.replace("\\", "\\\\");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.err
			.println("�ش� ����� null�� ���Դٸ� txt�� �߸��� �Ǳ����� ���� �� �ֽ��ϴ�. �ش�ǿ� ������ �����ϼ���."
					+ s);
		} catch (IOException e) {
			System.err.println("�ش� ������ ã�� �� �����ϴ�." + e.getMessage());

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
			.println("�ش� ����� null�� ���Դٸ� txt�� �߸��� �Ǳ����� ���� �� �ֽ��ϴ�. �ش�ǿ� ������ �����ϼ���.");
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
		System.out.println("��뿹1:java Bible â1");
		System.out.println("��뿹2:java Bible â1:2");
		System.out.println("��뿹3:java Bible â1:2-3");
		System.out.println("��뿹4:java Bible â����1");
		System.out.println("��뿹5:java Bible â����1:2");
		System.out.println("��뿹6:java Bible â����1:2-3");
		System.out.println("��뿹7:java Bible â 1");
		System.out.println("��뿹8:java Bible â 1:2");
		System.out.println("��뿹9:java Bible â 1:2-3");
		System.out.println("��뿹10:java Bible â���� 1");
		System.out.println("��뿹11:java Bible â���� 1:2");
		System.out.println("��뿹12:java Bible â���� 1:2-3");
	}
}
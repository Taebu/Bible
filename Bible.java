package taebu;

public class Bible extends Valiables
{
	public static void main(String[] args) throws Exception
	{
		Functions ft = new Functions();
		version = ft.get_version(args);
		version_name=ft.get_version_name(args);
		chapter=ft.get_chapter(stringArgs);
				
		/* 장절 검색 */
		tmpA=ft.search_verse(stringArgs);

		ft.connectSqlite(ft);

		String mainTitle="";
		
		/* 장절 구절 */
		mainTitle = ft.getTitle(ft);
		
		
		/* 검색어 검색*/
		if(ft.isKeyword(stringArgs)){
			ft.searchKeyword(stringArgs);
		}else {
			System.out.println(mainTitle);
		}
		

		if(is_west)
		{
			ft.getWestminster();
		}

		if(!is_west)
		{
			ft.getBible();
		}
  }

}

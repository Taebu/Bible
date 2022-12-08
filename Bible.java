package taebu;

public class Bible extends Valiables
{
	public static void main(String[] args) throws Exception
	{
		Functions ft = new Functions();
		version = ft.get_version(args);
		version_name=ft.get_version_name(args);
		chapter=ft.get_chapter(args);
				
		/* 장절 검색 */
		tmpA=ft.search_verse(args);

		ft.connectSqlite(ft);

		String mainTitle="";
		String sql="";

		/* 장절 구절 */
		mainTitle = ft.setKeyword(ft);
		
		
		/* 검색어 검색*/
		if(ft.isKeyword(args)){
			ft.searchKeyword(args);
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

package taebu;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Bible extends Valiables
{
	
	public static void main(String[] args) throws Exception
	{
		Funtions ft = new Funtions();
		version = ft.get_version(args);
		version_name=ft.get_version_name(args);
		chapter=ft.get_chapter(args);
				
		/* 장절 검색 */
		tmpA=ft.search_verse(args);

		ft.connectBible(ft);

		String result="";
		String sql="";

		/* 장절 검색*/
		result = ft.setKeyword(ft);

		/* 검색어 검색*/
		if(ft.isKeyword(args)){
			ft.searchKeyword(args, getStatement(), version_name);
			return;
		}
		

		if(is_west)
		{
			ft.getWestminster(getConnection(), getStatement(), searchStr2, searchStr3, result);
		}

		if(!is_west)
		{
			ft.getBible(getConnection(), getStatement(), version_name, book, searchStr2, searchStr3, searchStr4, result);

		}
  }

}

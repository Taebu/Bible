package taebu;

import java.io.IOException;
import java.sql.SQLException;

public interface FuncInter {
    public String get_where(String str);
	public String get_version(String[] args);
    public String get_version_name(String[] args);
	public String[] removeFirstElement(String[] arr);
	public String get_chapter(String[] args);
	public String search_verse(String[] args);
	public boolean isKeyword(String[] args);
	public void showUsage();
	public void searchKeyword(String[] args) throws SQLException ;
	public abstract void getBible() throws SQLException;
	public void getWestminster() throws SQLException;
	public String getTitle() throws SQLException ;
	public void connectSqlite()  throws IOException, SQLException ;
}


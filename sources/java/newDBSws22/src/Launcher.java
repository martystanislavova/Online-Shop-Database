import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Launcher {
	
	static DatabaseHelper dbhelper = new DatabaseHelper();
	
	public static void main(String args[])  throws SQLException {

	
		dbhelper.removeAll();
		System.out.println("All entries from tables deleted.");
		
		dbhelper.insertAll();
		dbhelper.close();
	}
	
}

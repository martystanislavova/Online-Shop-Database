import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;  

// The DatabaseHelper class encapsulates the communication with our database
class DatabaseHelper {
    // Database connection info
    //private static final String DB_CONNECTION_URL = "jdbc:oracle:thin:@oracle-lab.cs.univie.ac.at:1521:lab";
    private static final String DB_CONNECTION_URL = "jdbc:oracle:thin:@oracle19.cs.univie.ac.at:1521:orclcdb"; 

    private static final String USER = "user"; //TODO: use a + matriculation number
    private static final String PASS = "pass"; //TODO: use your password (default: dbs19)

    // The name of the class loaded from the ojdbc14.jar driver file
    //private static final String CLASSNAME = "oracle.jdbc.driver.OracleDriver";

    // We need only one Connection and one Statement during the execution => class variable
    private static Statement stmt;
    private static Connection con;
    
	static HelperCSV helpercsv = new HelperCSV();
	static RandomHelper rand = new RandomHelper();


    private static final String CLASSNAME = "oracle.jdbc.driver.OracleDriver";
   // private static int personCounter=20; //TODO: your task --> remove this counter 
    
    private String[] tables = {
    		"angestellter",
    		"artikel",
    		"benutzer",
    		"bestellung",
    		"bietet",
    		"leitet",
    		"spediteur",
    		"verkaeufer",
    		"zahlung",
    	};
    
    //CREATE CONNECTION
    DatabaseHelper() {
        try {
            //Loads the class into the memory
            Class.forName(CLASSNAME);

            // establish connection to database
            con = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASS);
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeAll() throws SQLException {
		for(String table : tables) {
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM " + table;
			stmt.executeUpdate(sql);
		}
	}
    
    public void insertAll() {
    	insertAngestellte();
    	insertArtikel();
    	insertBenutzer();
    }
    
    //INSERT ANGESTELLTER
    private void insertAngestellte() {
    	List<String[]> angestellterInput = helpercsv.getData("/Users/martina/Desktop/Mart/Uni/DBS/NEW/MS 4/Java/Data/angestellter.csv"); 
		// relative
		// path
		List<String> angKeys = new ArrayList<>();
		
		for (String[] ang : angestellterInput) {
		Integer JobID = rand.getRandomInteger(100000000, 999999999); 
		insertIntoAngestellter(
		ang[0], 
		ang[1], 
		ang[2],
		ang[3], 
		ang[4]); 
		
		
		angKeys.add(JobID.toString());
		}
		
		System.out.println("Inserted angestellte.");
    }
    
    private void insertIntoAngestellter(String SozNr, String Vorname, String Nachname, String Gehalt, String Wohnort) {
        try {
            String sql = "INSERT INTO angestellter(SozNr, ANG_Vorname, ANG_Nachname, Gehalt, Wohnort) VALUES ('"  +
                    SozNr +
                    "', '" +
                    Vorname + "', '" + Nachname + "', '" + Gehalt + "', '" + Wohnort +
                    "')";
            stmt.execute(sql);
        } catch (Exception e) {
            System.err.println("Error at: insertIntoAngestellter\nmessage:");
            e.printStackTrace();
        }
    }
    
 //INSERT ARTIKEL
    private void insertArtikel() {
    	List<String[]> artikelInput = helpercsv.getData("/Users/martina/Desktop/Mart/Uni/DBS/NEW/MS 4/Java/Data/artikel.csv"); 

    	List<String> artKeys = new ArrayList<>();

		for (String[] art : artikelInput) {
			Integer ArtikelNr = rand.getRandomInteger(100000000, 999999999); 
			insertIntoArtikel(
				art[0],
				art[1],
				Double.parseDouble(art[2]),
				Double.parseDouble(art[3]),
				Double.parseDouble(art[4])
			);
			artKeys.add(ArtikelNr.toString());
		}
		

		System.out.println("Inserted artikel.");
    }
    
    private void insertIntoArtikel(String ART_NAME, String BEZEICHNUNG, double PREIS, double GROESSE, double GEWICHT) {
    	 try {
             String sql = "INSERT INTO artikel(ART_NAME, BEZEICHNUNG, PREIS, GROESSE, GEWICHT) VALUES ('"  +
            		 ART_NAME +
                     "', '" +
                     BEZEICHNUNG + "', '" + PREIS + "', '" + GROESSE + "', '" + GEWICHT +
                     "')";
             stmt.execute(sql);
         } catch (Exception e) {
             System.err.println("Error at: insertIntoAngestellter\nmessage:");
             e.printStackTrace();
         }
    }
 
    
   //INSERT BENUTZER 
         private void insertBenutzer() {
         	List<String[]> benutzerInput = helpercsv.getData("/Users/martina/Desktop/Mart/Uni/DBS/NEW/MS 4/Java/Data/benutzer.csv"); 
   
     		for (String[] ben : benutzerInput) {
     			Integer LoginID = rand.getRandomInteger(100000000, 999999999);
     			insertIntoBenutzer(
     				ben[0],
     				ben[1],
     				ben[2],
     				Long.parseLong(ben[3])
     			);
     		
     		} 
     		System.out.println("Inserted Benutzer.");
         }
         
         private void insertIntoBenutzer(String USER_VORNAME, String USER_NACHNAME, String EMAIL, long TELEFON) {
        	 try {
                 String sql = "INSERT INTO benutzer(USER_VORNAME, USER_NACHNAME, EMAIL, TELEFON) VALUES ('"  +
                 		USER_VORNAME +
                         "', '" +
                         USER_NACHNAME  + "', '" + EMAIL + "', '" + TELEFON +
                         "')";
                 stmt.execute(sql);
             } catch (Exception e) {
                 System.err.println("Error at: insertIntoBenutzer\nmessage:");
                 e.printStackTrace();
             }
        } 
         
    
    //SELECT
    ArrayList<Integer> selectLoginIdsFromBenutzer() {
        ArrayList<Integer> IDs = new ArrayList<>();

        try {
            ResultSet rs = stmt.executeQuery("SELECT LOGINID FROM BENUTZER ORDER BY LOGINID");
            while (rs.next()) {
                IDs.add(rs.getInt("LOGINID"));
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(("Error at: selectLoginIdsFromBenutzer\n message: " + e.getMessage()).trim());
        }
        return IDs;
    }

    public void close()  {
        try {
            stmt.close(); //clean up
            con.close();
        } catch (Exception ignored) {
       }
    }

}

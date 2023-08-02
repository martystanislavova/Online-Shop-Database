import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class HelperCSV {
	public static final String angestellters = "/Users/martina/Desktop/Mart/Uni/DBS/NEW/MS 4/Java/Data/angestellter.csv";
	public static final String artikeln = "/Users/martina/Desktop/Mart/Uni/DBS/NEW/MS 4/Java/Data/artikel.csv";
	public static final String benutzern = "/Users/martina/Desktop/Mart/Uni/DBS/NEW/MS 4/Java/Data/benutzer.csv";
	
	public List<String[]> getData(String csv) {	
		
		List<String[]> data = new ArrayList<>();
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(csv));
			
			while((line = br.readLine()) != null) {
				String[] tupel = line.split(",");		
				data.add(tupel);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Data from CSV retriving(ERROR): ");
			e.printStackTrace();
		}
		
		return data;
	}
	
	
}
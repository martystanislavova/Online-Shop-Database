import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class HelperCSV {
	public static final String angestellters = "csv file path"; //TO DO
	public static final String artikeln = "csv file path";
	public static final String benutzern = "csv file path";
	
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

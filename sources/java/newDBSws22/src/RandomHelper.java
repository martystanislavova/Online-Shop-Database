//Database Systems (Module IDS) 

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

// The RandomHelper class wraps around the JAVA Random class to provide convenient access to random data as we need it
// Additionally it provides access to external single-columned files (e.g. courses.csv, names.csv, surnames.csv)
class RandomHelper {
    private final char[] alphabet = getCharSet();
    private Random rand;
    private ArrayList<String> firstNames;
    private ArrayList<String> lastNames;
    private ArrayList<String> courses;
   // private static final String firstNameFile = "./resources/names.csv"; //todo check directory
    //private static final String lastNameFile = "./resources/surnames.csv";
    //private static final String coursesFile = "./resources/courses.csv";

    //instantiate the Random object and store data from files in lists
    RandomHelper() {
        this.rand = new Random();
      //  this.lastNames = readFile(lastNameFile);
       // this.firstNames = readFile(firstNameFile);
       // this.courses = readFile(coursesFile);
    }
    

    //not used but it might be helpful
    String getRandomString(int minLen, int maxLen) {
        StringBuilder out = new StringBuilder();
        int len = rand.nextInt((maxLen - minLen) + 1) + minLen;
        while (out.length() < len) {
            int idx = Math.abs((rand.nextInt() % alphabet.length));
            out.append(alphabet[idx]);
        }
        return out.toString();
    }
    
	public static Date randomDate() {
		int startYear=2020;
		int endYear=2022;
		int year = (int)(Math.random()*(endYear-startYear+1))+startYear;	//Random year
		int month= (int)(Math.random()*12)+1;								//Random Month
		Calendar c = Calendar.getInstance();				//Create Calendar objects
		c.set(year, month, 0);								//Setting Date
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);		//How many days to get the corresponding year and month
		int day=(int)(Math.random()*dayOfMonth+1)	;		//Generating random days
		Date my_date=Date.valueOf(year+"-"+month+"-"+day);	//Generating Date Object by valueOf Method
		return my_date;
	}

    //returns random element from list
    String getRandomFirstName() {
        return firstNames.get(getRandomInteger(0, firstNames.size() - 1));
    }

    //returns random element from list
    String getRandomLastName() {
        return lastNames.get(getRandomInteger(0, lastNames.size() - 1));
    }

    //returns random element from list
    String getRandomCourse() {
        return courses.get(getRandomInteger(0, courses.size() - 1));
    }

    //returns random double from the Interval [min, max] and a defined precision (e.g. precision:2 => 3.14)
    Double getRandomDouble(double min, double max, int precision) {
        //Hack that is not the cleanest way to ensure a specific precision, but...
        double r = Math.pow(10, precision);
        return Math.round(min + (rand.nextDouble() * (max - min)) * r) / r;
    }

    //return random Integer from the Interval [min, max]; (min, max are possible as well)
    Integer getRandomInteger(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    //reads single-column files and stores its values as Strings in an ArraList
    private ArrayList<String> readFile(String filename) {
        String line;
        ArrayList<String> set = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                try {
                    set.add(line);
                } catch (Exception ignored) {
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    //defines which chars are used to create random strings
    private char[] getCharSet() { // create getCharSet char array
        StringBuffer b = new StringBuffer(128);
        for (int i = 48; i <= 57; i++) b.append((char) i);        // 0-9
        for (int i = 65; i <= 90; i++) b.append((char) i);        // A-Z
        for (int i = 97; i <= 122; i++) b.append((char) i);       // a-z
        return b.toString().toCharArray();
    }
}
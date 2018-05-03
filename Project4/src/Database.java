import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Database {

	HashMap<String,Record> femaleRecords = new HashMap<String,Record>();  
	HashMap<String,Record> maleRecords = new HashMap<String,Record>();  
	
	public Database() {
		// create maps
		femaleRecords = new HashMap<String,Record>();  
		maleRecords = new HashMap<String,Record>();  
	}
	
//	- Loads all records from the given file name.
//	- Start by clearing both HashMap collections.
//	- Open the file and loop over all lines.
//	- Split each line on commas, and save the resulting String array.
//	- Use the first and second items in the String array to create a Record object.
//	- Loop over remaining items in the String array. Calculate the associated year and set the corresponding year 
//	value in the Record using its setValue(…) method. Make sure to convert each value in the split String array to an 
//	int using the Integer.parseInt(…) method.
//	- Once the Record object is fully populated with all data, make sure to put the Record object in the proper HashMap, 
//	based on the sex of the baby name record
	public void loadData(String fileName) {
		// clear maps
		femaleRecords.clear();
		maleRecords.clear();
		
		try {
			// Open file using the correct file name
		    Scanner sc = new Scanner(new File(fileName));
			
			// iterate reading each line
		    while (sc.hasNextLine()) {
				// read name, gender, and rank together from one line
		    	String line = sc.nextLine();
		    	
				// Split line into array of String
		    	String[] strArr = line.split(",");

		    	// get  name and gender
		    	String name = strArr[0];
		    	String sex = strArr[1];

		    	// create a Record
				Record nameRec = new Record(name, sex);
				
		    	// now iterate through rest of array to get the values for each year
				for (int i = 2; i < strArr.length; i++) {
					// get value for year, adjusting year index since the values start on the third array element
					nameRec.setValue(i - 2, Integer.parseInt(strArr[i]));
				}

				// Add to appropriate list depending on gender
				if (sex.equals("F")) {
					femaleRecords.put(name, nameRec);
				}
				else {
					maleRecords.put(name, nameRec);
				}
				System.out.println("Read " + (strArr.length - 2) + " values for " + nameRec.getName());
		    }
		}
		catch (Exception e) {
			System.out.println("ERROR> Error reading file: " + e);
			System.exit(0);
		}
	}

	// Return the best year for the name, and if none is found, return -1
	public static int getBestYear(String name, ArrayList<NameRecord> records) {
		NameRecord nameRec;

		// iterate through list and find record matching the name
		for (int i =0 ; i < records.size(); i++) {
			// if there is an existing record update it, and reset it on the list, and return
			nameRec = records.get(i);
			if (nameRec.getName().equalsIgnoreCase(name)) {
				return nameRec.bestYear();
			}
		}
		
		// if I made it through the loop without finding, return -1 to indicate none was found
		return -1;
	}
	

	// Return the best rank for the name, and if none is found, return -1
	public static int getBestRank(String name, ArrayList<NameRecord> records) {
		NameRecord nameRec;

		// iterate through list and find record matching the name
		for (int i =0 ; i < records.size(); i++) {
			// if there is an existing record update it, and reset it on the list, and return
			nameRec = records.get(i);
			if (nameRec.getName().equalsIgnoreCase(name)) {
				int bestYearIndex = nameRec.bestYear() - NameRecord.START;
				return nameRec.getRank(bestYearIndex);
			}
		}
		
		// if I made it through the loop without finding, return -1 to indicate none was found
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);

		// create Database object and load it
		Database nameDb = new Database();
		nameDb.loadData("names.txt");

		// Present options and loop until user wannts to quit
		int selection = 0;
		int bestYear = 0;
		int bestRank = 0;
		String name = ""; 

		do {		
			System.out.println("1 - Find best year for a female name");
			System.out.println("2 - Find best rank for a female name");
			System.out.println("3 - Find best year for a male name");
			System.out.println("4 - Find best rank for a male name");
			System.out.println("5 - Quit");
			System.out.println("Enter your selection.");
			
			// read selection
			selection = Integer.parseInt(scnr.nextLine());

			// if selection will require a name (1-4), prompt for name (do it here, so you don't have to do it in each option 1 through 4)
			if (selection > 0 && selection < 5) {
				System.out.print("\nEnter a name to search: ");
				name = scnr.nextLine();
			}
			
			// switch statement for each option
			switch (selection) {
			case 1:
				bestYear = getBestYear(name, femaleRecords);
				if (bestYear >= 0) {
					System.out.println("The best year for " + name + " was " + bestYear);
				}
				else {
					System.out.println("Sorry, we have no record of the name " + name);
				}
				break;
				
			case 2:
				bestRank = getBestRank(name, femaleRecords);
				if (bestRank >= 0) {
					System.out.println("The best rank for " + name + " was " + bestRank);
				}
				else {
					System.out.println("Sorry, we have no record of the name " + name);
				}
				break;
				
			case 3:
				bestYear = getBestYear(name, maleRecords);
				if (bestYear >= 0) {
					System.out.println("The best year for " + name + " was " + bestYear);
				}
				else {
					System.out.println("Sorry, we have no record of the name " + name);
				}
				break;
				
			case 4:
				bestRank = getBestRank(name, maleRecords);
				if (bestRank >= 0) {
					System.out.println("The best rank for " + name + " was " + bestRank);
				}
				else {
					System.out.println("Sorry, we have no record of the name " + name);
				}
				break;
			}
		}
		while (selection != 5);

	}

}

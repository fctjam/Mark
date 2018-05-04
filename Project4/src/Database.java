import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
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
		    }
		}
		catch (Exception e) {
			System.out.println("ERROR> Error reading file: " + e);
			System.exit(0);
		}
	}

	// Gets the correct Record object from the females HashMap using the name key.
	// Invokes the Record object’s bestYear(…) method and returns the value.
	public int bestFemaleYear(String name)
	{
		Record nameRec = femaleRecords.get(name);
		if (nameRec == null) {
			return -1;
		}
		else {
			return Record.START + nameRec.bestYear();
		}
	}

	// Gets the correct Record object from the males HashMap using the name key.
	// Invokes the Record object’s bestYear(…) method and returns the value.
	public int bestMaleYear(String name)
	{
		Record nameRec = maleRecords.get(name);
		if (nameRec == null) {
			return -1;
		}
		else {
			return Record.START + nameRec.bestYear();
		}
	}
	// Loops over all Record objects in the females HashMap.
	// Finds and returns the name with the largest value for the given year.
	public String bestFemaleName(int year) {
		String bestName = null;
		try {
			int  bestValue = -1;
			Iterator<Map.Entry<String, Record>> entries = femaleRecords.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
				int thisValue = ((Record)entry.getValue()).getValue(year);
				if (thisValue > bestValue) {
					bestName = (String)entry.getKey();
				}
			}

		}
		catch (java.lang.ArrayIndexOutOfBoundsException e) {
		}

		return bestName;
	}


	// Loops over all Record objects in the males HashMap.
	// Finds and returns the name with the largest value for the given year.
	public String bestMaleName(int year) {
		String bestName = null;
		try {
			int  bestValue = -1;
			Iterator<Map.Entry<String, Record>> entries = maleRecords.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
				int thisValue = ((Record)entry.getValue()).getValue(year);
				if (thisValue > bestValue) {
					bestName = (String)entry.getKey();
				}
			}

		}
		catch (java.lang.ArrayIndexOutOfBoundsException e) {
		}

		return bestName;
	}

	// Runs the main menu loop.
	// Prints the main menu and scans for an integer entered by the user.
	// Responds by running the appropriate Database method.
	// Prints results to the terminal as a nicely formatted message.
	// Continue looping back to the menu while the integer entered is not 5.	
	public void runMenu() {
		Scanner scnr = new Scanner(System.in);

		// Present options and loop until user wannts to quit
		int selection = 0;
		int bestYear = 0;
		int bestRank = 0;
		String name = "";
		int year, yearIdx;
		Record nameRec = null;

		do {		
			System.out.println("1 - Find the most popula year for a female name");
			System.out.println("2 - Find the most popula year for a male name");
			System.out.println("3 - Find the most popular female for a year");
			System.out.println("4 - Find the most popular male for a year");
			System.out.println("5 - Quit");
			System.out.println("Enter your selection.");
			
			// read selection
			selection = Integer.parseInt(scnr.nextLine());

			// switch statement for each option
			switch (selection) {
			case 1:
				System.out.print("\nEnter female name: ");
				name = scnr.nextLine();
				bestYear = bestFemaleYear(name);
				if (bestYear >= 0) {
					System.out.println("The best year for " + name + " was " + bestYear);
				}
				else {
					System.out.println("Sorry, we have no record of the name " + name);
				}
				break;
				
			case 2:
				System.out.print("\nEnter male name: ");
				name = scnr.nextLine();
				bestYear = bestMaleYear(name);
				if (bestYear >= 0) {
					System.out.println("The best year for " + name + " was " + bestYear);
				}
				else {
					System.out.println("Sorry, we have no record of the name " + name);
				}
				break;
				
			case 3:
				System.out.print("\nEnter year: ");
				year = Integer.parseInt(scnr.nextLine());
				yearIdx = year - Record.START;
				name = bestFemaleName(yearIdx);
				if (name != null)
					System.out.println("The most popular female name for " + year + " is  " + name);
				else {
					System.out.println("Sorry, the year must be between " + Record.START + " and " + Record.END);
				}
				break;
				
			case 4:
				System.out.print("\nEnter year: ");
				year = Integer.parseInt(scnr.nextLine());
				yearIdx = year - Record.START;
				name = bestMaleName(yearIdx);
				if (name != null)
					System.out.println("The most popular male name for " + year + " is  " + name);
				else {
					System.out.println("Sorry, the year must be between " + Record.START + " and " + Record.END);
				}
				break;
			}
		}
		while (selection != 5);
	}
	
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);

		// create Database object
		Database nameDb = new Database();
		
		// Load names
		System.out.print("Loading data from names.txt ... ");
		nameDb.loadData("names.txt");
		System.out.println("done.");

		// Present options and loop until user wannts to quit
		nameDb.runMenu();
		
		System.out.println("Program exited");
	}
}

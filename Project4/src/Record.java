  public class Record {
	  
	  // Create constants START=1880 and END=2016 define the start and end years in the data.
	  public static final int START=1880;
	  public static final int END=2016;
	  
	  // Use an int array to store the int value  numbers
	  int [] valueNumbers = new int[END - START + 1];
	  
	  // name
	  String name;
	  String sex;


	// Constructor – takes a String name and sets up the NameRecord object.
	  public Record(String name, String sex) {
		  this.name = name;
		  this.sex = sex;
	  }

	  // returns the name
	  public String getName() {
		  return name;
	  }

	  public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		
	  // sets the value of the name in the given year. Use the convention that year=0 is 1880, year=1 is 1881, and so on.
	  public void setValue (int year, int value) {
		  valueNumbers[year] = value;
	  }
	  
	  // returns the value of the name in the given year. Use the convention that year=0 is 1880, year=1 is 1881, and so on.
	  public int getValue(int year) {
		  return valueNumbers[year];
	  }
	  
	  // returns the year where the name was most popular, using the earliest year in the event of a tie. Returns the actual year,
	  // for example 1920, so the caller does not need to adjust for START. It is safe to assume that every name has at least one 
	  // year with a non-zero value.  
	  public int bestYear() {
		  // iterate through the whole array of years
		  int highestYear = 0;
		  int highestvalue = 0;
		  for (int i = 0; i < valueNumbers.length; i++) {
			  if (valueNumbers[i] > highestvalue) {
				  highestvalue = valueNumbers[i];
				  highestYear = i;
			  }
		  }
		  
		  // add the start 
		  return highestYear;
		  
	  }
  }


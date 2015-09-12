import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Scheduling { 
	
	public static void main(String[] args) {
		readFile("C:/Users/BenX/git/Programing_Languages/PL/test");
	}
	
	// Attempts to read the text file and process it line by line
	private static void readFile(String fileName){
		try {
			FileReader inputFile = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(inputFile);
			String line;
			
			// Since there are 4 shifts, this simple array will suffice
			String[][] shiftArray = new String[4][4];
			
			// For storing an unknown sized employee list
			ArrayList<Employee> empAr = new ArrayList<Employee>();
			
			int rowCounter = 0;
			
			while ((line = bufferReader.readLine()) != null){
				
				String temp2 = line.trim();
				
				// Checks if each line is null when trimmed of white space and skips line 4	
				if(!temp2.isEmpty()){
					
					//splits each element of the array into each word separated by a space char
					String[] temp = line.split(" ");
					// Checks for line number for employee data for employee array processing
					if(rowCounter > 4){
						//Adds a new employee to the array list if they're on the shift
						for(int row = 0; row < shiftArray.length; row++) {
							for (int col = 0; col < shiftArray[row].length; col++) {
								if(temp[0].compareTo(shiftArray[row][col]) == 0 && temp.length == 4){
									empAr.add(new Employee(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3])));
								}
							}
						}
					}
					
					// This processes the list of names for each shift
					else if(rowCounter <= 3){
						for(int i = 0; i < temp.length; i++){
							shiftArray[rowCounter][i] = temp[i];
						}
					}
					
				    rowCounter++;
				}

					
			}
			bufferReader.close();
			if(noDuplicates(shiftArray)){	
				if(shiftChecker(shiftArray, empAr)){
					System.out.println("Acceptable");
				}
			
				else{
					System.out.println("Unacceptable");
				}
			}
			else{
				System.out.println("There is a duplicate!");
			}
					
		}
		catch (IOException ex){
	        System.out.println("Error: " + fileName);
	    }
		
	}
	
	// Checks if there are any duplicates in the day's shifts
	public static boolean noDuplicates(String[][] s) {
		 
		//Check for duplicates in shift
		List<String> list = new LinkedList<String>();
		
		for(int row = 0; row < s.length; row++) {
			for (int col = 0; col < s[row].length; col++) {
				list.add(s[row][col]);
			}
		}

		Set<String> set = new HashSet<String>(list);

		if(set.size() < list.size()){
		   return false;
		}
		return true;
				
	}
	
	// Validates shift schedule with employee skills
	private static boolean shiftChecker(String[][] s, ArrayList<Employee> empList){
	

		//Row index is also shift index
		for(int row = 0; row < s.length; row++) {
			for (int col = 0; col < s[row].length; col++) {
				String temp = s[row][col];
				for(int i = 0; i < empList.size(); i++){
					if(temp.compareTo(empList.get(i).getName()) == 0){
						if(col < 2){
							if(empList.get(i).getPhoneSkill() == 0){
								return false;
							}
						}
						
						else if(col == 2){
							
							if(empList.get(i).getRepairSkill() == 0){
								return false;
							}
						}
						
						else{
							
							if(empList.get(i).getNetworkSkill() == 0){
								return false;
							}
						}
					}
				}
			}
		}
			 
		return true;
			
	}
}
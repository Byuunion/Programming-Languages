import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Brute { 

	public static void main(String[] args) {
		readFile("D:/Eclipse_Workspace/PL/test");
	}
	
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
				if(!temp2.isEmpty() && rowCounter != 4){
					
					//splits each element of the array into each word separated by a space char
					String[] temp = line.split(" ");
					
					// Checks for line number for employee data for employee array processing
					if(rowCounter > 3){
						//Adds a new employee to the array list
						if()
						empAr.add(new Employee(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3])));
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
			
			if(goodShift(shiftArray,empAr)){
				System.out.println("Good Shift");
			}
			
			else{
				System.out.println("Bad Shift");
			}

		}
					
			
		catch (IOException ex){
	        System.out.println("Error: " + fileName);
	    }
		
	}
	
	private static boolean goodShift(String[][] s, ArrayList empList){
		//Check for duplicates in shift
		for(int i = 0; i < s.length; i++) {
			
			for (int j = 0; j < s[i].length; j++) {
				System.out.println(s[i][j]);
			}
			
		}
		
		
		return true;
		
	}
}
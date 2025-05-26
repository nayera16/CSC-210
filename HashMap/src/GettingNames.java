import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;

public class GettingNames {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File myFile = new File("names.txt");
		Scanner myReader = new Scanner(myFile);
		
		HashSet<String> myNames = new HashSet<String>();
		while (myReader.hasNext()) {
			String line = myReader.nextLine();
			myNames.add(line);	
				
		}
		
		ArrayList<String> sortedNames = new ArrayList<String>(myNames);
		Collections.sort(sortedNames);
		
		for (String name : sortedNames) System.out.println(name);
		
		myReader.close();
	}

}

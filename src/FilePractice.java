import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FilePractice {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File myFile = new File("inputFile1.txt");
		Scanner myReader = new Scanner(myFile);
		
		while (myReader.hasNextLine()) {
			String line1 = myReader.nextLine();
			System.out.println(line1);
		}
		
		
		myReader.close();
	}

}
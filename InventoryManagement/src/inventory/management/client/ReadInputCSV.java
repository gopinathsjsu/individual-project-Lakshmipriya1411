package inventory.management.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadInputCSV {

	//private static final Pattern COMMA_DELIMITER= new Pattern((\\p{javaWhitespace}|\\,)+";
	private static List<String> getRecordFromLine(String line) {
	    List<String> values = new ArrayList<String>();
	    try (Scanner rowScanner = new Scanner(line)) {
	        rowScanner.useDelimiter(",");
	        while (rowScanner.hasNext()) {
	            values.add(rowScanner.next());
	        }
	    }
	    return values;
	}
	public static List<List<String>> readCSV(String filePath) throws Exception
	{
		List<List<String>> records = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(filePath));) {
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		}
		return records;
	}
}

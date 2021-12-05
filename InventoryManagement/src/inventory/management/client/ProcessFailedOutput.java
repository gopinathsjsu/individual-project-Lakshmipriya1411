package inventory.management.client;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;


public class ProcessFailedOutput implements IProcessOutput{
	private static List<String[]> createCsvDataSpecial(List<InputInventory> ii) throws Exception {
        String[] header = {"Please correct quantities."};	       
        
        List<String[]> lstArr=new ArrayList<String[]>();
        lstArr.add(header);
        for(int i=0;i<ii.size();i++)
        {
        	String[] record = {};
        	InputInventoryAsObject iiObj=new InputInventoryAsObject(ii.get(i));
        	
        	InputInventoryListAdapter stringArrAdapter = new InputInventoryListAdapter(iiObj);   
        	record=stringArrAdapter.getInputInventoryAsArray();
        	lstArr.add(record);
        }
        
        return lstArr;

	}
	@Override
	public void renderOutput(List<InputInventory> ii) throws Exception {		
		List<String[]> csvData = createCsvDataSpecial(ii);
		try (CSVWriter writer = new CSVWriter(new FileWriter("FailedOutput.txt"))) {
	            writer.writeAll(csvData);
	    }
		catch(Exception ex)
		{
			
		}
		
	}	
}

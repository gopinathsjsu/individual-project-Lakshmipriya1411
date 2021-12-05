package inventory.management.client;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVWriter;

import inventory.management.server.Repository.IInventoryRepository;
import inventory.management.server.Repository.InventoryItem;
import inventory.management.server.Repository.InventoryRepository;

public class ProcessSuccessOutput implements IProcessOutput{
	
	private static List<String[]> createCsvDataSpecial(List<InputInventory> ii) throws Exception {
	       
			String[] header = {"Amt Paid"};	       
	        String[] record1 = {"0"};
	        
	        ItemRepository itemsRepository = new ItemRepository();
	        double total=0;
			for(IIterator iter = itemsRepository.getIterator(ii); iter.hasNext();){               
				InputInventory itm = (InputInventory)iter.next();
				IInventoryRepository inventoryRepo = new InventoryRepository();
				InventoryItem it=inventoryRepo.read(itm.getItem());
				total=total+(itm.getQuantity()* Double.parseDouble(it.Price));				
			}
	        
	        List<String[]> list = new ArrayList<>();
	        list.add(header);	             
	        record1[0]=String.valueOf(total);
	        list.add(record1); 
	        return list;

    }
	@Override
	public void renderOutput(List<InputInventory> ii) throws Exception {		
		List<String[]> csvData = createCsvDataSpecial(ii);
		try (CSVWriter writer = new CSVWriter(new FileWriter("SuccessOutput.csv"))) {
	            writer.writeAll(csvData);
	    }
		catch(Exception ex)
		{
			
		}
		
	}	

}

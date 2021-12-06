package inventory.management.server.DAL;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import inventory.management.server.Repository.InventoryItem;

public class InventoryItemDAOImpl implements InventoryItemDAO{

	   private static Map<String,Map<String,String>> inventoryManager;
	   private static Map<String,String> creditCardManager;
	   
	   public InventoryItemDAOImpl() throws Exception {
		   inventoryManager=CSVFileReader.loadDataFromCSV("Dataset - Sheet1.csv");
		   creditCardManager=CSVReadCard.loadCSVForCreditCard("Cards - Sheet1.csv");
	   } 
	   
	    @Override
	    public InventoryItem read(String item) {
	        Map<String,String> inventry= inventoryManager.get(item);
	        final ObjectMapper mapper = new ObjectMapper(); 
	        final InventoryItem inventoryMapper = mapper.convertValue(inventry, InventoryItem.class);
			return inventoryMapper;	        
	    }
	    @Override
	    public String readCard(String item) {
	        String creditCard= creditCardManager.get(item);	       
			return creditCard;	        
	    }
	    @Override
	    public void readCards() {	      
			Iterator<Entry<String, String>> ccIterator=creditCardManager.entrySet().iterator();
	        while(ccIterator.hasNext())
	        {
	        	@SuppressWarnings("rawtypes")
				Map.Entry mapElem=(Map.Entry)ccIterator.next();
	        	System.out.println(mapElem.getValue());
	        }
	    }
	    @Override
	    public void addCard(String item) {
	        String creditCard= creditCardManager.put(item,item);
	        @SuppressWarnings("rawtypes")
			Iterator ccIterator=creditCardManager.entrySet().iterator();
	        while(ccIterator.hasNext())
	        {
	        	@SuppressWarnings("rawtypes")
				Map.Entry mapElem=(Map.Entry)ccIterator.next();
	        	//System.out.println(mapElem.getValue());
	        }
	        
	    }
 }

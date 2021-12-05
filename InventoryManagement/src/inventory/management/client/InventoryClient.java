package inventory.management.client;

import java.util.ArrayList;
import java.util.List;

import inventory.management.middleware.CheckQuantityCap;
import inventory.management.middleware.IsValidInventoryQuantity;
import inventory.management.middleware.Middleware;
import inventory.management.server.Inventory;

public class InventoryClient {
	private static Inventory server;
	private static Output ipo;
	private static List<InputInventory> lstInputInv=new ArrayList<InputInventory>();
	private static void init() throws Exception {
        server = new Inventory();        
        Middleware middleware = new IsValidInventoryQuantity(server);
        middleware.linkWith(new CheckQuantityCap(server));   
        server.setMiddleware(middleware);
    }
	public static void main(String[] args) throws Exception {
        	init();        	        	  
        	List<List<String>> lstItems=ReadInputCSV.readCSV("Input3 - Sheet1.csv");      
        	 ItemRepository itemsRepository = new ItemRepository();
             for(IIterator iter = itemsRepository.getIterator(lstItems); iter.hasNext();){
                InputInventory iinv=new InputInventory();
				@SuppressWarnings("unchecked")
				List<String> itm = (List<String>)iter.next();
				IIterator iter2 = itemsRepository.getIterator(itm);
				if(iter2.hasNext())
					iinv.setItem((String)iter2.next());
				if(iter2.hasNext())
					iinv.setQuantity((String)iter2.next());
				if(iter2.hasNext())
					iinv.setCardNumber((String)iter2.next());
				lstInputInv.add(iinv);
             }
                          
            List<InputInventory> failedInventory = server.processInventories(lstInputInv);                    
            if(failedInventory.size()==0)
            {
            	configureOutput(true);
            	runOutput(lstInputInv);
            }
            else
            {
            	configureOutput(false);
            	runOutput(failedInventory);
            }       
    }
	private static void runOutput(List<InputInventory> ii) {
		try 
		{		
			ipo.generateOutput().renderOutput(ii);
		} catch (Exception e) {			
			e.printStackTrace();
		};
	}
	private static void configureOutput(boolean isSuccess) {
		if(isSuccess)
		{
			ipo = new SuccessOutput();
		}
		else
		{
			ipo=new FailureOutput();
		}		
	}
}

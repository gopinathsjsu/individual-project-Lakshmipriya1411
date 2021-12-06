package inventory.management.middleware;

import java.util.ArrayList;
import java.util.List;

import inventory.management.client.IIterator;
import inventory.management.client.InputInventory;
import inventory.management.client.ItemRepository;
import inventory.management.server.Inventory;
import inventory.management.server.Repository.IInventoryRepository;
import inventory.management.server.Repository.InventoryItem;
import inventory.management.server.Repository.InventoryRepository;

public class IsValidInventoryQuantity extends Middleware{
	private Inventory server;

	public IsValidInventoryQuantity(Inventory server) {
        this.server = server;
    }

    public List<InputInventory> isValidInventory(List<InputInventory> items) {
    	//boolean isValidItem=true;
    	List<InputInventory> lstII=new ArrayList<InputInventory>();
    	ItemRepository itemsRepository = new ItemRepository();
    	try {
    		
    		for(IIterator iterate = itemsRepository.getIterator(items); iterate.hasNext();){ 
    			InputInventory item= (InputInventory)iterate.next();  
    			InventoryItem it=server.readInventoryDetails(item.getItem());	
    			
	        if (Integer.parseInt(it.Quantity) < item.getQuantity()) {
	            System.out.println("The input item quantity is greater than the stock quantity!");
	            System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
	            lstII.add(item);
	            //isValidItem=false;
	            return lstII;
	        }else
	        {
	        	System.out.println("The input item quantity is less than the stock quantity!");
	            System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
	        }
    	  }
    		
    		//return lstII;
    		
		} catch (Exception e) {			
			e.printStackTrace();
		}		
        return checkNext(items);
    }
}

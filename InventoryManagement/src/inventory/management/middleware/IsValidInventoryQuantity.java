package inventory.management.middleware;

import inventory.management.client.InputInventory;
import inventory.management.server.Inventory;
import inventory.management.server.Repository.IInventoryRepository;
import inventory.management.server.Repository.InventoryItem;
import inventory.management.server.Repository.InventoryRepository;

public class IsValidInventoryQuantity extends Middleware{
	private Inventory server;

	public IsValidInventoryQuantity(Inventory server) {
        this.server = server;
    }

    public boolean isValidInventory(InputInventory item) {
    	boolean isValidItem=true;    	
    	try {			
			InventoryItem it= this.server.readInventoryDetails(item.getItem());
	        if (Integer.parseInt(it.Quantity) < item.getQuantity()) {
	            System.out.println("The input item quantity is greater than the stock quantity!");
	            System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
	            isValidItem=false;
	            return isValidItem;
	        }else
	        {
	        	System.out.println("The input item quantity is less than the stock quantity!");
	            System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
	        }
		} catch (Exception e) {			
			e.printStackTrace();
		}		
        return checkNext(item);
    }
}

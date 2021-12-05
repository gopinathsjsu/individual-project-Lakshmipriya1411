package inventory.management.middleware;

import inventory.management.client.InputInventory;
import inventory.management.server.Inventory;
import inventory.management.server.Repository.IInventoryRepository;
import inventory.management.server.Repository.InventoryItem;
import inventory.management.server.Repository.InventoryRepository;

public class CheckQuantityCap extends Middleware {

	private Inventory server;

	public CheckQuantityCap(Inventory server) {
        this.server = server;
    }
	public enum Categories {
		ESSENTIAL,
		LUXURY,
		MISC
	}
	public boolean isValidInventory(InputInventory item) {
	    boolean isValidItem=true;	
	    
		try 
		{			
			InventoryItem it=this.server.readInventoryDetails(item.getItem());
		    switch(Categories.valueOf(it.Category.toUpperCase()))
		    {
		    	case ESSENTIAL: if(item.getQuantity()>Inventory.MAXEssentials)
		    					{
		    						//isValidItem= ?false:true;return isValidItem;
		    						System.out.println("item quantity is greater than the max lmit on essentials");
		    						System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
		    						return false;
		    					}else
		    					{
		    						//isValidItem= ?false:true;return isValidItem;
		    						System.out.println("item quantity is less than the max lmit on essentials");
		    						System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
		    						return true;
		    					}
		    	case LUXURY: if(item.getQuantity()>Inventory.MAXLuxury)
		    				 {
		    						System.out.println("item quantity is greater than the max lmit on Luxury");
		    						System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
		    						return false;
		    				 }
		    				 else
		    				 {
		    					 	System.out.println("item quantity is less than the max lmit on Luxury");
		    						System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
		    						return true;
		    		  		 }
		    	case MISC:  if(item.getQuantity()>Inventory.MAXMisc)
		    				{
		    						//?false:true;return isValidItem;
		    					System.out.println("item quantity is greater than the max lmit on Misc");
		    					System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
		    					return false;
		    				}
		    				else
		    				{
		    					System.out.println("item quantity is less than the max lmit on Misc");
	    						System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
	    						return true;
		    				}
		    } 
		} catch (Exception e) {			
			e.printStackTrace();
		}	
	   
	    return checkNext(item);
	}	
}

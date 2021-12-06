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
	public List<InputInventory> isValidInventory(List<InputInventory> items) {
	    //boolean isValidItem=true;
		List<InputInventory> lstII=new ArrayList<InputInventory>();
		ItemRepository itemsRepository = new ItemRepository();
		try 
		{
		  int essentialCount=0;
		  int luxuryCount=0;
		  int miscCount=0;
		  List<InputInventory> lstEssentials=new ArrayList<InputInventory>();
		  List<InputInventory> lstLuxuries=new ArrayList<InputInventory>();
		  List<InputInventory> lstMisc=new ArrayList<InputInventory>();
		  for(IIterator iterate = itemsRepository.getIterator(items); iterate.hasNext();){ 
			InputInventory itemNext= (InputInventory)iterate.next();  
			InventoryItem item=server.readInventoryDetails(itemNext.getItem());		
			//InventoryItem it=this.server.readInventoryDetails(item.getItem());
		    switch(Categories.valueOf(item.Category.toUpperCase()))
		    {
		    	case ESSENTIAL: essentialCount+=itemNext.getQuantity();lstEssentials.add(itemNext);break;
		    	case LUXURY: luxuryCount+=itemNext.getQuantity();lstLuxuries.add(itemNext);break;
		    	case MISC:  miscCount+=itemNext.getQuantity();lstMisc.add(itemNext);break;
		    } 
		  }
		  if(essentialCount>Inventory.MAXEssentials)
		  {
			  for(int i=0;i<lstEssentials.size();i++)
			  {
				  InputInventory item=lstEssentials.get(i);
				  System.out.println("The input item quantity Essential is greater than the MAX cap quantity!");
		          System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
				  lstII.add(lstEssentials.get(i));
			  }
		  }
		  else if(luxuryCount>Inventory.MAXLuxury)
		  {
			  for(int j=0;j<lstLuxuries.size();j++)
			  {
				  InputInventory item=lstLuxuries.get(j);
				  System.out.println("The input item quantity Luxury is greater than the MAX cap quantity!");
		          System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
				  lstII.add(lstLuxuries.get(j)); 
			  }
		  }
		  else if(miscCount>Inventory.MAXMisc)
		  {
			  for(int k=0;k<lstMisc.size();k++)
			  {
				  InputInventory item=lstLuxuries.get(k);
				  System.out.println("The input item quantity Misc is greater than the MAX cap quantity!");
		          System.out.println(item.getItem()+" "+item.getQuantity()+" "+item.getCardNumber());
				  lstII.add(lstMisc.get(k));  
			  }
		  }
		  
		  return lstII;
		  
		} catch (Exception e) {			
			e.printStackTrace();
		}	
	   
	    return checkNext(lstII);
	}	
}

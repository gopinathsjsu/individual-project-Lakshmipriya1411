package inventory.management.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import inventory.management.client.IIterator;
import inventory.management.client.InputInventory;
import inventory.management.client.ItemRepository;
import inventory.management.middleware.Middleware;
import inventory.management.server.Repository.IInventoryRepository;
import inventory.management.server.Repository.InventoryItem;
import inventory.management.server.Repository.InventoryRepository;

public class Inventory {	
	
	public static InventoryItem item =new InventoryItem();
	
	public static int MAXEssentials = 5;
	public static int MAXLuxury = 3;
	public static int MAXMisc = 6;
	
	private Middleware middleware;
	
	IInventoryRepository inventoryRepo;
	
	public Inventory() throws Exception
	{
		 	inventoryRepo=new InventoryRepository();
	}
	public void setMiddleware(Middleware middleware) {
		
	        this.middleware = middleware;
	}
	public List<InputInventory> processInventories(List<InputInventory> lstInventories)
	{
		 	boolean success;
		 	List<InputInventory> failedInventory=new ArrayList<InputInventory>();    
		 	ItemRepository itemsRepository = new ItemRepository();
		 	for(IIterator iter = itemsRepository.getIterator(lstInventories); iter.hasNext();){            	
			InputInventory ipInv= (InputInventory)iter.next();         	
         	success = processInventory(ipInv);
         	if(!success)
         	{
         		failedInventory.add(ipInv);        
         	}
		 }
		 	if(failedInventory.size()==0)
		 		chkAndAddCard(lstInventories);
			return failedInventory;
	}
	public boolean processInventory(InputInventory ipInv) {
		
        if (middleware.isValidInventory(ipInv)) {
            System.out.println("verification have been successful!");           
            return true;
        }
        return false;
    }
	
	public void addNewCardDetails(String card)
	{
		try {		
			inventoryRepo.addCard(card);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public void chkAndAddCard(List<InputInventory> ii)
	{
		 ItemRepository itemsRepository = new ItemRepository();
		 for(IIterator iter = itemsRepository.getIterator(ii); iter.hasNext();){            	
         	InputInventory ipInv= (InputInventory)iter.next();           	
         	if(readCardDetails(ipInv.getCardNumber()) == null)
         	{         		
         		addNewCardDetails(ipInv.getCardNumber());
         	}
         }	
		 System.out.println("Unique cards in the databse:");
		inventoryRepo.readCards();
	}
	public InventoryItem readInventoryDetails(String itemName)
	{
		try {			
			item=inventoryRepo.read(itemName);			
			return item;
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
		
	}
	public String readCardDetails(String itemName)
	{
		try {			
			String cc=inventoryRepo.readCard(itemName);	
			return cc;
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return "";
		
	}
}

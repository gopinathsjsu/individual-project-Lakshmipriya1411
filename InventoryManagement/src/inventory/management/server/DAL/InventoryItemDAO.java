package inventory.management.server.DAL;

import inventory.management.server.Repository.InventoryItem;

public interface InventoryItemDAO {	
    InventoryItem read(String item);
	String readCard(String item);   
	void addCard(String item);
	void readCards();
}

package inventory.management.server.Repository;

public interface IInventoryRepository {
	 InventoryItem read(String item);
	 String readCard(String item);   
	 void addCard(String item);
	 void readCards();
}

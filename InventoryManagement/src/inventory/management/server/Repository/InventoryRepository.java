package inventory.management.server.Repository;

import inventory.management.server.DAL.InventoryItemDAOImpl;

public class InventoryRepository implements IInventoryRepository {
    private InventoryItemDAOImpl inventoryItemDaoImpl;
    public InventoryRepository() throws Exception {
    	inventoryItemDaoImpl=new InventoryItemDAOImpl();
    }
    @Override
	public
    InventoryItem read(String item) {
        InventoryItem ii = inventoryItemDaoImpl.read(item);
        return ii;
    }
	@Override
	public String readCard(String item) {
		String cc = inventoryItemDaoImpl.readCard(item);
        return cc;
	}
	@Override
	public void addCard(String item) {
		inventoryItemDaoImpl.addCard(item);		
	}
	@Override
	public void readCards()
	{
		inventoryItemDaoImpl.readCards();
	}    
}

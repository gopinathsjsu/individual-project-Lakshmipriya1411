package inventory.management.middleware;

import inventory.management.client.InputInventory;

public interface IValidInventory {
	
	public boolean isValidInventory(InputInventory item);
	
}

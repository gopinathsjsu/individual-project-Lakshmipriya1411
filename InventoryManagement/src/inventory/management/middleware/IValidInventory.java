package inventory.management.middleware;

import java.util.List;

import inventory.management.client.InputInventory;

public interface IValidInventory {
	
	public List<InputInventory> isValidInventory(List<InputInventory> item);
	
}

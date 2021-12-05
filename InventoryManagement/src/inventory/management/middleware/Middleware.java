package inventory.management.middleware;

import inventory.management.client.InputInventory;

public abstract class Middleware implements IValidInventory {
	private Middleware next;
	public Middleware linkWith(Middleware next) {
	        this.next = next;
	        return next;
	}
	
	public abstract boolean isValidInventory(InputInventory item);
	protected boolean checkNext(InputInventory item) {
	        if (next == null) {
	            return true;
	        }
	        return next.isValidInventory(item);
	 }
}

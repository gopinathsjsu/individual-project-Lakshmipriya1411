package inventory.management.middleware;

import java.util.ArrayList;
import java.util.List;

import inventory.management.client.InputInventory;

public abstract class Middleware implements IValidInventory {
	private Middleware next;
	public Middleware linkWith(Middleware next) {
	        this.next = next;
	        return next;
	}
	
	public abstract List<InputInventory> isValidInventory(List<InputInventory> item);
	protected List<InputInventory> checkNext(List<InputInventory> item) {
	        if (next == null) {
	        	List<InputInventory> lstii=new ArrayList<InputInventory>();
	            return lstii;
	        }
	        return next.isValidInventory(item);
	 }
}
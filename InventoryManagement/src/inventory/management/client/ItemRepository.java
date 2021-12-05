package inventory.management.client;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository implements IContainer {

	@Override
	 public <T> IIterator getIterator(List<T> lstItems) {
	      return new ItemIterator<T>(lstItems);
	 }
	 private class ItemIterator<T> implements IIterator {
      
	      int index=0;
	      int size;
	      List<T> listItems = new ArrayList<>();
	      public ItemIterator(List<T> lstItems)
	      {
	    	 this.size= lstItems.size();
	    	 this.listItems=(List<T>) lstItems;
	      }

	      @Override
	      public boolean hasNext() {	      
	    	
			if(index<this.size){
	            return true;
	         }
	         return false;
	      }

	      @Override
	      public Object next() {
	      
	         if(this.hasNext()){
	        	 return listItems.get(index++);
	         }
	         return null;
	      }		
	   }
	

}

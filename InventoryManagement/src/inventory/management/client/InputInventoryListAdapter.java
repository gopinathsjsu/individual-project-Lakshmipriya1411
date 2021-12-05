package inventory.management.client;

public class InputInventoryListAdapter extends InputInventoryAsStringArray{

	private InputInventoryAsObject iil;
	
	public InputInventoryListAdapter(InputInventoryAsObject lstii) {
	        this.iil = lstii;
	}
	 @Override
	public String[] getInputInventoryAsArray() {
		 String[] arr = new String[3];
		 arr[0]=iil.getInputInventory().getItem();
		 arr[1]=String.valueOf(iil.getInputInventory().getQuantity());
		 arr[2]=iil.getInputInventory().getCardNumber();
		 return arr;
	}
}

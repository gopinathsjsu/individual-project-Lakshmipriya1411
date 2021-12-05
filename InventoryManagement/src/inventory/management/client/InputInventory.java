package inventory.management.client;

public class InputInventory {

	private String item;
	  // Getter
	public String getItem() {
	   return item;
	}	  
	  // Setter
	public void setItem(String it) {
	    this.item = it;
	}
	
	private String cardNumber;
	// Getter
	public String getCardNumber() {
	    return cardNumber;
	}		  
	  // Setter
	public void setCardNumber(String cn) {
	  this.cardNumber = cn;
	} 
	
	private int quantity;
	// Getter
	public int getQuantity() {
	    return quantity;
	}		  
	  // Setter
	public void setQuantity(String qty) {
	  this.quantity = Integer.parseInt(qty);
	} 	  
}

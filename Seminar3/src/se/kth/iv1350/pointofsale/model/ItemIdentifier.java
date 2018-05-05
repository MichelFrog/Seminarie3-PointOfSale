package se.kth.iv1350.pointofsale.model;

public class ItemIdentifier {
	final int itemId;
	
	/*
	 * Constructor changes the value of the @itemIdentifier
	 *  which will be used for HashMaps and to find Items 
	 *  in database.
	 *  
	 */
	public ItemIdentifier(int itemIdentifier) {
		this.itemId = itemIdentifier;
	}
	
	/*
	 * Used for comparing two object, items, to see if they are of the same type;
	 * 
	 * @return true(1) if they are equal else return false(0).
	 * 
	 */
	 @Override
	 public boolean equals(Object comparedItem){
		  
		    if(comparedItem instanceof ItemIdentifier){ 
		    ItemIdentifier compId = (ItemIdentifier) comparedItem;
		    return itemId == compId.getItemId();
		    }
		    return false; 
	 } 
	 
	 @Override
	 public int hashCode() {
		 return itemId;
		 
	 }
	 /*
	  * Gets the ItemId from field variable.
	  * 
	  */
	public int getItemId() {
		return itemId;
		}
	
}


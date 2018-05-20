package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.model.ItemIdentifier;
/*******************************************************
 * Thrown if the ItemIdentifier isn't compatible when
 * trying to perform operation in <code>ItemIdentifier</code>
 * The error message contains more information regarding the
 * issue at hand.
 *******************************************************/
public class NonExistingItemException extends Exception {

	private ItemIdentifier itemIdentifierThatDoesntExist;

	/***************************************************************
	 * Constructor for <code>NonExistingItemException</code>. Used to throw
	 * exception when items are not in the database. <code>ItemIdentifier</code> 
	 * is stored to be used in other method.
	 * 
	 * @param itemIdentifierThatDoesntExist The <code>ItemIdentifier</code> that
	 * doesn't exist
	 ***************************************************************/
	public NonExistingItemException(ItemIdentifier itemIdentifierThatDoesntExist) {
		
		super("Cannot find item with itemID: " + itemIdentifierThatDoesntExist.getItemId() + 
				". Please try another itemID.");
		this.itemIdentifierThatDoesntExist = itemIdentifierThatDoesntExist; 
	}

	/********************************
	 * Getter for the value of the ItemIdentifier. 
	 * Used for printing
	 ********************************/
	public int getItemIdentifierThatDoesntExist() {
		return itemIdentifierThatDoesntExist.getItemId();
	}
}




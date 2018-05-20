package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.model.ItemIdentifier;

import java.util.*;
/****************************************************************
 * Generic exception class used for giving information regarding
 * of exceptions within the <code>ItemCatalog</code>.
 * 
 ****************************************************************/
public class ItemCatalogException extends RuntimeException {

	/************************************************************
	 * Creates a new instance representing a condition that
	 * is described in the message.
	 *
	 * @param msg Describing message for the error that occurred.
	 ************************************************************/
	public ItemCatalogException(String message) { 
		super(message);
	}
}


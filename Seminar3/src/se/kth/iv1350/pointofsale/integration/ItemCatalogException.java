package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.model.ItemIdentifier;

import java.util.*;
/*
 * Generic exception class used for giving information regarding
 * of exceptions within the ItemCatalog.
 * 
 */
public class ItemCatalogException extends RuntimeException {

	/**
	 * Creates a new instance representing a condition that
	 * is described in the msg.
	 *
	 * @param msg Describing message for the error that occurred.
	 */
	public ItemCatalogException(String msg) { 
		super(msg);
	}
}


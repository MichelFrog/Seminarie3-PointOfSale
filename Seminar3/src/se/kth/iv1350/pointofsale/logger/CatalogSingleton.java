package se.kth.iv1350.pointofsale.logger;

public class CatalogSingleton {

	private static final CatalogSingleton ITEM_CATALOG = null;
			
	/*
	 * Empty constructor for SingleTon
	 */
	private CatalogSingleton() { 
	}
	
	/*
	 * Fetching the empty instance of CatalogSingleton. Used
	 * to create a Singleton of a class.
	 * 
	 * @Return the main, and only, singleton		
	 */
	public static CatalogSingleton getFactory() { 
		return ITEM_CATALOG;
	}
}

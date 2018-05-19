package se.kth.iv1350.pointofsale.logger;

public class CatalogSingleton {

	private static final CatalogSingleton ITEM_CATALOG = null;
			
	
	private CatalogSingleton() { 
	}
	
	/*
	 * @Return the main, and only, singleton		
	 */
	public static CatalogSingleton getFactory() { 
		return ITEM_CATALOG;
	}
}

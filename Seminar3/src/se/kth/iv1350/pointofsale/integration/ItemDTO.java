package se.kth.iv1350.pointofsale.integration;

import se.kth.iv1350.pointofsale.integration.*;
import se.kth.iv1350.pointofsale.model.*;

/*****************************************************
 * ItemDTO is final since its static and may not be
 * changed as its passing through the layers.
 *****************************************************/
public final class ItemDTO {

	private ItemIdentifer itemIdentifer;
	private int price;
	private String itemName;
	private String description;
	private String tax;
	
	/******************************************************
	 * Constructor.
	 * Creates a new instance representing an item in the store.
	 *
	 * @param itemName	 	Name of the product. 
	 * @param price  	 	The price after tax for the item.
	 * @param tax   		 	The tax added to the price.
	 * @param description 	Short description of the book.
	 *****************************************************/
	public ItemDTO(String itemName, int price,String tax, String description) {
			
			this.itemIdentifier;
			this.itemName = itemName; 
			this.price = price;
			this.tax = tax; 
			this.description = description; 
	
			}
	
	/*******************************************************************************
	 * Empty ItemDTO used for returning values in <code>searchForItem<code>
	 * *****************************************************************************
	 */
	public ItemDTO() {
	}
	
	public String toString() {
        return "Item [Name:" + itemName + ", Price:" + price + ", Taxrate:" + tax + "Description:"+ description+"]";
        }
	
	
	
    /****************************
     * Get the value of itemName
     *
     * @return the value of itemName
     ***************************/
    public String getItemName() {
        return itemName;
    }

    /***************************
     * Get the value of price
     *
     * @return the value of price
     ***************************/
    public int getPrice() {
        return price;
    }

    /****************************
     * Get the value of tax
     *
     * @return the value of tax
     ***************************/
    public String getTax() {
        return tax;
    }

    /****************************
     * Get the value of description
     *
     * @return the value of description
     ***************************/
    public String getDescription() {
        return description;
    }

}

package se.kth.iv1350.pointofsale.model;

public class Receipt {
	private SaleDTO saleInfo;
	private AmountOfCash change;
	private AmountOfCash givenAmount;

	/***********************************************
	 *Constructor for Receipt. Sets all the variables to parameters
	 * @param saleInfo Contains all the information of the sale.
	 * @param change			  The amount of change that will be returned.
	 * @param givenAmount		  The amount of money given by the customer
	 **********************************************/
	public Receipt(SaleDTO saleInfo, AmountOfCash change, AmountOfCash givenAmount) {
		this.saleInfo = saleInfo;
		this.change = change;
		this.givenAmount = givenAmount;


	}
	/**********************************************
	 * Getter for all the scanned items as a string representation
	 **********************************************/
	private String getSoldItems(){

		return saleInfo.getScannedItems().toString();
	}
	/**********************************************
	 * Creates a string representation of all the items that has been sold.
	 * 
	 * @return String Returns the string represenation of all the items.
	 **********************************************/ 
	public String toString(){
		StringBuilder buildReciept = new StringBuilder();
		buildReciept.append(getSoldItems());

		return buildReciept.toString();
	}
}


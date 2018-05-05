package se.kth.iv1350.pointofsale.model;

import se.kth.iv1350.pointofsale.model.*;
import se.kth.iv1350.pointofsale.integration.*;

public class TotalPrice {

	private  AmountOfCash price;

	private double tax;

    /**
     *
     * @param finalSaleInfo
     */
    public TotalPrice(SaleInformation finalSaleInfo) {
		if(finalSaleInfo == null) {System.out.print("rerrreroeoreoroe");}
    		price = finalSaleInfo.getRunningTotal();
                tax = 12;
                addTax();
	}

	private void addTax() {
            price.updateAmount(price.getAmount()*tax);
	}
	
	
	public AmountOfCash getFinalPrice() {
			return price;
	}
}

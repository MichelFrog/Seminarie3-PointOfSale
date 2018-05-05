package se.kth.iv1350.pointofsale.model;

public class Receipt {
	        private SaleDTO saleInfo;
	        private AmountOfCash change;
	        private AmountOfCash givenAmount;

	    /**
	     *
	     * @param saleInformation
	     * @param change
	     * @param paidMoney
	     */
	    public Receipt(SaleDTO saleInformation, AmountOfCash change, AmountOfCash givenAmount) {
	        this.saleInfo = saleInformation;
	        this.change = change;
	        this.givenAmount = givenAmount;
	        
	        
	    }
	    
	    private String getSoldItems(){
	            
	        return saleInfo.getScannedItems().toString();
	    }
	    
	    public String toString(){
	        StringBuilder buildReciept = new StringBuilder();
	        buildReciept.append(getSoldItems());
	        
	        return buildReciept.toString();
	    }
	}


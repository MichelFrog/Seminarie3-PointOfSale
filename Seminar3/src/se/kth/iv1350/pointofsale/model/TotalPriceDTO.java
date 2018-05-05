package se.kth.iv1350.pointofsale.model;

public class TotalPriceDTO {
	    private final AmountOfCash totalPrice;

	    /**
	     *
	     * @param totalPrice
	     */
	    public TotalPriceDTO(TotalPrice totalPrice) {
	        this.totalPrice = totalPrice.getFinalPrice();
	    }

	    /**
	     *
	     * @return
	     */
	    public AmountOfCash getTotalPrice() {
	        return totalPrice;
	    }
	    
	    public String toString(){
	        return totalPrice.toString();
	    }
	    
}


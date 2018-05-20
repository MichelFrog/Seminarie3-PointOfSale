package se.kth.iv1350.pointofsale.model;

public class TotalPriceDTO {
	private final AmountOfCash totalPrice;

	/*************************
	 *Constructor for TotalPrice
	 * @param totalPrice
	 ************************/
	public TotalPriceDTO(TotalPrice totalPrice) {
		this.totalPrice = totalPrice.getPrice();
	}


	/************************
	 *Getter for TotalPrice
	 * @return
	 ************************/
	public AmountOfCash getTotalPrice() {
		return totalPrice;
	}


	public String toString(){
		return totalPrice.toString();
	}

}


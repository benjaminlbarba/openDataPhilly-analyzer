package edu.upenn.cit594.data;

/**
 * This class represents a fine. The values include the amount of the fine and zipcode
 * @author @author benjamin.barba & lexie ulven
 *
 */
public class Fine {
	private Double amount;
	private String zipcode;
	
	public Fine(Double amount, String zipcode){
		this.amount = amount;
		this.zipcode = zipcode;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public Double getAmount() {
		return amount;
	}
	
}

package edu.upenn.cit594.data;

/**
 *  i.e. the money that was charged as penalty to the vehicle, as well as information about the location 
 *  at which it occurred, the violation’s ZIP Code, which is a numerical code.
 * @author @author benjamin.barba & lexie ulven
 *
 */
public class Fine {
	Double amount;
	String zipcode;
	
	public Fine(Double amount, String zipcode){
		this.amount = amount;
		this.zipcode = zipcode;
	}
}

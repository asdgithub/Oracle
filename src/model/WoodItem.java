/**
 * Class defining the elements of a wood type
 */
package model;

/**
 * @author Ashleigh Davis
 *
 */
public class WoodItem {

	String type;
	double baseDeliveryTime;
	double price;
	
	/**
	 * Default constructor 
	 */
	public WoodItem(){
		this.type = "Empty";
		this.baseDeliveryTime = 0.0;
		this.price = 0.0;
	}
	
	/**
	 * Constructor of a WoodItem element with parameters
	 * @param type Name of the wood type
	 * @param daseDeliveryTime base delivery time
	 * @param price price per Board Foot
	 */
	public WoodItem(String type, double baseDeliveryTime, double price) {
		this.type = type;
		this.baseDeliveryTime = baseDeliveryTime;
		this.price = price;
	}

	/**
	 * Get the type of Wood
	 * 
	 * @return Name of the WoodItem
	 */
	public String getType() {
		return type;
	}

	/**
	 * Get the base delivery time
	 * 
	 * @return the baseDeliverytime
	 */
	public double getBaseDeliveryTime() {
		return baseDeliveryTime;
	}

	/**
	 * 
	 * Get the price per Board Foot
	 * 
	 * @return the price for 1 Board Foot of this WoodItem
	 */
	public double getPrice() {
		return price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * You may implement this method to fit your needs
	 */
	@Override
	public String toString() {	
		return "";
	}
	
}

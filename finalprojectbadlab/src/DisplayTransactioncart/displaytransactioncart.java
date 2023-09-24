package DisplayTransactioncart;

public class displaytransactioncart {

	private Integer ID;
	private String FoodName;
	private String FoodType;
	private String FoodPrice;
	private String Quantity;
	private String TotalPrice;
	public displaytransactioncart(Integer iD, String foodName, String foodType, String foodPrice, String quantity,
			String totalPrice) {
		super();
		ID = iD;
		FoodName = foodName;
		FoodType = foodType;
		FoodPrice = foodPrice;
		Quantity = quantity;
		TotalPrice = totalPrice;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getFoodName() {
		return FoodName;
	}
	public void setFoodName(String foodName) {
		FoodName = foodName;
	}
	public String getFoodType() {
		return FoodType;
	}
	public void setFoodType(String foodType) {
		FoodType = foodType;
	}
	public String getFoodPrice() {
		return FoodPrice;
	}
	public void setFoodPrice(String foodPrice) {
		FoodPrice = foodPrice;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public String getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}
	
	
}

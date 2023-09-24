package finalprojectbadlab;


public class displaybuyfoodcart {

	private String name;
	private Integer id;
	private Integer price;
	private int quantity;
	private int totalprice;
	
	//constructor
	public displaybuyfoodcart(String name, int price, int quantity, int totalprice) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.totalprice = totalprice;
	}
	
	//getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	
	
	
}


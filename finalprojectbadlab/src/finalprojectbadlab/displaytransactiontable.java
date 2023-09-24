package finalprojectbadlab;

public class displaytransactiontable {

	//attribute
	private Integer id;
	private Integer user_id;
	private String  username;
	private String  role;
	private String  date;
	public displaytransactiontable(Integer id, Integer user_id, String username, String role, String date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.username = username;
		this.role = role;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUserid(Integer userid) {
		this.user_id = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
	
	
	
}

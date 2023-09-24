package User;

import connection.Connect;

public class User {
	//Attribute
	private int id;
	private String phonenumber;
	private String username;
	private String password;
	private String email;
	private String address;
	private String gender;
	private String role;
	private String nationality;
	private Connect connect = Connect.getInstance();
	//constructor
	public User(int id, String phonenumber, String username, String password, String email, String address, String gender,
			String role, String nationality) {
		super();
		this.id = id;
		this.phonenumber = phonenumber;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.role = role;
		this.nationality = nationality;
	}

	public void insertuser() {
		String query2 = String.format("insert into user VALUES (0,'%s','%s','%s','%s','%s','%s','user','%s')", this.username,this.password,this.email,this.phonenumber,this.address,this.gender,this.nationality);
		connect.execUpdate(query2);
	}
	
	//getter setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	
	

	
	


	
	
	
}

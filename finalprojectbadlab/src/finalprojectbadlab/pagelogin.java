package finalprojectbadlab;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import connection.Connect;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;
import User.User;


public class pagelogin {

	
	Scene scene;
	BorderPane borderContainer;
	GridPane gridContainer;
	
	Label emailLbl, passLbl, registerLbl,loginLbl;
	TextField emailTF;
	PasswordField passPF;
	TextField nameField;
	Button loginBtn;
	private Vector<User> users;
	private Connect connect = Connect.getInstance();

	
	public pagelogin() {
		initialize();
		set();
		build();
		button();
		
		Main.gotoPage(scene);
		
	}
	
	void initialize() {
		borderContainer =new BorderPane();
		gridContainer = new GridPane();
		scene = new Scene(borderContainer, 520, 520);
		
		loginLbl = new Label("LOGIN");
		loginLbl.setFont(Font.font("Courier", FontWeight.BOLD,12));
		
		emailLbl = new Label("Email");
		passLbl = new Label("Password");
		emailTF = new TextField();
		passPF = new PasswordField();
		
		loginBtn = new Button("Login");
		
		registerLbl = new Label("Don't have account? Register here");
		
	


}

	void set() {
		GridPane.setHalignment(loginLbl, HPos.CENTER);
		GridPane.setHalignment(loginBtn, HPos.CENTER);
		GridPane.setHalignment(registerLbl, HPos.CENTER);
		gridContainer.setAlignment(Pos.CENTER);
	    
		gridContainer.setVgap(20);
		gridContainer.setHgap(20);
		
		
		borderContainer.setStyle("-fx-background-color:orange;");
	    loginBtn.setStyle("-fx-background-color: red; -fx-text-fill: white;");
	    registerLbl.setStyle("-fx-text-fill:blue;");
	    
		registerLbl.setOnMouseEntered(new EventHandler<Event>() {
            
			
			
			
			@Override
			public void handle(Event arg0) {
				registerLbl.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 12));
				
				

				
			}
		
		
		
		});
		
		registerLbl.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				registerLbl.setFont(Font.font("Courier",12));
				
			}
		
		
		
		});
		
		registerLbl.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
                
				new Register();
				
			}
		});
	}
		
		
		
		
		
		
//		loginBtn.setOnAction(e -> {
//		if(e.getSource() == loginBtn) {
//				String email = emailTF.getText();
//				String password = passPF.getText();
//			
//				if(email.isEmpty()||(password.isEmpty())) {
//					Alert a = new Alert(AlertType.ERROR);
//					a.setContentText("Please insert email and password!");
//					a.show();
//				}
//			}
//		});
		
//		loginBtn.setOnAction(e ->{
//			if(e.getSource() == loginBtn) {
//				String email = emailTF.getText();
//				String password = passPF.getText();
//				
//				if(email.equals("user@gmail.com")&&(password.equals("password"))) {
//					new MainForm();
//				}else if 
//				  (email.equals("admin@gmail.com")&&(password.equals("password"))) {
//				    new MainFormAdmin();
//					}
//				}else {
//					Alert a = new Alert(AlertType.ERROR);
//					a.setContentText("Invalid email/password!");
//					a.show();
//					
//					
//				}
//				
//			
//			}
//		);
		
//		loginBtn.setOnAction(e ->{
//			if(e.getSource() == loginBtn) {
//				String email = emailTF.getText();
//				String password = passPF.getText();
//				
//				if(email.equals("admin@gmail.com")&&(password.equals("password"))) {
//					new MainFormAdmin();
//				}
//				
//			}
//		});
		
		
		
		
		
	
//		loginBtn.setOnAction(e -> {
//			if(e.getSource() == loginBtn) {
//				String email = emailTF.getSelectedText();
//				
//				
//				if(email != "user@gmail.com" || email != "admin@gmail.com") {
//					Alert a = new Alert(AlertType.ERROR);
//					a.setContentText("Invalid email/password!");
//				    a.show();
//				}
//			}
//			});
//			
//		loginBtn.setOnAction(e -> {
//			if(e.getSource() == loginBtn) {
//				String password = passPF.getSelectedText();
//				
//				
//				if(password != "password") {
//					Alert a = new Alert(AlertType.ERROR);
//					a.setContentText("Invalid email/password!");
//				    a.show();
//				}
//			}
//			});
			
//		loginBtn.setOnMouseClicked(new EventHandler<Event>() {
//			
//			@Override
//			public void handle(Event arg0) {
//				loginBtn.setOnAction(e ->{
//					if(e.getSource() == loginBtn) {
//						String email = emailTF.getText();
//						String password = passPF.getText();
//						
//						if(email.isEmpty()||(password.isEmpty())) {
//								Alert a = new Alert(AlertType.ERROR);
//								a.setContentText("Please insert email and password!");
//								a.show();
//						       
//						}
//						
//					
//					
//				
//				
//			}
//		});
//		
//			
//			}});
//	
//		}
	
	
	
	void build() {
		gridContainer.add(loginLbl, 0, 0,2,1);
		gridContainer.add(emailLbl, 0, 1);
		gridContainer.add(emailTF, 1, 1);
		gridContainer.add(passLbl, 0, 2);
		gridContainer.add(passPF, 1, 2);
		gridContainer.add(loginBtn, 0, 3,2,1);
		gridContainer.add(registerLbl, 0, 4,2,1);
		
		borderContainer.setCenter(gridContainer);
		
	}
	
//	void getData() {
//        users.removeAllElements();
//		
//		//Select from database 
//		//Buat query
//		String query = "SELECT * FROM user";
//		connect.rs = connect.execQuery(query);
//		
//		try {
//			while(connect.rs.next()) {
//				Integer id = connect.rs.getInt("id");
//				String username = connect.rs.getString("name");
//				String password = connect.rs.getString("password");
//				String email = connect.rs.getString("email");
//				Integer phonenumber = connect.rs.getInt("phone_number");
//			    String address = connect.rs.getString("address");
//			    String gender = connect.rs.getString("gender");
//			    String role = connect.rs.getString("role");
//			    String nationality = connect.rs.getString("nationality");
//			    
//			    users.add(new User(id, phonenumber, username, password,email, address,gender, role, nationality));
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		
//	}
	
	public void button() {
		loginBtn.setOnAction(e -> {
			//Ambil user input
			String email = emailTF.getText();
			String password = passPF.getText();
			Alert alert = new Alert(AlertType.ERROR);
			
			//Ambil dari dbs
			String query = String.format("SELECT * FROM user  WHERE email ='%s' AND password = '%s'", email, password);
			
			//Execute query
			ResultSet rs = connect.execQuery(query);
			//validate user input
			try {
				if(email.isBlank() || password.isBlank()) {
					alert.setHeaderText("Error");
					alert.setContentText("Email/password is empty!");
					alert.show();
				} else if(rs.next()) {
					System.out.println("Login berhasil!!!");	
					//Validate user role
					//Admin
						//Go to Admin Main Form
					if(rs.getString("role").equalsIgnoreCase("administrator")) {
						System.out.println("INI USER ROLE ADMINS");
						new MainFormAdmin();
					}else if(rs.getString("role").equalsIgnoreCase("user")) {
						System.out.println("Ini role user");
						new MainForm();
					}
					
					//User
						//Go to User Main Form
				}else {
					alert.setHeaderText("error");
					alert.setContentText("Invalid email/password!");
					alert.show();
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			
			
//			try {
//				while(connect.rs.next()) {
//					String emailDB = connect.rs.getString("email");
//					String passwordDB = connect.rs.getString("password");
//					
//				}
//			}catch (SQLException e1) {
//				
//				e1.printStackTrace();
//			}
		});
	}
		
	
	
	public void createWindow(String title, int width, int height, Node node) {
		Window window = new Window();
		window.getContentPane().getChildren().add(node);
		
		window.getRightIcons().add(new CloseIcon(window));
		window.setPrefSize(width, height);
		
		window.setLayoutX(scene.getWidth() / 2 - width / 2);
	    window.setLayoutX(scene.getHeight() / 2 - height / 2);
	    
	    window.setTitle(title);
	    
	    borderContainer.getChildren().add(window);
	
	
	}
	
	
	
	
}

package finalprojectbadlab;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Displaybuyfoodtable.displaybuyfoodtable;
import Displaymanagefood.displaymanagefoodtable;
import User.User;
import connection.Connect;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;
import Displaybuyfoodtable.displaybuyfoodtable;


public class foodmanage extends Application{
	private MenuBar menuBar;
    private Menu Menu, Account;
    private MenuItem BuyFood,ManageFood,TransactionHistory,Logout;
    private TextField IDTF,nameTF,priceTF;
    private ComboBox<String> foodtypeCB;
	private Scene scene;
	private BorderPane bp;
	private FlowPane flow;
	private TableView<displaymanagefoodtable> managefoodtable;
//	private TableView<displaybuyfoodcart> buyfoodcart;
	private Label IDLbl, nameLbl, typeLbl, priceLbl, stockLbl;
	private Vector<displaymanagefoodtable> managefoodlist;
//	private Vector<displaybuyfoodcart> foodcartlist;
	VBox box;
	VBox box2;
	private HBox btnBox;
	private Spinner<Integer>spinner;
	private GridPane grid;
	private Button insertBtn,updateBtn,deleteBtn;
	private Connect connect = Connect.getInstance();
     
	
	
	
//	int userID;
//	public void displaybuyfoodcart(int userID) {
//		this.userID = userID;
//	}
	
    public void window() {
    	box.getChildren().addAll(bp);
    }
	
	@Override
	public void start(Stage s) throws Exception {
		initComp();
		initPos();
		button();
		button2();
//		managefoodtable();
		managefoodtable.setOnMouseClicked(managefoodtable());
		s.setScene(scene);
		s.show();
		
	}
	public static void main(String[] args) {
		launch(args);
		
	}
	
	void initComp() {
		bp = new BorderPane();
		flow = new FlowPane();
		grid = new GridPane();
		box = new VBox();
		box2 = new VBox();
		btnBox = new HBox();
		scene = new Scene(bp, 1200,1200);
		
		
		
		IDTF = new TextField();
		IDTF.setDisable(true);
		
		
		
		
		nameTF = new TextField();
		priceTF = new TextField();
		nameTF.setPrefSize(400, 10);
		
		foodtypeCB = new ComboBox<>();
//		foodtypeCB.setPrefSize(400, 10);
	    foodtypeCB.getItems().addAll("Main Dish", "Appetizer", "Drink","Dessert", "Side dish");
		foodtypeCB.setPromptText("choose food type");
		foodtypeCB.setPrefSize(400, 10);
		
		IDLbl = new Label("ID");
		nameLbl = new Label("Name");
		typeLbl = new Label("Type");
		priceLbl = new Label("Price");
		stockLbl = new Label("Stock");
		
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, 50);
		spinner = new Spinner<>(valueFactory);
		valueFactory.setValue(10);
		spinner.valueProperty().addListener((observable, oldValue, newValue) -> {
		    System.out.println("Spinner value changed: " + oldValue + " -> " + newValue);
		});
		spinner.setPrefSize(400, 10);
		
		
		
		insertBtn = new Button("Insert");
		updateBtn = new Button("Update");
		deleteBtn = new Button("Delete");
	    managefoodtable = new TableView();
	
		
		managefoodlist = new Vector<>();

		
		menuBar = new MenuBar();
	    Menu = new Menu("Menu");
		Account = new Menu("Account");
		BuyFood = new MenuItem("BuyFood");
		ManageFood = new MenuItem("ManageFood");
		TransactionHistory = new MenuItem("TransactionHistory");
		Logout = new MenuItem("LogOut");
		 
		menuBar.getMenus().addAll(Menu, Account);
		Menu.getItems().addAll(BuyFood,ManageFood,TransactionHistory);
		Account.getItems().addAll(Logout);
		
		
		//managefoodtable
		TableColumn<displaymanagefoodtable, Integer> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		idCol.setMinWidth(100);
		
		TableColumn<displaymanagefoodtable, String> nameCol = new TableColumn<>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameCol.setMinWidth(100);
		
		TableColumn<displaymanagefoodtable, String> typeCol = new TableColumn<>("Type");
		typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
		typeCol.setMinWidth(100);
		
		TableColumn<displaymanagefoodtable, Integer> priceCol = new TableColumn<>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		priceCol.setMinWidth(100);
		
		TableColumn<displaymanagefoodtable, Integer> stockCol = new TableColumn<>("Stock");
		stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
		stockCol.setMinWidth(100);
		managefoodtable.getColumns().addAll(idCol, nameCol, typeCol, priceCol, stockCol);		
		
	
		
//		managefoodtable.setonm
		
		//displaybuyfoodcart
//		TableColumn<displaybuyfoodcart, Integer> foodIDCol = new TableColumn<>("FoodID");
//		foodIDCol.setCellValueFactory(new PropertyValueFactory<>("foodid"));
//		foodIDCol.setMinWidth(50);
//		
//		TableColumn<displaybuyfoodcart, String> foodnameCol = new TableColumn<>("FoodName");
//		foodnameCol.setCellValueFactory(new PropertyValueFactory<>("foodname"));
//		foodnameCol.setMinWidth(50);
//		
//		TableColumn<displaybuyfoodcart, Integer> foodpriceCol = new TableColumn<>("FoodPrice");
//		foodpriceCol.setCellValueFactory(new PropertyValueFactory<>("foodprice"));
//		foodpriceCol.setMinWidth(50);
//		
//		TableColumn<displaybuyfoodcart, Integer> quantityCol = new TableColumn<>("Quantity");
//		quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//		quantityCol.setMinWidth(50);
//		
//		TableColumn<displaybuyfoodcart, Integer> totalpriceCol = new TableColumn<>("TotalPrice");
//		totalpriceCol.setCellValueFactory(new PropertyValueFactory<>("totalprice"));
//		totalpriceCol.setMinWidth(50);
		
		
//		buyfoodtable.setMaxWidth(300);
//		buyfoodtable.setMaxHeight(300);
		
//		buyfoodcart.getColumns().addAll(foodIDCol, foodnameCol, foodpriceCol, quantityCol, totalpriceCol);		
//		buyfoodcart.setMaxWidth(200);
//		buyfoodcart.setMaxHeight(200);
		
//		getmarketplaceData();
		refreshmanageplaceTable();
//		refreshcartTable();
		
		grid.setAlignment(Pos.CENTER);
		
		grid.setPadding(new Insets(20));
		grid.setVgap(20);
		grid.setHgap(20);
		
		btnBox.setAlignment(Pos.CENTER);
		
		
		
	}
	
	void initPos() {
		grid.add(IDLbl, 0, 0);
		grid.add(IDTF, 1, 0);
		grid.add(nameLbl, 0, 1);
		grid.add(nameTF, 1, 1);
		grid.add(insertBtn, 2, 1);
	    grid.add(typeLbl, 0, 2);
	    grid.add(foodtypeCB, 1, 2);
	    grid.add(updateBtn, 2, 2);
		grid.add(priceLbl, 0, 3);
		grid.add(priceTF, 1, 3);
		grid.add(stockLbl, 0, 4);
		grid.add(spinner, 1, 4);
		grid.add(deleteBtn, 2, 4);
//		grid.add(quantityLbl, 3, 0);
//		grid.add(quantitySP, 3, 1);
//		grid.add(addtocartBtn, 3, 2);
//		grid.add(removefromcartBtn, 3, 3);
//		grid.add(checkoutBtn, 3, 4);
		
		box.getChildren().add(grid);
	
//		box.setMaxWidth(5);
//		btnBox.getChildren().add(addtocartBtn);
//		btnBox.setMargin(addtocartBtn, new Insets(10, 10, 10, 10));
		
		bp.setTop(menuBar);
		bp.setTop(managefoodtable);
//		bp.setRight(buyfoodcart);
		bp.setLeft(box);
		bp.setBottom(btnBox);
		bp.setStyle("-fx-background-color:lightblue;");
		box2.getChildren().add(bp);
		
	}
	
	private void getmanageplaceData() {
		
		//Select from database 
		//Buat query
		managefoodlist.clear();
		String query = "SELECT * FROM food";
		connect.rs = connect.execQuery(query);
		
		try {
			//get data
			while(connect.rs.next()) {
				Integer id = connect.rs.getInt("id");
		        String name = connect.rs.getString("name");
			    String type = connect.rs.getString("type");
			    Integer price = connect.rs.getInt("price");
			    Integer stock = connect.rs.getInt("stock");
			//add ke kelas
			    managefoodlist.add(new displaymanagefoodtable(id,name,type,price,stock));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void refreshmanageplaceTable() {
		getmanageplaceData();
		ObservableList<displaymanagefoodtable> manageObs = FXCollections.observableArrayList(managefoodlist);
		managefoodtable.setItems(manageObs);
		
	}

	
	public void button() {
		insertBtn.setOnAction(e -> {
	        String name = nameTF.getText();
	        String type = foodtypeCB.getValue();
	        Integer price = Integer.parseInt(priceTF.getText());
	        Integer stock = spinner.getValue();
	        
	        Alert alert = new Alert(AlertType.ERROR);
	        Alert alert2 = new Alert(AlertType.INFORMATION);
	        //Query
			String query = String.format("INSERT INTO `food`(`name`, `type`, `price`, `stock`) VALUES ('%s','%s','%d','%d')", name,type,price,stock);
	
			ResultSet rs = null;
			
			try {
//				rs = connect.execUpdate(query);
				connect.execUpdate(query);
				refreshmanageplaceTable();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			try {
				if(name.isBlank() || type.isEmpty() || price <= 0 || stock <= 0 ) {
					alert.setHeaderText("error");
					alert.setContentText("Please fill the blank fields");
					alert.show();
				}else if(name.length() < 5 || name.length() > 30) {
					alert.setHeaderText("error");
					alert.setContentText("food length must be between 5-20 characters");
				    alert.show();
				}else {
					alert2.setContentText("Success!");
					alert2.show();
				}
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			
		
		
		});
		
	     deleteBtn.setOnAction(e -> {
               
	    	 String name = nameTF.getText();
//	    	 System.out.println(name);
//	    	 String type = foodtypeCB.getValue();
//	    	 Integer price = Integer.parseInt(priceTF.getText());
//	    	 Integer stock = spinner.getValue();
	    	 
	    	 Alert alert = new Alert(AlertType.ERROR);
		     Alert alert2 = new Alert(AlertType.INFORMATION);
	    	 
//	    	    Query
//				String query = String.format("DELETE FROM `food`", name,type,price,stock);
				String query = String.format("DELETE FROM food WHERE name = '%s'", name);
//				ResultSet rs = null;
	    	 
				try {
//					rs = connect.execUpdate(query);
					connect.execUpdate(query);
//					System.out.println(query);
					refreshmanageplaceTable();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	    	 
				try {
					if(name.isBlank()) {
						alert.setHeaderText("error");
						alert.setContentText("Please fill food name");
						alert.show();
					}else {
						alert2.setContentText("Food deleted successfully");
						alert2.show();
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
	     });
	}
	     
	     
		public void button2() {

		    updateBtn.setOnAction(e ->{
		    Integer id = Integer.parseInt(IDTF.getText());
	        String name = nameTF.getText();
	        String type = foodtypeCB.getValue();
	        Integer price = Integer.parseInt(priceTF.getText());
	        Integer stock = spinner.getValue();
	        
	        Alert alert = new Alert(AlertType.ERROR);
	        Alert alert2 = new Alert(AlertType.INFORMATION);
	        //Query
			String query = String.format("UPDATE food SET `name`='%s',`type`='%s',`price`='%d',`stock`='%d' WHERE id = '%d'", name,type,price,stock,id);
	
			ResultSet rs = null;
			
			try {
//				rs = connect.execUpdate(query);
				connect.execUpdate(query);
				refreshmanageplaceTable();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			try {
				if(name.isBlank() || type.isEmpty() || price <= 0 || stock <= 0 ) {
					alert.setHeaderText("error");
					alert.setContentText("Please fill the blank fields and pick a food to update!");
					alert.show();
				}else if(name.length() < 5 || name.length() > 30) {
					alert.setHeaderText("error");
					alert.setContentText("food length must be between 5-30 characters");
				    alert.show();
				}else {
					alert2.setContentText("Food updated successfully!");
					alert2.show();
				}
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}	
			
//			managefoodtable.setOnMouseClicked(e -> {
//				int selectedindex = managefoodtable.getSelectionModel().getSelectedIndex();
//				// Do something with the selected index...
//			});
			
		});
		
		
		
	}
	     
//	     public void tableclicked() {
//	    		managefoodtable.setOnMouseClicked(e -> {
//					int selectedindex = managefoodtable.getSelectionModel().getSelectedIndex();
//					// Do something with the selected index...
//				});
//				
//	     }
//	     
	     
	    	 
			
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	
		
	    	 
	    	 
	    	 
	    	 
	    	 
	
	
	
	
	
//	private void getfoodcartData() {
//		
//		//Select from database 
//		//Buat query
//		String query = "SELECT * FROM transaction_detail";
//		connect.rs = connect.execQuery(query);
//		
//		try {
//			//get data
//			while(connect.rs.next()) {
//		        String name = connect.rs.getString("Name");
//		        int price = connect.rs.getInt("Price");
//		        int quantity = connect.rs.getInt("Quantity");
//			    int totalprice = connect.rs.getInt("Total Price");
//			//add ke arraylist
//			    foodcartlist.add(new displaybuyfoodcart(name,price,quantity,totalprice));
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		
//	}
//
//	private void refreshcartTable() {
//		getfoodcartData();
//		ObservableList<displaybuyfoodcart> foodObs2 = FXCollections.observableArrayList(foodcartlist);
//		buyfoodcart.setItems(foodObs2);
//		
//	}
	
	private EventHandler<MouseEvent> managefoodtable() {
	        return new EventHandler<MouseEvent>() {

	            @Override
	            public void handle(MouseEvent arg0) {
	            	//buat array
	            	TableSelectionModel<displaymanagefoodtable> tableSelectionModel = managefoodtable.getSelectionModel();
	            	tableSelectionModel.setSelectionMode(SelectionMode.SINGLE);
	            	displaymanagefoodtable managefoodlist = tableSelectionModel.getSelectedItem();
	            	//dari field
	            	IDTF.setText(managefoodlist.getId().toString());
	            }
	            
	        };
	}
	
	            	
		
	public void createWindow(String title, int width, int height, Node node) {
		Window window = new Window();
		window.getContentPane().getChildren().add(node);
		
		window.getRightIcons().add(new CloseIcon(window));
		window.setPrefSize(width, height);
		
		window.setLayoutX(scene.getWidth() / 2 - width / 2);
	    window.setLayoutX(scene.getHeight() / 2 - height / 2);
	    
	    window.setTitle(title);
	    
	    bp.getChildren().add(window);
	
	
	}
	
	public foodmanage() {
		
		initComp();
		initPos();
		button();
		button2();
		managefoodtable.setOnMouseClicked(managefoodtable());
	}
}


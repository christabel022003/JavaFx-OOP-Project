package finalprojectbadlab;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import DisplayTransactioncart.displaytransactioncart;

import Displaybuyfoodtable.displaybuyfoodtable;
import Displaymanagefood.displaymanagefoodtable;
import connection.Connect;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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


public class Transactions extends Application{
	private MenuBar menuBar;
    private Menu Menu, Account;
    private MenuItem BuyFood,ManageFood,TransactionHistory,Logout;

    private Label IDLbl;
	private Scene scene;
	private BorderPane bp;
	private FlowPane flow;
	private GridPane grid;
	
	private TableView<displaytransactiontable> transactiontable;
	private TableView<displaytransactioncart> transactioncart;
	
	private Vector<finalprojectbadlab.displaytransactiontable> transactionlist;
	private Vector<displaytransactioncart> transactioncartlist;
	
	VBox box;
	VBox box2;
	
	private HBox btnBox;
	
	
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
//		buyfoodtable.setOnMouseClicked(buyfoodtable());
		
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
		scene = new Scene(bp, 800,800);
		
//		IDLbl = new Label("ID");
//		nameLbl = new Label("Name");
//		typeLbl = new Label("Type");
//		priceLbl = new Label("Price");
//		stockLbl = new Label("Stock");
//		quantityLbl = new Label("Quantity");
		
//		quantitySP = new Spinner<>();
//		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, 50);
//		spinner = new Spinner<>(valueFactory);
//		valueFactory.setValue(10);
//		spinner.valueProperty().addListener((observable, oldValue, newValue) -> {
//		    System.out.println("Spinner value changed: " + oldValue + " -> " + newValue);
//		});
//		addtocartBtn = new Button("Add to Cart");
//		removefromcartBtn = new Button("Remove From Cart");
//		checkoutBtn = new Button("Checkout");
		
		transactiontable = new TableView();
		transactioncart = new TableView();
		
		transactionlist = new Vector<>();
		transactioncartlist = new Vector<>();
		
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
		
		
		//displaytransactiontable
		TableColumn<displaytransactiontable, Integer> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		idCol.setMinWidth(100);
		
		TableColumn<displaytransactiontable, Integer> useridCol = new TableColumn<>("UserID");
		useridCol.setCellValueFactory(new PropertyValueFactory<>("user_id"));
		useridCol.setMinWidth(100);
		
		TableColumn<displaytransactiontable, String> usernameCol = new TableColumn<>("UserName");
		usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
		usernameCol.setMinWidth(100);
		
		TableColumn<displaytransactiontable, String> roleCol = new TableColumn<>("Role");
		roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
		roleCol.setMinWidth(100);
		
		TableColumn<displaytransactiontable, String> dateCol = new TableColumn<>("Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		dateCol.setMinWidth(100);
		
		
		
		//displaytransactionscart
		TableColumn<displaytransactioncart, Integer> IDCol = new TableColumn<>("ID");
		IDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		IDCol.setMinWidth(50);
		
		TableColumn<displaytransactioncart, String> foodnameCol = new TableColumn<>("FoodName");
		foodnameCol.setCellValueFactory(new PropertyValueFactory<>("foodname"));
		foodnameCol.setMinWidth(50);
		
		TableColumn<displaytransactioncart, Integer> foodpriceCol = new TableColumn<>("FoodPrice");
		foodpriceCol.setCellValueFactory(new PropertyValueFactory<>("foodprice"));
		foodpriceCol.setMinWidth(50);
		
		TableColumn<displaytransactioncart, Integer> quantityCol = new TableColumn<>("Quantity");
		quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		quantityCol.setMinWidth(50);
		
		TableColumn<displaytransactioncart, Integer> totalpriceCol = new TableColumn<>("TotalPrice");
		totalpriceCol.setCellValueFactory(new PropertyValueFactory<>("totalprice"));
		totalpriceCol.setMinWidth(50);
		
		
		transactiontable.getColumns().addAll(idCol,useridCol,usernameCol, roleCol, dateCol);		
//		buyfoodtable.setMaxWidth(300);
//		buyfoodtable.setMaxHeight(300);
		
		transactioncart.getColumns().addAll(IDCol, foodnameCol, foodpriceCol, quantityCol, totalpriceCol);		
//		buyfoodcart.setMaxWidth(200);
//		buyfoodcart.setMaxHeight(200);
		
//		getmarketplaceData();
		refreshtransactionTable();
//		getDate();
//		refreshcartTable();
		
//		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(20));
		grid.setVgap(20);
		grid.setHgap(20);
		

		btnBox.setAlignment(Pos.CENTER);
		
		
		
	}
	
	void initPos() {
//		grid.add(IDLbl, 0, 0);
//		grid.add(nameLbl, 0, 1);
//	    grid.add(typeLbl, 0, 2);
//		grid.add(priceLbl, 0, 3);
//		grid.add(stockLbl, 0, 4);
//		grid.add(quantityLbl, 3, 0);
//		grid.add(spinner, 3, 1);
//		grid.add(addtocartBtn, 3, 2);
//		grid.add(removefromcartBtn, 3, 3);
//		grid.add(checkoutBtn, 3, 4);
		
		
//		btnBox.getChildren().add(addtocartBtn);
//		btnBox.setMargin(addtocartBtn, new Insets(10, 10, 10, 10));
		
		bp.setTop(menuBar);
		bp.setCenter(transactiontable);
		bp.setBottom(transactioncart);
		bp.setLeft(box);
//		bp.setBottom(btnBox);
		box.getChildren().addAll(transactiontable,transactioncart);
        
//		box.getChildren().add(bp);
//		box2.getChildren().add(bp);
		
	}
	
	private void gettransactionData() {
		
		//Select from database 
		//Buat query
		transactionlist.clear();
		String query = "SELECT * FROM user JOIN transaction_header ON user.id = transaction_header.transaction_id";
		connect.rs = connect.execQuery(query);
		
		try {
			//get data
			while(connect.rs.next()) {
				Integer id = connect.rs.getInt("id");
				Integer user_id = connect.rs.getInt("user_id");
				String  username = connect.rs.getString("username");
				String  role = connect.rs.getString("role");
				String  date = connect.rs.getString("date");
				
			//add ke kelasS
			    transactionlist.add(new displaytransactiontable(id, user_id,username, role, date));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void refreshtransactionTable() {
		gettransactionData();
		ObservableList<displaytransactiontable> transactionObs = FXCollections.observableArrayList(transactionlist);
		transactiontable.setItems(transactionObs);
		
	}

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
	
//	private EventHandler<MouseEvent> buyfoodtable() {
//        return new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent arg0) {
//            	//buat array
//            	TableSelectionModel<displaybuyfoodtable> tableSelectionModel = buyfoodtable.getSelectionModel();
//            	tableSelectionModel.setSelectionMode(SelectionMode.SINGLE);
//            	displaybuyfoodtable buyfoodlist = tableSelectionModel.getSelectedItem();
//            	//dari field
//            	nameLbl.setText(buyfoodlist.getName());
//            }
//            
//        };
//}

	
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
	public Transactions() {
		
		initComp();
		initPos();
//		buyfoodtable.setOnMouseClicked(buyfoodtable());
	}

//	public buyfood() {
//		
//		initComp();
//		initPos();
//		buyfoodtable.setOnMouseClicked(buyfoodtable());
	
//	public String getDate() {
//		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//		 LocalDateTime date = LocalDateTime.now(); 
//		 return dtf.format(date);
//	}
	
	}

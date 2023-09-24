package finalprojectbadlab;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.Window;


public class MainFormAdmin implements EventHandler<ActionEvent>{
	Scene scene;
	BorderPane borderContainer;
	GridPane gridContainer;
	
	Label blaLbl;
	MenuBar menuBar;
    Menu Menu, Account;
    MenuItem BuyFood,ManageFood,TransactionHistory,Logout;

    ImageView imageView;
    Image image;

    Window window,window2;
    
    public MainFormAdmin() {
	initialize();
	set();
	build();
	
	Main.gotoPage(scene);
	
    }
    
    
    void initialize() {
	 borderContainer = new BorderPane();
	 gridContainer = new GridPane();
	 scene = new Scene(borderContainer,520,520);
	  
    
	 try {
		 image = new Image(new FileInputStream(Paths.get("").toAbsolutePath().toString()+"/src/finalprojectbadlab/mcdonalds.png"));
		 imageView = new ImageView(image);
	 } catch (FileNotFoundException e) {
		 e.printStackTrace();
	 }
	
	 imageView.setFitHeight(520);
	 imageView.setFitWidth(520);
	 
    
	 menuBar = new MenuBar();
	 Menu = new Menu("Menu");
	 Account = new Menu("Account");
	 BuyFood = new MenuItem("BuyFood");
	 ManageFood = new MenuItem("ManageFood");
	 TransactionHistory = new MenuItem("TransactionHistory");
	 Logout = new MenuItem("LogOut");
	 
	 menuBar.getMenus().addAll(Menu, Account);
	 Menu.getItems().addAll(ManageFood,TransactionHistory);
	 Account.getItems().addAll(Logout);
	 BuyFood.setOnAction(this);
    }
    
    
    void set() {
	gridContainer.setAlignment(Pos.CENTER);
	  
	gridContainer.setVgap(20);
	gridContainer.setHgap(20);
	
	BuyFood.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent arg0) {
			window = new Window("buyfood");
			window.getContentPane().getChildren().add(new buyfood().box2);
		    borderContainer.setCenter(window);
		}
	});
	
	ManageFood.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent arg0) {
			window2 = new Window("foodmanage");
			window2.getContentPane().getChildren().add(new foodmanage().box2);
		    borderContainer.setCenter(window2);
		}
	});
	
	Logout.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent arg0) {
			new pagelogin();
			
		}
	});
	
	
	
   
    }
 
    void build() {
	    
    	
    	 
        gridContainer.add(imageView, 0, 0);
    	borderContainer.setTop(menuBar);
    	borderContainer.setCenter(gridContainer);
    	
    
    	
    	
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


	@Override
	public void handle(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
	}


}






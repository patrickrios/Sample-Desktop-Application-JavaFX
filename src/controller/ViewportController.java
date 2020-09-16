package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewportController implements Initializable{
	@FXML
	private AnchorPane MainContainer;
	@FXML
    private AnchorPane anchorMenu;
	@FXML
	private AnchorPane mainContentConteiner;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addMainMenu();
	}
	
	@FXML
    void minimizeStage() {
    	Stage stage = (Stage)MainContainer.getScene().getWindow();
    	stage.setIconified(true);
    }
    
    @FXML
    void closeApplication() {
    	System.exit(0);
    }
    
    @FXML
    void maximizeStage() {
    	Stage stage = (Stage)MainContainer.getScene().getWindow();
    	stage.setX(0.0);
    	stage.setY(0.0);
    }
    
    private void addMainMenu() {
    	FXMLLoader load = new FXMLLoader(getClass().getResource("/view/fxml/MainMenu.fxml"));
		try {
			Parent p = load.load();
			MainMenuController c = load.getController();
			c.initi(this.mainContentConteiner);
			this.anchorMenu.getChildren().setAll(p);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

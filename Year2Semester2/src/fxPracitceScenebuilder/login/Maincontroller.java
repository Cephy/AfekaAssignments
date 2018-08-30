package fxPracitceScenebuilder.login;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Maincontroller {
	
	
	@FXML
	private Label lblStatus;
	
	@FXML
	private TextField txtPassWord;
	
	@FXML
	private TextField txtUserName;
	
	public void Login(ActionEvent event) throws IOException{
		
		if(txtUserName.getText().equals("User") && txtPassWord.getText().equals("password")){
			lblStatus.setText("Login Success");
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/fxPracitceScenebuilder/login/Login.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else {
			lblStatus.setText("Login Faild");
		}
		
	}
	
}

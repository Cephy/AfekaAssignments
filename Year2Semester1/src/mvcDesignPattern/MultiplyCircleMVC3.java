/*Sefi Azoulay 303139141*/

package mvcDesignPattern;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MultiplyCircleMVC3 extends Application{
	
	private Button controllerNViewBut = new Button ("Show Controller and View");
	private int circleCounter = 0;
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane bP = new BorderPane();
		bP.setCenter(controllerNViewBut);
		Scene mainScene = new Scene(bP, 300,100);
		primaryStage.setScene(mainScene);
		primaryStage.setOnCloseRequest(e-> javafx.application.Platform.exit());
		primaryStage.setTitle("MultiplyCircleMVC2");
		primaryStage.centerOnScreen();
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.show();

	}
	
	public MultiplyCircleMVC3(){
		
		controllerNViewBut.setOnAction(e -> {
			CircleController3 tempCC2 = new CircleController3(circleCounter);
			CircleModel3 tempCM2 = new CircleModel3(circleCounter);
			CircleView3 tempCV2 = new CircleView3();
			tempCC2.setModel(tempCM2);
			
			Stage controlerStage = new Stage();
			Scene controlerScene = new Scene(tempCC2,300,200);
			controlerStage.setScene(controlerScene);
			controlerStage.setResizable(false);
			controlerStage.setAlwaysOnTop(true);
			controlerStage.setOnCloseRequest(et->{
				et.consume();
			});
			controlerStage.setX(150);
			controlerStage.setY(150);
			controlerStage.setTitle("Controller number" + (circleCounter+1));
			controlerStage.show();
			
			Stage viewStage = new Stage();
			Scene viewScene = new Scene(tempCV2,500,150);
			tempCV2.setModel(tempCM2);
			viewStage.setScene(viewScene);
			viewStage.setOnCloseRequest(et->{
				et.consume();
			});
			viewStage.setX(400);
			viewStage.setY(400);
			viewStage.setResizable(false);
			viewStage.setAlwaysOnTop(true);
			viewStage.setTitle("View number" + (circleCounter+1));
			viewStage.show();
			
			circleCounter++;
			
		});
	}
	

}

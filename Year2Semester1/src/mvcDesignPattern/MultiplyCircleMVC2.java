/*Sefi Azoulay 303139141*/

package mvcDesignPattern;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MultiplyCircleMVC2 extends Application{

	private Button controllerNViewBut = new Button ("Show Controller and View");
	private ObservableList<CircleController2> circleControllerList;
	private int circleCounter = 0;
	private ObservableList<CircleView2> circleViewList;
	private ObservableList<CircleModel2> circleModelList;
	
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
	
	public MultiplyCircleMVC2(){
		circleControllerList = FXCollections.observableArrayList();
		circleModelList = FXCollections.observableArrayList();
		circleViewList = FXCollections.observableArrayList();
		
		
		controllerNViewBut.setOnAction(e -> {
			CircleController2 tempCC2 = new CircleController2(circleCounter);
			CircleModel2 tempCM2 = new CircleModel2(circleCounter);
			CircleView2 tempCV2 = new CircleView2();
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
			viewStage.setResizable(false);
			viewStage.setAlwaysOnTop(true);
			viewStage.setOnCloseRequest(et->{
				et.consume();
			});
			viewStage.setX(400);
			viewStage.setY(400);
			viewStage.setTitle("View number" + (circleCounter+1));
			viewStage.show();
			
			circleControllerList.add(circleCounter, tempCC2);
			circleModelList.add(circleCounter, tempCM2);
			circleViewList.add(circleCounter, tempCV2);
			circleCounter++;
			
		});
	}
	

}

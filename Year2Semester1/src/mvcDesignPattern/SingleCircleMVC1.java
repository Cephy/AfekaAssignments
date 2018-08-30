/*Sefi Azoulay 303139141*/

package mvcDesignPattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class SingleCircleMVC1 extends Application {

	private Button controlerButton = new Button("Show Controler");
	private Button viewButton = new Button("Show View");
	private CircleModel1 model = new CircleModel1();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FlowPane fP = new FlowPane(5, 2);
		fP.setPadding(new Insets(5, 5, 0, 80));

		fP.getChildren().add(controlerButton);
		fP.getChildren().add(viewButton);
		Scene mainScene = new Scene(fP, 370, 60);
		primaryStage.setOnCloseRequest(e-> javafx.application.Platform.exit());
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("SingleCircleMvc1");
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.show();

	}

	public SingleCircleMVC1() {

		controlerButton.setOnAction(e-> {
				
			Stage controlerStage = new Stage();
			CircleController1 circleControllerPane = new CircleController1();
			circleControllerPane.setModel(model);
			Scene controlerScene = new Scene(circleControllerPane,300,150);
			controlerStage.setOnCloseRequest(et->{
				et.consume();
			});
			controlerStage.setX(200);
			controlerStage.setY(200);
			controlerStage.setScene(controlerScene);
			controlerStage.setResizable(false);
			controlerStage.setAlwaysOnTop(true);
			controlerStage.setTitle("Controller");
			controlerStage.show();
		});
		
		viewButton.setOnAction(e-> {

			Stage viewStage = new Stage();
			CircleView1 circleViewPane = new CircleView1();
			Scene viewScene = new Scene(circleViewPane,500,200);			    
			circleViewPane.setModel(model);
			viewStage.setOnCloseRequest(et->{
				et.consume();
			});
			viewStage.setX(300);
			viewStage.setY(300);
			viewStage.setScene(viewScene);
			viewStage.setResizable(false);
			viewStage.setAlwaysOnTop(true);
			viewStage.setTitle("View");
			viewStage.show();	
			
		});		
	}
	

}

package mvcDesignPattern;

import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CircleView2 extends Pane implements CircleEvents{
	
	private Circle circle = new Circle();
	private CircleModel2 model;
	private int circleNumber;
	private String eventTitle = "DEFAULT";
	private Text eventTitleText = new Text("DEFAULT");
	private Text circleCounterText = new Text("" + circleNumber);
	private Text circleRaduisText = new Text();
	private Text circleAreaText = new Text();
	
	class RadiusEvent implements EventHandler<Circle1ActionEvent>{
		public void handle(Circle1ActionEvent e) {
			eventTitle = eventType.RADIUS.toString();
			Paint();
		}
	}

	class ColorEvent implements EventHandler<Circle1ActionEvent> {
		public void handle(Circle1ActionEvent e) {
			eventTitle = eventType.COLOR.toString();
			Paint();
		}
	}

	class FilledEvent implements EventHandler<Circle1ActionEvent> {
		public void handle(Circle1ActionEvent e) {
			eventTitle = eventType.FILLED.toString();
			Paint();
		}
	}

	class AreaEvent implements EventHandler<Circle1ActionEvent> {
		public void handle(Circle1ActionEvent e) {
			eventTitle = eventType.AREA.toString();
			Paint();
		}
	}
	
	public int getcircleCounter() {
		return circleNumber;
	}
	
	public void Paint(){
		if (model == null)
			return;
		getChildren().clear();
		VBox textFieldsBox = new VBox(15);
		eventTitleText.setText("Event Type: " + eventTitle);
		circleCounterText.setText("Circle number " + circleNumber);
		circleRaduisText.setText("Circle raduis " + (int)model.getRadius());
		
		textFieldsBox.getChildren().add(eventTitleText);
		textFieldsBox.getChildren().add(circleCounterText);
		textFieldsBox.getChildren().add(circleRaduisText);
		if(model.calculateArea()){
			circleAreaText.setText("Circle Area " + (int)model.getRadius()*(int)model.getRadius()*Math.PI);
			textFieldsBox.getChildren().add(circleAreaText);
		}
		getChildren().add(textFieldsBox);
		circle.setCenterX(getWidth()/2);
		circle.setCenterY(getHeight()/2);
		circle.setRadius(model.getRadius());
		circle.setStroke(model.getColor());
		if (model.isFilled()) {
			circle.setFill(model.getColor());
			getChildren().add(circle);
		} else {
			circle.setFill(null);
			getChildren().add(circle);
		}
		
	}
	
	public void setModel(CircleModel2 newModel) {
		model = newModel;
		if (model != null) {
			model.addActionListener(new RadiusEvent(), eventType.RADIUS);
			model.addActionListener(new FilledEvent(), eventType.FILLED);
			model.addActionListener(new ColorEvent(), eventType.COLOR);
			model.addActionListener(new AreaEvent(), eventType.AREA);
		}
		Paint();
	}
	
	public CircleModel2 getModel() {
		return model;
	}
	
	
}

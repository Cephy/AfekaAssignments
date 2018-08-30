package mvcDesignPattern;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class CircleView1 extends Pane implements EventHandler<ActionEvent> {

	private Circle circle = new Circle();
	private CircleModel1 model;

	public CircleView1() {
		
	}

	@Override
	public void handle(ActionEvent event) {
		paint();
	}

	public void setModel(CircleModel1 newModel) {
		model = newModel;
		if (model != null) {
			// Register the view as listener for the model
			model.addActionListener(this);
		}
		paint();
	}

	public void paint() {
		if (model == null){
			return;
		}
		getChildren().clear();
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

}

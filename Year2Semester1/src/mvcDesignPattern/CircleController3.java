package mvcDesignPattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CircleController3 extends HBox implements CircleEvents, EventHandler<ActionEvent>{
	private CircleModel3 model;				// change to model  2
	private int circleCounter;
	private TextField jtfRadius = new TextField();
	private ObservableList<Boolean> items = FXCollections.observableArrayList(true,false);
	private ComboBox<Boolean> jcboFilled = new ComboBox<Boolean>(items);
	private ComboBox<Boolean> jcboCalculateArea = new ComboBox<Boolean>(items);
	private VBox labelsBox = new VBox(25);
	private VBox buttonsBox = new VBox(10);
	private ColorPicker colorpicker = new ColorPicker();

	public CircleController3(int circleCounter) {
		
		this.circleCounter = circleCounter;
		
		labelsBox.getChildren().add(new Label(eventType.RADIUS.toString()));
		labelsBox.getChildren().add(new Label(eventType.FILLED.toString()));
		labelsBox.getChildren().add(new Label(eventType.COLOR.toString()));
		labelsBox.getChildren().add(new Label(eventType.AREA.toString()));
		buttonsBox.getChildren().add(jtfRadius);
		buttonsBox.getChildren().add(jcboFilled);
		buttonsBox.getChildren().add(colorpicker);
		buttonsBox.getChildren().add(jcboCalculateArea);
		
		getChildren().add(labelsBox);
		getChildren().add(buttonsBox);
		jtfRadius.setOnAction(this);
		jcboFilled.setOnAction(this);
		colorpicker.setOnAction(this);
		jcboCalculateArea.setOnAction(this);
		
	}

	@Override
	public void handle(ActionEvent e) {
		if (model == null)
			return;
		if (e.getSource() == jtfRadius) {
			model.setRadius(new Double(jtfRadius.getText()).doubleValue());
		}
		else if(e.getSource() == jcboFilled){			
			model.setFilled(jcboFilled.getValue());		
		}
		else if(e.getSource() == colorpicker){
			model.setColor(colorpicker.getValue());
		}
		else if(e.getSource() == jcboCalculateArea){
			model.setCalculateArea(jcboCalculateArea.getValue());
		}
	}

	public void setModel(CircleModel3 newModel) {
		model = newModel;
	}

	public CircleModel3 getModel() {
		return model;
	}
	
	public int getcircleCounter() {
		return circleCounter;
	}
	
}

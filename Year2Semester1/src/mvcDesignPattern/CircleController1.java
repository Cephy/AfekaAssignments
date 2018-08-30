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

public class CircleController1 extends HBox implements EventHandler<ActionEvent> {
	private CircleModel1 model;
	private TextField jtfRadius = new TextField();
	private ObservableList<Boolean> items = FXCollections.observableArrayList(true,false);
	private ComboBox<Boolean> jcboFilled = new ComboBox<Boolean>(items);
	private VBox labelsBox = new VBox(25);
	private VBox buttonsBox = new VBox(10);
	private ColorPicker colorpicker = new ColorPicker();

	public CircleController1() {

		labelsBox.getChildren().add(new Label("Radiues"));
		labelsBox.getChildren().add(new Label("Filled"));
		labelsBox.getChildren().add(new Label("Color"));
		buttonsBox.getChildren().add(jtfRadius);
		buttonsBox.getChildren().add(jcboFilled);
		buttonsBox.getChildren().add(colorpicker);
		
		getChildren().add(labelsBox);
		getChildren().add(buttonsBox);

		jtfRadius.setOnAction(this);
		jcboFilled.setOnAction(this);
		colorpicker.setOnAction(this);
		;
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
		if(e.getSource() == colorpicker){
			model.setColor(colorpicker.getValue());
		}
	}

	public void setModel(CircleModel1 newModel) {
		model = newModel;
	}

	public CircleModel1 getModel() {
		return model;
	}
	
	/*Missing 
	 * Event type: 
	 * 
	 * 
	 * */
	
}

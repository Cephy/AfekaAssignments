package mvcDesignPattern;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class CircleModel1 {
	private double radius = 20;
	private Color color = Color.BLACK;
	private boolean filled;

	private ArrayList<EventHandler<ActionEvent>> eventHandlerArray;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
		// Notify the listener for the change on radius
		processEvent(new Circle1ActionEvent("radius"));
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
		// Notify the listener for the change on filled
		processEvent(new Circle1ActionEvent("filled"));
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		// Notify the listener for the change on color
		processEvent(new Circle1ActionEvent("color"));
	}

	/** Register an action event listener */
	public synchronized void addActionListener(EventHandler<ActionEvent> e) {
		if (eventHandlerArray == null)
			eventHandlerArray = new ArrayList<EventHandler<ActionEvent>>();
		eventHandlerArray.add(e);
	}

	/** Remove an action event listener */
	public synchronized void removeActionListener(EventHandler<ActionEvent> e) {
		if (eventHandlerArray != null && eventHandlerArray.contains(e))
			eventHandlerArray.remove(e);
	}

	/** Fire Event */
	private void processEvent(Circle1ActionEvent e) {
		ArrayList<EventHandler<ActionEvent>> list;
		System.out.println("size of actionListenerList is: " + eventHandlerArray.size());
		synchronized (this) {
			if (eventHandlerArray == null)
				return;
			list = (ArrayList<EventHandler<ActionEvent>>) eventHandlerArray.clone();
		}
		for (int i = 0; i < list.size(); i++) {
			EventHandler<ActionEvent> actionEvent = (EventHandler<ActionEvent>) list.get(i);
			System.out.println("event is: " + e.getActionNanem()); //Event type missing
			actionEvent.handle(e);
		}
	}
}

package mvcDesignPattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class CircleModel2 implements CircleEvents {
	private int circleCounter;
	private double radius = 20;
	private boolean filled;
	private boolean calculateArea;
	private Color color = Color.BLACK;
	private ObservableMap<eventType, ObservableList<EventHandler<Circle1ActionEvent>>> circleHashMap = FXCollections
			.observableHashMap();

	public CircleModel2(int circleCounter) {
		this.circleCounter = circleCounter;
		for (eventType et : eventType.values()) {
			circleHashMap.put(et, FXCollections.observableArrayList());
		}
	}

	public int getcircleCounter() {
		return circleCounter;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
		processEvent(eventType.RADIUS, new Circle1ActionEvent(eventType.RADIUS.toString()));
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
		processEvent(eventType.FILLED, new Circle1ActionEvent(eventType.FILLED.toString()));
	}

	public boolean calculateArea() {
		return calculateArea;
	}

	public void setCalculateArea(boolean calculateArea) {
		this.calculateArea = calculateArea;
		processEvent(eventType.AREA, new Circle1ActionEvent(eventType.AREA.toString()));
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		processEvent(eventType.COLOR, new Circle1ActionEvent(eventType.COLOR.toString()));
	}

	public synchronized void addActionListener(EventHandler<Circle1ActionEvent> l, eventType et) {
		ObservableList<EventHandler<Circle1ActionEvent>> al;
		al = circleHashMap.get(et);
		if (al == null)
			al = FXCollections.observableArrayList();
		al.add(l);
		circleHashMap.put(et, al);
	}

	public synchronized void removeActionListener(EventHandler<Circle1ActionEvent> l, eventType et) {
		ObservableList<EventHandler<Circle1ActionEvent>> al;
		al = circleHashMap.get(et);
		if (al != null && al.contains(l))
			al.remove(l);
		circleHashMap.put(et, al);
	}

	private void processEvent(eventType et, Circle1ActionEvent e) {
		ObservableList<EventHandler<Circle1ActionEvent>> al;	
		synchronized (this) {
			al = circleHashMap.get(et);
			if (al == null)
				return;
		}
		System.out.println("model number: " + (getcircleCounter() + 1) + " actionCommand: " + e.getActionNanem()
				+ " array size is: " + al.size());
		for (int i = 0; i < al.size(); i++) {
			EventHandler<Circle1ActionEvent> listener = (EventHandler<Circle1ActionEvent>) al.get(i);
			listener.handle(e);
		}
	}

}

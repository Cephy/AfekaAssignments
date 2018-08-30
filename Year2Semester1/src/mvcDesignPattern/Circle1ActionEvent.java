package mvcDesignPattern;

import javafx.event.ActionEvent;

public class Circle1ActionEvent extends ActionEvent{
	
	private static final long serialVersionUID = 1L;
	private String actionName;
	
	public Circle1ActionEvent(String actionName){
		this.actionName = actionName;	
	}
	
	public void setActionName(String actionName){
		this.actionName = actionName;
	}
	
	public String getActionNanem(){
		return actionName;
	}	
}

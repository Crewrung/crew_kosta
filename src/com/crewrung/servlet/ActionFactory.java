package com.crewrung.servlet;

public class ActionFactory {
	private ActionFactory(){}
	
	public static Action getAction(String cmd){
		Action action;
		switch (cmd) {
		case "A":
			action = null;
			break;
		case "B":
			action = null;
			break;
		default:
			action = null;
			break;
		}
		
		return action;
		
	}

}

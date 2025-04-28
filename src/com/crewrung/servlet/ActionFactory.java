package com.crewrung.servlet;

public class ActionFactory {
	private ActionFactory(){}
	
	public static Action getAction(String cmd){
		Action action;
		switch (cmd) {
		case "getCrewInfoAction":
			action = new GetCrewInfoAction();
			break;
		default:
			action = null;
			break;
		}
		return action;
	}
}

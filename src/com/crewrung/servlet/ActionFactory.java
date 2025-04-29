package com.crewrung.servlet;

import com.crewrung.board.action.boardCommentUIAction;
import com.crewrung.board.action.boardsUIAction;
import com.crewrung.board.action.deleteBoardAction;
import com.crewrung.board.action.detailBoardUIAction;
import com.crewrung.board.action.pagingAction;
import com.crewrung.board.action.postingUIAction;
import com.crewrung.board.action.updateBoardAction;
import com.crewrung.board.action.updateBoardUIAction;
import com.crewrung.board.action.uploadboardAction;


public class ActionFactory {
	private ActionFactory() {
	}

	public static Action getAction(String cmd) {
		Action action;

		switch (cmd) {
		// Board related actions
		case "detailBoardUI":
			action = new detailBoardUIAction();
			break;
		case "deleteBoard":
			action = new deleteBoardAction();
			break;
		case "updateBoardUI":
			action = new updateBoardUIAction();
			break;
		case "updateBoard":
		    action = new updateBoardAction();
		    break;
		case "boardCommentUI":
		    action = new boardCommentUIAction();
		    break;
		case "boardsUI":
			action = new boardsUIAction();
			break;
		case "postingUI":
			action = new postingUIAction();
			break;
		case "paging":
			action = new pagingAction();
			break;
		case "uploadboard":
			action = new uploadboardAction();
			break;

		// Default action
		default:
			action = new MainActionUI();
			break;
		}

		return action;
	}
}
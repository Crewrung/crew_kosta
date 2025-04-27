package com.crewrung.servlet;

import com.crewrung.flashMob.action.FlashMobUIAction;
import com.crewrung.flashMob.action.addFlashMobCommentAction;
import com.crewrung.flashMob.action.addFlashMobUIAction;
import com.crewrung.flashMob.action.applyFlashMobAction;
import com.crewrung.flashMob.action.flashMobDetailUIAction;
import com.crewrung.flashMob.action.flashMobFilterUIAction;
import com.crewrung.flashMob.action.isFlashMobHostAction;
import com.crewrung.flashMob.action.isFlashMobParticipantAction;
import com.crewrung.flashMob.action.updateFlashMobAction;
import com.crewrung.flashMob.action.updateFlashMobUIAction;

public class ActionFactory {
	private ActionFactory() {
	}

	public static Action getAction(String cmd) {
		Action action;

		switch (cmd) {

		// Flash mob related actions
		case "flashMobUI":
			action = new FlashMobUIAction();
			break;
		case "flashMobDetailUI":
			action = new flashMobDetailUIAction();
			break;
		case "flashMobFilterUI":
			action = new flashMobFilterUIAction();
			break;
		case "updateFlashMobUI":
			action = new updateFlashMobUIAction();
			break;
		case "updateFlashMob":
			action = new updateFlashMobAction();
			break;
		case "addFlashMobUI":
			action = new addFlashMobUIAction();
			break;
		case "applyFlashMob":
			action = new applyFlashMobAction();
			break;
		case "addFlashMobComment":
			action = new addFlashMobCommentAction();
			break;
		case "isFlashMobHost":
			action = new isFlashMobHostAction();
			break;
		case "isFlashMobParticipant":
			action = new isFlashMobParticipantAction();
			break;

		// Default action
		default:
			action = new MainActionUI();
			break;
		}

		return action;
	}
}
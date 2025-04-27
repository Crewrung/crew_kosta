package com.crewrung.servlet;

import com.crewrung.crew.action.AddCrewAction;
import com.crewrung.crew.action.AddCrewMeetingAction;
import com.crewrung.crew.action.AddCrewMeetingUIAction;
import com.crewrung.crew.action.AddCrewUIAction;
import com.crewrung.crew.action.ApplyCrewAction;
import com.crewrung.crew.action.ApplyCrewUIAction;
import com.crewrung.crew.action.CrewDetailUIAction;
import com.crewrung.crew.action.CrewFilterAction;
import com.crewrung.flashMob.action.FlashMobUIAction;
import com.crewrung.flashMob.action.addFlashMobCommentAction;
import com.crewrung.flashMob.action.addFlashMobUIAction;
import com.crewrung.flashMob.action.applyFlashMobAction;
import com.crewrung.flashMob.action.flashMobDetailUIAction;
import com.crewrung.flashMob.action.flashMobFilterAction;
import com.crewrung.flashMob.action.isFlashMobHostAction;
import com.crewrung.flashMob.action.isFlashMobParticipantAction;
import com.crewrung.flashMob.action.updateFlashMobAction;
import com.crewrung.flashMob.action.updateFlashMobUIAction;

import crewaction.CrewUIAction;

public class ActionFactory {
	private ActionFactory() {}

	public static Action getAction(String cmd) {
		Action action;

		switch (cmd) {
		// Crew 愿��젴 �븸�뀡
		case "crewUI":
			action = new CrewUIAction();
			break;
		case "crewFilter":
			action = new CrewFilterAction();
			break;
		case "crewDetailUI":
		    action = new CrewDetailUIAction();
		    break;
		case "addCrewUI":
			action = new AddCrewUIAction();
			break;
		case "addCrew":
			action = new AddCrewAction();
			break;
		case "applyCrewUI":
			action = new ApplyCrewUIAction();
			break;
		case "applyCrew":
			action = new ApplyCrewAction();
			break;
		case "addCrewMeetingUI":
			action = new AddCrewMeetingUIAction();
			break;
		case "addCrewMeeting":
			action = new AddCrewMeetingAction();
			break;

			// FlashMob 愿��젴 �븸�뀡
		case "flashMobUI":
			action = new FlashMobUIAction();
			break;
		case "flashMobDetailUI":
			action = new flashMobDetailUIAction();
			break;
		case "flashMobFilter":
			action = new flashMobFilterAction();
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

			// 湲곕낯 硫붿씤 �럹�씠吏�
		default:
			action = new MainActionUI();
			break;
		}

		return action;
	}
}

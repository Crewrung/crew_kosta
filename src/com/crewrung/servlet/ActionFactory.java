package com.crewrung.servlet;

import com.crewrung.crew.action.AddCrewMeetingAction;
import com.crewrung.crew.action.AddCrewMeetingUIAction;
import com.crewrung.crew.action.AddCrewUIAction;
import com.crewrung.crew.action.ApplyCrewUIAction;
import com.crewrung.crew.action.CrewDetailUIAction;
import com.crewrung.crew.action.CrewMeetingDetailUIAction;
import com.crewrung.crew.action.CrewUIAction;
import com.crewrung.crew.action.RejectCrewJoinRequestAction;
import com.crewrung.crew.action.UpdateCrewAction;
import com.crewrung.crew.action.UpdateCrewUIAction;
import com.crewrung.flashMob.action.FlashMobUIAction;
import com.crewrung.flashMob.action.addFlashMobAction;
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
		case "addFlashMob":
			action = new addFlashMobAction();
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
		case "crewDetailUI":
			action = new CrewDetailUIAction();
			break;
		case "crewUI":
			action = new CrewUIAction();
			break;
//		case "getCrewByFilter":
//			action = new GetCrewByFilterAction();
//			break;
		case "addCrewUI":
			action = new AddCrewUIAction();
			break;
		case "addCrew":
			action = new AddCrewUIAction();
			break;
		case "applyCrewUI":
			action = new ApplyCrewUIAction();
			break;
//		case "applyCrew":
//			action = new ApplyCrewAction();
//			break;
		case "updateCrewUI":
			action = new UpdateCrewUIAction();
			break;
		case "updateCrew":
			action = new UpdateCrewAction();
			break;
		case "addCrewMeetingUI":
			action = new AddCrewMeetingUIAction();
			break;
		case "addCrewMeeting":
			action = new AddCrewMeetingAction();
			break;
		case "crewMeetingDetailUI":
			action = new CrewMeetingDetailUIAction();
			break;
//		case "deleteCrewMember":
//			action = new DeleteCrewMemberAction();
//			break;
		case "rejectCrewJoinRequest":
			action = new RejectCrewJoinRequestAction();
			break;
//		case "approveCrewJoinRequest":
//			action = new ApproveCrewJoinRequestAction();
//			break;
		default:
			action = new MainActionUI();
			break;
		}

		return action;
	}
}

package com.crewrung.servlet;

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

public class ActionFactory {
	private ActionFactory() {
	}

	public static Action getAction(String cmd) {
		Action action;

		switch (cmd) {
		// Board related actions
//		case "detailBoardUI":
//			action = new detailBoardUIAction();
//			break;
//		case "deleteBoard":
//			action = new deleteBoardAction();
//			break;
//		case "updateBoard":
//			action = new updateBoardAction();
//			break;
//		case "boardViewCount":
//			action = new boardViewCountAction();
//			break;
//		case "boardCommentUI":
//			action = new boardCommentAction();
//			break;
//		case "boardsUI":
//			action = new boardsUIAction();
//			break;
//		case "writingBoards":
//			action = new writingBoardsAction();
//			break;
//		case "paging":
//			action = new PagingAction();
//			break;
//		case "postingUI":
//			action = new postingUIAction();
//			break;
//		case "uploadboard":
//			action = new UploadpostAction();
//			break;
//		case "cancelboard":
//			action = new cancelPostAction();
//			break;

		// User related actions
//		case "loginUI":
//			action = new LoginUIAction();
//			break;
//		case "loginAction":
//			action = new LoginAction();
//			break;
//		case "logoutAction":
//			action = new LogoutAction();
//			break;
//		case "joinUI":
//			action = new JoinUIAction();
//			break;
//		case "joinAction":
//			action = new JoinAction();
//			break;
//		case "findUserIdUIAction":
//			action = new FindUserIdUIAction();
//			break;
//		case "findUserIdAction":
//			action = new FindUserIdAction();
//			break;
//		case "findUserPwUIAction":
//			action = new FindUserPwUIAction();
//			break;
//		case "findUserPwAction":
//			action = new FindUserPwAction();
//			break;
//		case "mypageUIAction":
//			action = new MypageUIAction();
//			break;
//		case "mypageAction":
//			action = new MypageAction();
//			break;
//		case "userUpdateInfoUIAction":
//			action = new UserUpdateInfoUIAction();
//			break;
//		case "userUpdateInfoAction":
//			action = new UserUpdateInfoAction();
//			break;
//		case "removeUserAction":
//			action = new RemoveUserAction();
//			break;

		// Flash mob related actions
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

		// Crew related actions
//		case "crewUI":
//			action = new CrewUIAction();
//			break;
//		case "getCrewByFilter":
//			action = new GetCrewByFilterAction();
//			break;
//		case "filterByCategory":
//			action = new FilterByCategoryAction();
//			break;
//		case "filterByGuName":
//			action = new FilterByGuNameAction();
//			break;
//		case "filterByAgeRange":
//			action = new FilterByAgeRangeAction();
//			break;
//		case "addCrewUI":
//			action = new AddCrewUIAction();
//			break;
//		case "addCrew":
//			action = new AddCrewAction();
//			break;
//		case "applyCrew":
//			action = new ApplyCrewUIAction();
//			break;
//		case "crewDetailUI":
//			action = new CrewDetailUIAction();
//			break;
//		case "updateCrewUI":
//			action = new UpdateCrewUIAction();
//			break;
//		case "updateCrew":
//			action = new UpdateCrewAction();
//			break;
//		case "addCrewMeetingUI":
//			action = new AddCrewMeetingUIAction();
//			break;
//		case "addCrewMeeting":
//			action = new AddCrewMeetingAction();
//			break;
//		case "crewMeetingDetailUI":
//			action = new CrewMeetingDetailUIAction();
//			break;
//		case "deleteCrewMember":
//			action = new DeleteCrewMemberAction();
//			break;
//		case "rejectCrewJoinRequest":
//			action = new RejectCrewJoinRequestAction();
//			break;
//		case "approveCrewJoinRequest":
//			action = new ApproveCrewJoinRequestAction();
//			break;

		// Default action
		default:
			action = new MainActionUI();
			break;
		}

		return action;
	}
}
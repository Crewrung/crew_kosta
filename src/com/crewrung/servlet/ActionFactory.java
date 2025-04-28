package com.crewrung.servlet;

import com.crewrung.account.action.FindUserIdAction;
import com.crewrung.account.action.FindUserIdUIAction;
import com.crewrung.account.action.FindUserPwAction;
import com.crewrung.account.action.FindUserPwUIAction;
import com.crewrung.account.action.JoinAction;
import com.crewrung.account.action.JoinUIAction;
import com.crewrung.account.action.LoginAction;
import com.crewrung.account.action.LoginUIAction;
import com.crewrung.account.action.LogoutAction;
import com.crewrung.account.action.MypageAction;
import com.crewrung.account.action.MypageUIAction;
import com.crewrung.account.action.RemoveUserAction;
import com.crewrung.account.action.UserUpdateInfoAction;
import com.crewrung.account.action.UserUpdateInfoUIAction;
import com.crewrung.flashMob.action.FlashMobUIAction;
import com.crewrung.flashMob.action.addFlashMobAction;
import com.crewrung.flashMob.action.addFlashMobCommentAction;
import com.crewrung.flashMob.action.addFlashMobUIAction;
import com.crewrung.flashMob.action.addFlashMobAction;
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
//		case "flashMobFilterUI":
//			action = new flashMobFilterUIAction();
//			break;
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
			
		case "loginUI":
			action = new LoginUIAction();
			break;
		case "loginAction":
			action = new LoginAction();
			break;
		case "logoutAction":
			action = new LogoutAction();
			break;
		case "joinAction":
			action = new JoinAction();
			break;
		case "joinUIAction":
			action = new JoinUIAction();
			break;
		case "findUserIdUIAction":
			action = new FindUserIdUIAction();
			break;
		case "findUserIdAction":
			action = new FindUserIdAction();
			break;
		case "mypageUIAction":
			action = new MypageUIAction();
			break;
		case "mypageAction":
			action = new MypageAction();
			break;
		case "userUpdateInfoUIAction":
			action = new UserUpdateInfoUIAction();
			break;
		case "userUpdateInfoAction":
			action = new UserUpdateInfoAction();
			break;
		case "removeUserAction":
			action = new RemoveUserAction();
			break;
		case "removeUserUIAction":
			action = new RemoveUserAction();
			break;

		// Default action
		default:
			action = new MainActionUI();
			break;
		}

		return action;
	}
}

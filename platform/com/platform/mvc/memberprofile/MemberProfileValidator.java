package com.platform.mvc.memberprofile;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class MemberProfileValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(MemberProfileValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/memberProfile/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/platform/memberProfile/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(MemberProfile.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/memberProfile/save")){
			controller.render("/platform/xxx.html");
		
		} else if (actionKey.equals("/jf/platform/memberProfile/update")){
			controller.render("/platform/xxx.html");
		
		}
	}
	
}

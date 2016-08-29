package com.platform.mvc.members;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class MembersValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(MembersValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/members/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/platform/members/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Members.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/members/save")){
			controller.render("/platform/xxx.html");
		
		} else if (actionKey.equals("/jf/platform/members/update")){
			controller.render("/platform/xxx.html");
		
		}
	}
	
}

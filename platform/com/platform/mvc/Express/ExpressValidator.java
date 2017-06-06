package com.platform.mvc.Express;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class ExpressValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ExpressValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/express/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/platform/express/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Express.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/express/save")){
			controller.render("/platform/xxx.html");
		
		} else if (actionKey.equals("/jf/platform/express/update")){
			controller.render("/platform/xxx.html");
		
		}
	}
	
}

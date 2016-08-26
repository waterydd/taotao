package com.platform.mvc.partner;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class PartnerValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(PartnerValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/partner/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/platform/partner/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Partner.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/partner/save")){
			controller.render("/platform/xxx.html");
		
		} else if (actionKey.equals("/jf/platform/partner/update")){
			controller.render("/platform/xxx.html");
		
		}
	}
	
}

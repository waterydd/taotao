package com.platform.mvc.investment;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class InvestmentValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(InvestmentValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/investment/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/platform/investment/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Investment.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/investment/save")){
			controller.render("/platform/xxx.html");
		
		} else if (actionKey.equals("/jf/platform/investment/update")){
			controller.render("/platform/xxx.html");
		
		}
	}
	
}

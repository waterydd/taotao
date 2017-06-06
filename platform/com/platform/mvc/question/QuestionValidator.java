package com.platform.mvc.question;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class QuestionValidator extends Validator {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(QuestionValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/question/save")){
			// validateString("username", 6, 30, "usernameMsg", "请输入登录账号!");
			
		} else if (actionKey.equals("/jf/platform/question/update")){
			
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Question.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/question/save")){
			controller.render("/platform/xxx.html");
		
		} else if (actionKey.equals("/jf/platform/question/update")){
			controller.render("/platform/xxx.html");
		
		}
	}
	
}

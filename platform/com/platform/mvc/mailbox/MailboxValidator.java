package com.platform.mvc.mailbox;

import java.util.Date;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.platform.tools.ToolDateTime;

@SuppressWarnings({"unused"})
public class MailboxValidator extends Validator {

	private static Logger log = Logger.getLogger(MailboxValidator.class);
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/mailbox/sendmail")){
			validateString("subject", 1, 100, "subjectMsg", "标题不正确!");
			validateString("content", 1, 100, "contentMsg", "内容不正确!");
		}
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Mailbox.class);

		String actionKey = getActionKey();
		if (actionKey.equals("/jf/platform/mailbox/sendmail")){
			
			controller.render("/platform/mailbox/add.html");
		}
	}
	
}

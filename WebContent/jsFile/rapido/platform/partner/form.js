/**
 * 用户添加和编辑页面js
 */
var platform_partner_form = function() {
	"use strict";
	
	/**
	 * 验证用户名是否存在
	 * @param userName
	 */
	var valiUserName = function(phone, realname){
		var param = {"partner.phone" : phone, "partner.realname" : realname};
		var result = common_ajax.ajaxFunc("/jf/platform/partner/valiPartInfo", param);
		return result;
	}
	
	
	var dataVali = function (form, isAdd){
		var phone = $("#phone").val();
		var realname = $("#realname").val();

		if(isAdd){ // 添加
			if(phone != "" &&realname!="" && valiUserName(phone,realname) != "true"){
				toastr.warning("股东信息重复！");
		 		return false;
			}
		
		
		
		}else{ // 更新
			
			var userIds = $("#userIds").val();
			var userInfoIds = $("#userInfoIds").val();
			
			if(idcardId != "" && valiIdcard(idcardId, userInfoIds) != "true"){
				toastr.warning("身份证号码不可用！");
		 		return false;
			}
		
			if(usernameId != "" && valiUserName(usernameId, userIds) != "true"){
				toastr.warning("账号不可用！");
		 		return false;
			}
		
			if(mailboxId != "" && valiMailBox(mailboxId, userInfoIds) != "true"){
				toastr.warning("邮箱不可用！");
		 		return false;
			}
	
			if(mobileId != "" && valiMobile(mobileId, userInfoIds) != "true"){
				toastr.warning("手机号码不可用！");
		 		return false;
			}
		}
		
		var errorCount = platform_verify.formVali(form);
		if(errorCount != 0){
			toastr.warning("有" + errorCount + "处错误，请修正！");
	 		return false;
		}
		
		common_ajax.ajaxFormMainPanel("editForm");
	}


	return {
		submitValiFunc: dataVali
	};
	
}();

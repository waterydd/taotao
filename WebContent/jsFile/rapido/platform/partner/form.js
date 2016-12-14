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
		var jine = $("#jnb_balance").val();

		if(isAdd){ // 添加

			if(phone != "" &&realname!="" && valiUserName(phone,realname) != "true"){
				toastr.warning("股东信息重复！");
		 		return false;
			}
		}else{ // 更新
			
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

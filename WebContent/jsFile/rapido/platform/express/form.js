/**
 * 商品操作信息验证
 */
var platform_express_form = function() {
	"use strict";
	
	var dataVali = function (form, isAdd){
		
		var code = $("#code").val();
		var name = $("#name").val();
		var display_order = $("#display_order").val();
		/* 判断只能为数字和字母的 正则 */
		var reg = /^[0-9a-zA-Z]+$/;
		/*判断不能为中文的正则表达式*/
		var reg2 = /.*[\u4e00-\u9fa5]+.*$/;
		if(isAdd){ // 添加 快递公司
			
			if(!reg.test(code)) {
				toastr.warning("快递代码只能是字母或数字！");
				return false; 
			} 
			if (display_order < 0) {
				 toastr.warning("显示顺序必须大于或等于 0的整数");
			 	 return false;
			}
		}else{ // 更新快递公司
			
			if (display_order < 0) {
				 toastr.warning("显示顺序必须大于或等于 0的整数");
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

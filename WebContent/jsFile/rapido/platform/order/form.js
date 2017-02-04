/**
 * 
 */
var platform_order_form = function() {
	"use strict";
	

	
	var dataVali = function (form, isAdd){
		var expressNumber = $("#expressNumber").val();//快递单号
		
		if(isAdd){ // 添加

		
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

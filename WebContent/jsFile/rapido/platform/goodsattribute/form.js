/**
 * 商品操作信息验证
 */platform_goodsattribute_form
var platform_goodsattribute_form = function() {
	"use strict";
	

	
	var dataVali = function (form, isAdd){


		if(isAdd){ // 添加  true    subject =="" &&             ture         true

		} else {
	
			
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

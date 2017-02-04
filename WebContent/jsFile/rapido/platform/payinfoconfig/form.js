/**
 * 商品操作信息验证
 */
var platform_payinfoconfig_form = function() {
	"use strict";


	
	var dataVali = function (form, isAdd){
		var flowno_length = $('#flowno_length').val();
		if (Number(flowno_length) >8388607 || Number(flowno_length) <=0) {
			 toastr.warning("流水号长度必须为非零正数或长度过长！");
		 	 return false;
		}
		if(isAdd){ 
			

			
		}else{
	
			
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

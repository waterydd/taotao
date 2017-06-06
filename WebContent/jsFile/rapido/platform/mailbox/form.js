/**
 * 商品操作信息验证
 */
var platform_mailbox_form = function() {
	"use strict";
	

	
	var dataVali = function (form, isAdd){
		
		if(isAdd){ // 发送邮件的

		} else { // 上传Excel数据的
			 var path = document.getElementById("excelfile").value; //获取上传文件名
			 var fileExtension = path.substring(path.lastIndexOf('.') + 1); // 截取文件的后缀
			 if (fileExtension!="xlsx" && fileExtension!="xls") {
				 toastr.warning("导入文件不是所需Excel类型！");
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

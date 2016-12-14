/**
 * 用户添加和编辑页面js
 */
var platform_imgmanage_form = function() {
	"use strict";
	
	var dataVali = function (form, isAdd){
		if(isAdd){ 
			 var path = document.getElementById("image_url").value;//获取上传文件名
			 var fileExtension = path.substring(path.lastIndexOf('.') + 1); // 截取文件的后缀
			 if (fileExtension =="" || (fileExtension!="gif" && fileExtension!="png" && fileExtension!="jpeg" && fileExtension!="bmp" && fileExtension!="jpg")) {
				 toastr.warning("上传文件不是所需图片类型！");
			 	 return false;
			} 
			
		}else{ // 更新
			 var path = document.getElementById("image_url").value;//获取上传文件名
			 var fileExtension = path.substring(path.lastIndexOf('.') + 1); // 截取文件的后缀
			 if (fileExtension!="gif" && fileExtension!="png" && fileExtension!="jpeg" && fileExtension!="bmp" && fileExtension!="jpg") {
				 toastr.warning("上传文件不是所需图片类型！");
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

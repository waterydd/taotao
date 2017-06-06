/**
 * 问答新增验证
 */
var platform_fm = function() {
	
	var dataVali = function (form, isAdd){
		var subject = $("#subject").val();
		if(subject == null || subject == ''){
			toastr.warning("请输入音频标题！");
			return false;
		}
		
		var type = $('#type').val();
		if (type == null || type == '')
		{
			toastr.warning("请输入音频类型！");
			return fasle;
		}
		
		 var path = document.getElementById("image_url").value;//获取上传文件名
		 var fileExtension = path.substring(path.lastIndexOf('.') + 1); // 截取文件的后缀
		 if (fileExtension !="" && (fileExtension!="gif" && fileExtension!="png" && fileExtension!="jpeg" && fileExtension!="bmp" && fileExtension!="jpg")) {
			 toastr.warning("音频图片类型错误！");
		 	 return false;
		} 
		
		 var recordUrl = document.getElementById("record_url").value;//获取上传文件名
		 var recordfileExtension = recordUrl.substring(recordUrl.lastIndexOf('.') + 1); // 截取文件的后缀
		 if (recordfileExtension !="" && (recordfileExtension!="mp3" && recordfileExtension!="mp4")) {
			 toastr.warning("音频文件类型错误！");
		 	 return false;
		}
		 
		 var recordUrl = $('#record_url').val();
		 if (recordUrl != null && recordUrl != '')
			 $('#source_file_name').val(recordUrl);
		common_ajax.ajaxFormMainPanel("editForm");
	}

	return {
		submitValiFunc: dataVali
	};
	
}();

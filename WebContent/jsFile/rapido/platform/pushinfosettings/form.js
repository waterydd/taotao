/**
 * 推送
 */
var platform_pushinfosettings_form = function() {
	"use strict";
	
	/**
	 * 验证ForumThread表tid是否存在
	 * @param subject
	 */
	var valiTidInfo = function(tid){
		var param = {"homeTopPost.subject": tid};
		var result = common_ajax.ajaxFunc("/jf/platform/pushInfoSettings/valiTidInfo", param);
		return result;
	}
	

	
	var dataVali = function (form, isAdd){
		var body = $("#body").val();
		var operation_type = $("#operation_type").val();
		var url = $("#url").val();
		var re=/^\d+$/;
		var re2=/^https{0,1}:\/\//;
		if(isAdd){ // 添加  true 
			if (body == '' || body == null) {
				toastr.warning("内容不能为空！");
				return false;
			}

			if (operation_type == 'APP_OPEN_POST') { //APP_OPEN_POST 为APP内打开帖子 判断推送链接为非0 正整数
				if( !re.test(url) || Number(url) == 0){
					toastr.warning("当选择‘APP内打开帖子’类型时，链接值请输入大于0的正整数！");
					return false;
				}
				if (valiTidInfo(url) != "true") {
					toastr.warning("帖子不存在！");
					return false;
				}
			}else{
				console.log(re2.test(url))
				console.log(url)
				if(!re2.test(url)){
					toastr.warning("当前链接不是“https://”或“http://”开头，请更改");
					return false;
				}
			}
			
			 var r=confirm("信息是否无误 ？")
			  if (r !=true) {
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

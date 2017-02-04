/**
 * 用户添加和编辑页面js
 */
var platform_forum_form = function() {
	"use strict";
	
	/**
	 * 验证ForumThread表文章标题是否存在
	 * @param subject
	 */
	var valiSubjectInfo = function(subject){
		var param = {"homeTopPost.subject" : subject};
		var result = common_ajax.ajaxFunc("/jf/platform/homeTopPost/valiSubjectInfo", param);
		return result;
	}
	
	/**
	 * 验证HomeTopPost表文章标题是否存在
	 * @param subject
	 */
	var valiHTPubjectInfo = function(subject){
		var param = {"homeTopPost.subject" : subject};
		var result2 = common_ajax.ajaxFunc("/jf/platform/homeTopPost/valiHTPubjectInfo", param);
		return result2;
	}
	
	/**
	 * 验证标题是否改变过
	 * @param subject
	 */
	var isalter = function(subject,tid){
		var param = {"homeTopPost.subject" : subject, "homeTopPost.tid" : tid};
		var result3 = common_ajax.ajaxFunc("/jf/platform/homeTopPost/isalter", param);
		return result3;
	}
	
	var dataVali = function (form, isAdd){
		var subject = $("#subject").val();// 获取输入的文章标题
		var tid = $("#tid").val();// 获取输入的文章标题
		var forumName = $("#forumName").val();// 获取输入的是否是廣告
		

		if(isAdd){ // 添加  true    subject =="" &&             ture         true
			if (forumName != "AD") {
				if (subject == '' || subject == null) {
					toastr.warning("标题不能为空！");
					return false;
				}
				if(valiSubjectInfo(subject) == "false"){  //  真||假  一真为真  &&   一假为假
					toastr.warning("此文章的标题 不存在！");
			 		return false;
				}
				if(valiHTPubjectInfo(subject) == "true"){ 
					toastr.warning("此文章的标题 已存在！");
			 		return false;
				}

			}



			
			 var path = document.getElementById("image_url").value;//获取上传文件名
			 var fileExtension = path.substring(path.lastIndexOf('.') + 1); // 截取文件的后缀
			 if (fileExtension =="" || (fileExtension!="gif" && fileExtension!="png" && fileExtension!="jpeg" && fileExtension!="bmp" && fileExtension!="jpg")) {
				 toastr.warning("上传文件不是所需图片类型！");
			 	 return false;
			} 
			
		}else{ // 更新
			if (forumName != "AD") {
				if(valiSubjectInfo(subject) == "false"){  //  真||假  一真为真  &&   一假为假
					toastr.warning("此文章的标题 不存在！");
			 		return false;
				}
				if (subject == null || subject == '') {
					toastr.warning("标题不能为空！");
					return false;
				}
				
			}
			
			/*if(valiSubjectInfo(subject) == "false"){  //  真||假  一真为真  &&   一假为假
				toastr.warning("此文章的标题 不存在！");
		 		return false;
			}*/
			var content = $("#content").val();
			if (forumName == 'AD' && content == '')
			{
				toastr.warning("板块名为AD时，内容不能为空！");
		 		return false;
			}
			// 这里就是 判断为增加 还是修改的分界线
			if(isalter(subject,tid) == "false"){  //isalter(subject,tid) 为true 没改过，为false 改动过
				if(valiHTPubjectInfo(subject) == "true"){ 
					toastr.warning("此文章的标题 已存在！");
			 		return false;
				}
			}
			
			 var path = document.getElementById("image_url2").value;//获取上传文件名
			 if (path != "") {
				 var fileExtension = path.substring(path.lastIndexOf('.') + 1); // 截取文件的后缀
				 if (fileExtension!="gif" && fileExtension!="png" && fileExtension!="jpeg" && fileExtension!="bmp" && fileExtension!="jpg") {
					 toastr.warning("上传文件不是所需图片类型！");
				 	 return false;
				} 
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

/**
 * 商品操作信息验证
 */
var platform_goods_form = function() {
	"use strict";
	
	/**
	 * 验证ID是否存在
	 * @param userName
	 */
	var valiId = function(id){
		var param = {"goods.id" : id};
		var result = common_ajax.ajaxFunc("/jf/platform/goods/valiId", param);
		return result;
	}

	
	var dataVali = function (form, isAdd){
		
		var id = $("#id").val();
		var re8 = /^[0-9a-zA-z_]+$/g;
		if(!re8.test(id)){
			toastr.warning("商品ID 只能是数字和字母！");
		 	 return false;
		}

		var inventory = $("#inventory").val();
		if (Number(inventory) >8388607 || Number(inventory) <0) {
			 toastr.warning("库存必须为非零正数或长度过长！");
		 	 return false;
		}
		var publisher_id = $("#publisher_id").val();
		if (publisher_id == '' || Number(publisher_id) <= 0 || Number(publisher_id) >= 8388607)
		{
			toastr.warning("发布人编号错误或超出上限！");
			return false;
		}
		var display_order = $("#display_order").val();
		if (display_order == '' || Number(display_order) <= 0 || Number(display_order) >= 8388607)
		{
			toastr.warning("显示顺序错误或超出上限！");
			return false;
		}
		if(isAdd){ // 添加  true    subject =="" &&             ture         true
			if (id == '' || id == null) {
				toastr.warning("ID不能为空！");
				return false;
			}
			
			
			if(valiId(id) != "0"){
				toastr.warning("ID已存在！");
		 		return false;
			}
			
			 var path = document.getElementById("image_url").value;//获取上传文件名
			 var fileExtension = path.substring(path.lastIndexOf('.') + 1); // 截取文件的后缀
			 if (fileExtension =="" || (fileExtension!="gif" && fileExtension!="png" && fileExtension!="jpeg" && fileExtension!="bmp" && fileExtension!="jpg")) {
				 toastr.warning("上传文件不是所需图片类型！");
			 	 return false;
			} 
			 
		 
			
		}else{ // 更新
			
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

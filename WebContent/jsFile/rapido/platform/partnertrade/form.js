/**
 * 商品操作信息验证
 */
var platform_partnertrade_form = function() {
	"use strict";
	
	/**
	 * 验证ID是否存在
	 * @param userName
	 */
	var valiId = function(id){
		var param = {"partnerTrade.id" : id};
		var result = common_ajax.ajaxFunc("/jf/platform/partnerTrade/valiId", param);
		return result;
	}

	
	var dataVali = function (form, isAdd){
//		var re2=/^-/; // 一个判断头是否为“-”开头的
//		"^-[0-9]*[1-9][0-9]*$"　　//负整数

		var seller_id = $("#seller_id").val();
		var id = $("#id").val();
		var inventory = $("#inventory").val();
		if (Number(inventory) >8388607 || Number(inventory) <0) {
			 toastr.warning("超出库存上限");
		 	 return false;
		}
		
		var re=/^\d+$/;
		if( !re.test(seller_id) || Number(seller_id) == 0){
			toastr.warning("卖家ID必须是非零正整数！");
			return false;
		}
		
		if(isAdd){ // 添加  true    
//			console.log(re2.test(id))
//			console.log(id)
//			if(!re2.test(id)){
//				toastr.warning("当前ID不是“-”开头，请更改");
//				return false;
//			}
			
			if(valiId(id) == "1"){
				toastr.warning("此商品ID已存在！");
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

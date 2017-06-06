/**
 * 问答新增验证
 */
var platform_indexArticle = function() {
	
	var dataVali = function (form, isAdd){
		var subject = $('#subject').val();
		if (subject == null || subject == '')
		{
			toastr.warning("标题为空！");
			return fasle;
		}
		
		var display_order = $("#display_order").val();
		var re=/^\d+$/;
		if( !re.test(display_order) || Number(display_order) == 0){
			toastr.warning("显示顺序请输入大于0的正整数！");
			return false;
		}
		
		common_ajax.ajaxFormMainPanel("editForm");
	}

	return {
		submitValiFunc: dataVali
	};
	
}();

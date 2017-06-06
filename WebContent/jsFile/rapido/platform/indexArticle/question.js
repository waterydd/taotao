/**
 * 问答新增验证
 */
var platform_indexArticle = function() {
	
	var dataVali = function (form, isAdd){
		var display_order = $("#display_order").val();
		var re=/^\d+$/;
		
		if( !re.test(display_order) || Number(display_order) == 0){
			toastr.warning("显示顺序请输入大于0的正整数！");
			return false;
		}
		var id = $('#article_id').val();
		if (id == null || id == '')
		{
			toastr.warning("问题编号为空");
			return fasle;
		}
		common_ajax.ajaxFormMainPanel("editForm");
	}

	return {
		submitValiFunc: dataVali
	};
	
}();

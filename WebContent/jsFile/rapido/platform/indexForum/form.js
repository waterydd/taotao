/**
 * 板块名
 */
var platform_indexForum = function() {
	
	var dataVali = function (form, isAdd){
		var name = $('#name').val();
		if (name == '')
		{
			alert("板块名不能为空！");
			return false;
		}
		var displayOrder = $('#displayOrder').val();
		if (displayOrder == '')
		{
			alert("显示顺序不能为空！");
			return false;
		}
		if (isNaN(displayOrder))
		{
			alert("显示顺序必须为数字！");
			return false;
		}
		var fid = $('#fid').val();
		if (fid == '')
		{
			alert("fid不能为空！");
			return false;
		}
		if (isNaN(fid))
		{
			alert("fid必须为数字！");
			return false;
		}
		
		common_ajax.ajaxFormMainPanel("editForm");
	}

	return {
		submitValiFunc: dataVali
	};
	
}();

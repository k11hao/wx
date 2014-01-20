$(document).ready(function(){
	$(".mytable tbody tr:even").each(function(){
		$(this).css("background-color","#FFFFFF");
	});
	
	$( "#editMetaDiv" ).dialog({
		autoOpen: false,
		width: 500,
		height:500,
		buttons: [
			{
				text: "保存",
				click: function() {
					$( this ).dialog( "close" );
				}
			},
			{
				text: "取消",
				click: function() {
					$( this ).dialog( "close" );
				}
			}
		]
	});
	
});
function editMeta(userid){
	$("#editMetaDiv").dialog( "open" );
}
//设定bootstrapTable表格样式	(表头色，toolbar样式)	
//以调整到menu-ui.js中
/*window.onload=function() {
	alert("bars");
	$(".bs-bars ").removeClass("pull-left");
	$(".fixed-table-container").attr("style",
			"padding-bottom: 0px;margin-top: 10px;");
	$(".th-inner").attr("style", "background-color: #3072AC;color:#fff");
}
*/

//全局AJAX设定
$(function () {
    $.ajaxSetup({
        function (XMLHttpRequest, textStatus) {
            console.debug(textStatus);
        }
    })
})



$(function() {
	var windowWidth = $(window).width() - 30;
	$("#main-left").width(windowWidth);
	console.log(windowWidth);
    $("#hideTool").click(function(){
        $("#main-right").toggle(300);
        if ($("#hideTool").attr("src") == "../image/hide.png") {
            $("#hideTool").attr("src","../image/show.png");
        } else {
            $("#hideTool").attr("src","../image/hide.png");
        } 
    });
});
(function($){    
    if(document.URL.indexOf('activity-main.aspx') > 0) {
        $(window).bind("scroll",function(e){
            $.cookie('ListPagePosition', $(window).scrollTop());
        });
    }
    else {
        if (document.URL.indexOf('activity-customized1.aspx') > 0 && 
            document.URL.indexOf('&pageIndex=') > 0) {
            $.cookie('LogPage', document.URL);
        }
    }
})(jQuery);

$(function(){
    fontSize();
    $(window).resize(fontSize)

    let p=0,t=0;
    $(window).scroll(function(e){
        p = $(this).scrollTop();
        if(t<=p){//向下滚
            $('#nav').css('top','-60px')
            $('#nav').removeClass('nav1')
        }else{//向上滚
            if(p===0){
                $('#nav').removeClass('nav1')
            }else {
                $('#nav').addClass('nav1')
            }
            $('#nav').css('top','0px')
        }
        setTimeout(function(){t = p;},0);
    });
})


function fontSize(){
    var h = $(window).width()/100;
    $("html").css("font-size",h+"px");
}


$(function(){var G=3000;var C=null;var A=$(".sliderRank").find("a");var F=$(".sliderItem");var B=$(".slider-content");var D=0;F.hover(function(){A.eq(D).click()},function(){E()});F.click(function(){var J=$(this),H=J.attr("data-type");if(H==="video"){clearInterval(C);var I=J.find(".video_wrap").html();$(".slider-container").empty().html(I)}});A.click(function(){var I=$(this);clearInterval(C);var H=I.index();D=H;F.eq(D).siblings().stop(true,true).animate({opacity:0,display:"none"},500,function(){F.eq(D).siblings().hide()});F.eq(D).stop(true,true).animate({opacity:1,display:"block"},300,function(){F.eq(D).show()});A.eq(H).addClass("current").siblings().removeClass("current")});function E(){C=setInterval(function(){D>2?D=0:D++;F.eq(D).siblings().stop().animate({opacity:0},600,function(){F.eq(D).siblings().hide()});F.eq(D).stop().animate({opacity:1},200,function(){F.eq(D).show()});A.eq(D).addClass("current").siblings().removeClass("current")},G)}E()});
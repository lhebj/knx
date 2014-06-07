$(function(){
	var $toolControl  = $('.controlContainer').find('a');
	var $tool = $('.toolBarWrap').find('a');
	var len = $toolControl.length;
	var flag = false;
    var tmplIndex = 0;
	$toolControl.on('click',function(e){
		e.preventDefault();
		var $this = $(this);
		var index = $toolControl.index($this);
		if(index === (len-1)){    //最后一个
			if($this.hasClass('tool_control_open')){  //关闭
				for(var n=0 ;n<len ;n++){
					$toolControl.eq(n).attr('class','tool_control tool_control_'+(n+1));
					$tool.eq(n).attr('class','tool tool_'+(n+1));
				}
			}else{    //打开
				for(var k=0 ;k<len ;k++){
					$toolControl.eq(k).attr('class','tool_control_open tool_control_open_'+(k+1));
					$tool.eq(k).attr('class','tool_open tool_open_'+(k+1));
				}
			}
		}else{    //非最后一个
			if($this.hasClass('tool_control_open')){  //关闭  最后一个
				$this.attr('class','tool_control tool_control_'+(index+1));
				$tool.eq(index).attr('class','tool tool_'+(index+1));
			}else{   //打开  非最后一个
				$this.attr('class','tool_control_open tool_control_open_'+(index+1));
				$tool.eq(index).attr('class','tool_open tool_open_'+(index+1));
			}

			if($('.tool_control').length > 0){
				$toolControl.eq(len-1).attr('class','tool_control tool_control_'+(len));
			}
			if($('.tool_control_open').length==7){
				$toolControl.eq(len-1).attr('class','tool_control_open tool_control_open_'+(len));
			}
		}
	});

    //当前时间
    var year = new Date().getFullYear(),
    	month = new Date().getMonth()+1,
    	day = new Date().getDate(),
    	week = new Date().getDay(),
    	weeks = ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'];
  	$weatherInfo = $('.weatherInfo');
  	$weatherInfo.find('.data').html(year+'-'+month+'-'+day+'  '+weeks[week]);


  	//天气预报
	var url = 'http://api.map.baidu.com/telematics/v3/weather?location=北京&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ';
	$.ajax({
		url:url,
		dataType:'jsonp',
		success:function(json){
			//debugger
		}
	});
})
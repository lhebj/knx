$(function(){
	var timer = 3000;
	var handId = null;

	var $aRank = $('.sliderRank').find('a');
	var $li = $('.sliderItem');
	var $ul = $('.slider-content');
	var current = 0;
	$li.hover(function() {
		$aRank.eq(current).click();
	}, function() {
		playImg();
	});

	//点击播放视频
	$li.click(function(){
		var $this= $(this),
		dataType = $this.attr('data-type');
		//视频
		if(dataType ==='video'){
			clearInterval(handId);
			var videoIframe = $this.find('.video_wrap').html();
			$('.slider-container').empty().html(videoIframe);
		}
	});

	$aRank.click(function() {
		var $this = $(this);
		clearInterval(handId);
		var currentIndex = $this.index();
		current = currentIndex;
		$li.eq(current).siblings().stop(true, true).animate({
			'opacity': 0,
			'display': 'none'
		}, 500, function() {
			$li.eq(current).siblings().hide();
		});
		$li.eq(current).stop(true, true).animate({
			'opacity': 1,
			'display': 'block'
		}, 300, function() {
			$li.eq(current).show();
		});
		$aRank.eq(currentIndex).addClass('current').siblings().removeClass('current');
	});

	function playImg() {
		handId = setInterval(function() {
			current > 2 ? current = 0 : current++;
			$li.eq(current).siblings().stop().animate({
				'opacity': 0
			}, 600, function() {
				$li.eq(current).siblings().hide();
			});
			$li.eq(current).stop().animate({
				'opacity': 1
			}, 200, function() {
				$li.eq(current).show();
			});
			$aRank.eq(current).addClass('current').siblings().removeClass('current');

		}, timer);
	};

	playImg();
})
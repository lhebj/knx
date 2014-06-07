$(function(){
	var $imgItem = $('.img_item'),
		$largeImg = $('#largeImg');
	$imgItem.on({
		mouseenter:function(){
			var imgsrc = $(this).find('img').attr('src');
			if(imgsrc != ''){
				$largeImg.attr('src',imgsrc);
			}
		}
	});
});
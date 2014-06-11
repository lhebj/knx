$(function(){
	var $item = $('.classification ');
	$item.on('mouseenter',function(){
		
	});
	$item.on({
		'mouseenter':function(){
			var $this =$(this);
			$this.siblings('.classify-list').show();
		},
		'mouseleave':function(){
			var $this =$(this);
			$this.siblings('.classify-list').hide();
		}
	});
})
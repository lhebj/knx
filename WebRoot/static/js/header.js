$(function(){
	function init(){

		var $brand = $('#J_brand'),
		    $classify = $('#J_classify'),
		    $container = $('.container'),
		    $content = $container.find('.content'),
		    $brandBox = $container.find('.brand_submenubox'),
		    $classifyBox = $container.find('.classify_submenubox'),
		    $registrationWrap = $container.find('.registrationWrap'),
		    cTop = $content.position().top,
		    cLeft = $content.position().left,
		    $tip = $('#tip'),
		    brandId = 0,
			classifyId =0,
			head_brand_load_for_id=-1,
			head_category_load_for_id=-1,
			left_brand_load_for_id=-1
			left_category_load_for_id=-1;

		 $brandBox.css({
			top:cTop + 60,
			left:cLeft+36
		});
	 	$classifyBox.css({
			top:cTop+60,
			left:cLeft+36
		});

	 	/*
	 	//点击导航
		$container.on('click','.nav',function(){
			var $this = $(this);
		    $container.find('.nav').removeClass('current');
		    $this.addClass('current');
		    $registrationWrap.hide();

			if($this.attr('id') === 'J_brand'){
				$brandBox.show();
				$classifyBox.hide();
			}else if($this.attr('id') === 'J_classify'){
				$classifyBox.show();
			    $brandBox.hide();
			}else{
				$classifyBox.hide();
			    $brandBox.hide();
			}
		});
		
		*/
	 	
	 	//show head brand
	 	function show_head_brand(){
	 		if(head_category_load_for_id>=0 && head_category_load_for_id==classifyId){
	 			$brandBox.show();
	 			return;
	 		}
	 		$.post('brand.do?action=list', {
	 			categoryId:classifyId
			}, function(json) {
				 json = $.parseJSON(json);
				if(json.result){
					var a = [];
					$.each(json.result.map, function(key, val) { a[a.length] = key;  });
					a.sort();
					 $.each(a, function (name, key) {  
				         $("#head_brand_ul").append("<li><span class=\"sort_title\">"+key+"</span><div class=\"detail\" id='brand_li_"+key+"'></div></li>");
				         $.each(json.result.map[key].list, function (i, brandDTO) { 
							 $("#brand_li_"+key).append("<a href=\"javascript:;\" data-id=\""+brandDTO.idBrd+"\" class=\"nav_item\">"+brandDTO.nameBrd+" </a>");
				         }); 
				     }); 
					 $brandBox.show();
					 head_category_load_for_id = classifyId;
				}else{
					//$tip.html(json.message).show();
				}
			});
	 	} 
	 	
	 	//show category
	 	function show_head_category(){
	 		if(head_brand_load_for_id>=0&&head_brand_load_for_id == brandId){
	 			$classifyBox.show();
	 			return;
	 		}
	 		 $.post('category.do?action=list', {
	 			brandId:brandId
				}, function(json) {
					 json = $.parseJSON(json);
					if(json.result){
						 $.each(json.result.list, function (i, categoryDTO) {  
					         $("#head_category_ul").append("<li><a href=\"javascript:;\" class=\"nav_item\" data-id=\""+categoryDTO.idCat+"\">"+categoryDTO.nameCat+"</a></li>");
					     }); 
						 $classifyBox.show();
						 head_brand_load_for_id = brandId;
					}else{
						//$tip.html(json.message).show();
					}
				});
	 	}
	 	
	 	//点击导航
		$container.on('click','.nav',function(){
			var $this = $(this);
		    $container.find('.nav').removeClass('current');
		    $this.addClass('current');
		    $registrationWrap.hide();

			if($this.attr('id') === 'J_brand'){
				$classifyBox.hide();
				show_head_brand();				
			}else if($this.attr('id') === 'J_classify'){
			    $brandBox.hide();
			    show_head_category();
			}else{
				$classifyBox.hide();
			    $brandBox.hide();
			}
		});

		//分类 && 品牌
		$container.on('click','.nav_item',function(){
			var $this = $(this),
				$wrap = $this.parents('.wrap');
		    $container.find('.nav').removeClass('current');
		    
			//品牌
			if($wrap.hasClass('brand_submenubox')){
				brandId = $this.attr('data-id');
				if(classifyId !='' && brandId !=''){
					window.location.href ='brand.do?action=detail&id='+brandId+'&categoryId='+classifyId;
				}else{
					$wrap.hide();
					show_head_category();
					$classify.addClass('current');
				}
			//分类
			}else if($wrap.hasClass('classify_submenubox')){
				classifyId = $this.attr('data-id');
				if(classifyId !='' && brandId !=''){
					window.location.href ='brand.do?action=detail&id='+brandId+'&categoryId='+classifyId;
				}else{
					$wrap.hide();
					show_head_brand();
					$brand.addClass('current');
				}
			}
		});

		//注册 && 登陆
		$container.on('click','.userBtn',function(){
			var $this = $(this);
			$registrationWrap.css({
				top:cTop +60
			}).show();

		});
		//密码
		$container.on('click','.submit',function(){
			var userName = $('.userName').val(),
				email = $('.email').val(),
				weiXin = $('.weiXin').val(),
				password = $('.password').val(),
				rePassword = $('.rePassword').val();

			$tip.hide();
			if(userName==''||email==''||weiXin==''||password==''){
				$tip.html('请检查必填项').show();
				return;
			}else if(password != rePassword){
				$tip.html('两次输入的密码不一致').show();
				return;
			}
			$.post('register.do', {
				username: userName,
				email: email,
				weixin: weiXin,
				p: password,
				pc:rePassword
			}, function(json) {
				 json = $.parseJSON(json);
				if(!!json.success){
					//隐藏注册
					$registrationWrap.hide();
					window.location.reload(); 
				}else{
					$tip.html(json.message).show();
				}
			});
		});

		//登陆
		$container.on('click','.login_btn',function(){
			var $this = $(this),
			    $loginError =$('.login_error'),
			    userName=$('#j_username').val(),
			    passWord = $('#j_password').val();
			 $loginError.hide();
			 if(userName ==''){
			 	$loginError.html('请输入用户名').show();
			 	return;
			 }
			 if(passWord ==''){
			 	$loginError.html('请输入密码').show();
			 	return;
			 }
			$.post('login.do', {
				usernameOrEmail: userName,
				password: passWord,
			}, function(json) {
				json = $.parseJSON(json);
				if(!!json.success){
					//隐藏
					$registrationWrap.hide();
					window.location.reload();  
				}else{
					$loginError.html(json.message).show();
				}
			});
		});

		$('.aside_nav .item').on('click',function(){
			var $this = $(this),
			    $asideNav = $this.parents('.aside_nav'),
			    className = $asideNav.attr('name');
			if(className =='brand'){
				brandId = $this.attr('id');
				if(classifyId !='' && brandId !=''){
					window.location.href ='brand.do?action=detail&id='+brandId+'&categoryId='+classifyId;
				}else{
					$asideNav.find('.classification').removeClass('current');
					$asideNav.siblings('.aside_nav').find('.classification').addClass('current');
					$asideNav.find('.submenubox').hide();
					$asideNav.siblings('.aside_nav').find('.submenubox').show();
				}
			}
			if(className =='classify'){
				classifyId = $this.attr('id');
				if(classifyId !='' && brandId !=''){
					window.location.href ='brand.do?action=detail&id='+brandId+'&categoryId='+classifyId;
				}else{
				    $asideNav.find('.classification').removeClass('current');
					$asideNav.siblings('.aside_nav').find('.classification').addClass('current');
				    $asideNav.find('.submenubox').hide();
				    $asideNav.siblings('.aside_nav').find('.submenubox').show();
				}
			}
		});

		//左侧菜单
		$('.aside_nav').on({
			mouseenter:function(){
				var $this = $(this);
				$this.find('.classification').addClass('current');
				$this.find('.submenubox').show();
			},
			mouseleave:function(){
				var $this = $(this);
				$this.find('.classification').removeClass('current');
				$this.find('.submenubox').hide();
			}
		});		
	}

	init();
})
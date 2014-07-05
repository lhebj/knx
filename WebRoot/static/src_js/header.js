$(function(){
	function init(){

		var $brand = $('#J_brand'),
		    $classify = $('#J_classify'),
		    $container = $('.container'),
		    $content = $container.find('.content'),
		    $brandBox = $container.find('.brand_submenubox'),
		    $classifyBox = $container.find('.classify_submenubox'),
		    $asideBrandBox = $container.find('#asideBrandBox'),
		    $asideClassifyBox = $container.find('#asideClassifyBox'),
		    $registrationWrap = $container.find('.registrationWrap'),
		    cTop = $content.position().top,
		    cLeft = $content.position().left,
		    $tip = $('#tip'),
		    brandId = 0,
			classifyId =0,
			head_brand_load_for_0=0,
			head_category_load_for_0=0,
			aside_brand_load_for_0=0,
			aside_category_load_for_0=0,
			head_brand_or_category_show=0;

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
	 		/*if(head_category_load_for_id>=0 && head_category_load_for_id==classifyId){
	 			$brandBox.show();
	 			return;
	 		}
	 		*/
	 		head_brand_or_category_show=1;
	 		if(head_brand_load_for_0==1 && classifyId==0){
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
					$("#head_brand_ul").empty();
					 $.each(a, function (name, key) {  
				         $("#head_brand_ul").append("<li><div class=\"sort_title\">"+key+"</div><div id='brand_li_"+key+"'></div></li>");
				         $.each(json.result.map[key].list, function (i, brandDTO) { 
				        	 if(brandDTO.show){
				        		 $("#brand_li_"+key).append("</br><a href=\"javascript:;\" data-id=\""+brandDTO.idBrd+"\" class=\"nav_item\">"+brandDTO.nameBrd+" </a>"); 
				        	 }else{
				        		 $("#brand_li_"+key).append("</br><span class=\"item_disabled\">"+brandDTO.nameBrd+"</span>");
				        	 }
							 
				         }); 
				     }); 
					 $brandBox.show();
					 //head_category_load_for_id = classifyId;
					 //cache when classifyId=0
					 if(classifyId==0){
						 head_brand_load_for_0 = 1;
					 }else {
						 head_brand_load_for_0 = 0;
					 }
				}else{
					//$tip.html(json.message).show();
				}
			});
	 	} 
	 	
	 	//show category
	 	function show_head_category(){
	 		/*if(head_brand_load_for_id>=0&&head_brand_load_for_id == brandId){
	 			$classifyBox.show();
	 			return;
	 		}
	 		*/
	 		head_brand_or_category_show=1;
	 		if(head_category_load_for_0==1&&brandId==0){
	 			$classifyBox.show();
 				return;
	 		}
 		
	 		 $.post('category.do?action=list', {
	 			brandId:brandId
				}, function(json) {
					 json = $.parseJSON(json);
					if(json.result){
						$("#head_category_ul").empty();
						 $.each(json.result.list, function (i, categoryDTO) {  
							 if(categoryDTO.show){
								 $("#head_category_ul").append("<li><a href=\"javascript:;\" class=\"nav_item\" data-id=\""+categoryDTO.idCat+"\">"+categoryDTO.nameCat+"</a></li>");
							 }else{
								 $("#head_category_ul").append("<li><span class=\"item_disabled\">"+categoryDTO.nameCat+"</span></li>");
							 }
					         
					     }); 
						 $classifyBox.show();
						 //head_brand_load_for_id = brandId;
						 //cache when brandId=0
						 if(brandId==0){
							 head_category_load_for_0 = 1;
						 }else {
							 head_category_load_for_0 = 0;
						 }
					}else{
						//$tip.html(json.message).show();
					}
				});
	 	}
	 	
	 	//点击导航中的品牌和分类
		$container.on('click','.nav',function(){
			var $this = $(this);
		    $container.find('.nav').removeClass('current');
		    $this.addClass('current');
		    $registrationWrap.hide();

			if($this.attr('id') === 'J_brand'){
				classifyId=0;
				$classifyBox.hide();
				show_head_brand();				
			}else if($this.attr('id') === 'J_classify'){
				brandId=0;
			    $brandBox.hide();
			    show_head_category();
			}else{
				$classifyBox.hide();
			    $brandBox.hide();
			}
		});

		//点击导航中展开的分类和品牌
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

		//点击左侧导航中展开的分类和品牌
		$container.on('click','.item',function(){
//		$('.aside_nav .item').on('click',function(){
			var $this = $(this),
			    $asideNav = $this.parents('.aside_nav'),
			    asideNavId = $asideNav.attr('id');
			if(asideNavId =='aside_nav_brand'){
				brandId = $this.attr('id');
				if(classifyId !='' && brandId !=''){
					window.location.href ='brand.do?action=detail&id='+brandId+'&categoryId='+classifyId;
				}else{
					$asideNav.find('.classification').removeClass('current');
					$asideNav.siblings('.aside_nav').find('.classification').addClass('current');
					//$asideNav.find('.submenubox').hide();
					//$asideNav.siblings('.aside_nav').find('.submenubox').show();
					
					$asideBrandBox.hide();
					show_aside_category();
				}
			}
			if(asideNavId =='aside_nav_classify'){
				classifyId = $this.attr('id');
				if(classifyId !='' && brandId !=''){
					window.location.href ='brand.do?action=detail&id='+brandId+'&categoryId='+classifyId;
				}else{
				    $asideNav.find('.classification').removeClass('current');
					$asideNav.siblings('.aside_nav').find('.classification').addClass('current');
				    //$asideNav.find('.submenubox').hide();
				    //$asideNav.siblings('.aside_nav').find('.submenubox').show();
				    
				    $asideClassifyBox.hide();
				    show_aside_brand();
				}
			}
		});

		/*
		//左侧菜单
		$('.aside_nav').on({
			mouseenter:function(){
				var $this = $(this);
				$this.find('.classification').addClass('current');
				//$this.find('.submenubox').show();
				show_aside_brand();
			},
			mouseleave:function(){
				var $this = $(this);
				$this.find('.classification').removeClass('current');
				//$this.find('.submenubox').hide();
				show_aside_category();
			}
		});	
		
		*/
		function mouse_enter_brand_action(){
			$('#aside_nav_brand').find('.classification').addClass('current');
			brandId=0;
			show_aside_brand();
		}
		
		function mouse_leave_brand_action(){
			$('#aside_nav_brand').find('.classification').removeClass('current');
			//$this.find('.submenubox').hide();
			$asideBrandBox.hide();
		}
		
		function mouse_enter_classification_action(){
			$('#aside_nav_classify').find('.classification').addClass('current');
			classifyId=0;
			show_aside_category();
		}
		
		function mouse_leave_classification_action(){
			$('#aside_nav_classify').find('.classification').removeClass('current');
			//$this.find('.submenubox').hide();
			$asideClassifyBox.hide();
		}
		//左侧品牌
		$('#aside_nav_brand').on({
			mouseenter:function(){
				//防止与head导航上的冲突
				if(head_brand_or_category_show == 1){
					return;
				}
				mouse_leave_classification_action();
				mouse_enter_brand_action();
			},
			mouseleave:function(){
				mouse_leave_brand_action();
			}
		});	
		
		//左侧分类 
		$('#aside_nav_classify').on({
			mouseenter:function(){
				//防止与head导航上的冲突
				if(head_brand_or_category_show == 1){
					return;
				}
				mouse_leave_brand_action();
				mouse_enter_classification_action();
			},
			mouseleave:function(){
				mouse_leave_classification_action();
			}
		});	
		
		
		
		//show aside brand
	 	function show_aside_brand(){
	 		/*if(aside_category_load_for_id>=0 && aside_category_load_for_id==classifyId){
	 			$asideBrandBox.show();
	 			return;
	 		}*/
	 		if(aside_brand_load_for_0==1 && classifyId==0){
	 			$asideBrandBox.show();
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
					$("#aside_brand_ul").empty();
					 $.each(a, function (name, key) {  
				         $("#aside_brand_ul").append("<li><span class=\"sort_title\">"+key+"</span><div id='aside_brand_li_"+key+"'></div></li>");
				         $.each(json.result.map[key].list, function (i, brandDTO) { 
				        	 if(brandDTO.show){
				        		 $("#aside_brand_li_"+key).append("</br><a href=\"javascript:;\" id=\""+brandDTO.idBrd+"\" class=\"item\">"+brandDTO.nameBrd+" </a>"); 
				        	 }else{
				        		 $("#aside_brand_li_"+key).append("</br><span class=\"item_disabled\">"+brandDTO.nameBrd+"</span>");
				        	 }
							 
				         }); 
				     }); 
					 $asideBrandBox.show();
					 //aside_category_load_for_id = classifyId;
					 //cache when classifyId==0
					 if(classifyId==0){
						 aside_brand_load_for_0=1;
					 }else{
						 aside_brand_load_for_0=0;
					 }
				}else{
					//$tip.html(json.message).show();
				}
			});
	 	} 
	 	
	 	//show aside category
	 	function show_aside_category(){
	 		/*if(aside_brand_load_for_id>=0&&aside_brand_load_for_id == brandId){
	 			$asideClassifyBox.show();
	 			return;
	 		}*/
	 		if(aside_category_load_for_0==1&&brandId==0){
 				$asideClassifyBox.show();
 				return;
 			}
	 		 $.post('category.do?action=list', {
	 			brandId:brandId
				}, function(json) {
					 json = $.parseJSON(json);
					if(json.result){
						$("#aside_category_ul").empty();
						 $.each(json.result.list, function (i, categoryDTO) {  
							 if(categoryDTO.show){
								 $("#aside_category_ul").append("<li><a href=\"javascript:;\" class=\"item\" id=\""+categoryDTO.idCat+"\">"+categoryDTO.nameCat+"</a></li>");
							 }else{
								 $("#aside_category_ul").append("<li><span class=\"item_disabled\">"+categoryDTO.nameCat+"</span></li>");
							 }
					         
					     }); 
						 $asideClassifyBox.show();
						 //aside_brand_load_for_id = brandId;
						 //cache when brandId==0
						 if(brandId==0){
							 aside_category_load_for_0=1;
						 }else{
							 aside_category_load_for_0=0;
						 }
					}else{
						//$tip.html(json.message).show();
					}
				});
	 	}
	}

	init();
})
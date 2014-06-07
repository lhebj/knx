$(function(){
	function init(){
		//登陆
		$('#login_btn').on('click', function(){
			var userName=$('#j_username').val(),
			    passWord = $('#j_password').val();
			$.post('login.do', {
				usernameOrEmail: userName,
				password: passWord,
			}, function(json) {
				json = $.parseJSON(json);
				if(!!json.success){
					window.location.href="admin.do?action=home"; 
				}else{
					window.location.reload();  
				}
			});
		});
		
	}

	init();
});
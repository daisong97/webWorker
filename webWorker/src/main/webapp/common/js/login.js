
$(function() {
	$(window).keydown(function(event) {
		if (event.keyCode == 13) {
			$("#doLgnBtn").click();
		}
	});
	$("#doLgnBtn").click(function() {
		var username = $("#username");
		var username_text = username.val();

		var password = $("#password");
		var password_text = password.val();

		var captcha = $("#captcha_text");
		var captcha_text = captcha.val();

		if (username_text == "") {
			username.toggleClass("isNullText");
			return false;
		}
		if (password_text == "") {
			password.toggleClass("isNullText");
			return false;
		}
		
		if ($("#captcha").css("display") == "block") {
			if (captcha_text == "") {
				captcha.toggleClass("isNullTxtCode");
				return false;
			}
		}
		var url = $("#loginFrm").attr("action");
		var rememberMe_=$("#rememberMe").attr("checked");
		var reberMe=rememberMe_=='checked'?true:false;
		$.post(url, {
			username : username_text,
			password : password_text,
			captcha : captcha_text,
			rememberme: reberMe
		}, function(data) {
			if (data.status != 1) {
				$("#captcha").css({
					"display" : "block"
				});
				alert(data.msg);
				flushCaptcha();
				return;
			}
			if (data.status == 1) {
				$("#isloginOut").val("true");
				window.location.href = data.jumpUrl;
			}
		}, "json");
		/*
		 * $('#loginFrm').form('submit', { onSubmit: function(){ var
		 * username=$("#username"); var username_text=username.val(); var
		 * password=$("#password"); var password_text=password.val();
		 * if(username_text==""){ username.toggleClass("isNullText"); return
		 * false; } if(password_text==""){ password.toggleClass("isNullText");
		 * return false; } }, success:function(data){ var obj =
		 * $.parseJSON(data); if(obj.status!=1){ alert(obj.msg); return ; }
		 * if(obj.status==1){ window.location.href=obj.jumpUrl; } } });
		 */
	});
	$("#doLgnBtn").hover(function() {
		$(this).addClass("doLgnBtn");
	}, function() {
		$(this).removeClass("doLgnBtn");
	});
	$("#username").change(function(data) {
		if ($(this).val() != '') {
			$(this).removeClass();
			$(this).addClass("txt");
		}
	});
	$("#password").change(function(data) {
		if ($(this).val() != '') {
			$(this).removeClass();
			$(this).addClass("txt");
		}
	});
	$("#captcha_text").change(function(data) {
		if ($(this).val() != '') {
			$(this).removeClass();
			$(this).addClass("txtCode");
		}
	});
	if ($("#isloginOut").val() == 'true') {
		$.post("loginOut");
	}
});
function flushCaptcha() {
	var img = $("#captchaImg");
	img.removeAttr("src");
	img.attr("src", "../kaptcha.jpg?" + Math.floor(Math.random() * 100));
}
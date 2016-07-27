// Initialize your app
var myApp = new Framework7({
			animateNavBackIcon : true,
			// animatePages : Framework7.prototype.device.ios,
			pushState : true,
			swipePanel : 'left',
			modalButtonOk : '确认',
			modalButtonCancel : '取消',
			imagesLazyLoadPlaceholder : imgUrl + '/image/loading.png',
			// Hide and show indicator during ajax requests
			onAjaxStart : function(xhr) {
				myApp.showIndicator();
			},
			onAjaxComplete : function(xhr) {
				myApp.hideIndicator();
			}
		});

// Export selectors engine
var $$ = Dom7;

$$('form.ajax-submit.portal-index-login-form').on('beforeSubmit', function(e) {
		});

$$('form.ajax-submit.portal-index-login-form').on('submitted', function(e) {
			myApp.hideIndicator();
			var xhr = e.detail.xhr;

			top.location.href = appUrl + "/user/shop.htm";
		});

$$('form.ajax-submit.portal-index-login-form').on('submitError', function(e) {
			myApp.hideIndicator();
			var xhr = e.detail.xhr;
			myApp.alert(xhr.responseText, '错误');
		});

function submit() {
	myApp.showIndicator();

	$$('#portal/index/login/form').attr("action", appUrl + "/login.htm");

	$$('#portal/index/login/form').trigger("submit");
}

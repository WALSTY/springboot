$("#btn-reg").click(function(){
	$.ajax({
		url:"/users/reg",
		type:"POST",
		date:$("#form-reg").serialize(),
		dataType:"json",
		success: function(json){
			if(json.state == 200){
				alert("changgong");
			}else{
				alert("shibai");
			}
		},
		error: function(xhr){
			alert("weizhicuowu" + xhr.status);
		}
	})
})
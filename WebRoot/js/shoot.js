$(document).ready(function(){
    $(".total-head").addClass("blank");
    $(".media-heading").addClass("h4-blank");
	$(".list-group-item").addClass("listbox");
    $("#btn").click(function() {
 		var div = $("#moveDiv");
		if(div.hasClass("dest")) {
			div.removeClass("dest").animate({left:"0",right:"0"}, 600);
    		$("#mySelect").hide(500);
    		$("#btn").attr("src","icons/select.jpg"); 
      		$("li").removeClass("dest1").animate({left:"0"},600);
		}
 		else {
			div.addClass("dest").animate({left:"40%",right:"-40%"}, 600);
   		 	$("#mySelect").show(500);
    		$("#btn").attr("src","icons/select1.jpg");
      		$("li").addClass("dest1").animate({left:"40%"},600);
		}
		});
    $("#h_page,#h_page_two").click(function() {
    	if($("#moveDiv").hasClass("dest")) {
    	$("#moveDiv").removeClass("dest").animate({left:"0",right:"0"}, 600);
    	$("#mySelect").hide(500);
    	$("#btn").attr("src","icons/select.jpg");
    	$("li").removeClass("dest1").animate({left:"0"},600);
    	}
    });
    $("#btn1").click(function() {
		var div = $("#moveDiv");
		if(div.hasClass("dest2")) {
			div.removeClass("dest2");
    		$("#btn1").attr("src","icons/list.jpg"); 
    		$("#h_page").show();
    		$("#h_page_two").hide();
		}
 		else {
			div.addClass("dest2");
    		$("#btn1").attr("src","icons/list1.jpg");
    		$("#h_page").hide();
    		$("#h_page_two").show();
		}
	});
	 $("#b_like").click(function() {
	 	
		if($("#b_like").hasClass("p_change")) {
			$("#b_like").removeClass("p_change");
			$("#b_like").css("color","#bbb");
			$("#love").attr("src","icons/praise.jpg"); 
		}
 		else {
    		$("#b_like").addClass("p_change");
    		$("#b_like").css("color","#ff5e5e");
			$("#love").attr("src","icons/praise1.jpg"); 
		}
	});
	 $("#p_content").click(function() {
		$("#d_prasie").hide();
		$("#i_prasie").hide();
    	$("#d_content").show();
    	$("#i_content").show();
	});
	 $("#p_prasie").click(function() {
	 	$("#d_content").hide();
	 	$("#i_content").hide();
    	$("#d_prasie").show();
    	$("#i_prasie").show();
	});

	$(".upload").children().addClass("block");
	$(".upload").children("label").css({"font-size":"small","font-weight":"normal"});
	$(".upload").children("p").css({"padding":"1.5rem 3rem"});
	$(".upload").children("input,textarea").addClass("i_b");


	// var a=$("ul").width();
	$("li").addClass("more！important").css("height","12rem");
	$("#h_page_two").find("img").addClass("more！important").css("height","12rem");

	if ($("ul").children("img").width()<=$("#h_page_two").width() ) {
		$(".img-centre").css("height","100%！important");
	}
	else{
		$(".img-centre").css("width","100%！important");
	}

	if ( $(".img-centre").width()<=$(".img-centre").height() ) {
	$(".img-centre").css("height","100%");
	}
	else{
		$(".img-centre").css("width","100%");
	}

});
function check(form) {
		if (form.rubric.value == "") {
		alert("照片标题不能为空");
		return false;
	}
		if (form.brief.value == "") {
		alert("照片简介不能为空");
		return false;
	}
		if (form.contact.value == "") {
		alert("联系方式不能为空");
		return false;
	}
	if (form.photo.value = "") {
		alert("上传的图片不能为空");
		return false;
	}
		return true;
	}


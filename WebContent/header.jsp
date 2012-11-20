<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		$(".navi-center > a").hover(function(){
			$(this).css("color","#3181AF");
		},function(){
			$(this).css("color","#000000");
		});
		
		$('#slider').cycle({
			fx : 'fade',
			timeout : 1000,
			random : 1
		});
	});
</script>
<div class="banner">
	<div></br></div>
	<div class="banner-center">
		<div id="cyclepicture">
			<div id="slider">
				<div class="show"><img src="./images/slider01.png"></img></div>
				<div class="show"><img src="./images/slider02.png"/></div>
			</div>
		</div>
		<div id="announcement">
			<div id="announcement-content">
			最新公告：呼吸体验日，凡在本店购买吸氧机将赠送吸氧袋一个
			</div>
		</div>
		<div><div id="banner-logo">同康寿氧气机</div></div>
	</div>
</div>
<div class="navi">
	<div class="navi-center">
	<a href="./index.jsp">首页</a>
	<span>|</span>
	<a href="./productview.jsp">产品</a>
	<span>|</span>
	<a href="./about.jsp">简介</a>
	<span>|</span>
	<a href="./contact.jsp">关于</a>
	<a href="tencent://message/?uin=150191368&amp;Site=%D6%C7%C4%DC%BD%A8%D5%BE&amp;Menu=yes">
		<img border="0" alt="点击这里给我发消息" src="http://wpa.qq.com/pa?p=1:150191368:1">
	</a>
	</div>
</div>
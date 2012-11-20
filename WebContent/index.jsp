<%@page import="com.jam.productmanager.product.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.jam.productmanager.product.service.ProductManager"%>
<%@page import="com.jam.utils.SpringBeanUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制氧机</title>
<script type="text/javascript" src="/jquery/jquery.js"></script>
<script type="text/javascript" src="/jquery/jquery.cycle.all.js"></script>
<link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<%@ include file="header.jsp" %>
<style type="text/css">
#listTextRoll3 { background:#eee; height:60px; overflow:hidden;}
#listTextRoll3 li {}
</style>

<div class="content">
	<div class="content-center">
	<div id="listTextRoll3">
        <ul class="list">
          <li>&middot;<a href="#" target="_blank">文章标题文章标题文章标题01</a></li>
          <li>&middot;<a href="#" target="_blank">文章标题文章标题文章标题02</a></li>
          <li>&middot;<a href="#" target="_blank">文章标题文章标题文章标题03</a></li>
          <li>&middot;<a href="#" target="_blank">文章标题文章标题文章标题04</a></li>
          <li>&middot;<a href="#" target="_blank">文章标题文章标题文章标题05</a></li>
        </ul>
    </div>
    <script type="text/javascript">
	$(function(){
		var rollH=$("#listTextRoll3").height();
		var listH=$("#listTextRoll3 .list").height();
		if(listH>rollH){
			var martop=0;
			$("#listTextRoll3 .list").clone().attr("class","").appendTo("#listTextRoll3");
			function rollText(){
				martop++;
				if(martop>listH){
					martop=0;
					$("#listTextRoll3 .list").css("margin-top",-martop);
				}
				else{
					$("#listTextRoll3 .list").css("margin-top",-martop);
				}
			}
			var int=setInterval(rollText,50);
			$("#listTextRoll3").hover(
				function(){
					clearInterval(int);
				},
				function(){
					int=setInterval(rollText,50);
				}
			);
		}
	});
	</script>
	<%
		ProductManager productManager = (ProductManager)SpringBeanUtils.getBeanByName("productManager");
		
		List<Product> products = productManager.getProducts(0, 9);
		if(products != null) {
			for(Product product : products){
		%>
		<div class="product">
			<a class="product-item" href="/productAction!read.do?id=<%=product.getId() %>">
				<img class="product-image" alt="" src="/images/products/<%=product.getImagePath() %>"><br/>
				<p><%=product.getProductName() %></p>
				<p>零售价：￥<%=product.getPrice() %></p>
			</a>
		</div>
		<%
			}
		}
		%>
	</div>
</div>
<div class="contentbottom">
	<div class="contentbottom-center"></br></div>
</div>

<%@ include file="footer.jsp"%>
</body>
</html>
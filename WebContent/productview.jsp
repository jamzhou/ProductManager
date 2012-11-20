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
<div class="content">
	<div class="content-center">
		<div class="product-list">
			<table width="100%" cellpadding="20px" style="border-collapse:collapse;">
				<%
				int pageIndex = 0;
				String pageIndexStr = request.getParameter("pageIndex");
				if(pageIndexStr != null) {
					try{
						pageIndex = Integer.parseInt(pageIndexStr);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				ProductManager productManager = (ProductManager)SpringBeanUtils.getBeanByName("productManager");
				
				int count = productManager.getCountOfProducts();
				int pageCount = count/10 + 1;
				
				List<Product> products = productManager.getProducts(pageIndex, 10);
				if(products != null) {
					for(Product product : products){
				%>
				<tr style="border-bottom:1px solid #888;">
					<td class="product-images"><img alt="" src="/images/products/<%=product.getImagePath() %>" height="80px"></td>
					<td>
						<p><a href="/productAction!read.do?id=<%=product.getId() %>"><%=product.getProductName() %></a><p>
						<p><%=product.getDescription() %></p>
						<p>零售价:<%=product.getPrice() %></p>
					</td>
				</tr>
				<%
					}
				}
				%>
			</table>
		</div>
		<div class="page-tools">
			<a>共<%=pageCount %>页</a>
			<a>当前第<%=pageIndex+1 %>页</a>
			<%
			if(pageIndex > 0) { 
			%>
			<a href="./productview.jsp?pageIndex=<%=pageIndex-1 %>">上一页</a>
			<%
			}
			if(pageCount > 1) {
			%>
			<a href="./productview.jsp?pageIndex=<%=pageIndex+1 %>">下一页</a>
			<%
			}
			%>
		</div>
	</div>
</div>
<div class="contentbottom">
	<div class="contentbottom-center"><br/>
	</div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
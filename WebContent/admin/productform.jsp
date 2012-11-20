<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制氧机</title>
<script type="text/javascript" src="/jquery/jquery.js"></script>
<script type="text/javascript" src="/jquery/jquery.cycle.all.js"></script>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="/css/css.css" />
</head>
<body>
<%@ include file="header.jsp" %>
<div class="content">
	<div class="content-center">
		<s:form action="/productAction!save.do" method="post" enctype="multipart/form-data">
			<div class="product-form">
				<s:hidden id="id" name="id"/>
				<div><label>产品名称:</label><s:textfield id="procuctName" name="productName"/><br/></div>
				<div><label>产品价格:</label><s:textfield id="price" name="price"/><br/></div>
				<div><label>产品类别:</label><s:textfield id="category" name="category"/><br/></div>
				<div><label>产品特点和优点:</label><s:textarea id="characteristic" name="characteristic" rows="10" cssClass="product-form-textarea"></s:textarea><br/></div>
				<div><label>产品简介:</label><s:textarea id="description" name="description" rows="10" cssClass="product-form-textarea"></s:textarea><br/></div>
				<div><label>上传图片:</label><s:file name="productImage"/><br/></div>
			</div>
			<div class="product-form-submit"><input type="submit" value="      保存      " class="btn btn-large btn-primary"></div>
		</s:form>
	</div>
</div>
<div class="contentbottom">
	<div class="contentbottom-center"></br></div>
</div>
<%@ include file="footer.jsp" %>

<script src="/bootstrap/js/bootstrap.js"></script>

</body>
</html>
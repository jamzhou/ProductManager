<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
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
<link rel="stylesheet" type="text/css" href="/css/css.css" />
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap-responsive.css">
</head>
<body>
<%@ include file="header.jsp"%>
<div class="content">
	<div class="content-center">
		<div><h1 align="center"><s:property value="model.productName"/></h1></div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span7">
					<dl class="dl-horizontal">
						<div><dt>价钱：</dt><dl><s:property value="model.price"/></dl></div>
						<div><dt>特点：</dt><dl><s:property value="model.characteristic"/></dl></div>
						<div><dt>简介：</dt><dl><s:property value="model.description"/></dl></div>
					</dl>
				</div>
				<div class="span3" align="right">
					<img src="/images/products/${model.imagePath }" class="img-polaroid">
				</div>
			</div>
		</div>
	</div>
</div>
<div class="contentbottom">
	<div class="contentbottom-center"><br/>
	</div>
</div>
<%@ include file="footer.jsp"%>

<script src="/bootstrap/js/bootstrap.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加产品</title>
<script type="text/javascript" src="/jquery/jquery.js"></script>
</head>
<body>
<form action="productAction!save.do" method="post">
	产品名称：<input id="productName" name="productName" type="text"/></br>
	产品价格：<input id="price" name="price" type="text"/></br>
	产品类别：<input id="category" name="category" type="text"/></br>
	产品特点：<textarea  id="characteristic" name="characteristic" ></textarea></br>
	产品介绍：<textarea  id="description" name="description" ></textarea></br>
	<input type="submit" value="保存">
</form>
</body>
</html>
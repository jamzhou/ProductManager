<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form action="/userLoginAction!login.do" method="post">
		<div class="container-fluid">
			<div class="row-fluid">
			    <div class="span4"></div>
			    <div class="span8">
			    	<div class="row">
					  <div class="span2" align="right">UserName:</div>
					  <div class="span3"><input type="text" id="username" name="username"/></div>
					</div>
					<div class="row">
					  <div class="span2" align="right">Password:</div>
					  <div class="span3"><input type="password" id="password" name="password"></div>
					</div>
					<div class="row">
						<div class="span2" align="right"></div>
						<div class="span4">
							<div class="control-group error">
								<div class="controls">
									<button class="btn btn-large btn-primary" type="submit">登录</button>
									<%
										String e = request.getParameter("errorType");
										if(e != null && e.equals("1")){
									%>
									<span class="help-inline">用户名或密码错误</span>
									<%		
										}
									%>
								</div>
							</div>
						</div>
						</div>
					</div>
			    </div>
			</div>
		</div>
		</form>
	</div>
</div>
<div class="contentbottom">
	<div class="contentbottom-center"></br></div>
</div>
<%@ include file="./footer.jsp" %>

<script src="/bootstrap/js/bootstrap.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" +request.getServerName()+":"+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登陆</title>
<script type="text/javascript">

	//Ajax编程第一步 ，创建 XMLHttpRequest
	var xmlHttp;
	function createXMLHttpRequest(){
		try {
	         xmlHttp = new XMLHttpRequest();
	    } catch (tryMS) {
	        try {
	             xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	        } catch (otherMS) {
	            try {
	                 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	           } catch (failed) {
	                 xmlHttp = null;
		        // 这里可以报一个错误，无法获得 XMLHttpRequest对象	
	           }
	        }
	     }
	    
	    return xmlHttp;
	} 
	
	// 采用异步方式 访问服务器，获取用户名是否有效信息
	function validateUsername(){
		// 第一步 
		createXMLHttpRequest();
		// 第二步 绑定状态触发器 到 函数上
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				document.getElementById("showmsg").innerHTML = xmlHttp.responseText;
			}
		}
		// 第三步 建立与服务器目标资源连接
		var username = document.getElementById("username").value;
		xmlHttp.open("GET","/Shopping-Online/CheckUsernameServlet.htm?username="+username,true);
		xmlHttp.send();
	}
	
</script>
</head>
<body>
	<form action="<%=basePath%>CheckManagerLoginServlet.htm">
		用户名 <input type="text" name="username" id="username" onblur="validateUsername()"/><span id="showmsg"></span><br /> 
		密码 <input type="password" name="password" id="password" /><br /> 
		<input type="submit" value="登陆" />
	</form>
</body>
</html>
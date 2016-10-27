<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="<%=basePath%>resources/css/mysheet.css">
</head>
<body>
	<div class="header">
		<div class="logo">
			<Strong><p>管理员系统</p></Strong>
		</div>
		<div class="lg">
			<a href="manager_login.jsp">登陆</a>
		</div>
	</div>
	<div class="main">
		<div class="lefter">
			<div class="menu-list">
				<div class="menu">
					<span>我的功能菜单</span>
				</div>
				<div class="menu-css">
					<div>
						<i class="icon menu-icon "></i> <a
							href="<%=basePath%>manager_main.jsp" target="rightContent">产品信息</a>
					</div>
				</div>
				<div class="menu-css">
					<div>
						<i class="icon menu-icon "></i> <a
							href="<%=basePath%>SellerDetailServlet.htm" target="rightContent">卖家信息</a>
					</div>
				</div>
				<div class="menu-css">
					<div>
						<i class="icon menu-icon"></i> <a
							href="<%=basePath%>manager_order.jsp" target="rightContent">订单信息</a>
					</div>
				</div>

			</div>
		</div>
		<div class="righter">
			<iframe src="<%=basePath%>manager_main.jsp" width="1118px"
				height="900px" frameborder="0" name="rightContent"></iframe>
		</div>
	</div>


</body>
</html>
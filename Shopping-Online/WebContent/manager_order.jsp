<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*,net.sf.json.*,net.sf.json.util.JSONTokener"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>manager_main</title>
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	var xmlHttp;

	function createXMLHttpRequest() {
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
				}
			}
		}

		return xmlHttp;
	}

	function showProduct(str) {
		createXMLHttpRequest();
		var s = "";
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

				var dataArray = JSON.parse(xmlHttp.responseText);
				//var dataArray = eval("(" + xmlHttp.responseText + ")");
				for (var i = 0; i < dataArray.length; i++) {
					var data = dataArray[i];
					if (data != null)
						s = s
								+ "<tr><td><input type=\"checkbox\" name=\"id\" /></td>"
								+ "<td>" + data.order_id + "</td>" + "<td>"
								+ data.user_name + "</td>" + "<td>"
								+ data.product_name + "</td>" + "<td>"
								+ data.total_price + "</td>" + "<td>"
								+ data.order_card + "</td>" + "<td>"
								+ data.product_state + "</td></tr>";
				}
				document.getElementById("detail").innerHTML = s;
			}
		}
		xmlHttp.open("GET", "/Shopping-Online/OrderDetailServlet.htm?state=" + str,
				true);
		xmlHttp.send();
	}
</script>
</head>
<body style="background: #e1e9eb;">

	<form action="" id="mainForm">
		<div class="right">
			<div class="current">
				当前位置：<a href="javascript:void(0)" style="color: #6E6E6E;">管理界面</a>
				&gt; 订单详情
			</div>
			<div class="rightCont">

				<table class="tab1">
					<tbody>
						<tr>
							<td><select name="status"
								onchange="showProduct(this.value)">
									<option value="all">所有订单</option>
									<option value="1">未发货</option>
									<option value="2">发货</option>
							</select></td>
						</tr>
					</tbody>
				</table>

				<div class="zixun fix ">
					<table class="tab2" width="100%">
						<thead>
							<tr>
								<th><input type="checkbox" id="all" onclick="" /></th>
								<th>id</th>
								<th>用户</th>
								<th>商品</th>
								<th>总价</th>
								<th>订单号</th>
								<th>订单状态</th>
							</tr>

						</thead>
						<tbody id="detail">

						</tbody>
					</table>
				</div>
			</div>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.shopping.model.SellerDetail"%>
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
<script src="<%=basePath%>resources/js/jquery-1.8.0.min.js"></script>
</head>
<body style="background: #e1e9eb;">

	<form action="" id="mainForm">
		<div class="right">
			<div class="current">
				当前位置：<a href="javascript:void(0)" style="color: #6E6E6E;">管理界面</a>
				&gt; 卖家详情
			</div>
			<div class="rightCont">
				<div class="zixun fix ">
					<table class="tab2" width="100%">
						<thead>
							<tr>
								<th><input type="checkbox" id="all" onclick="" /></th>
								<th>id</th>
								<th>姓名</th>
								<th>店铺</th>
								<th>身份证</th>
								<th>电话</th>
								<th>住址</th>
							</tr>

						</thead>
						<tbody id="detail">
							<%
								List<SellerDetail> list = (List<SellerDetail>) session.getAttribute("sellerDetail");
								if (list != null && list.size() > 0) {
									for (int i = 0; i < list.size(); i++) {
										SellerDetail seller = list.get(i);
							%>
							<tr>
								<td><input type="checkbox" id="all" onclick="" /></td>
								<td><%=seller.getSeller_id()%></td>
								<td><%=seller.getSeller_realName()%></td>
								<td><%=seller.getStore_name()%></td>
								<td><%=seller.getSeller_IdCard()%></td>
								<td><%=seller.getSeller_phone()%></td>
								<td><%=seller.getSeller_address()%></td>
							</tr>
							<%
								}
								}
							%>

						</tbody>
					</table>
				</div>
			</div>
	</form>

</body>
</html>
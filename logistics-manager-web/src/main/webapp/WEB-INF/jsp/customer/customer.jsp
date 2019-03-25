<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li class="click">
					<a href="userUpdate">
						<span>
								<img src="/images/t01.png" />
						</span>
						添加
					</a>
				</li>
				<li class="click"><span><img src="/images/t02.png" /></span>修改</li>
				<li><span><img src="/images/t03.png" /></span>删除</li>
				<li><span><img src="/images/t04.png" /></span>统计</li>
			</ul>
			<ul class="toolbar1">
				<li><span><img src="/images/t05.png" /></span>设置</li>
			</ul>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
					<th>编号<i class="sort"><img src="/images/px.gif" /></i></th>
					<th>客户姓名</th>
					<th>客户电话</th>
					<th>邮箱</th>
					<th>性别</th>
					<th>业务员</th>
					<th>常用区间</th>
					<th>身份证号</th>
					<th>通讯地址</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageModel.list }" var="dto">
					<tr>
						<td><input name="" type="checkbox" value="" /></td>
						<td>${dto.customer.customerId }</td>
						<td>${dto.customer.customerName }</td>
						<td>${dto.customer.mobilePhone }</td>
						<td>${dto.customer.email }</td>
						<td>${dto.customer.cSex eq true?"男":"女" }</td>
						<td>${dto.salesMan }</td>
						<td>${dto.interval }</td>
						<td>${dto.customer.idCard}</td>
						<td>${dto.customer.address }</td>
						<td>
							<a href="/customer/customerUpdate?id=${dto.customer.customerId }" 
							class="tablelink">修改</a> 
							<shiro:hasAnyRoles name="业务员,操作员">
								<c:if test="${dto.orderNum eq 0 }">
									<a href="javascript:void(0)" onclick="deleteUser(${dto.customer.customerId})" 
									class="tablelink"> 删除</a></td>
								</c:if>
							</shiro:hasAnyRoles>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<div class="inline pull-right page" style="margin-top: 20px;">
				<form action="/user/queryPage" id="pager">
					<input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize }">
					<input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum }">
				</form>
				<jsp:include page="/pageBar.jsp"></jsp:include>
			</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		function deleteUser(userId){
			if(window.confirm("确定要删除该用户吗?")){
				location.href="/customer/delete?id="+userId;
			}
		}
	</script>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout>
	
	<jsp:attribute name="header">
		<!--header content here-->
	</jsp:attribute>

	<jsp:attribute name="footer">
		<div class='container'>
			Footer Test<br>
		</div>
	</jsp:attribute>
	
	<jsp:attribute name="script">
		<script>
			console.log("123");
		</script>
	</jsp:attribute>
	
	<jsp:body>
		<div ng-controller='BASE'>
			${pageContext.request.contextPath}<br>
			Body Test<br>
			${msg}<br>
			<button ng-click="send_post()">POST</button><br>
			<button ng-click="send_put()">PUT</button><br>
			<button ng-click="send_delete()">DELETE</button>
		</div>
	</jsp:body> 
	
</t:layout>

<%
    /*String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	out.print(basePath);*/
%>

<script>

	var app = angular.module("Embedded",[]);
	app.controller("BASE",baseFunc);
	
	function baseFunc($scope,$http,$location){
		$scope.send_post = function(){
			$http({
				method:'POST',
				url:$location.absUrl(),
				data:$.param({key:"987",key2:"k555",key3:"ey99"}),
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).then(function success(msg){
				console.log(msg);
			},function error(err){
				console.log(err);
			});
		}
		
		$scope.send_put = function(){
			$http({
				method:'PUT',
				url:$location.absUrl(),
				data:$.param({key:"987",key2:"k555",key3:"ey99"}),
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).then(function success(msg){
				console.log(msg);
			},function error(err){
				console.log(err);
			});
		}
		
		$scope.send_delete = function(){
			$http({
				method:'DELETE',
				url:$location.absUrl(),
				data:$.param({key:"987",key2:"k555",key3:"ey99"}),
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).then(function success(msg){
				console.log(msg);
			},function error(err){
				console.log(err);
			});
		}
	}
	
	
	
</script>
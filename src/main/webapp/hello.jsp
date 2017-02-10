<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout>
	
	<jsp:attribute name="header">
		<!--header content here-->
	</jsp:attribute>
	
	<jsp:attribute name="script">
		<script>
			console.log("123");
		</script>
	</jsp:attribute>
	
	<jsp:body>
		<div>
			<a href='${path}/chat'>Chat</a>
		</div>
		<div ng-controller='BASE'>
			<div class='row'>
				<div class='col-md-6'>
					${ori}<br>
				</div>
				<div class='col-md-6'>
					${note}
				</div>
			</div>
			<div>
				<h4>From Remote Postgres Data</h4>
					${dbdata}<br>
			</div><br>
			<div class='row'>
				<div class='col-md-3'>
					<button class='btn' ng-click="send_post()">POST</button><br>
					{{Dpost}}
				</div>
				<div class='col-md-3'>
					<button class='btn' ng-click="send_put()">PUT</button><br>
					{{Dput}}
				</div>
				<div class='col-md-3'>
					<button class='btn' ng-click="send_delete()">DELETE</button><br>
					{{Ddelete}}
				</div>
				<div class='col-md-3'>
					<button class='btn' ng-click="send_mail()">MAIL</button><br>
					{{Dmail}}
				</div>
			</div>
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
		$scope.Dpost = "";
		$scope.Dput = "";
		$scope.Ddelete = "";
		$scope.Dmail = "";
		
		$scope.send_post = function(){
			$http({
				method:'POST',
				url:$location.absUrl(),
				data:$.param({key:"987",key2:"k555",key3:"ey99"}),
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).then(function success(msg){
				console.log(msg);
				$scope.Dpost = {
					data:msg.data,
					method:msg.config.method,
				};
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
				$scope.Dput = {
					data:msg.data,
					method:msg.config.method,
				};
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
				$scope.Ddelete = {
					data:msg.data,
					method:msg.config.method,
				};
			},function error(err){
				console.log(err);
			});
		}
		
		$scope.send_mail = function(){
			$http({
				method:'POST',
				url:$location.absUrl(),
				data:$.param({key:"mail",key2:"Tomcat Mail",key3:"This is test"}),
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).then(function success(msg){
				console.log(msg);
				$scope.Dmail = {
					data:msg.data,
					method:msg.config.method,
				};
			},function error(err){
				console.log(err);
			});
			
			console.log("999");
			
		}
		
	}
	
	
	
</script>
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
			<a href='/chat'>Chat</a><!--${path}-->
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
			<br>
			<div class='thumbnail'>
				<br> <b><large>RSA Demo (put some text in Encrypt textarea, then click Encrypt button): </large></b><br>
				<div class='row break'>
					<div class='col-md-6'>
						<b>Encrypt :</b><br>
						<textarea ng-model='encry' class='form-control'></textarea>
						<input type='button' class='btn' ng-click="doEncry()" value='Encrypt'/>
						<div>{{encry_data}}</div>
					</div>
					<div class='col-md-6'>
						<b>Decrypt :</b><br>
						<textarea ng-model='decry' class='form-control'></textarea>
						<input type='button' class='btn' ng-click="doDecry()" value='Decrypt'/>
						<div>{{decry_data}}</div>
					</div>
				</div>
				<br><hr><br>
				<br> <b><large>RSA Keys: </large></b><br>
				<div class='row break'>
					<br><br>
					<div class='col-md-4'>
						<b>Public Key:</b><br>
						${pb}
					</div>
					<div class='col-md-8'>
						<b>Private Key:</b><br>
						${pv}
					</div>
				</div>
				<br>
			</div>
			<div class="modal fade" id="sendmail" tabindex="-1" role="dialog" style="" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">Mail Sender (to author) <b compile='sender.result'></b></h4>
						</div>
						<div class="modal-body">
							<form name='myForm'>
							<div class='row'>
								<div class='col-md-3'>Your Name</div>
								<div class='col-md-6'><input type='text' class='form-control' name='name' placeholder='name...' ng-model='sender.name' required></div>
							</div>
							<br>
							<div class='row'>
								<div class='col-md-3'>Your Mail</div>
								<div class='col-md-6'><input class='form-control' name='email' type='email' placeholder='email...' ng-model='sender.mail' required></div>
							</div>
							<br>
							<div class='row'>
								<div class='col-md-3'>Content</div>
								<div class='col-md-6'><textarea class='form-control' name='content' placeholder='content...' ng-model='sender.content' required></textarea></div>
							</div>
							<button type='submit' ng-click="do_mail()" class='btn pull-right'>Send</button>
							<br><br>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
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
<style>
.error{
	font-weight:bold;
	color:red;
	font-size:12px;
}
.break{
	word-break:break-all;
}
</style>
<script>

	var app = angular.module("Embedded",[]);
	app.controller("BASE",baseFunc);
	app.directive("compile",['$compile',function($compile){
		return function(scope,element,attrs){
			scope.$watch(
				function(scope){
					// watch the 'compile' expression for changes
					return scope.$eval(attrs.compile);
				},
				function(value){
					// when the 'compile' expression changes
					// assign it into the current DOM
					element.html(value);
					// compile the new DOM and link it to the current
					// scope.
					// NOTE: we only compile .childNodes so that
					// we don't get into infinite loop compiling ourselves
					$compile(element.contents())(scope);
				},true
			);
		};
	}]);
	function baseFunc($scope,$http,$location){
		$scope.Dpost = "";
		$scope.Dput = "";
		$scope.Ddelete = "";
		$scope.Dmail = "";
		
		$scope.public = "";
		
		$scope.encry_data = "";
		$scope.decry_data = "";
		
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
			$scope.sender = {mail:"",content:"",name:"",result:""};
			$("#sendmail").modal('show');
		}
		
		$scope.do_mail = function(){
			//console.log($scope.myForm.$valid);
			//console.log($scope.myForm.email.$valid);
			if($scope.myForm.$valid){
				if(confirm("Sure send a mail to author?")){
					$http({
						method:'POST',
						url:$location.absUrl(),
						data:$.param({key:"mail",key2:$scope.sender.mail,key3:$scope.sender.content,key4:$scope.sender.name}),
						headers: {'Content-Type': 'application/x-www-form-urlencoded'}
					}).then(function success(msg){
						console.log(msg);
						if(msg.data == "Success"){
							$scope.sender.result = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style='color:blue;'>Success Sended</b>";
						}else{
							$scope.sender.result = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style='color:red;'>Fail ... </b>";
						}
					},function error(err){
						console.log(err);
					});
				}
			}
		}
		
		$scope.doEncry = function(){
			//console.log($scope.encry);
			$http({
				method:'POST',
				url:$location.absUrl(),
				data:$.param({key:"encrypt",key2:$scope.encry}),
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).then(function success(msg){
				$scope.encry_data = msg.data;
				$scope.decry = "["+msg.data+"]";
			},function error(err){
				console.log(err);
			});
		}
		
		$scope.doDecry = function(){
			//console.log($scope.decry);
			$http({
				method:'POST',
				url:$location.absUrl(),
				data:$.param({key:"decrypt",key2:$scope.decry}),
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).then(function success(msg){
				$scope.decry_data = msg.data;
			},function error(err){
				console.log(err);
			});
		}
		
		
	}
	
	
	
</script>
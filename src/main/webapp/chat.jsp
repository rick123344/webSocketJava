<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout>
	
	<jsp:attribute name="header">
		<!--header content here-->
	</jsp:attribute>
	
	<jsp:attribute name="script">
		<script>
			//console.log("123");
		</script>
	</jsp:attribute>
	
	<jsp:body>
		
		<div ng-controller='CHAT' id='main'>
			<div class='row'>
				<div class='col-md-6'>
					<div class='thumbnail area' id='chatmsg'>
						<ul class='list-unstyled'>
							<li ng-repeat="message in allmsg track by $index" compile="message">
						</ul>
					</div>
					<div class=''>
						<div class='col-md-8'>
							<input type='text' class='form-control' ng-model='newmsg' ng-keyup="go($event,'keycode')" />
						</div>
						<input type='button' class='btn' value='Send' ng-click="go($event,'btn')">
					</div>
				</div>
				<div class='col-md-6'>
					<div class='thumbnail area'>
						<a href='/page1'>Page1</a>
						
						<div class=''>
							
							<br>This test web base on <b>Tomcat Embed.</b><br>
							Using <b>maven</b> to manage all sources.<br>
							Annotation path (Without web.xml).<br><br>
							
							In "<a href='/page1'>/page1</a>" , test the UTF-8 encode.<br>
							1. "From Remote Postgres Data" area datas, they come from Amazan cloud Database base on Postgres.<br>
							2. "POST" button is ajax post method,<br>
							3. "PUT" button is ajax put method,<br>
							4. "DELETE"  button is ajax delete method,<br>
							5. "MAIL" button is ajax post method and will send a mail to me.<br>
							<br>
							In "<a href='/chat'>"/chat</a> , test the socket using tomcat embed websocket.<br>
							<br>
							Above web using jsp template <b>view</b>, servlet <b>controller</b>, and connect <b>model</b><br>
							Base AngularJs using, Base socket using, Base taglibs using.
							
						</div>
						
					</div>
				</div>
			</div>
			<div class='row'>
				<div class='col-md-6'>
					
				</div>
				<div class='col-md-6'>
					
				</div>
			</div>
		</div>
	</jsp:body> 
	
</t:layout>
<script src="${pageContext.request.contextPath}/public/js/jsencrypt.min.js"></script>
<style>
#main{
	height:100%;
	//background-color:#dddddd;
}
.area{
	min-height:500px;
	max-height:500px;
	overflow:auto;
}

.blockA{
	width:50%;
	display:inline-block;
}
.blockB{
	width:50%;
	display:inline-block;
}
.blockB>span,.blockA>span{
	-moz-border-radius: 15px;
	border-radius: 15px;
	font: 16px Arial, sans-serif;
	padding:8px;
	word-break: break-all;
	font-weight:bold;
}
.blockB>span{
	float:right;
	background-color:#53f442;
}
.blockA>span{
	float:left;
	background-color:#42f1f4;
}

</style>
<script>

	var app = angular.module("Embedded",[]);
	app.controller("CHAT",baseFunc);
	
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
	
	function baseFunc($scope,$http,$location,$sce,$timeout){
		
		$scope.allmsg=[];
		$scope.newmsg = "";
		
		/*$scope.privateKey = "";
		$scope.encrypt = new JSEncrypt();
        $scope.encrypt.setPublicKey("");
        var tmp = $scope.encrypt.encrypt("abc");
		console.log(tmp);
		
		$scope.decrypt = new JSEncrypt();
		$scope.decrypt.setPrivateKey($scope.privateKey);
		console.log($scope.decrypt.decrypt(tmp));
		*/
		
		$scope.go = function(e,type){
			if(e.keyCode!='13'&&type=='keycode'){
				return;
			}
			if($scope.newmsg!=""){
				$scope.postToServer();
				$scope.newmsg = "";
			}
		}
		
		
		
		$scope.$watch("allmsg",function(newValue,oldValue){
			var out=document.getElementById("chatmsg");
			var isScrolledToBottom = out.scrollHeight - out.clientHeight <= out.scrollTop + 1;
			$timeout(function(){
				//get correct scrollHeight must wait for dom is ready ($timeout)
				if(isScrolledToBottom)
					out.scrollTop = out.scrollHeight;
			},0);
		},true);
		
		var ws = "wss://";
		if(document.location.protocol == "http:"){
			ws = "ws://";
		}
		var wsUri = ws + document.location.host + "/ws";
		//console.log(wsUri);
		var ws = new WebSocket(wsUri);
		ws.onopen = function(){
			//console.log("Connected");
		};
		ws.onmessage = function(message){
			//console.log(message.data);
			var tmp = JSON.parse(message.data);
			$scope.allmsg.push(tmp.msg);
			$scope.$apply();
		};
		$scope.postToServer = function(){
			ws.send($scope.newmsg);
			$scope.newmsg = "";
		}
		$scope.closeConnect = function(){
			ws.close();
			//console.log("Close Ws");
		}
		
	}
	
</script>
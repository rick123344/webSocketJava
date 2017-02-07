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
		
		<div ng-controller='CHAT' id='main'>
			<div class='row'>
				<div class='col-md-6'>
					<div class='thumbnail area' id='chatmsg'>
						<ul class='list-unstyled'>
							<li ng-repeat="message in allmsg track by $index" compile="message">
						</ul>
					</div>
				</div>
				<div class='col-md-6'>
					<div class='thumbnail area'>
						<a href='${path}/page1' target='_blank'>Page1</a>
					</div>
				</div>
			</div>
			<div class='row'>
				<div class='col-md-6'>
					<div class='col-md-8'>
						<input type='text' class='form-control' ng-model='newmsg' ng-keyup="go($event,'keycode')" />
					</div>
					<input type='button' class='btn' value='Send' ng-click="go($event,'btn')">
				</div>
				<div class='col-md-6'>
					
				</div>
			</div>
		</div>
	</jsp:body> 
	
</t:layout>

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
		$scope.allmsg=['<div class="blockA"><span>a</span></div><div class="blockB"></div>',
		'<div class="blockA"></div><div class="blockB"><span>b</span></div>',
		'<div class="blockA"><span>c</span></div><div class="blockB"></div>',
		'<div class="blockA"></div><div class="blockB"><span>d</span></div>'];
		$scope.newmsg = "";
		
		$scope.go = function(e,type){
			if(e.keyCode!='13'&&type=='keycode'){
				return;
			}
			if($scope.newmsg!=""){
				$scope.allmsg.push('<div class="blockA"><span>'+$scope.newmsg+'</span></div><div class="blockB"></div>');
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
		
	}
	
</script>
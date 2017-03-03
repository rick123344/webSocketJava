<html>
	<head>
		<title>Index Demo</title>
		<link href="/public/css/bootstrap.min.css" rel="stylesheet"/>
		<script src="/public/js/jquery.min.js"></script>
		<script src="/public/js/angular1.5.8.min.js"></script>
		<script src="/public/js/bootstrap.min.js"></script>
	</head>
    <body>
		<div class='container'> 
			<h2>Hello Rick!</h2>
			<div>
			<a href='/page1'>Page1</a><br>
			<a href='/chat'>Chat</a><br>
			</div>
			<br>
			<#list lang as l>
				${l}<br>
			</#list>
			hihihi
		</div>
    </body>
</html>
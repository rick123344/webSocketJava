<%@tag description="Overall" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="script" fragment="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Tomcat Embedded</title>
		<link href="${pageContext.request.contextPath}/public/css/bootstrap.min.css" rel="stylesheet"/>
		<script src="${pageContext.request.contextPath}/public/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/public/js/angular1.5.8.min.js"></script>
		<script src="${pageContext.request.contextPath}/public/js/bootstrap.min.js"></script>
		<div id='pageheader'>
			<jsp:invoke fragment="header"/>
		</div>
    </head>
    <body ng-app='Embedded'>
		<div id='body' class='container'>
			<div class='jumbotron'>
				<h2>Tomcat Embedded</h2> 
			</div>
			<jsp:doBody/>
		</div>
    </body>
	<!--<foot class='navbar navbar-default navbar-fixed-bottom'>
		<div class='container'>
			Footer Test Message: <strong>${message}</strong>
		</div>
		<jsp:invoke fragment="footer"/>
	</foot>-->
	<style>
		
	</style>
	<jsp:invoke fragment="script"/>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<title>${param.title}</title>
<link rel="stylesheet"
	href="<c:url value="/static/vendor/bootstrap-3.3.7/css/bootstrap.min.css" />" />
<script type="text/javascript"
	src="<c:url value="/static/vendor/jquery/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/static/vendor/bootstrap-3.3.7/js/bootstrap.min.js" />"></script>
<style type="text/css">
.container-width-500 {
	max-width: 500px;
}

html, body {
	height: 100%;
}

html {
	display: table;
	margin: auto;
}

body {
	display: table-cell;
	vertical-align: middle;
}
</style>
<script type="text/javascript">
	setTimeout(function() {
		$('#validationErrors').alert('close');
	}, 10000);
</script>
</head>

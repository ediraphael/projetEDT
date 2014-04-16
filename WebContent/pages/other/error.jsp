<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<link rel="stylesheet" href="./css/pageCss/css/mainstyle.css" type="text/css" />
		<title><s:text name="title.error"/></title>
	</head>
	<body>
		<div id="wrap">
			<%@ include file="../other/applicationName.jsp" %>
			<%@ include file="../other/menuAdmin.jsp" %>
			<div id="content-top"></div>
			<div id="content-middle">
				<h1><s:text name="title.error"/></h1><br/>
			    <p class="errorBigCenter"><s:text name="label.error.contactus"/></p>
			    <p class="mailError">
			    	<a href="mailto:<s:text name="mail.coffinet"/>"><s:text name="mail.coffinet"/></a><br/>
			    	<a href="mailto:<s:text name="mail.fardilha"/>"><s:text name="mail.fardilha"/></a><br/>
			    	<a href="mailto:<s:text name="mail.gauthier"/>"><s:text name="mail.gauthier"/></a><br/>
			    	<a href="mailto:<s:text name="mail.pillie"/>"><s:text name="mail.pillie"/></a><br/><br/>
			    </p>
				<div class="error"><span><s:text name="label.error.exception"/></span></div>
				<p><s:property value="error.errorMessage"/></p>
			    <div class="error"><span><s:text name="label.error.stacktrace"/></span></div>
				<p><s:property value="error.errorTraces"/></p><br/>
			</div>
			<div id="content-bottom"></div>
		</div>
	</body>
</html>
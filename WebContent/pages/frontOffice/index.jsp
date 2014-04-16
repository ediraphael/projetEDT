<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<link rel="stylesheet" href="./css/pageCss/css/mainstyle.css" type="text/css" />
		<title><s:text name="title.home"/></title>
	</head>
	<body>
		<div id="wrap">
			<%@ include file="../other/applicationName.jsp" %>
			<s:if test="#session.user!=null">
				<% response.sendRedirect("ShowCalendar");	%> 
			</s:if>
			<div id="content-top"></div>
			<div id="content-middle">
				<h1><s:text name="title.home"/></h1><br/>
				<s:actionerror cssClass="errorCenter" />
				<table  class="indexLink">
					<tr><td> </td></tr>
					<tr>
						<td><s:a action="Login"><s:text name="label.login"/></s:a></td>
					</tr>
					<tr><td> </td></tr>
					<tr>
						<td><s:a action="InscriptionForm"><s:text name="label.register"/></s:a></td>
					</tr>
					<tr><td> </td></tr>
					<tr>
						<td><s:a action="ShowCalendar"><s:text name="label.view_calendar"/></s:a></td>
					</tr>
				</table>
				<div class="clear"></div>
			</div>
			<div id="content-bottom"></div>
		</div>
	</body>
</html>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
		<link rel="stylesheet" href="./css/pageCss/css/mainstyle.css" type="text/css" />
		<title><s:text name="title.login"/></title>
	</head>
	<body>
		<div id="wrap">
			<%@ include file="../other/applicationName.jsp" %>
			<div id="content-top"></div>
			<div id="content-middle">
				<s:form action="LoginAction" method="post">
					<h1><s:text name="title.login"/></h1>
					<s:actionerror cssClass="errorCenter" />
					<table>
						<tr><td> </td></tr>
						<tr>
							<td><s:text name="label.email"/></td>
							<td><s:textfield name="userBean.email"/></td>
							<td class="error"><s:fielderror fieldName="error.email"/></td>
						</tr>
						<tr><td> </td></tr>
						<tr>
							<td><s:text name="label.password"/></td>
							<td><s:password name="userBean.password"/></td>
							<td class="error"><s:fielderror fieldName="error.password"/></td>
						</tr>
					</table>
					<br/>
					<s:submit key="label.valide"  cssClass="user_button"/>	
				</s:form>
				<div class="clear"></div>
			</div>
			<div id="content-bottom"></div>
		</div>
	</body>
</html>


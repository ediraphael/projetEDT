<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<s:head theme="simple" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title><s:text name="title.login"/></title>
	</head>
	<body>
		<h1><s:text name="title.login"/></h1>
		<s:actionerror />
		<s:form action="LoginAction" method="post">
			<s:textfield name="userBean.email" key="label.email"/>
			<s:fielderror fieldName="error.email" />
			<s:password name="userBean.password" key="label.password"/>
			<s:fielderror fieldName="error.password" />
			<s:submit key="label.valide"/>
		</s:form>
	</body>
</html>


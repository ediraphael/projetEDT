<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title><s:property value="getText('title.home')"/></title>
</head>

<body>
<h1><s:property value="getText('title.home')"/></h1>
<s:property value="#session.user.email" />

<a href="<s:url action='Login'/>"><s:property value="getText('label.login')"/></a>
<a href="<s:url action='Inscription'/>"><s:property value="getText('label.register')"/></a>
<a href="<s:url action='AfficherCalendrier'/>"><s:property value="getText('label.view_calendar')"/></a>

</body>
</html>

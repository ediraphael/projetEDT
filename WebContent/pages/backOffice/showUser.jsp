<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<s:head theme="simple" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title><s:text name="title.show.user"/></title>
	</head>
	<body>
		<%@ include file="../other/menuAdmin.jsp" %>
		<h1><s:text name="title.show.user"/></h1>
		<table>
			<tr>
				<th><s:text name="label.id"/></th>
				<th><s:text name="label.email"/></th>
				<th><s:text name="label.firstname"/></th>
				<th><s:text name="label.name"/></th>
				<th><s:text name="label.group"/></th>
			</tr>
			<s:iterator value="listUserBean" id="group">
				<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="email"/></td>
					<td><s:property value="firstname"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="nameGroup"/></td>
					<td>
						<s:url id="url" action="DeleteUser">
							<s:param name="id"><s:property value="id"/></s:param>
					    </s:url>
					    <s:a href="%{url}"><s:text name="label.delete"/></s:a>
				    </td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:property value="getText('title.schedule')"/></title>
</head>
<body>
	<h2>Struts 2 - Classroom show</h2>
	<table>
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th></th>
			<th></th>
		</tr>
	<s:iterator value="listClassroomBean" id="classroom">
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="name"/></td>
			<td>
				<s:url id="url" action="getClassroom">
					<s:param name="id"><s:property value="id"/></s:param>
			    </s:url>
			    <s:a href="%{url}"><s:property value="getText('action.update')"/></s:a>
			</td>
			<td>
				<s:url id="url" action="ClassroomDelete">
					<s:param name="id"><s:property value="id"/></s:param>
			    </s:url>
			    <s:a href="%{url}"><s:property value="getText('action.delete')"/></s:a>
			</td>
		</tr>
	</s:iterator>
	</table>
</body>
</html>
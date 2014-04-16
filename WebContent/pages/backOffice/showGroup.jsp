<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<link rel="stylesheet" href="./css/pageCss/css/mainstyle.css" type="text/css" />
		<title><s:text name="title.show.group"/></title>
	</head>
	<body>
		<div id="wrap">
			<%@ include file="../other/applicationName.jsp" %>
			<s:if test="#session.user.nameGroup=='Enseignant'">
				<%@ include file="../other/menuAdmin.jsp" %>
			</s:if>
			<s:else>
				<%@ include file="../other/menuEtu.jsp" %>
			</s:else>
			<div id="content-top"></div>
			<div id="content-middle">
				<h1><s:text name="title.show.group"/></h1>
				<table>
					<tr>
						<th><s:text name="label.name"/></th>
						<th></th>
					</tr>
					<s:iterator value="listGroupBean" id="group">
						<tr>
							<s:if test="%{id<=2 }">
								<td><s:property value="name"/></td>
								<td class="bine">
									<a href="#">
										<img src="./css/pageCss/images/btn_info.png" alt="<s:text name="label.info"/>" width="20px"  title="<s:text name="label.group.info"/>"/>
									</a>
								</td>
							</s:if>
							<s:else>
								<s:url id="url" action="GetGroup">
									<s:param name="id"><s:property value="id"/></s:param>
							    </s:url>
								<td><s:a href="%{url}"><s:property value="name"/></s:a></td>
								<td class="bine">
									<s:url id="url" action="DeleteGroup">
										<s:param name="id"><s:property value="id"/></s:param>
								    </s:url>
								    <s:a href="%{url}">
								    	<img src="./css/pageCss/images/btn_corbeille.png" alt="<s:text name="label.delete"/>" width="20px"  title="<s:text name="label.delete"/>" />
								    </s:a>
							    </td>
						    </s:else>
						</tr>
					</s:iterator>
				</table>
				<br/><s:url id="url" action="GroupForm"/><s:a href="%{url}" cssClass="user_button"><s:text name="label.add"/></s:a>
				<div class="clear"></div>
			</div>
			<div id="content-bottom"></div>
		</div>
	</body>
</html>
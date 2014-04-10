<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script type='text/javascript' src='./javascript/utils/form.js'></script>
<title>Struts 2 - Inscription </title>
</head>

<body>
<h2>Struts 2 - Inscription </h2>
<s:actionerror />


<s:form action="InscriptionAction" method="post">
	<s:textfield name="userBean.firstName" key="label.firstname" size="20" />
	<s:fielderror fieldName="error.name" />
	<s:textfield name="userBean.name" key="label.name" size="20" />
	<s:fielderror fieldName="error.name"/>
	<s:select id="inscriptionGroup" label="Groupe" list="userBean.arrayGroupName" name="userBean.nameGroup" onchange="showPwdTeach()"/>
	<s:fielderror fieldName="error.group"/>
	<s:password   id="pwdTeach" name="userBean.teacherPassword" key="label.password.teacher" size="20" />
	<s:fielderror id="pwdTeachErr" fieldName="error.teacherpassword"/>
	<s:textfield name="userBean.email" key="label.email" size="20" />
	<s:fielderror fieldName="error.email"/>
	<s:password name="userBean.password" key="label.password" size="20" />
	<s:fielderror fieldName="error.password"/>
	<s:password name="userBean.confirmPassword" key="label.password.confirm" size="20" />
	<s:fielderror fieldName="error.confirmpassword"/>
	<s:submit method="execute" key="label.valide" align="center" />
</s:form>
</body>
</html>


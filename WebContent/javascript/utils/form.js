function hideField(id)
{
	document.getElementById(id).style.visibility="hidden";
}

function showField(id)
{
	document.getElementById(id).style.visibility="visible";
}

function showPwdTeach() 
{
	var groupIndex= document.getElementById('groupList').selectedIndex ;
	var groupValue= document.getElementById('groupList').options[groupIndex].value;
	if(groupValue!=1)
	{
		hideField('pwdTeacher');
	}
	else
	{
		showField('pwdTeacher');
	}
}


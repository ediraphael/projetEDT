function hideOrShowField(id,showOrHide)
{
	document.getElementById(id).style.display = showOrHide;
}

function showPwdTeach() 
{
	var groupIndex= document.getElementById('inscriptionGroup').selectedIndex ;
	var groupValue= document.getElementById('inscriptionGroup').options[groupIndex].value;
	if(groupValue!='Enseignant')
	{
		hideOrShowField('pwdTeach','none');
		hideOrShowField('pwdTeachErr','none');
	}
	else
	{
		hideOrShowField('pwdTeach','block');
		hideOrShowField('pwdTeachErr','block');
	}
}

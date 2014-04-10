package bean;

import java.util.List;

/**
 * Bean User
 * @author mickael
 *
 */
public class UserBean
{
	/**
	 * champs du formulaire
	 */
	private long id;
	private String firstName;
	private String name;
	private String email;
	private String password;
	private String confirmPassword;
	private String nameGroup;
	private String passwordTeacher;
	private List<String> arrayGroupName;

	public UserBean() 
	{
		super();
		this.id=0;
		this.firstName="";
		this.name="";
		this.email="";
		this.password="";
		this.confirmPassword="";
		this.nameGroup="";
		this.passwordTeacher="";
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public long getId() 
	{
		return id;
	}
	
	public void setId(long id) 
	{
		this.id = id;
	}
	
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getConfirmPassword() 
	{
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) 
	{
		this.confirmPassword = confirmPassword;
	}

	public String getNameGroup() 
	{
		return nameGroup;
	}

	public void setNameGroup(String nameGroup) 
	{
		this.nameGroup = nameGroup;
	}

	public String getPasswordTeacher()
	{
		return passwordTeacher;
	}

	public void setPasswordTeacher(String passwordTeacher)
	{
		this.passwordTeacher = passwordTeacher;
	}

	public List<String> getArrayGroupName() 
	{
		return arrayGroupName;
	}

	public void setArrayGroupName(List<String> arrayGroupName) 
	{
		this.arrayGroupName = arrayGroupName;
	}
}

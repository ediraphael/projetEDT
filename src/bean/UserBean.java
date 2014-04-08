package bean;


public class UserBean
{
	private String firstName;
	private String name;
	private String email;
	private String password;
	private String confirmPassword;
	private String idGroupe;

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

	public String getIdGroupe() 
	{
		return idGroupe;
	}

	public void setIdGroupe(String idGroupe) 
	{
		this.idGroupe = idGroupe;
	}
}

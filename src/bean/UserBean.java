package bean;


public class UserBean
{
	private String firstName;
	private String name;
	private String email;
	private String password;
	private long idGroupe;

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

	public long getIdGroupe() 
	{
		return idGroupe;
	}

	public void setIdGroupe(long idGroupe) 
	{
		this.idGroupe = idGroupe;
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
}

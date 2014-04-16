package bean;


/**
 * Bean Classroom
 * @author mickael
 *
 */
public class ClassroomBean
{
	private long id;
	private String name;
	private String oldName;

	/**
	 * Getters and Setters
	 */
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOldName() 
	{
		return oldName;
	}

	public void setOldName(String oldName) 
	{
		this.oldName = oldName;
	}

}

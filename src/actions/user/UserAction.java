package actions.user;


import java.util.ArrayList;
import java.util.List;

import model.dao.GroupDAO;
import model.dao.UserDAO;
import model.org.persistence.UserEntity;
import actions.abstractAction.AbstractAction;
import bean.UserBean;


public class UserAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	//bean de formulaire permettant le transfere des informations
	private ArrayList<UserBean> listUserBean;
	//déclaration et initialisation des DAO
	private UserDAO userDao = new UserDAO();
	private GroupDAO gdao = new GroupDAO();

	
	/**
	 * Méthode permettant d'afficher la liste des users 
	 * @return
	 */
	public String showUser()
	{
		forward = FORWARD_SUCCESS;
		this.listUserBean = new ArrayList<UserBean>();
		try
		{
			List<UserEntity> listUserEntity = userDao.getAllUser();
			for (UserEntity userEntity : listUserEntity)
			{
				UserBean userBean = convertEntityToBean(userEntity);
				this.listUserBean.add(userBean);
			}
		} catch (Exception e)
		{
			forward = FORWARD_ERROR;
		}
		return forward;
	}


	/**
	 * Méthode de conversion avec un userEntity en entrée et un userBean en sortie
	 * @param UserEntity
	 * @return UserBean
	 */
	private UserBean convertEntityToBean(UserEntity userToConvert)
	{
		UserBean userResult = new UserBean();
		
		userResult.setId(userToConvert.getId());
		userResult.setFirstName(userToConvert.getFirstName());
		userResult.setEmail(userToConvert.getEmail());
		userResult.setName(userToConvert.getName());
		userResult.setNameGroup(userToConvert.getGroupe().getName());
		userResult.setArrayGroupName(gdao.getAllGroupName());
		
		return userResult;
	}
	
	/**
	 * Getters and setters
	 * @return
	 */
	public ArrayList<UserBean> getListUserBean() 
	{
		return listUserBean;
	}
	
	public void setListUserBean(ArrayList<UserBean> listUserBean) 
	{
		this.listUserBean = listUserBean;
	}
}

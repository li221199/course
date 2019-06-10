package shop.service;

import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.ParentUser;
import shop.bean.User;
import shop.dao.ParentUserDao;

public class ParentUserService
{
	@Autowired
	ParentUserDao pud;

	public boolean registerParentUser(ParentUser user)
	{
		return false;
	}

	/**
	 * @return 返回0代表“用户名不存在”，1代表“密码不正确”，2代表“登陆成功”
	 */
	public int login(String userName, String password)
	{
		// 查找用户名是否存在
		User user = pud.findByUserName();
		if(user==null)
			return 0;
		
		//检验密码是否正确
		if (!password.equals(user.getPassword()))
			return 1;
		return 2;
		
	}

	public boolean changeInfo(ParentUser user)
	{
		return false;
	}
}

package team.unibro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import team.unibro.dao.IUserDao;
import team.unibro.model.User;
import team.unibro.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.findAllUser();
	}
	
}
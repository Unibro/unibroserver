package team.unibro.dao;

import java.util.List;

import team.unibro.model.User;

public interface IUserDao {
	
	public void addUser(User user);
	
	public List<User> findAllUser();
	
}

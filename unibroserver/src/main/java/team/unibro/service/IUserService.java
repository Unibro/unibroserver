package team.unibro.service;

import java.util.List;

import team.unibro.model.User;

public interface IUserService {
	
	public void addUser(User user);
	
	public List<User> getAllUser();
}
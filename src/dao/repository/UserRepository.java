package dao.repository;

import dao.model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	public final List<User> USERS = new ArrayList<>();
	
	public void addUser(User user) {
		USERS.add(user);
	}
	
	public User getUser(String email) {
		for (User user : USERS)
			if (user.getEmail().equals(email.toLowerCase())) return user;
		return null;
	}
	
	public boolean containsUser(String email) {
		for (User user : USERS)
			if (user.getEmail().equals(email)) return true;
		return false;
	}
	
	public void updateUser(User changedUser) {
		for (User user : USERS) {
			if (user.getEmail().equals(changedUser.getEmail())) {
				user.setFirstName(changedUser.getFirstName());
				user.setLastName(changedUser.getLastName());
				user.setAge(changedUser.getAge());
				user.setCountry(changedUser.getCountry());
				user.setCity(changedUser.getCity());
				user.setUsername(changedUser.getUsername());
				user.setPassword(UserService.encryptPassword(changedUser.getPassword()));
				user.setPhoneNumber(changedUser.getPhoneNumber());
				break;
			}
		}
	}
	
	public void deleteUser(User user) {
		USERS.remove(user);
	}
}
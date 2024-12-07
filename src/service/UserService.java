package service;

import dao.model.User;
import dao.repository.UserRepository;

public class UserService {
	UserRepository userRepository;
	private static final String SECRET_KEY = "SD432Sv&D#4$5*2$&as!da_sda#pv3AS0m";
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	private boolean containsUser(String email) {
		for (User user : userRepository.USERS)
			if (user.getEmail().equals(email)) return true;
		return false;
	}
	
	private boolean isEmailRegistered(String email) {
		return containsUser(email);
	}
	
	public void registerUser(User user) {
		if (isEmailRegistered(user.getEmail())) {
			System.out.println("Email is already registered!");
		} else {
			user.setPassword(encryptPassword(user.getPassword()));
			userRepository.USERS.add(user);
		}
	}
	
	private boolean isValidUser(String email) {
		return containsUser(email);
	}
	
	private boolean verifyUserCredentials(String email, String password) {
		for (User user : userRepository.USERS) {
			if (user.getEmail().equals(email)) {
				if (password.equals(decryptPassword(user.getPassword())))
					return true;
			}
		}
		return false;
	}
	
	public void loginUser(String email, String password) {
		if (isValidUser(email)) {
			if (verifyUserCredentials(email, password)) {
				System.out.println("Login successful!");
			} else {
				System.out.println("Email or password is incorrect!");
			}
		} else {
			System.out.println("Such a user does not exist.");
		}
	}
	
	public User getUserDetails(String email) {
		for (User user : userRepository.USERS) {
			if (user.getEmail().equals(email.toLowerCase())) return user;
		}
		return null;
	}
	
	public static String encryptPassword(String password) {
		return SECRET_KEY + password;
	}
	
	public static String decryptPassword(String encryptedPassword) {
		return encryptedPassword.replace(SECRET_KEY, "");
	}
}
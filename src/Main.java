import dao.model.User;
import dao.repository.UserRepository;
import service.UserService;

public class Main {
	public static void main(String[] args) {
		User user = new User(
			"Lionel", "Messi", 37,
			"Argentina", "Buenos Aires", "leomessi",
			"leomessi@gmail.com", "123", "050-666-66-66"
		);
		
		// Register the user
		UserRepository userRepository = new UserRepository();
		UserService userService = new UserService(userRepository);
		userService.registerUser(user);
		
		// Get the user details
		System.out.println(userService.getUserDetails("leomessi@gmail.com"));
		
		// Login the user
		userService.loginUser("leomessi@gmail.com", "123");
	}
}
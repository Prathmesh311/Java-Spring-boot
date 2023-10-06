package com.rest.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class UserDaoService {
	
	public static ArrayList<User> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "Jim", LocalDate.now().minusYears(20)));
	}
	
	public ArrayList<User> findAll(){
		return users;
	}
	
	public User findone(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
}

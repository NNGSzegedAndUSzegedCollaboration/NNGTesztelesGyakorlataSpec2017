package com.nng.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.nng.test.dto.User;

public class UserMemoryDb {
	
	private static List<User> users = new ArrayList<>();

	public static List<User> getUsers() {
		return users;
	}

	public static void setUsers(List<User> users) {
		UserMemoryDb.users = users;
	}
	
	public static void addUsers(User... user) {
		users.addAll(Arrays.asList(user));
	}
	
	public static User getUser(Integer id) {
		return users.stream()
				.filter(x -> x.getUserId() == id).collect(Collectors.toList()).get(0);
	}
	
	public static List<User> removeUser(User user) {
		users.remove(user);
		return users;
	}
	
	public static Integer getMaxId() {
		Comparator<Integer> naturalOrder = Comparator.naturalOrder();
		return users.stream()
				.map(u -> u.getUserId()).max(naturalOrder).orElse(null);
	}

}

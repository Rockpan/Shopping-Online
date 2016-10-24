package com.shopping.service;
import com.shopping.dao.CheckUsernameDao;

public class CheckUsernameService {

	public int checkExist(String username,String password){
		int i = 0;
		i = new CheckUsernameDao().checkExist(username,password);
		return i;
	}
	
	public int checkExist(String username){
		int i = 0;
		i = new CheckUsernameDao().checkExist(username);
		return i;
	}
}

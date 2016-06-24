package com.xhly.godutch.business;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.xhly.godutch.business.base.BusinessBase;
import com.xhly.godutch.database.sqlitedal.SQLiteDALUser;
import com.xhly.godutch.model.User;

public class BusinessUser extends BusinessBase{
	private SQLiteDALUser sqliteDALUser;
	public BusinessUser(Context context) {
		super(context);
		sqliteDALUser = new SQLiteDALUser(context);
	}
	
	public boolean insertUser(User user){
		boolean result = sqliteDALUser.insertUser(user);
		return result;
	}

		public boolean deleteUserById(int id){
			
			String condition = " And _id = "+ id;
			boolean result  = sqliteDALUser.deleteUser(condition);
			return result;
		}
		
		public boolean updateUserById(User user){
			String condition = " And _id="+user.getUserID();
			boolean result = sqliteDALUser.updateUser(condition, user);
			return result;
			
		}
		
		private List<User> getUser(String condition){
			return sqliteDALUser.getUser(condition);
		}

		public User getUserById(int id){
			List<User> list = sqliteDALUser.getUser(" And _id="+id);
			if(list.size()==1){
				return list.get(0);
			}else{
				return null;
			}
		}
		
		public List<User> getUserListById(String[] id){
			List<User> list = new ArrayList<User>();
			for (int i = 0; i < id.length; i++) {
				list.add(getUserById(Integer.parseInt(id[i])));
			}
			return list;
		}
		
		public List<User> getNotHideUser(){
			return sqliteDALUser.getUser(" And state=1");
		}
}

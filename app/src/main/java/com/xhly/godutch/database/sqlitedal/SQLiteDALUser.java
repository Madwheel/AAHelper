package com.xhly.godutch.database.sqlitedal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xhly.godutch.R;
import com.xhly.godutch.database.base.SQLiteDALBase;
import com.xhly.godutch.model.User;
import com.xhly.godutch.utility.DateTools;

import java.util.Date;
import java.util.List;

public class SQLiteDALUser extends SQLiteDALBase {

	public SQLiteDALUser(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String[] getTableNameAndPK() {
		// TODO Auto-generated method stub
		return new String[]{"users","_id"};
	}

	@Override
	protected User findModel(Cursor cursor) {
		
			int userID = cursor.getInt(cursor.getColumnIndex("_id"));
			String userName = cursor.getString(cursor.getColumnIndex("name"));
			Date createDate = DateTools.getDate(cursor.getString(cursor.getColumnIndex("createDate")), "yyyy-MM-dd HH:mm:ss");
			int state =cursor.getInt(cursor.getColumnIndex("state")) ;	
		return new User(userID, userName, createDate, state);
	}

	private void initDefault(SQLiteDatabase database){
		User user = new User();
		String[] names = getContext().getResources().getStringArray(R.array.initDefaultUserName);
		for (int i = 0; i < names.length; i++) {
			user.setUserName(names[i]);
			ContentValues values = createParams(user);
			database.insert(getTableNameAndPK()[0], null, values);			
		}
	}
	
	public boolean insertUser(User user) {
		ContentValues values = createParams(user);
		long newId = getDataBase().insert(getTableNameAndPK()[0], null, values);
		user.setUserID((int) newId);
		
		return newId>0;

	}
public boolean deleteUser(String condition){
	return detele(getTableNameAndPK()[0], condition);
}

public boolean updateUser(String condition,User user){
	ContentValues values = createParams(user);
	return getDataBase().update(getTableNameAndPK()[0], values, condition, null)>0;
}

public List<User> getUser(String condotion){
	String sql = "Select * From users  Where 1=1 "+ condotion;
	return getList(sql);	
}


	public ContentValues createParams(User user) {
		ContentValues values = new ContentValues();
		values.put("name", user.getUserName());
		values.put("createDate", DateTools.getFormatDateTime(user.getCreateDate(), "yyyy-MM-dd HH:mm:ss"));
		values.put("state", user.getState());
		return values;

	}

	@Override
	public void onCreate(SQLiteDatabase dataBase) {
		dataBase.execSQL("create table users(_id integer primary key autoincrement not null,name varchar(20) not null , createDate datetime not null, state integer not null)");
		initDefault(dataBase);
	}

	private void initDefaultData(SQLiteDatabase pDatabase) {
		User user = new User();
		String userNames[]  = getContext().getResources().getStringArray(
				R.array.initDefaultUserName);
	

		for (int i = 0; i < userNames.length; i++) {
			user.setUserName(userNames[i]);
			ContentValues _ContentValues = createParams(user);
			pDatabase.insert(getTableNameAndPK()[0], null, _ContentValues);
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

}

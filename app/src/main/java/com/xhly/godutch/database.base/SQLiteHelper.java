package com.xhly.godutch.database.base;

import java.util.ArrayList;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.xhly.godutch.utility.Reflection;

public class SQLiteHelper extends SQLiteOpenHelper {
	private static SQLiteDataBaseConfig sqliteDataBaseConfig ;
	private Context context;

	private static SQLiteHelper instance;
	private Reflection mReflection;
	
	public interface SQLiteDataTable{
		public void onCreate(SQLiteDatabase dataBase);
		public void onUpgrade(SQLiteDatabase db);
	}
	
	private  SQLiteHelper(Context context) {
		super(context, sqliteDataBaseConfig.getDataBaseName(), null, sqliteDataBaseConfig.getVersion());
		this.context = context;
		

	}

	public static SQLiteHelper getInstance(Context context){
		if (instance == null) {
			sqliteDataBaseConfig = SQLiteDataBaseConfig.getInstance(context);
			instance = new SQLiteHelper(context);
		}
		return instance;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("getSQLiteInstance---getSQLiteInstance+###");
		ArrayList<String> tables = sqliteDataBaseConfig.getTables();
		System.out.println("###-+new ");
		mReflection = new Reflection();

		for (int i = 0; i < tables.size(); i++) {
			try {
				
				((SQLiteDataTable) mReflection.newInstance(tables.get(i),
						new Object[] { context },
						new Class[] { Context.class })).onCreate(db);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}

}

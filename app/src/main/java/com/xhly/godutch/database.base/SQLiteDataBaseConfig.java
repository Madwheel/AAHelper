package com.xhly.godutch.database.base;

import java.util.ArrayList;

import android.content.Context;

import com.xhly.godutch.R;

public class SQLiteDataBaseConfig {
	private static final String DATABASE_NAME = "GoDutchDataBase";
	private static final int VERSION = 1;
	private static SQLiteDataBaseConfig instance ;
	private static Context context;
	private SQLiteDataBaseConfig() {

	}

	public static SQLiteDataBaseConfig getInstance(Context context) {
		if (instance == null) {
			instance = new SQLiteDataBaseConfig();
			SQLiteDataBaseConfig.context = context;
		}
		return instance;
	}

	public int getVersion() {
		return VERSION;
	}

	public String getDataBaseName() {
		return DATABASE_NAME;
	}
	
	public ArrayList<String> getTables(){
		ArrayList<String> _ArrayList = new ArrayList<String>();

		String[] _SQLiteDALClassName = context.getResources().getStringArray(
				R.array.SQLiteDALClassName);
		String _PackagePath = context.getPackageName()
				+ ".database.sqlitedal.";
		for (int i = 0; i < _SQLiteDALClassName.length; i++) {
			_ArrayList.add(_PackagePath + _SQLiteDALClassName[i]);
		}
		return _ArrayList;
	}

}

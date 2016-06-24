package com.xhly.godutch.database.base;

import java.util.ArrayList;
import java.util.List;

import com.xhly.godutch.database.base.SQLiteHelper.SQLiteDataTable;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class SQLiteDALBase implements SQLiteDataTable{
	private Context context;
	private SQLiteDatabase m_Database;

	public SQLiteDALBase(Context context) {
		this.context = context;
	}

	protected Context getContext() {

		return context;
	}

	public SQLiteDatabase getDataBase() {
		if (m_Database == null) {
			
			m_Database = SQLiteHelper.getInstance(context)
					.getReadableDatabase();
		}
		return m_Database;
	}

	public void beginTransaction() {
		m_Database.beginTransaction();
	}

	public void setTransactionSuccessful() {
		m_Database.setTransactionSuccessful();
	}

	public void endTransaction() {
		m_Database.endTransaction();
	}

	public int getCount(String condition) {
		  String[] string = getTableNameAndPK();  
		  Cursor cursor =execSql("Select "+string[1]+" From "+string[0] +" Where 1=1 "+condition );
		  int count = cursor.getCount();
		  cursor.close();
		  return count;
		 
	}

	public int getCount(String column,String table, String condition){
		Cursor cursor = execSql("Select "+column +" From "+table +" Where 1=1  "+ condition);
		int count = cursor.getCount();
		cursor.close();
		return count;
	}
	
	protected Boolean detele(String table, String condition) {
		return getDataBase().delete(table, " 1=1 " + condition, null) > 0;
	}

	protected abstract String[] getTableNameAndPK();

	protected List getList(String sql) {
		Cursor cursor = execSql(sql);
		return cursorToList(cursor);
	}

	protected abstract Object findModel(Cursor cursor);

	protected List cursorToList(Cursor cursor) {
		List list = new ArrayList();
		while (cursor.moveToNext()) {		
			Object obj = findModel(cursor);
			list.add(obj);
		}
		cursor.close();
		
		return list;
	}

	public Cursor execSql(String sql) {
		return getDataBase().rawQuery(sql, null);
	}

	
}

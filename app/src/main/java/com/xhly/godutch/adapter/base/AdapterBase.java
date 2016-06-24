package com.xhly.godutch.adapter.base;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class AdapterBase extends BaseAdapter {
	public List list;
	public Context context;
	
	public List getList() {	
		return list;
	}

	public void setList(List list) {
		this.list = list;
		
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public AdapterBase(List list, Context context) {
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
}

package com.xhly.godutch.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xhly.godutch.R;

public class GridAdapter extends BaseAdapter {
	private String[] mImageString = new String[6];
	
	public GridAdapter(Context context) {
		super();
		this.context = context;
		mImageString[0] = context.getString(R.string.payoutAdd);
		mImageString[1] = context.getString(R.string.payoutManage);
		mImageString[2] = context.getString(R.string.statisticsManage);
		mImageString[3] = context.getString(R.string.accountBookManage);
		mImageString[4] = context.getString(R.string.categoryManage);
		mImageString[5] = context.getString(R.string.userManage);	
	}

	private Context context;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mImageString.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mImageString[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if(convertView==null){
			view  = View.inflate(context, R.layout.main_body_item, null);
		}
		ImageView img_menu = (ImageView) view.findViewById(R.id.img_menu);
		TextView tv_menu =  (TextView) view.findViewById(R.id.tv_menu);
		img_menu.setBackgroundResource(R.mipmap.ic_launcher);
		tv_menu.setText(mImageString[position]);
		return view;
	}

}

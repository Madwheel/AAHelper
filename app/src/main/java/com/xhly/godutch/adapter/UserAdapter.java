package com.xhly.godutch.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xhly.godutch.R;
import com.xhly.godutch.adapter.base.AdapterBase;
import com.xhly.godutch.business.BusinessUser;
import com.xhly.godutch.model.User;

import java.util.List;

public class UserAdapter extends AdapterBase {

	public UserAdapter(List list, Context context) {
		super( null, context);
		BusinessUser businessUser = new BusinessUser(context);
		List<User> notHideUser = businessUser.getNotHideUser();
		setList(notHideUser);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if(convertView==null){
			view = View.inflate(getContext(), R.layout.list_user_item, null);
			holder = new ViewHolder();
			holder.tv_name = (TextView) view.findViewById(R.id.tv_name);
			view.setTag(holder);			
		}
		
		User user = (User) (getList().get(position));
		
		holder  = (ViewHolder) view.getTag();
		holder.tv_name.setText(((User) user).getUserName());
		return view;
	}

	
	class ViewHolder{
		TextView tv_name;
	}
}

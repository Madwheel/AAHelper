package com.xhly.godutch.adapter;

import java.util.List;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xhly.godutch.R;
import com.xhly.godutch.adapter.base.AdapterBase;
import com.xhly.godutch.control.SliderMenuItem;

public class SlideMenuAdapter extends AdapterBase {

    public SlideMenuAdapter(List list, Context context) {
        super(list, context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (convertView == null) {
            view = View.inflate(getContext(), R.layout.slide_menu_list_item, null);
            holder = new ViewHolder();
            holder.tv_menu_name = (TextView) view.findViewById(R.id.tv_menu_name);
            view.setTag(holder);
        }
        holder = (ViewHolder) (view.getTag());
        
        holder.tv_menu_name.setText(((SliderMenuItem) (getList().get(position))).getmTitle());
        
        return view;
    }

    public class ViewHolder {
        TextView tv_menu_name;
    }
}

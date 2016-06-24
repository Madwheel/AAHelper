package com.xhly.godutch.control;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.xhly.godutch.R;
import com.xhly.godutch.adapter.SlideMenuAdapter;

import java.util.ArrayList;
import java.util.List;
public class SliderMenuView {
	private Activity activity;
	private List<SliderMenuItem> menuList;
	private boolean isClosed;
	private RelativeLayout bottom_box;
	private ListView listView;
	private BaseAdapter adapter;
	private OnSlideMenuListener onSlideMenuListener;
	public SliderMenuView(Activity activity) {
		super();
		this.activity = activity;
		onSlideMenuListener = (OnSlideMenuListener) activity;
		initVariable();
		initView();
		bindList();
		initListeners();
	}
	public void initVariable(){
		menuList = new ArrayList();
		isClosed = true;
	}	
	public void initView(){
		bottom_box = (RelativeLayout) activity.findViewById(R.id.include_bottom);
		listView = (ListView)activity.findViewById(R.id.listView);
	}	
	public void initListeners(){
		listView.setOnItemClickListener(new OnSlideMenuItemClick());
		bottom_box.setOnClickListener(new OnSlideMenuClick());
		bottom_box.setFocusableInTouchMode(true);
		bottom_box.setOnKeyListener(new View.OnKeyListener() {
		
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(keyCode==KeyEvent.KEYCODE_MENU&&event.getAction()==KeyEvent.ACTION_UP){
					toggle();		
					return true;
				}
				return false;
			}
		});
		
	}
	
	private void open(){
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
		params.addRule(RelativeLayout.BELOW,R.id.include_title);	
		bottom_box.setLayoutParams(params);
		isClosed = false;
	}	
	private void close(){
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,100);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		bottom_box.setLayoutParams(params);
		isClosed = true;
	}
	public void toggle(){
		if(isClosed){
			open();
		}else{
			close();
		}
	}
	
	public void add(SliderMenuItem sliderMenuItem){
		menuList.add(sliderMenuItem);
		adapter.notifyDataSetChanged();
	}
	
	private void bindList(){
		adapter = new SlideMenuAdapter(menuList, activity);
		listView.setAdapter(adapter);
	
	}
	
	/*private void OnSlideMenuClick(){
		
	}*/
	private class OnSlideMenuClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			toggle();
		}
		
	}
	private class OnSlideMenuItemClick implements AdapterView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			SliderMenuItem item = (SliderMenuItem) parent.getItemAtPosition(position);
			onSlideMenuListener.slideMenuItemClick(view, item);
		}
	}
	public interface OnSlideMenuListener{
		void slideMenuItemClick(View view, SliderMenuItem item);
	}
}

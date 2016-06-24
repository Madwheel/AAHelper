package com.xhly.godutch.activity;

import android.os.Bundle;
import android.view.View;

import com.xhly.godutch.R;
import com.xhly.godutch.activity.base.BaseFrameActivity;
import com.xhly.godutch.control.SliderMenuItem;
import com.xhly.godutch.control.SliderMenuView.OnSlideMenuListener;

public class PayoutActivity extends BaseFrameActivity implements OnSlideMenuListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		appendMainBody(R.layout.user);
		
		initVariable();
		InitView();
		initListeners();
		bindData();
	}
	
	public void initVariable(){
	
		
	}	
	public void InitView(){
	
		createSlideMenu(R.array.slideMenuPayout);
	}	
	public void initListeners(){
		
	}
	public void bindData(){
		
	}

	@Override
	public void slideMenuItemClick(View view, SliderMenuItem item) {
		// TODO Auto-generated method stub
		
	}
}


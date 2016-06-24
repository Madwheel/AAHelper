package com.xhly.godutch.activity.base;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xhly.godutch.R;
import com.xhly.godutch.control.SliderMenuItem;
import com.xhly.godutch.control.SliderMenuView;

public class BaseFrameActivity extends BaseActivity {

	private SliderMenuView sliderMenuView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
	}
	/**
	 * 设置TopBar标题
	 * @param pRestID 要设置的String资源ID
	 */
	protected void setTopTitle(String pText) {
		TextView tvTitle = (TextView) findViewById(R.id.tvTopTitle);
		tvTitle.setText(pText);
	}
	
	protected void appendMainBody(int xResId){
		LinearLayout mainBody = (LinearLayout) findViewById(R.id.mainBody);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);	
		mainBody.addView(View.inflate(this, xResId, null), params);
	
	}
	protected void slideMenuToggle() {
		sliderMenuView.toggle();
	}
	protected void createSlideMenu(int resId){
		String[] stringArray = getResources().getStringArray(resId);
		sliderMenuView = new SliderMenuView(this);
		for (int i = 0; i < stringArray.length; i++) {
			sliderMenuView.add(new SliderMenuItem(i, stringArray[i]));
		}
	}
}

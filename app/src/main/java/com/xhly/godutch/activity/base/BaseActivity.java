package com.xhly.godutch.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

public class BaseActivity extends Activity {
	
	protected void showMsg(String xMsg){
		Toast.makeText(this, xMsg, 1).show();
	}
	protected void openActivity(Class<?> xClass){
		Intent intent = new Intent();
		intent.setClass(this,xClass);
		startActivity(intent);
	}
}

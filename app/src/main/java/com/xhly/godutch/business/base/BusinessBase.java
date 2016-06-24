package com.xhly.godutch.business.base;
import android.content.Context;
/**
 *
 * @author 新火燎塬
 * created at 2016/6/12 20:52
 */
public class BusinessBase {
	private Context context;
	
	protected BusinessBase (Context context) {
		this.context = context;
	}
	
	protected String  getString(int resId) {
		return context.getString(resId);
	}
	
	protected String getString(int resId,Object obj[]) {
		return context.getString(resId, obj);
		
	}
	
}

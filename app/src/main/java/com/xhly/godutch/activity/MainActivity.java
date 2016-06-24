package com.xhly.godutch.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.xhly.godutch.R;
import com.xhly.godutch.activity.base.BaseFrameActivity;
import com.xhly.godutch.adapter.GridAdapter;
import com.xhly.godutch.control.SliderMenuItem;
import com.xhly.godutch.control.SliderMenuView.OnSlideMenuListener;

/**
 * 
 * @author 新火燎塬
 *@time 下午7:54:55
*
* ━━━━━━神兽出没━━━━━━
* 　　　┏┓　　　┏┓
* 　　┏┛┻━━━┛┻┓
* 　　┃　　　　　　　┃
* 　　┃　　　━　　　┃
* 　　┃　┳┛　┗┳　┃
* 　　┃　　　　　　　┃
* 　　┃　　　┻　　　┃
* 　　┃　　　　　　　┃
* 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
* 　　　　┃　　　┃    神兽保佑,代码无bug
* 　　　　┃　　　┃
* 　　　　┃　　　┗━━━┓
* 　　　　┃　　　　　　　┣┓
* 　　　　┃　　　　　　　┏┛
* 　　　　┗┓┓┏━┳┓┏┛
* 　　　　　┃┫┫　┃┫┫
* 　　　　　┗┻┛　┗┻┛
*
* ━━━━━━感觉萌萌哒━━━━━━
 */

public class MainActivity extends BaseFrameActivity implements OnSlideMenuListener{
	private GridView gridView;
	private GridAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		appendMainBody(R.layout.activity_main);
		
		initVariable();
		InitView();		
		bindData();
		initListeners();
	}
	
	public void initVariable(){
		adapter = new GridAdapter(this);		
		
	}	
	public void InitView(){
		gridView = (GridView) findViewById(R.id.gridView);
		createSlideMenu(R.array.slideMenuActivityMain);
	}	
	public void initListeners(){
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//获取点击条目，菜单选项
				String item = (String)(parent.getAdapter().getItem(position));
				//人员管理
				if(item.equals(getString(R.string.userManage))){
					openActivity(UserActivity.class);
					return;
				}
				//类别管理
				if(item.equals(getString(R.string.categoryManage))){
					openActivity(CategoryActivity.class);
					return;
				}
				//账本管理
				if(item.equals(getString(R.string.accountBookManage))){
					openActivity(AccountBookActivity.class);
					return;
				}
				//统计管理
				if(item.equals(getString(R.string.statisticsManage))){
					openActivity(StatisticsActivity.class);
					return;
				}
				//查询消费
				if(item.equals(getString(R.string.payoutManage))){
					openActivity(PayoutActivity.class);
					return;
				}
				//记录消费
				if(item.equals(getString(R.string.payoutAdd))){
					openActivity(PayoutAddOrEditActivity.class);
					return;
				}


			}
		});
	}
	public void bindData(){
		gridView.setAdapter(adapter);
	}

	@Override
	public void slideMenuItemClick(View view, SliderMenuItem item) {
		System.out.println("###"+item);
	}
}

package com.xhly.godutch.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.xhly.godutch.R;
import com.xhly.godutch.activity.base.BaseFrameActivity;
import com.xhly.godutch.adapter.UserAdapter;
import com.xhly.godutch.control.SliderMenuItem;
import com.xhly.godutch.control.SliderMenuView.OnSlideMenuListener;
import com.xhly.godutch.database.sqlitedal.SQLiteDALUser;
import com.xhly.godutch.model.User;

public class UserActivity extends BaseFrameActivity implements OnSlideMenuListener{
	private UserAdapter adapter;
	private ListView listView;


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
	
		adapter = new UserAdapter(null, this);
		
	}	
	public void InitView(){
		listView = (ListView) findViewById(R.id.userListView);
		createSlideMenu(R.array.slideMenuUser);
	}	
	public void initListeners(){
		registerForContextMenu(listView);
	}
	public void bindData(){
		listView.setAdapter(adapter);
	}

	@Override
	public void slideMenuItemClick(View view, SliderMenuItem item) {

		slideMenuToggle();
		View v = View.inflate(this, R.layout.user_add_or_edit, null);
		final EditText et_user_name = (EditText) v.findViewById(R.id.et_user_name);
		new AlertDialog.Builder(this)
		            .setTitle(getString(R.string.hintUserName))
		            .setView(v)
		            .setPositiveButton("保存", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

							String userName = et_user_name.getText().toString();
							SQLiteDALUser userDao = new SQLiteDALUser(UserActivity.this);
							User user = new User();
							user.setUserName(userName);
							userDao.insertUser(user);
							adapter.getList().add(user);
							adapter.notifyDataSetChanged();

							et_user_name.setFocusable(false);
							InputMethodManager imm = (InputMethodManager) (getApplication().getSystemService(Context.INPUT_METHOD_SERVICE));
							imm.hideSoftInputFromWindow(et_user_name.getWindowToken(), 0);

						}
					})
		            .setNegativeButton("取消", null)
		            .show();
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

		menu.add(Menu.NONE, 1, Menu.NONE, "修改");
		menu.add(Menu.NONE,2,Menu.NONE,"删除");

		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		final AdapterView.AdapterContextMenuInfo menuInfo =(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
		switch (item.getItemId()) {
		    case  1:
				View v = View.inflate(this, R.layout.user_add_or_edit, null);
				final EditText et_user_name = (EditText) v.findViewById(R.id.et_user_name);

				final SQLiteDALUser userDao = new SQLiteDALUser(UserActivity.this);
				final User user = (User) adapter.getList().get(menuInfo.position);
				et_user_name.setText(user.getUserName());
				new AlertDialog.Builder(this)
						.setTitle(getString(R.string.hintUserName))
						.setView(v)
						.setPositiveButton("保存", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								User u = new User();
								u.setUserName( et_user_name.getText().toString());
								userDao.updateUser("_id="+user.getUserID(),u);
								adapter.getList().set(menuInfo.position,u);
								adapter.notifyDataSetChanged();
								et_user_name.setFocusable(false);
								InputMethodManager imm = (InputMethodManager) (getApplication().getSystemService(Context.INPUT_METHOD_SERVICE));
								imm.hideSoftInputFromWindow(et_user_name.getWindowToken(), 0);
							}
						})
						.setNegativeButton("取消", null)
						.show();
				break;
			case  2:


			break;
		}


		return super.onContextItemSelected(item);
	}



	public void showUsesrAddOrEditDialog(User user){
		View v = View.inflate(this, R.layout.user_add_or_edit, null);
		EditText et_user_name = (EditText) v.findViewById(R.id.et_user_name);
		if(user!=null){
			et_user_name.setText(user.getUserName());
		}

		String title ;
		if(user==null){
			title = getString(R.string.titleUser,new Object[]{getString(R.string.titleAdd)});
		}else{
			title = getString(R.string.titleUser,new Object[]{getString(R.string.titleEdit)});
		}

		new AlertDialog.Builder(this)
				.setTitle(getString(R.string.hintUserName))
				.setView(v)
				.setIcon(R.mipmap.ic_launcher)
				.setPositiveButton("保存", new onAddOrEditUserListener())
				.setNegativeButton("取消", null)
				.show();

	}

	private class onAddOrEditUserListener implements DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {

		}
	}
}

package com.JS.completesong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		ָ����ǰ���activity��ʹ�õĲ����ļ�
		setContentView(R.layout.activity_main);
		Log.v("mainAcitivity", "ִ��onCreate����");
		
		Button loginB=(Button)findViewById(R.id.login);
//		����ť��һ������¼�
		loginB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//��ȡ����   ���п��������ID������R������ 
				//		R.id.XXX
				EditText username=(EditText)findViewById(R.id.main_username);
				EditText password=(EditText)findViewById(R.id.main_password);
				
				//��ȡֵ
				String usernameStr=username.getText().toString();
				String passwordStr=password.getText().toString();
				
				Intent intent=new Intent(MainActivity.this,SongMainActivity.class);
				intent.putExtra("username", usernameStr);
				intent.putExtra("password", passwordStr);
//				������ͼ
				startActivity(intent);
				Log.v("mainActivity",usernameStr);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

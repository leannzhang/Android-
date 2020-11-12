package com.JS.completesong;

import java.util.List;

import com.JS.Bean.Song;
import com.JS.Fragment.LikeFragment;
import com.JS.Fragment.LocalFragment;
import com.JS.Fragment.NetworkFragment;
import com.JS.Fragment.PersonalFragment;
import com.JS.Service.MediaPlaySerives;
import com.JS.Service.MediaPlaySerives.MyBind;

import android.R.bool;
import android.app.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Service;
import android.content.ComponentName;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SongMainActivity extends Activity implements View.OnClickListener {

	private FragmentManager fragment;
	private FragmentTransaction beginTransaction;
	private MyService myService;
	private MyBind myBinder;

	private SeekBar seekBar;
	private int flag=0;   //如果是flag=0则为播放状态，按钮为播放图片  flag=1 则为暂停状态 按钮为暂停图片
	ImageButton song_next;
	ImageButton song_pre;
	ImageButton song_play;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_song_main);
		Intent intent = getIntent();
		String username = intent.getStringExtra("username");
		TextView usern = (TextView) findViewById(R.id.song_username);
		usern.setText(username);
		Log.v("SongmainActivity", "进入SongMainActivity");

		/* 关于切换上一首下一首的监听 */
		song_next = (ImageButton) findViewById(R.id.song_next);
		song_pre = (ImageButton) findViewById(R.id.song_pre);
		song_play = (ImageButton) findViewById(R.id.song_play);

		song_next.setOnClickListener(this);
		song_pre.setOnClickListener(this);
		song_play.setOnClickListener(this);

		seekBar = (SeekBar) findViewById(R.id.seekbar);

		Intent service = new Intent(this, MediaPlaySerives.class);
		myService = new MyService();
		Log.v("MusicSerives", "bindSerives之前");
		/* 第一个为意图，第二个是内部类，第三个是一个标志位 */
		bindService(service, myService, BIND_AUTO_CREATE);
		startService(service);
		setLocalFragment();

		/* 添加监听 */
		RadioGroup songMainTabs = (RadioGroup) findViewById(R.id.songMain_tabs);
		songMainTabs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				TextView text = (TextView) findViewById(R.id.song_mainfragmen);
				int id = group.getCheckedRadioButtonId();
				switch (checkedId) {
				case R.id.local_music:
					setLocalFragment();
					text.setText("本地音乐");
					break;
				case R.id.network_music:
					setNetworkFragment();
					text.setText("网络音乐");
					break;
				case R.id.like_music:
					setLikeFragment();
					text.setText("我的喜欢");
					break;
				case R.id.person:
					text.setText("个人中心");
					setPersonalFragment();

					break;

				default:
					break;
				}
			}

		});
	}

	// 切换的页面
	private void setNetworkFragment() {
		// TODO Auto-generated method stub

		fragment = getFragmentManager();
		beginTransaction = fragment.beginTransaction();
		beginTransaction.replace(R.id.song_content, new NetworkFragment());

		beginTransaction.commit();

	}

	private void setLikeFragment() {
		// TODO Auto-generated method stub

		fragment = getFragmentManager();
		beginTransaction = fragment.beginTransaction();
		beginTransaction.replace(R.id.song_content, new LikeFragment());

		beginTransaction.commit();

	}

	private void setPersonalFragment() {
		// TODO Auto-generated method stub

		fragment = getFragmentManager();
		beginTransaction = fragment.beginTransaction();
		beginTransaction.replace(R.id.song_content, new PersonalFragment());

		beginTransaction.commit();

	}

	private void setLocalFragment() {
		// TODO Auto-generated method stub

		fragment = getFragmentManager();
		beginTransaction = fragment.beginTransaction();

		beginTransaction.replace(R.id.song_content, new LocalFragment());

		beginTransaction.commit();
		Log.v("SongmainActivity", "beginTransaction.commit");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.song_main, menu);
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

	class MyService implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder binder) {
			// TODO Auto-generated method stub
			/* 获取返回的binder类 */
			myBinder = (MyBind) binder;

		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.print("监听自己");
		Log.v("mainActivity", "进入监听事件onClick");
		switch (arg0.getId()) {
		case R.id.song_pre:
			myBinder.callpre();
			break;
		case R.id.song_play:
			if (1 == flag) {
				myBinder.callplay();
				song_play.setImageResource(R.drawable.ic_play);
				flag=0;
			
			} else {
				myBinder.callpause();
				song_play.setImageResource(R.drawable.ic_pause);
				flag=1;

			}
			break;
		case R.id.song_next:
			myBinder.callnext();
			break;
		}

	}

	public void skipTo(List<Song> songlist, int positon) {
		myBinder.callskipTo(songlist, positon, seekBar);
	}
}

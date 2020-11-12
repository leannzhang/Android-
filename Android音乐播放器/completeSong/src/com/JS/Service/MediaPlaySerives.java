package com.JS.Service;

import java.util.ArrayList;
import java.util.List;

import com.JS.Bean.Song;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.SeekBar;

public class MediaPlaySerives extends Service {
	private MediaPlayer mediaplay;
	private int pasueFlag = 0;
	private int playIndex = 0;
	private List<Song> songlist;

	private Handler handler;
	private SeekBar seekBar;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.v("MediaPlaySerives", "进入onBind");
		System.out.println("onBind.....");
		mediaplay = new MediaPlayer();
        mediaplay.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				next();
			}
		});
      
	return new MyBind();

}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.v("MediaPlaySerives", "进入onCreate");
		songlist = new ArrayList<Song>();
		  handler = new Handler() {
				public void handleMessage(Message msg)
				{
					if(msg.what==1)
					{
					seekBar.setProgress((int)(((double)mediaplay.getCurrentPosition()/mediaplay.getDuration())*100));
					sendEmptyMessageDelayed(1, 1000);
					}
				}
		};
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.v("MediaPlaySerives", "进入onStartCommand");
		return super.onStartCommand(intent, flags, startId);

	}

	public class MyBind extends Binder {

		public void callplay() {
			play();
		}

		public void callpause() {
			pause();
		}

		public void callpre() {
			pre();
		}

		public void callnext() {
			next();
		}

		public void callskipTo(List<Song> musiclist, int positon, SeekBar myseekBar) {
			// TODO Auto-generated method stub
			Log.v("MediaPlaySerives", "进入callskipTo");
			songlist = musiclist;
			playIndex = positon;
			seekBar=myseekBar;
			seekBar.setMax(100);
			pasueFlag = 0;
			play();
		}
	}

	public void play() {
		Log.v("MediaPlaySerives", "进入play");
		try {
			if (pasueFlag == 1) {
				mediaplay.start();
			} else {
				mediaplay.reset();
				mediaplay.setDataSource(songlist.get(playIndex).getSong_path());
				mediaplay.prepare();
				mediaplay.start();
			}
           handler.sendEmptyMessage(1);
		} catch (Exception e) {
			e.fillInStackTrace();
		}
	}

	public void pause() {
		Log.v("MediaPlaySerives", "进入pause");
		pasueFlag = 1;
		mediaplay.pause();
		handler.removeMessages(1);
		Log.v("MediaPlaySerives", songlist.get(playIndex).getSong_path());
	}

	public void pre() {
		Log.v("MediaPlaySerives", "进入pre");
		mediaplay.reset();
        seekBar.setProgress(0);
		try {
			if (playIndex == 0) {
				playIndex = songlist.size() - 1;
			} else {
				playIndex = playIndex - 1;
			}
			mediaplay.setDataSource(songlist.get(playIndex).getSong_path());
			mediaplay.prepare();
			mediaplay.start();
			handler.sendEmptyMessage(1);
		} catch (Exception e) {
			e.fillInStackTrace();
		}
	}

	public void next() {
		Log.v("MediaPlaySerives", "进入next");
		mediaplay.reset();
		try {
			if (playIndex == songlist.size() - 1) {
				playIndex = 0;
			} else {
				playIndex = playIndex + 1;
			}
			mediaplay.setDataSource(songlist.get(playIndex).getSong_path());
			mediaplay.prepare();
			mediaplay.start();
			handler.sendEmptyMessage(1);
		} catch (Exception e) {
			e.fillInStackTrace();
		}

	}

}

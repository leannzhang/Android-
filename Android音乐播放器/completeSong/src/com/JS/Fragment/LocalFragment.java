package com.JS.Fragment;

import java.util.ArrayList;
import java.util.List;

import com.JS.Adapter.MyAdapter;
import com.JS.Bean.Song;
import com.JS.completesong.*;
import android.app.Activity;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class LocalFragment extends Fragment {
	private Activity myActivity;
	private List<Song> localMusicList;
	private String localMusicUrl="/storage/sdcard/";
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.myActivity=activity;
		Log.v("LocalFragment", "LocalFragment onattach");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view=inflater.inflate(R.layout.activity_lists_view,container,false);
		Log.v("LocalFragment", "进入LocalFragment");
		ListView songList=(ListView)view.findViewById(R.id.activity_lists_view);
		localMusicList=queryLocalMusic();
		MyAdapter songListadapter=new MyAdapter(myActivity,localMusicList);
		songList.setAdapter(songListadapter);
		songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				SongMainActivity songMainActivity=(SongMainActivity)getActivity();
				songMainActivity.skipTo(localMusicList, position);
			}
		});
		
		
		
		return view;
	}
	public List<Song> queryLocalMusic(){
		//本地内容读取内容的API
		localMusicList=new ArrayList<Song>();
		ContentResolver contentResolver=getActivity().getContentResolver();
		Cursor cursor=contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, 
				null, null, null, null);
		 if (cursor != null) {
	            while (cursor.moveToNext()) {
	            	Song song=new Song();
	            	//文件名
		          String Filename = cursor.getString(cursor.getColumnIndexOrThrow
		        		  (MediaStore.Audio.Media.DISPLAY_NAME));
		            	//歌名
		            String song_name =cursor.getString( 
		            		cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
		            	 //歌手
		           String singer = cursor.getString(cursor.getColumnIndexOrThrow(
		        		   MediaStore.Audio.Media.ARTIST));
		            	 //时长
		           int duration = cursor.getInt(cursor.getColumnIndexOrThrow(
		        		   MediaStore.Audio.Media.DURATION));
			           //歌曲大小
		           Long size = cursor.getLong(cursor.getColumnIndexOrThrow(
		        		   MediaStore.Audio.Media.SIZE));	
		           song.setSong_name(song_name);
		           song.setSinger_name(singer);
		           song.setSong_duration(duration+"");
		           song.setSong_size(size+"");
		           song.setSong_path(localMusicUrl+Filename);
		           
		           localMusicList.add(song);
	            }
		 }
		 return localMusicList;
	}
}

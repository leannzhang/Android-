package com.JS.Fragment;

import java.util.ArrayList;
import java.util.List;

import com.JS.Adapter.MyAdapter;
import com.JS.Bean.Song;
import com.JS.completesong.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class LikeFragment extends Fragment {
	
	private Activity myActivity;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.myActivity=activity;
		Log.v("LocalFragment", "LikeFragment onattch");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.activity_lists_view,container,false);
		Log.v("LikeFragment", "����LikeFragment");
//		getActivity();
		
		ListView songList=(ListView)view.findViewById(R.id.activity_lists_view);
		List<Song> songListBase=new ArrayList<Song>();
		
		Song song1=new Song("1","������","��ǧ��");
		Song song2=new Song("2","����","����");
		Song song3=new Song("3","��ʹ�뺣��","��ӽ��");
		Song song4=new Song("4","�̷�","��ӽ��");
		Song song5=new Song("5","������","����");
		
		
		songListBase.add(song1);
		songListBase.add(song2);
		songListBase.add(song3);
		songListBase.add(song4);
		songListBase.add(song5);
		MyAdapter songListadapter=new MyAdapter(myActivity,songListBase);
		songList.setAdapter(songListadapter);
		
		
		return view;
	}

}

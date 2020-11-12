package com.JS.Fragment;

import java.util.ArrayList;
import java.util.List;

import com.JS.Adapter.MyAdapter;
import com.JS.Bean.Song;
import com.JS.completesong.*;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ViewPagerFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.activity_lists_view,null);
		ListView songList=(ListView)view.findViewById(R.id.activity_lists_view);
		List<Song> songListBase=new ArrayList<Song>();
		
		Log.v("ViewPagerFragment", "����viewpagerfragment");
		Song song1=new Song("1","д���ƻ�","������˧");
		Song song2=new Song("2","DEAR JOHN","����");
		Song song3=new Song("3","����","en");
		Song song4=new Song("4","����","�����");
		Song song5=new Song("5","����","������");
		
		
		songListBase.add(song1);
		songListBase.add(song2);
		songListBase.add(song3);
		songListBase.add(song4);
		songListBase.add(song5);
		

		
		
		MyAdapter myadapter=new MyAdapter(getActivity(),songListBase);
		songList.setAdapter(myadapter);
		return super.onCreateView(inflater, container, savedInstanceState);

	}
}

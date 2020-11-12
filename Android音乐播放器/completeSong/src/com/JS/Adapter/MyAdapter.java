package com.JS.Adapter;

import java.util.List;

import com.JS.Bean.Song;
import com.JS.completesong.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	
//	要加载到listView里面的数据
	private List<Song> mdata;
	private Context mcontext;
	
	public MyAdapter(Context context,List<Song> list) {
		// TODO Auto-generated constructor stub
		this.mdata=list;
		this.mcontext=context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		
		return mdata.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
	
	      return  mdata.get(position);

	}


	@Override
	public long getItemId(int id) {
		// TODO Auto-generated method stub
		
		return id;
	}
/*
 * *方法的作用
 * listView通过设配器的getView方法来一条条加载view
 */
	@Override
	public View getView(int id, View view, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		
		if(view==null) {
		view=LayoutInflater.from(mcontext).inflate(R.layout.song_items,viewGroup,false);
		TextView songidView=(TextView)view.findViewById(R.id.song_id);
		TextView songnameView=(TextView)view.findViewById(R.id.song_name);
		TextView singernameView=(TextView)view.findViewById(R.id.singer_name);
		TextView songdurationView=(TextView)view.findViewById(R.id.song_duration);
		TextView songsizeView=(TextView)view.findViewById(R.id.song_size);

		 songidView.setText(mdata.get(id).getId());
		 songnameView.setText(mdata.get(id).getSong_name());
		 singernameView.setText(mdata.get(id).getSinger_name());
		 songsizeView.setText(mdata.get(id).getSong_size());
		 songdurationView.setText(mdata.get(id).getSong_duration());
		
		}
		
		return view;
	}
	

}

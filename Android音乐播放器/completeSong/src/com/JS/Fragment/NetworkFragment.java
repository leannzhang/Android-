package com.JS.Fragment;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import org.json.JSONArray;
import org.json.JSONObject;

import com.JS.Adapter.MyAdapter;
import com.JS.Bean.Song;
import com.JS.completesong.R;
import com.JS.completesong.SongMainActivity;

import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NetworkFragment extends Fragment {
//	网络设配器
	
	private ArrayList<Song> networkMusic;
	private static final String
	networkurl="http://10.0.2.2:8080/qingxun/Music";
	private static final String
	serverUrl="http://10.0.2.2:8080";
	private ListView songList;
	private Song song;
	@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.activity_lists_view, container,false);
		Log.v("NetworkFragment", "NetworkFragment-------------");
		songList=(ListView)view.findViewById(R.id.activity_lists_view);
		networkMusic=new ArrayList<Song>();
		queryMusic();
		songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				SongMainActivity songMainActivity=(SongMainActivity)getActivity();
				songMainActivity.skipTo(networkMusic, position);
			}
		});
		return view;
		}
	public void queryMusic() {
		AsyncHttpClient client=new AsyncHttpClient();
		RequestParams params=new RequestParams();
		params.put("flag", "queryNetworkMusic");
		System.out.print("我是可爱的小张啊");
	    client.post(networkurl, params, new JsonHttpResponseHandler() {
	    	@Override
	    	public void onSuccess(JSONObject response) {
	    		// TODO Auto-generated method stub
	    		try {
	    		
		    		JSONArray jsonArray=response.getJSONArray("musicList");
		    		networkMusic.clear();
		    		for(int i=0;i<jsonArray.length();i++)
		    		{
		    			JSONObject jObject=(JSONObject)jsonArray.get(i);
		    			song=new Song( jObject.getString("song_name"), 
		    					jObject.getString("song_singer"), 
		    					jObject.getString("song_duration"), 
		    					jObject.getString("song_size"), 
		    					serverUrl+jObject.getString("song_path"));
		    			networkMusic.add(song);
		    		}
		    		networkMusic.add(song);
		    		MyAdapter songListadapter=new MyAdapter(getActivity(),networkMusic);
		    		songList.setAdapter(songListadapter);
		    		
	    		}
	    		catch (Exception e) {
					// TODO: handle exception
	    			e.fillInStackTrace();
				}
	    	}
	    	@Override
	    	public void onFailure(Throwable arg0,JSONObject arg1) {
	    		// TODO Auto-generated method stub
	    		super.onFailure(arg0,arg1);
	    	}
	    });
		
	}
}


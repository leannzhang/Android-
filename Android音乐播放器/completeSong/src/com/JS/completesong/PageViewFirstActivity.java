package com.JS.completesong;

import java.util.ArrayList;
import java.util.List;

import com.JS.Adapter.PageViewFirstAdapter;
import com.JS.Adapter.PageViewImageAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class PageViewFirstActivity extends Activity {
	private List<Integer> imageList=new ArrayList<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page_view_first);
		/*进入该活动出错的原因是 必须在build里面的order 将android-support-v4勾上并且置顶*/
		Log.v("R.layout.activity_page_view_first", "进入pageviewfirstAcivity");	
	
		ViewPager ViewPageFirst=(ViewPager)findViewById(R.id.ViewPage_first);
		List<ImageView> ViewPageList=new ArrayList<ImageView>();
		
		
		ImageView one=new ImageView(this);
		one.setImageResource(R.drawable.zhuyilong1);
		
		ImageView two=new ImageView(this);
		two.setImageResource(R.drawable.zhuyilong2);
		
		ImageView three=new ImageView(this);
		three.setImageResource(R.drawable.zhuyilong3);
		
		ViewPageList.add(one);
		ViewPageList.add(two);
		ViewPageList.add(three);
		
		
		PageViewFirstAdapter PageviewFirstAdapter=new PageViewFirstAdapter(ViewPageFirst,ViewPageList);
		Log.v("R.layout.activity_page_view_first", "进入pageViewfirstAdapter");
		ViewPageFirst.setAdapter(PageviewFirstAdapter);
		ViewPageFirst.setCurrentItem(0);
		
//		
//		imageList.add(R.drawable.zhuyilong1);
//		imageList.add(R.drawable.zhuyilong2);
//		imageList.add(R.drawable.zhuyilong3);
//		imageList.add(R.drawable.zhuyilong4);
//		imageList.add(R.drawable.zhuyilong5);
//		PageViewImageAdapter pageViewImageAdapter=new PageViewImageAdapter(imageList,this);
//		ViewPageFirst.setAdapter(pageViewImageAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.page_view_first, menu);
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

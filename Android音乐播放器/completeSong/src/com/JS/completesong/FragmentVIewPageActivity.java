package com.JS.completesong;



import java.util.ArrayList;
import java.util.List;

import com.JS.Adapter.MyFragmentPagerAdapter;
import com.JS.Fragment.ViewPagerFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;

public class FragmentVIewPageActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_view_page);
		Log.v("FragmentVIewPageActivity", "Ω¯»ÎFragmentVIewPageActivity");
		
		ViewPager viewPager=(ViewPager)findViewById(R.id.ViewPage_fragment);
		List<Fragment> listF=new ArrayList<Fragment>();
		listF.add(new ViewPagerFragment());
		MyFragmentPagerAdapter myFragmentPagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(), listF);
		viewPager.setAdapter(myFragmentPagerAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fragment_view_page, menu);
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

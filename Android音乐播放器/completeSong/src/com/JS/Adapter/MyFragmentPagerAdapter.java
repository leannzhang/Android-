package com.JS.Adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> myList;
	private FragmentManager myFm;
	
	public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> List) {
		super(fm);
		this.myList=List;
		this.myFm=fm;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return myList.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return myList.size();
	}

}

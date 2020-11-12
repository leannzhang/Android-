package com.JS.Adapter;

import java.util.List;

import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PageViewFirstAdapter extends PagerAdapter {

	
	private ViewPager myPage=null;
	private  List<ImageView> myList=null;
	public PageViewFirstAdapter(ViewPager viewPager,List<ImageView> ListImageView) {
		// TODO Auto-generated constructor stub
		this.myList=ListImageView;
		this.myPage=viewPager;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return myList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		
		
		ImageView imageView=myList.get(position);
		imageView.setId(position);
		Log.v("PageViewFirstAdapter", "进入instantiateItem-imagtView");
		container.addView(imageView);
		Log.v("PageViewFirstAdapter", "进入instantiateItem-container");
		return imageView;
//		return container;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
//		super.destroyItem(container, position, object);
		container.removeView(myList.get(position));
	}

}

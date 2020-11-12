package com.JS.Adapter;

import java.util.List;
import com.JS.completesong.*;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PageViewImageAdapter extends PagerAdapter {

	private List<Integer> mydata;
	private Context mycontext;
	private LayoutInflater myInflater;

	public PageViewImageAdapter(List<Integer> data, Context context) {
		// TODO Auto-generated constructor stub
		this.mycontext = context;
		this.mydata = data;
		this.myInflater = LayoutInflater.from(mycontext);

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		View image=myInflater.inflate(R.layout.viewpage_image, null);
		ImageView imageView=(ImageView) image.findViewById(R.id.pageView_image);
		imageView.setImageResource(mydata.get(position));
		container.addView(image);
		return image;

	}
}

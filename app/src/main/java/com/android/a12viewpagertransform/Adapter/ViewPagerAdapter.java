package com.android.a12viewpagertransform.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.a12viewpagertransform.Model.PlatformData;
import com.android.a12viewpagertransform.R;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    Activity activity;
    List<PlatformData> data;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Activity activity, List<PlatformData> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.viewpager_item,container,false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
        TextView textView = (TextView) itemView.findViewById(R.id.textview);

        //set image and text
        imageView.setBackgroundResource(data.get(position).getImage());
        textView.setText(data.get(position).getName());

        //add view to container
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((View)object);
    }
}

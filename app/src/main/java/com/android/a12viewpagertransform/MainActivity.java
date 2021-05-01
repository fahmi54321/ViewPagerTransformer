package com.android.a12viewpagertransform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.android.a12viewpagertransform.Adapter.ViewPagerAdapter;
import com.android.a12viewpagertransform.Model.PlatformData;
import com.android.a12viewpagertransform.Transform.DepthPageTransofrm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ViewPagerAdapter adapter;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(MainActivity.this,getData());
        pager.setAdapter(adapter);

        //transform
        pager.setPageTransformer(true,new DepthPageTransofrm());

    }


    private List<PlatformData> getData(){
        List<PlatformData> list = new ArrayList<>();
        PlatformData data = new PlatformData();
        data.name = "Fahmi";
        data.image = R.drawable.fahmi;
        list.add(data);

        data = new PlatformData();
        data.name = "Donnie";
        data.image = R.drawable.donnie;
        list.add(data);

        data = new PlatformData();
        data.name = "Danny";
        data.image = R.drawable.danny;
        list.add(data);

        return list;

    }
}
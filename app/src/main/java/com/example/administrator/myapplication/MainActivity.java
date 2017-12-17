package com.example.administrator.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.myapplication.adapter.MainAdapter;
import com.example.administrator.myapplication.fragment.PersonalFragment;
import com.example.administrator.myapplication.fragment.VerticalLoopFragment;
import com.example.administrator.myapplication.widght.HorizontalViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HorizontalViewPager viewpager;
    private MainAdapter mainAdapter;
    private List<Fragment> fragments=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViewpagerDatas();
        initViewPager();
    }
    private void initViewpagerDatas(){
        fragments.add(new VerticalLoopFragment());
        fragments.add(new VerticalLoopFragment());
    }

    private void initViewPager(){
        viewpager= (HorizontalViewPager) findViewById(R.id.viewpager);
        mainAdapter=new MainAdapter(getSupportFragmentManager(),fragments);
        viewpager.setAdapter(mainAdapter);
        viewpager.setOffscreenPageLimit(2);
    }
}

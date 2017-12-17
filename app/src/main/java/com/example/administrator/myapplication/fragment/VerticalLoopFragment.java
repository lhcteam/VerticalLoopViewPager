package com.example.administrator.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.LoopViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.VerticalAdapter;
import com.example.administrator.myapplication.tansformer.DefaultTransformer;
import com.example.administrator.myapplication.widght.VerticalLoopViewPager;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.OVER_SCROLL_NEVER;

/**
 * Created by Administrator on 2017/12/15.
 */

public class VerticalLoopFragment extends Fragment {

    private VerticalLoopViewPager loopViewPager;
    private VerticalAdapter verticalAdapter;
    private List<Fragment> fragments=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_verticalveiwpager,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view){

        for (int i = 0; i < 3; i++) {
            PersonalFragment personalFragment=new PersonalFragment();
            Bundle mBundle= new Bundle();
            mBundle.putString("tag", String.valueOf(i));
            personalFragment.setArguments(mBundle);
            fragments.add(personalFragment);
        }


        loopViewPager=view.findViewById(R.id.pager);
        verticalAdapter=new VerticalAdapter(getChildFragmentManager(),fragments);
        loopViewPager.setAdapter(verticalAdapter);
        loopViewPager.setPageTransformer(true, new DefaultTransformer());
        loopViewPager.setOverScrollMode(OVER_SCROLL_NEVER);

    }

}

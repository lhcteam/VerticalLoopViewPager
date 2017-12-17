package com.example.administrator.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2017/12/15.
 */

public class PersonalFragment extends Fragment {

    private TextView tv;
    private String tag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_personal,container,false);
        initDatas();
        initViews(view);
        return view;
    }
    private void initDatas(){
        tag=getArguments().getString("tag");
    }
    private void initViews(View view){
        tv=view.findViewById(R.id.tv);
        tv.setText(tag);
    }
}

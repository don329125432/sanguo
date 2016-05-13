package com.sanguo.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sanguo.Activity.WebView_Activity;
import com.sanguo.R;

/**
 * Created by jinrong on 2016/3/25.
 */
public class Home_Fragment extends Fragment implements View.OnClickListener {
    private LinearLayout mBaidutieba;
    private Intent intent;
    private LinearLayout mXiaobazhu;
    private LinearLayout mBazhu;
    private LinearLayout mZhiyebazhu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBaidutieba = (LinearLayout) view.findViewById(R.id.baidutieba);
        mZhiyebazhu = (LinearLayout) view.findViewById(R.id.zhiyebazhu);
        mBazhu = (LinearLayout) view.findViewById(R.id.bazhu);
        mXiaobazhu = (LinearLayout) view.findViewById(R.id.xiaobazhu);

        mBaidutieba.setOnClickListener(this);
        mZhiyebazhu.setOnClickListener(this);
        mBazhu.setOnClickListener(this);
        mXiaobazhu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.baidutieba:
                intent = new Intent(getActivity(),WebView_Activity.class);
                intent.putExtra("key", "tieba");
                startActivity(intent);
                break;
            case R.id.zhiyebazhu:
                intent = new Intent(getActivity(),WebView_Activity.class);
                intent.putExtra("key","zhiyebazhu");
                startActivity(intent);
                break;
            case R.id.bazhu:
                intent = new Intent(getActivity(),WebView_Activity.class);
                intent.putExtra("key","bazhu");
                startActivity(intent);
                break;
            case R.id.xiaobazhu:
                intent = new Intent(getActivity(),WebView_Activity.class);
                intent.putExtra("key","xiaobazhu");
                startActivity(intent);
                break;
        }
    }
}

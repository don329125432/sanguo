package com.sanguo.Fragment.data;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sanguo.Adapter.MyFragment;
import com.sanguo.Fragment.data.wujiang.qun.Wujiang_qun_Fragment;
import com.sanguo.Fragment.data.wujiang.shu.Wujiang_shu_Fragment;
import com.sanguo.Fragment.data.wujiang.wei.Wujiang_wei_Fragment;
import com.sanguo.Fragment.data.wujiang.wu.Wujiang_wu_Fragment;
import com.sanguo.R;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinrong on 2016/3/25.
 */
public class Data_Fragment extends Fragment implements View.OnClickListener {
    private ImageView mData_wujiang;
    private ImageView mData_zhanyi;
    private ImageView mData_ziliao;
    private FragmentManager supportFragmentManager;
    private TabPageIndicator mTpi;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.data_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mData_wujiang = (ImageView) view.findViewById(R.id.data_wujiang);
        mData_zhanyi = (ImageView) view.findViewById(R.id.data_zhanyi);
        mData_ziliao = (ImageView) view.findViewById(R.id.data_ziliao);

        mData_wujiang.setOnClickListener(this);
        mData_zhanyi.setOnClickListener(this);
        mData_ziliao.setOnClickListener(this);

        supportFragmentManager = getFragmentManager();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.data_wujiang:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl,new Wujiang_Fragment()).commit();
                break;
            case  R.id.data_zhanyi:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl,new Zhanyi_Fragment()).commit();
                break;
            case  R.id.data_ziliao:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl,new Ziliao_Fragment()).commit();
                break;

        }
    }
}

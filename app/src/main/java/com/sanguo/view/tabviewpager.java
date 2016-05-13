package com.sanguo.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sanguo.R;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/13.
 */
public class tabviewpager extends Fragment {
    private TabPageIndicator mTpi;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tebpager_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
    }

        private void init(View view) {
        mTpi = ((TabPageIndicator) view.findViewById(R.id.tpi));
        mViewPager = ((ViewPager) view.findViewById(R.id.vp));

        List<Fragment> fragmentList = new ArrayList<>();

//        fragmentList.add(new Wujiang_wei_Fragment());
//        fragmentList.add(new Wujiang_shu_Fragment());
//        fragmentList.add(new Wujiang_wu_Fragment());
//        fragmentList.add(new Wujiang_qun_Fragment());
//        MyFragment adapter = new MyFragment(getFragmentManager(), fragmentList);
//
//        mViewPager.setAdapter(adapter);
//        mTpi.setViewPager(mViewPager);
//        mViewPager.setCurrentItem(0);
    }
}

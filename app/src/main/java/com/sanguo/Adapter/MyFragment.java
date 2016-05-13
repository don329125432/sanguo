package com.sanguo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/13.
 */
public class MyFragment extends FragmentPagerAdapter {

    private List<Fragment> framentList = new ArrayList<>();

    private String[] titleList = {"魏","蜀","吴","群雄"};

    public MyFragment(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.framentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        if (framentList.size() != 0){
            return framentList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return framentList.size();
    }

    @Override
    public  CharSequence getPageTitle(int position){
        return titleList[position];
    }
}

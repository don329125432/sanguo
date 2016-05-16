package com.sanguo.Fragment.data;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sanguo.Fragment.data.wujiang.qun.Wujiang_qun_Fragment;
import com.sanguo.Fragment.data.wujiang.shu.Wujiang_shu_Fragment;
import com.sanguo.Fragment.data.wujiang.wei.Wujiang_wei_Fragment;
import com.sanguo.Fragment.data.wujiang.wu.Wujiang_wu_Fragment;
import com.sanguo.R;

/**
 * Created by jinrong on 2016/4/18.
 */
public class Wujiang_Fragment extends Fragment implements View.OnClickListener {
    private ImageView mWu_wei;
    private ImageView mWu_shu;
    private ImageView mWu_wu;
    private ImageView mWu_qun;
    private FragmentManager supportFragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wujiang_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mWu_wei = (ImageView) view.findViewById(R.id.wujiang_wei);
        mWu_shu = (ImageView) view.findViewById(R.id.wujiang_shu);
        mWu_wu = (ImageView) view.findViewById(R.id.wujiang_wu);
        mWu_qun = (ImageView) view.findViewById(R.id.wujiang_qun);

        supportFragmentManager = getFragmentManager();

        mWu_qun.setOnClickListener(this);
        mWu_shu.setOnClickListener(this);
        mWu_wei.setOnClickListener(this);
        mWu_wu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wujiang_wei:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Wujiang_wei_Fragment()).commit();
                break;
            case R.id.wujiang_shu:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Wujiang_shu_Fragment()).commit();
                break;
            case R.id.wujiang_wu:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Wujiang_wu_Fragment()).commit();
                break;
            case R.id.wujiang_qun:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Wujiang_qun_Fragment()).commit();
                break;
        }
    }

}
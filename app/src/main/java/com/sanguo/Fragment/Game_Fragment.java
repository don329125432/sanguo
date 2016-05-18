package com.sanguo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sanguo.R;

/**
 * Created by jinrong on 2016/3/25.
 */
public class Game_Fragment extends Fragment implements View.OnClickListener {
    private TextView mOver;
    private TextView mSet;
    private Button mJia;
    private Button mJian;
    private Button mChen;
    private Button mChu;
    private Button mDian;
    private Button mDeng;
    private Button mYi;
    private Button mEr;
    private Button mSan;
    private Button mSi;
    private Button mWu;
    private Button mLiu;
    private Button mQi;
    private Button mBa;
    private Button mJiu;
    private Button mLin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mOver = (TextView) view.findViewById(R.id.over);
        mSet = (TextView) view.findViewById(R.id.set);
        mJia = (Button) view.findViewById(R.id.jia);
        mJian = (Button) view.findViewById(R.id.jian);
        mChen = (Button) view.findViewById(R.id.chen);
        mChu = (Button) view.findViewById(R.id.chu);
        mDian = (Button) view.findViewById(R.id.dian);
        mDeng = (Button) view.findViewById(R.id.deng);
        mYi = (Button) view.findViewById(R.id.yi);
        mEr = (Button) view.findViewById(R.id.er);
        mSan = (Button) view.findViewById(R.id.san);
        mSi = (Button) view.findViewById(R.id.si);
        mWu = (Button) view.findViewById(R.id.wu);
        mLiu = (Button) view.findViewById(R.id.liu);
        mQi = (Button) view.findViewById(R.id.qi);
        mBa = (Button) view.findViewById(R.id.ba);
        mJiu = (Button) view.findViewById(R.id.jiu);
        mLin = (Button) view.findViewById(R.id.lin);

        mOver.setOnClickListener(this);
        mSet.setOnClickListener(this);
        mJia.setOnClickListener(this);
        mJian.setOnClickListener(this);
        mChen.setOnClickListener(this);
        mChu.setOnClickListener(this);
        mDian.setOnClickListener(this);
        mDeng.setOnClickListener(this);
        mYi.setOnClickListener(this);
        mEr.setOnClickListener(this);
        mSan.setOnClickListener(this);
        mSi.setOnClickListener(this);
        mWu.setOnClickListener(this);
        mLiu.setOnClickListener(this);
        mQi.setOnClickListener(this);
        mBa.setOnClickListener(this);
        mJiu.setOnClickListener(this);
        mLin.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.yi:
                mSet.setText("1");
        }
    }
}

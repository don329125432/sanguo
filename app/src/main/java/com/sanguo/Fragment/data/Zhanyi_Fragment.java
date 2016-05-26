package com.sanguo.Fragment.data;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sanguo.R;

/**
 * Created by jinrong on 2016/4/18.
 */
public class Zhanyi_Fragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private Button mZhanyi;
    private Button mZhanyi2;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhanyi_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mZhanyi = (Button) view.findViewById(R.id.zhanyi_but);
        mZhanyi.setOnClickListener(this);
        mZhanyi2 = (Button) view.findViewById(R.id.zhanyi_but2);
        mZhanyi2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhanyi_but:
                intent = new Intent(getActivity(), LocationModeSourceActivity.class);
                startActivity(intent);
                break;
            case R.id.zhanyi_but2:
                intent = new Intent(getActivity(),GPSActivity.class);
                startActivity(intent);
                break;
        }
    }
}

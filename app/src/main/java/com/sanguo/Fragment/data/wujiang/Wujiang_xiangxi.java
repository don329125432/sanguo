package com.sanguo.Fragment.data.wujiang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.sanguo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jinrong on 2016/4/21.
 */
public class Wujiang_xiangxi extends Activity {
    private ImageView mWei_jieshao_zhaopian;
    private TextView mWei_jieshao_name;
    private TextView mWei_jieshao_biaozi;
    private TextView mWei_jieshao_shengri;
    private TextView mWei_jieshao_zhiye;
    private TextView mWei_jieshao_zuji;
    private TextView mWei_jieshao_jianjie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wei_wujiang_xiangxi);

        mWei_jieshao_zhaopian = (ImageView) findViewById(R.id.wei_jieshao_zhaopian);
        mWei_jieshao_name = (TextView) findViewById(R.id.wei_jieshao_name);
        mWei_jieshao_biaozi = (TextView) findViewById(R.id.wei_jieshao_biaozi);
        mWei_jieshao_zhiye = (TextView) findViewById(R.id.wei_jieshao_zhiye);
        mWei_jieshao_shengri = (TextView) findViewById(R.id.wei_jieshao_shengri);
        mWei_jieshao_zuji = (TextView) findViewById(R.id.wei_jieshao_zuji);
        mWei_jieshao_jianjie = (TextView) findViewById(R.id.wei_jieshao_jianjie);

        Bundle bundle = getIntent().getExtras();
        ArrayList list = bundle.getParcelableArrayList("list");
        List<Map<String, Object>> lists = (List<Map<String, Object>>) list;

        for (Map<String, Object> m : lists) {
            mWei_jieshao_name.setText(String.valueOf(m.get("name")));

            mWei_jieshao_zhaopian.setBackgroundResource((Integer) m.get("zhaopian"));

            mWei_jieshao_biaozi.setText(String.valueOf(m.get("biaozi")));

            mWei_jieshao_zhiye.setText(String.valueOf(m.get("zhiwei")));

            mWei_jieshao_shengri.setText(String.valueOf(m.get("shengri")));

            mWei_jieshao_zuji.setText(String.valueOf(m.get("zuji")));

            mWei_jieshao_jianjie.setText(String.valueOf(m.get("jianjie")));
        }
    }
}

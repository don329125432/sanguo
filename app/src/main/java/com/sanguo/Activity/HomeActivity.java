package com.sanguo.Activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.sanguo.Fragment.data.Data_Fragment;
import com.sanguo.Fragment.Forum_Fragment;
import com.sanguo.Fragment.Game_Fragment;
import com.sanguo.Fragment.Home_Fragment;
import com.sanguo.Fragment.my.My_Fragment;
import com.sanguo.R;

/**
 * Created by jinrong on 2016/3/22.
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentManager supportFragmentManager;
    private RadioButton mHome;
    private RadioButton mData;
    private RadioButton mForum;
    private RadioButton mMy;
    private RadioButton mGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        supportFragmentManager = getSupportFragmentManager();
        initView();
        supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Home_Fragment()).commit();

        Drawable drawable1 = getResources().getDrawable(R.mipmap.home);
        Drawable drawable2 = getResources().getDrawable(R.mipmap.datas);
        Drawable drawable3 = getResources().getDrawable(R.mipmap.forum);
        Drawable drawable4 = getResources().getDrawable(R.mipmap.game);
        Drawable drawable5 = getResources().getDrawable(R.mipmap.my);
        drawable1.setBounds(0, 10, 50, 50);
        drawable2.setBounds(0, 10, 50, 50);
        drawable3.setBounds(0, 10, 50, 50);
        drawable4.setBounds(0, 10, 50, 50);
        drawable5.setBounds(0, 10, 50, 50);
        mHome.setCompoundDrawables(null, drawable1, null, null);
        mData.setCompoundDrawables(null, drawable2, null, null);
        mForum.setCompoundDrawables(null, drawable3, null, null);
        mGame.setCompoundDrawables(null, drawable4, null, null);
        mMy.setCompoundDrawables(null, drawable5, null, null);
    }


    private void initView() {
        mHome = (RadioButton) findViewById(R.id.home_home);
        mData = (RadioButton) findViewById(R.id.home_data);
        mForum = (RadioButton) findViewById(R.id.home_forum);
        mMy = (RadioButton) findViewById(R.id.home_my);
        mGame = (RadioButton) findViewById(R.id.home_game);

        mHome.setOnClickListener(this);
        mData.setOnClickListener(this);
        mForum.setOnClickListener(this);
        mMy.setOnClickListener(this);
        mGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_home:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Home_Fragment()).commit();
                break;
            case R.id.home_data:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Data_Fragment()).commit();
                break;
            case R.id.home_forum:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Forum_Fragment()).commit();
                break;
            case R.id.home_game:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Game_Fragment()).commit();
                break;
            case R.id.home_my:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new My_Fragment()).commit();
                break;
        }
    }
}

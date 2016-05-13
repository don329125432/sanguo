package com.sanguo.Fragment.my;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.sanguo.Contact;
import com.sanguo.Fragment.my.My_Fragment;
import com.sanguo.R;
import com.sanguo.dao.LoginDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jinrong on 2016/4/7.
 */
public class Reg_Fragment extends Fragment implements View.OnClickListener {
    private EditText mReg_Mobile;
    private EditText mReg_Password;
    private Button mReg_Next;
    private EditText mReg_Password_tow;
    private String Mobile;
    private String Password;
    private String Password_tow;
    private LoginDao logindao;
    private FragmentManager supportFragmentManager;
    private ImageView mReg_Fanhui;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reg_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mReg_Mobile = (EditText) view.findViewById(R.id.Reg_Mobile);
        mReg_Password = (EditText) view.findViewById(R.id.Reg_Password);
        mReg_Next = (Button) view.findViewById(R.id.Reg_Next);
        mReg_Password_tow = (EditText) view.findViewById(R.id.Reg_Password_tow);
        mReg_Fanhui = (ImageView) view.findViewById(R.id.Reg_fanhui);

        mReg_Mobile.setOnClickListener(this);
        mReg_Next.setOnClickListener(this);
        mReg_Password.setOnClickListener(this);
        mReg_Password_tow.setOnClickListener(this);
        mReg_Fanhui.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Reg_Next:
                yanzheng();
                break;
            case R.id.Reg_fanhui:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new My_Fragment()).commit();
                break;
        }
    }

    public void yanzheng() {
        Mobile = mReg_Mobile.getText().toString();
        Password = mReg_Password.getText().toString();
        Password_tow =mReg_Password_tow.getText().toString();

        supportFragmentManager = getFragmentManager();

        String zz1 = "^((13[0-9])|(15[^4,\\d])|(18[0-9]))\\d{8}$";
        Pattern mob = Pattern.compile(zz1);
        Matcher mobile = mob.matcher(Mobile);
        boolean mo = mobile.find();

        String zz2 = "^[a-zA-Z]\\w{5,17}$";
        Pattern pw = Pattern.compile(zz2);
        Matcher password = pw.matcher(Password);
        boolean pa = password.find();

        if (Password == null || Password.length() == 0
                || Password_tow == null || Password_tow.length() == 0
                || Mobile == null || Mobile.length() == 0) {
            Toast.makeText(getContext(), "您的账号密码输入不完全", Toast.LENGTH_SHORT).show();
            return;
        } else if (mo != true) {
            Toast.makeText(getContext(), "您输入的手机号有误", Toast.LENGTH_SHORT).show();
            return;
        } else if (pa != true) {
            Toast.makeText(getContext(), "您输入的密码格式不对", Toast.LENGTH_SHORT).show();
            return;
        } else if (!Password.equals(Password_tow)) {
            Toast.makeText(getContext(), "您两次输入的密码不一样", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(getContext(), "您已经注册成功", Toast.LENGTH_SHORT).show();
            Contact contact = new Contact(Mobile, Password);
            logindao = new LoginDao();
            logindao.addContact(contact,getContext());
            supportFragmentManager.beginTransaction().replace(R.id.home_fl, new My_Fragment()).commit();
        }
    }
}
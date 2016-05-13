package com.sanguo.Fragment.my;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sanguo.Contact;
import com.sanguo.R;
import com.sanguo.dao.LoginDao;

/**
 * Created by jinrong on 2016/3/25.
 */
public class My_Fragment extends Fragment implements View.OnClickListener {
    private EditText mUsername;
    private EditText mPassword;
    private CheckBox mRememberPass;
    private Button mLogin;
    private Button mReg;
    private RadioButton mForgetPassword;
    private SharedPreferences mpref;
    private SharedPreferences.Editor editor;
    private FragmentManager supportFragmentManager;
    private Contact contact;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLogin = (Button) view.findViewById(R.id.Login);
        mReg = (Button) view.findViewById(R.id.Reg);
        mForgetPassword = (RadioButton) view.findViewById(R.id.ForgetPassword);
        mUsername = (EditText) view.findViewById(R.id.Username);
        mPassword = (EditText) view.findViewById(R.id.Password);
        mRememberPass = (CheckBox) view.findViewById(R.id.remeber_pass);

        mReg.setOnClickListener(this);
        mForgetPassword.setOnClickListener(this);
        mUsername.setOnClickListener(this);
        mPassword.setOnClickListener(this);
        mRememberPass.setOnClickListener(this);

        supportFragmentManager = getFragmentManager();

        mpref = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean isRemeber = mpref.getBoolean("remember_password", false);

        if (isRemeber) {
            String username = mpref.getString("username", "");
            String password = mpref.getString("password", "");
            mUsername.setText(username);
            mPassword.setText(password);
            mRememberPass.setChecked(true);
        }

        mLogin.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          String username = mUsername.getText().toString();
                                          String password = mPassword.getText().toString();

                                          LoginDao loginDao = new LoginDao();
                                          if (loginDao.getContact(username, getContext()) == null) {
                                              Toast.makeText(getContext(), "您并未输入账号密码", Toast.LENGTH_SHORT).show();
                                          } else {
                                              contact = loginDao.getContact(username, getContext());

                                              if (username.equals(contact.getKEY_MOBLIE()) && password.equals(contact.getKEY_PASSWORD())) {
                                                  editor = mpref.edit();

                                                  if (mRememberPass.isChecked()) {
                                                      editor.putBoolean("remember_password", true);
                                                      editor.putString("username", username);
                                                      editor.putString("password", password);
                                                  } else {
                                                      editor.clear();
                                                  }
                                                  editor.commit();
                                                  supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Login_Fragment()).commit();
                                                  Toast.makeText(getContext(), "欢迎您" + contact.getKEY_MOBLIE() + "回来", Toast.LENGTH_SHORT).show();
                                              } else {
                                                  Toast.makeText(getContext(), "您的账号密码输入有误", Toast.LENGTH_SHORT).show();
                                              }
                                          }
                                      }
                                  }
        );
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Reg:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new Reg_Fragment()).commit();
                break;
            case R.id.ForgetPassword:
                supportFragmentManager.beginTransaction().replace(R.id.home_fl, new ForgetPassword_Fragment()).commit();
                break;
        }
    }
}

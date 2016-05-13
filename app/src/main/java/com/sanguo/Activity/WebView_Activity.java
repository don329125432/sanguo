package com.sanguo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sanguo.R;

/**
 * Created by jinrong on 2016/5/4.
 */
public class WebView_Activity extends Activity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);

        mWebView = (WebView) findViewById(R.id.webview_tieba);
        //getSettings()可以设置游览器属性，也可以为空，setJavaScriptEnabled(true)支持JavaScript脚本
        mWebView.getSettings().setJavaScriptEnabled(true);
        //关键——此句可以让网页在当前webview中打开而非游览器
        mWebView.setWebViewClient(new WebViewClient());

        Intent intent = getIntent();
        String data = intent.getStringExtra("key");

        switch (data){
            case "tieba":
                mWebView.loadUrl("http://tieba.baidu.com/f?kw=%C8%FD%B9%FA%D6%BE9&pn=0&");
                break;
            case "zhiyebazhu":
                mWebView.loadUrl("http://tieba.baidu.com/home/main?un=%CE%F7%C1%B9%B3%AC%B8%E7");
                break;
            case "bazhu":
                mWebView.loadUrl("http://tieba.baidu.com/home/main/?un=yi%E4%B8%96%EF%BF%A1%E6%99%BA%E5%B0%86&ie=utf-8&fr=frs");
                break;
            case "xiaobazhu":
                mWebView.loadUrl("http://tieba.baidu.com/home/main?un=%C9%DB%B0%EB%CF%B917K");
                break;
        }
    }
}

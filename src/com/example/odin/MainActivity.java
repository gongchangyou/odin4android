package com.example.odin;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {
	private WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 填充标题栏
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //强制竖屏
        webView = (WebView) findViewById(R.id.WebView01);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://172.16.1.114:8080/m/");//地址
        webView.setVerticalScrollBarEnabled(false);//不显示滚动条
    	//webView.loadDataWithBaseURL("http://172.16.1.114:8080/m/", "", "text/html", "utf-8", "");
        webView.setWebViewClient(new WebViewClient(){    
        
        	public boolean shouldOverrideUrlLoading(WebView view, String url) {    
        	
        		view.loadUrl(url);    
        	
                return true;    
        	
            }    
        	
        });

        
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {//按手机返回功能键 
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) { 
        	webView.goBack(); //goBack()表示返回WebView的上一页面 
            return true; 
        } 
        return false; 
    } 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

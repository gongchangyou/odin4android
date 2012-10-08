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
        requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //ǿ������
        webView = (WebView) findViewById(R.id.WebView01);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://172.16.1.114:8080/m/");//��ַ
        webView.setVerticalScrollBarEnabled(false);//����ʾ������
    	//webView.loadDataWithBaseURL("http://172.16.1.114:8080/m/", "", "text/html", "utf-8", "");
        webView.setWebViewClient(new WebViewClient(){    
        
        	public boolean shouldOverrideUrlLoading(WebView view, String url) {    
        	
        		view.loadUrl(url);    
        	
                return true;    
        	
            }    
        	
        });

        
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {//���ֻ����ع��ܼ� 
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) { 
        	webView.goBack(); //goBack()��ʾ����WebView����һҳ�� 
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

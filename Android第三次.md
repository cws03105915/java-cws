##本实验通过自定义WebView加载URL来验证隐式Intent的使用。
实验包含两个应用：第一个应用：获取URL地址并启动隐式Intent的调用。
第二个应用：自定义WebView来加载URL<pre><code>

package  com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.net.Uri;

//public class MainActivity extends AppCompatActivity{

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        initView();
//    }
//    private void initView() {
//        Intent intent = getIntent();
//        String url = intent.getStringExtra("url");
//        if(TextUtils.isEmpty(url)) {
//            url = "http://www.baidu.com";
//        }
//        WebView webView = (WebView) findViewById(R.id.wbvw);
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
//        webView.loadUrl(url);
//    }
//}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String strUriHome = null;
    WebView webView;//浏览器
    EditText edtttUri;//地址栏
    Button btnGo;//打开网页按钮
    Button btnHome;//首页按钮
    Button btnBack;//返回按钮
    Button btnForward;//前进按钮
    Button btnRefresh;//刷新按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String url = intent.getData().toString();
        if(TextUtils.isEmpty(url)) {
            url = "http://www.baidu.com";
        }
        strUriHome = url;

        webView = (WebView)findViewById(R.id.wbvw);
        edtttUri = (EditText)findViewById(R.id.edtttUri);
        btnGo = (Button)findViewById(R.id.btnGo);
        btnHome = (Button)findViewById(R.id.btnHome);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnForward = (Button)findViewById(R.id.btnForeward);
        btnRefresh = (Button)findViewById(R.id.btnRefresh);

        webView.getSettings().setJavaScriptEnabled(true);//让浏览器支持javascript
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onLoadResource(WebView view, String url) {
                edtttUri.setText(view.getUrl());//当前WebView网址更新显示到地址栏
                super.onLoadResource(view, url);
            }
        });  //当跳转网页时，仍在WebView中打开。
        webView.loadUrl(strUriHome);

        edtttUri.setText(strUriHome);

        btnGo.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnForward.setOnClickListener(this);
        btnRefresh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //转到
            case R.id.btnGo:
                try {
                    String strUri = uriHttpFirst(edtttUri.getText().toString());//网址协议判断
                    webView.loadUrl(strUri);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            //首页
            case R.id.btnHome:
                try {
                    webView.loadUrl(strUriHome);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            //返回
            case R.id.btnBack:
                try {
                    webView.goBack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            //前进
            case R.id.btnForeward:
                try {
                    webView.goForward();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            //刷新
            case R.id.btnRefresh:
                try {
                    webView.reload();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
    //地址HTTP协议判断，无HTTP打头的，增加http://，并返回。
    private String uriHttpFirst(String strUri){

        if(strUri.indexOf("http://",0) != 0 && strUri.indexOf("https://",0) != 0 ){
            strUri = "http://" + strUri;
        }

        return strUri;
    }


}
package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;//注意view的大小写
import android.view.View.OnClickListener;
import android.net.Uri;
import android.widget.EditText;

public class input_url extends AppCompatActivity {

    private Button browse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Browse();
    }
    void Browse(){
        browse = (Button)findViewById(R.id.btn1) ;
        browse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText text = (EditText) findViewById(R.id.editUri);
                String address = text.getText().toString();
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(address);
                intent.setData(content_url);
                startActivity(intent);
            }
        });

    }
}


</pre></code>
atx-style:
##新建一个工程用来获取URL地址并启动Intent
输入URL网址，点击按钮，将发起浏览网页的行为<pre><code>
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.administrator.myapplication.input_url">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:focusableInTouchMode="true"
            android:orientation="horizontal">
    <EditText
        android:id="@+id/editUri"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:singleLine="true"
        android:maxLines="1"
        android:scrollHorizontally="false"
        android:layout_weight="1"
        android:text="http://baidu.com"
        />
        </LinearLayout>
    <Button
        android:id="@+id/btn1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="浏览该网页"
       />
    </LinearLayout>
</android.support.constraint.ConstraintLayout>

</pre></code>

atx-style:
##新建一个工程使用WebView来加载URL
跳转之后，出现选择项，选择自定义的MyBrowser进行浏览<pre><code>
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.administrator.myapplication.MainActivity">
   // tools:context="com.example.administrator.myapplication.MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:focusableInTouchMode="true"
        android:orientation="horizontal">
        <EditText
            android:id="@+id/edtttUri"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:singleLine="true"
            android:maxLines="1"
            android:scrollHorizontally="false"
            android:layout_weight="1"
            />
        <Button
            android:id="@+id/btnGo"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="转到"/>
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <Button
            android:id="@+id/btnHome"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="首页"/>
        <Button
            android:id="@+id/btnBack"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="后退"/>
        <Button
            android:id="@+id/btnForeward"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="前进"/>
        <Button
            android:id="@+id/btnRefresh"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="刷新"/>
    </LinearLayout>
    <WebView
        android:id="@+id/wbvw"
        android:layout_width="match_parent"
        android:layout_height="match_parent"></WebView>
</LinearLayout>


</pre></code>


package com.ff.todaytoutiao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 时间: 2017/8/13
 * 类作用:
 */
@ContentView(R.layout.activity_webview)
public class WebViewActivity extends Activity {

    @ViewInject(R.id.gou_back)
    ImageView gouback;
    @ViewInject(R.id.title_name)
    TextView name;
    @ViewInject(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        Intent intent = getIntent();
        String item_url = intent.getStringExtra("item_url");
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);//用于与jS交互
        settings.setBuiltInZoomControls(true);//设置出现缩放工具
        settings.setSupportZoom(true);//支持网页的缩放
        webview.loadUrl(item_url);
        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                name.setText(title);
            }
        });

        gouback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

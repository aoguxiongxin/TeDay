package com.ff.todaytoutiao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.andy.library.ChannelActivity;
import com.andy.library.ChannelBean;
import com.google.gson.Gson;

import java.util.List;

/**
 * 时间: 2017/8/18
 * 类作用:这个类是继承自频道管理的类,把里面的两个方法重写了一下,然后在跳转哪里设置成跳转这个Activity
 * 页面,记得注册,这样就可以让顶部的返回按钮生效
 */

public class MyChannalActivity extends ChannelActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static void startChannelActivity(AppCompatActivity context, String jsonArray) {
//  注意这个要跳转的Activity是现在这个重新创建的
        Intent intent = new Intent(context, MyChannalActivity.class);
        intent.putExtra(RESULT_JSON_KEY, jsonArray);
        context.startActivityForResult(intent, REQUEST_CODE);
    }

    public static void startChannelActivity(AppCompatActivity context, List<ChannelBean> list) {
        Gson gson = new Gson();
        String jsonArray = gson.toJson(list);
        startChannelActivity(context, jsonArray);
    }
}

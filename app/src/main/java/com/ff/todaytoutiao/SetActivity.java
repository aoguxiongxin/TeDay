package com.ff.todaytoutiao;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import cn.jpush.android.api.JPushInterface;

/**
 * 时间: 2017/8/12
 * 类作用:
 */

public class SetActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView gouback;
    private CheckBox tongzhiCheckBox;
    //用来保存通知的状态
    public static final String TONGZHI = "TONGZHI";
    //保存通知的key
    public static final String TONGZHI_CHECKBOX = "TONGZHI_CHECKBOX";

    private SharedPreferences NotiFication_sp;
    private RelativeLayout tongzhi;
    private RelativeLayout type_mobile;
    private RelativeLayout clear_cache;
    private TextView mobileMode;
    private String[] strings = new String[]{"最佳效果(下载大图)", "较省流量(智能下图)",
            "极省流量(不下载图)"};
    private String[] str = new String[]{"小", "中", "大", "特大"};
    private SharedPreferences MobileSTyle;
    private TextView huancun;
    private RelativeLayout textSize_mode;
    private SharedPreferences textSize_sp;
    private TextView text_size;
    private SharedPreferences setTextSize_sp;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                String size = (String) msg.obj;
                //修改当前缓存大小
                huancun.setText("当前缓存:" + size);
            }
        }
    };
    private TextView pinglun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        //保存通知的状态
        NotiFication_sp = getSharedPreferences(TONGZHI, MODE_PRIVATE);
        //保存字体大小的SharedPreferences
        textSize_sp = getSharedPreferences(MainActivity.TEXTSIZE_KEY, MODE_PRIVATE);
        //保存字体选择模式
        setTextSize_sp = getSharedPreferences("SetTextSize", MODE_PRIVATE);
        //保存移动数据状态下选择的图片加载模式
        MobileSTyle = getSharedPreferences(MobileStyle.TYPE_MOBILE_KEY, Context.MODE_PRIVATE);

        //初始化控件
        initView();

        tongzhiCheckBox.setChecked(NotiFication_sp.getBoolean(TONGZHI_CHECKBOX, true));
        //复选框的点击事件
        CheckBoxListener();

        //设置文字默认的大小类型
        text_size.setText(str[setTextSize_sp.getInt("TextSize_which", 1)]);

        //开启子线程,计算缓存文件的大小
        //获取缓存文件夹的大小
        //复选框的点击事件,因为刚进入的时候就计算,会造成跳转卡顿,所以在主线程开辟了子线程来计算,
//    最后在handler中更新UI
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //保存缓存图片的路劲
                    File Cachepath = new File(Environment.getExternalStorageDirectory().getPath() +
                            "/ImageLoaderCache");
                    int FileSize = 0;
//            分别得到里面文件的大小
                    for (int i = 0; i < Cachepath.listFiles().length; i++) {
                        File file1 = Cachepath.listFiles()[i];
                        FileInputStream fi = new FileInputStream(file1);
                        FileSize += fi.available();
                    }
                    //得到文件的大小,设置到huancun这个TextView上面显示
                    String size = Formatter.formatFileSize(SetActivity.this, FileSize);
                    Message msg = Message.obtain();
                    msg.what = 1;
                    msg.obj = size;
                    handler.sendMessage(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        ////得到缓存文件
        getCache();

    }

    //得到缓存文件
    private void getCache() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
                long size = 0;
                //得到内置缓存
                File cacheDir = getCacheDir();
                //得到外置缓存
                File externalCacheDir = getExternalCacheDir();

                int cacheSize = getCacheSize(cacheDir);
                int cacheSize1 = getCacheSize(externalCacheDir);
                //使用这个方法可以让大小格式化,变成几M,几G,因为我们正常得到的是byte字节
                String s = Formatter.formatFileSize(SetActivity.this, (cacheSize + cacheSize1));
                pinglun.setText("cache缓存:" + s);

                //使用下面这种方法也可以
                /*    File[] files = cacheDir.listFiles();
                    File[] excache = externalCacheDir.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        FileInputStream fi = new FileInputStream(files[i]);
                        size += fi.available();
                    }
                    for (int i = 0; i < excache.length; i++) {
                        FileInputStream fi = new FileInputStream(excache[i]);
                        size += fi.available();
                    }
                    String s = Formatter.formatFileSize(SetActivity.this, size);
                    pinglun.setText("cache缓存:" + s);
                } catch (Exception e) {
                    e.printStackTrace();
                }*/

            }
        }).start();
    }

    //计算内置和外置缓存大小
    private int getCacheSize(File file) {
        int size = 0;
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                getCacheSize(f);
            } else {
                size += f.length();
            }
        }
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            files[i].delete();
        }
        return size;
    }

    private void deleteCacheSize(File file) {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                getCacheSize(f);
            } else {
                f.delete();
            }
        }
    }

    //通知复选框的点击事件,开关
    private void CheckBoxListener() {
        tongzhiCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    NotiFication_sp.edit().putBoolean(TONGZHI_CHECKBOX, true).commit();
                    //如果选中,允许极光Mob通知
                    JPushInterface.resumePush(SetActivity.this);
                } else {
                    NotiFication_sp.edit().putBoolean(TONGZHI_CHECKBOX, false).commit();
                    //如果没选中,禁止极光Mob发送通知
                    JPushInterface.stopPush(SetActivity.this);
                }
                tongzhiCheckBox.setChecked(NotiFication_sp.getBoolean(TONGZHI_CHECKBOX, true));
            }
        });
    }

    //初始化View
    private void initView() {
        //顶部的返回箭头按钮
        gouback = (ImageView) findViewById(R.id.can_goback);
        //通知推送栏的复选框
        tongzhiCheckBox = (CheckBox) findViewById(R.id.tongzhiCheckBox);
        //通知推送的横向布局
        tongzhi = (RelativeLayout) findViewById(R.id.tongzhi);
        //非Wifi网络状态下的加载模式
        type_mobile = (RelativeLayout) findViewById(R.id.Type_Mobile);
        //清理缓冲
        clear_cache = (RelativeLayout) findViewById(R.id.clear_cache);
        //保存选择的非FIWI状态选择的模式
        mobileMode = (TextView) findViewById(R.id.MobileMode);
        //计算缓冲文件的大小
        huancun = (TextView) findViewById(R.id.huancun);
        //更改页面中文字的大小
        textSize_mode = (RelativeLayout) findViewById(R.id.textSize_mode);
        //显示文字大小的TextView
        text_size = (TextView) findViewById(R.id.text_size);
        //评论的TextView
        pinglun = (TextView) findViewById(R.id.pinglun);

        gouback.setOnClickListener(this);
        tongzhi.setOnClickListener(this);
        type_mobile.setOnClickListener(this);
        clear_cache.setOnClickListener(this);
        textSize_mode.setOnClickListener(this);
        //默认设置TextView显示的模式内容
        mobileMode.setText(strings[MobileSTyle.getInt(MobileStyle
                .TYPE_POSITION, 0)]);

    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.can_goback://返回
                finish();
                break;
            case R.id.tongzhi://推送通知开关
                if (tongzhiCheckBox.isChecked()) {
                    NotiFication_sp.edit().putBoolean(TONGZHI_CHECKBOX, false).commit();
                } else {
                    NotiFication_sp.edit().putBoolean(TONGZHI_CHECKBOX, true).commit();
                }
                tongzhiCheckBox.setChecked(NotiFication_sp.getBoolean(TONGZHI_CHECKBOX, true));
                break;
            case R.id.Type_Mobile://非WIFI状态下选择加载模式
                TypeMobileAlertDiaLog();
                break;
            case R.id.clear_cache://清除缓冲
                AlertDialog.Builder clear_builder = new AlertDialog.Builder(SetActivity.this);
                clear_builder.setMessage("确定要清除缓存吗?");
                clear_builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ImageLoader.getInstance().clearDiskCache();//清除缓存
                        ImageLoader.getInstance().clearMemoryCache();//清除内存缓存
                        //获取缓存文件夹的大小
                        getImageLoaderCacheSize();
                    }
                });
                clear_builder.setNegativeButton("取消", null);
                clear_builder.create().show();
                break;
            case R.id.textSize_mode://设置字体大小
                AlertDialog.Builder textsize_builder = new AlertDialog.Builder(SetActivity.this);
                textsize_builder.setTitle("字体大小");

                textsize_builder.setSingleChoiceItems(str, setTextSize_sp.getInt
                        ("TextSize_which", 1), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //设置字体大小
                        switch (which) {
                            case 0://小
                                textSize_sp.edit().putInt(MainActivity.TEXTSIZE_INTEGER,
                                        MainActivity.TEXTSIZE_SMALL).commit();
                                break;
                            case 1://中
                                textSize_sp.edit().putInt(MainActivity.TEXTSIZE_INTEGER,
                                        MainActivity.TEXTSIZE_CENTRE).commit();
                                break;
                            case 2://大
                                textSize_sp.edit().putInt(MainActivity.TEXTSIZE_INTEGER,
                                        MainActivity.TEXTSIZE_BIG).commit();
                                break;
                            case 3://特大
                                textSize_sp.edit().putInt(MainActivity.TEXTSIZE_INTEGER,
                                        MainActivity.TEXTSIZE_MAX_BIG).commit();
                                break;
                        }
                        //保存选中的状态
                        setTextSize_sp.edit().putInt("TextSize_which", which).commit();
                        //修改选中的文字类型
                        text_size.setText(str[setTextSize_sp.getInt("TextSize_which", 1)]);
                        dialog.dismiss();
                    }
                });
                textsize_builder.setNegativeButton("取消", null);
                textsize_builder.create().show();
                Intent intent = new Intent();
                setResult(301, intent);
                break;
        }

    }

    //得到ImageLoader加载到本地的缓存文件的大小
    private void getImageLoaderCacheSize() {
        try {
            //保存缓存图片的路劲
            File Cachepath = new File(Environment.getExternalStorageDirectory().getPath() +
                    "/ImageLoaderCache");
            int FileSize = 0;
//            分别得到里面文件的大小
            for (int i = 0; i < Cachepath.listFiles().length; i++) {
                File file1 = Cachepath.listFiles()[i];
                FileInputStream fi = new FileInputStream(file1);
                FileSize += fi.available();
            }
            //得到文件的大小,设置到huancun这个TextView上面显示
            String size = Formatter.formatFileSize(SetActivity.this, FileSize);
            huancun.setText("当前缓存:" + size);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //非WIFI状态下选择加载模式
    private void TypeMobileAlertDiaLog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SetActivity.this);
        builder.setTitle("请选择非WIFI网络加载模式:");
        builder.setSingleChoiceItems(strings, MobileSTyle.getInt(MobileStyle.TYPE_POSITION,
                0), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //保存选择的状态
                MobileSTyle.edit().putInt(MobileStyle.TYPE_POSITION, which).commit();
                //修改TextView显示的加载模式内容
                mobileMode.setText(strings[MobileSTyle.getInt(MobileStyle
                        .TYPE_POSITION, 0)]);
                //关闭弹窗
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", null);
        builder.create().show();

    }
}



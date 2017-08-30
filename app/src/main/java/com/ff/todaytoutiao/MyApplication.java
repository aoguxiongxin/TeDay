package com.ff.todaytoutiao;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatDelegate;
import android.widget.ImageView;

import com.mob.MobSDK;
import com.mob.commons.SMSSDK;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.x;

import java.io.File;

import cn.jpush.android.api.JPushInterface;


/**
 * 时间: 2017/8/10
 * 类作用:
 */

public class MyApplication extends Application {
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns" +
                ".whalecloud.com");
    }

    public static final String SP_NAME = "SP_NAME";
    public static final String SP_KEY = "SP_KEY";
    private static MyApplication myApplicaiton;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplicaiton = this;
        //手机验证登录初始化
        MobSDK.init(this, "1ff537dccc1b0", "2831ae8f2322b75878c0637cc140aaea");
        //初始化友盟,这里使用的友盟QQ和微信登录
        UMShareAPI.get(this);
        //初始化xutils
        x.Ext.init(this);
        //设置默认的模式,如果切换过日夜模式,在切换的时候会保存在SharedPreferences中,如果没有设置就设置默认的
        int mode = getSharedPreferences(SP_NAME, MODE_PRIVATE).getInt(SP_KEY, AppCompatDelegate
                .getDefaultNightMode());
        AppCompatDelegate.setDefaultNightMode(mode);
        //极光推送初始化
        JPushInterface.init(this);
//       初始化 ImageLoader
        MyImageLoader();

    }

    public void MyImageLoader() {
        File file = new File(Environment.getExternalStorageDirectory().getPath() +
                "/ImageLoaderCache");
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheExtraOptions(100, 100)
                .threadPoolSize(3)
                .threadPriority(100)
                .diskCache(new UnlimitedDiskCache(file))
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(100 * 1024 * 1024)
                .build();
        ImageLoader.getInstance().init(build);
    }

    public static Context Instance() {
        return myApplicaiton;
    }
}

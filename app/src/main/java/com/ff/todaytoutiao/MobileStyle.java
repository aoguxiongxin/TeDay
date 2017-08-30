package com.ff.todaytoutiao;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 时间: 2017/8/15
 * 类作用:
 */

public class MobileStyle {
    //三种加载图片的模式接口
    private static String BIG_STYLE = "www.big.com";//"最佳效果(下载大图)",
    private static String SMALL_STYLE = "www.small.com";//"较省流量(智能下图)",
    private static String NO_STYLE = "www.no.com";//"极省流量(不下载图)"

    //加载模式,默认是最佳效果
    public static String StyleValues = BIG_STYLE;
    //保存非WIFI网络加载模式的SharedPreferences的key值
    public static final String TYPE_MOBILE_KEY = "TYPEMOBILEVALUE";
    //保存选择的模式的下标
    public static final String TYPE_POSITION = "TYPE_POSITION";
    //判断是否有网络
    public static final String IS_NETWORK = "IS_NETWORK";


    public String setMode() {
        SharedPreferences sp = MyApplication.Instance().getSharedPreferences
                (TYPE_MOBILE_KEY, Context.MODE_PRIVATE);
        //判断如果是移动网络状态才进行选择
        if (sp.getBoolean(IS_NETWORK, false)) {
            //得到你所选择的图片加载模式,然后设置不同的接口
            int mode = sp.getInt(TYPE_POSITION, 0);
            switch (mode) {
                case 0:
                    StyleValues = BIG_STYLE;
                    break;
                case 1:
                    StyleValues = SMALL_STYLE;
                    break;
                case 2:
                    StyleValues = NO_STYLE;
                    break;
            }
        }
        return StyleValues;
    }

}

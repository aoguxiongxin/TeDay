package com.ff.todaytoutiao;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.andy.library.ChannelBean;
import com.ff.todaytoutiao.dao.Dao;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * 时间: 2017/8/9
 * 类作用:
 */

public class SlidingMent_Left extends Fragment implements View.OnClickListener {

    private View view;
    private ListView listview;
    private ArrayList<String> list;
    public static final String SP_NAME = "SP_NAME";
    public static final String SP_KEY = "SP_KEY";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.slidingment_left, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化存放listview里面item标题的集合
        list = new ArrayList<>();
        //查询数据库,如果是true的时候把名字添加到list集合,然后添加到适配器
        Dao dao = new Dao(getContext());
        ArrayList<ChannelBean> select = dao.select();
        for (int i = 0; i < select.size(); i++) {
            boolean isSelect = select.get(i).isSelect();
            if (isSelect)
                list.add(select.get(i).getName());
        }
        //初始化控件
        initView();
        listview.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout
                .simple_list_item_1, list));
        //listview的item点击事件
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //调用MainActivity的自定义方法,把当前下标传过去,让MainActivity主页面的VIewpager跳转
                MainActivity.getListViewItem(position);
            }
        });


    }

    //这里是友盟的回调,用来验证QQ和微信登录结果
    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getContext(), "登录成功", Toast.LENGTH_LONG).show();
            String iconurl = data.get("iconurl");
            String name = data.get("name");
            //调用Activity的方法把头像和用户昵称传过去
            MainActivity.getUserText(iconurl, name);
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getContext(), "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
            UMShareAPI.get(getContext()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ,
                    authListener);
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getContext(), "取消了", Toast.LENGTH_LONG).show();
        }
    };

    private void initView() {
        listview = (ListView) view.findViewById(R.id.slidingmentListView);
        ImageView mobile = (ImageView) view.findViewById(R.id.mobile);
        ImageView qq = (ImageView) view.findViewById(R.id.qq);
        ImageView sina = (ImageView) view.findViewById(R.id.sina);

        RadioButton day_night = (RadioButton) view.findViewById(R.id.daynight);
        RadioButton shezhi = (RadioButton) view.findViewById(R.id.rb_shezhi);
        RadioButton xiazai = (RadioButton) view.findViewById(R.id.xiazai_RadioButton);

        //更多登录方式按钮
        Button otherlogin = (Button) view.findViewById(R.id.otherlogin);
        mobile.setOnClickListener(this);
        qq.setOnClickListener(this);
        sina.setOnClickListener(this);
        otherlogin.setOnClickListener(this);
        //日夜模式点击事件
        day_night.setOnClickListener(this);
        //点击设置按钮,跳转到设置Activity页面
        shezhi.setOnClickListener(this);
        //离线下载按钮
        xiazai.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mobile://手机验证登录,使用的Mob集成
                //自定义方法调用系统自带的界面,打开手机注册页面
                registMobile();
                break;
            case R.id.qq://QQ登录,使用友盟,方法是一样的
                UMShareAPI.get(getContext()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ,
                        authListener);
                break;
            case R.id.sina://新浪登录,使用友盟
                UMShareAPI.get(getContext()).getPlatformInfo(getActivity(), SHARE_MEDIA.SINA,
                        authListener);
                break;
            case R.id.otherlogin://其他登录方式
                MainActivity.slidingMenu.toggle();
                MainActivity.slidingMenu.showSecondaryMenu();
                break;
            case R.id.xiazai_RadioButton://离线下载
                startActivity(new Intent(getActivity(), LiXian_Activity.class));
                break;
            case R.id.daynight://切换日夜模式
                DayAndNight();
                break;
            case R.id.rb_shezhi://跳转到设置页面
                startActivityForResult(new Intent(getContext(), SetActivity.class), 300);
                break;

        }
    }

    //切换日夜模式
    private void DayAndNight() {
        int uiMode = getResources().getConfiguration().uiMode & Configuration
                .UI_MODE_NIGHT_MASK;
        switch (uiMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                //保存这个模式,第二次进入的时候可以使用上次修改的模式
                getActivity().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit()
                        .putInt(SP_KEY, AppCompatDelegate.MODE_NIGHT_YES).commit();
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                //保存这个模式,第二次进入的时候可以使用上次修改的模式
                getActivity().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit()
                        .putInt(SP_KEY, AppCompatDelegate.MODE_NIGHT_NO).commit();
                break;
        }
        //重新启动Activity
        getActivity().recreate();
    }

    //调用系统自带的界面,打开手机注册页面
    private void registMobile() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                }
            }
        });
        registerPage.show(getContext());
    }

}

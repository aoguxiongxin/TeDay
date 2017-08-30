package com.ff.todaytoutiao;

import android.*;
import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.andy.library.ChannelActivity;
import com.andy.library.ChannelBean;
import com.ff.todaytoutiao.dao.Dao;
import com.ff.todaytoutiao.viewpager_Fragment.CaiJing_Fragment;
import com.ff.todaytoutiao.viewpager_Fragment.GuoJi_Fragment;
import com.ff.todaytoutiao.viewpager_Fragment.GuoNei_Fragment;
import com.ff.todaytoutiao.viewpager_Fragment.JunShi_Fragment;
import com.ff.todaytoutiao.viewpager_Fragment.KeJi_Fragment;
import com.ff.todaytoutiao.viewpager_Fragment.SheHui_Fragment;
import com.ff.todaytoutiao.viewpager_Fragment.ShiShang_Fragment;
import com.ff.todaytoutiao.viewpager_Fragment.TiYu_Fragment;
import com.ff.todaytoutiao.viewpager_Fragment.TouTiao_Fragment;
import com.ff.todaytoutiao.viewpager_Fragment.YuLe_Fragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.w3c.dom.NameList;
import org.xutils.x;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static ImageView handerimg;
    private TabLayout tablayout;
    private static ViewPager viewpager;
    private ArrayList<Fragment> list;
    private String[] title = new String[]{"头条", "社会", "国内", "国际", "娱乐", "体育", "军事",
            "科技", "财经", "时尚"};
    public static SlidingMenu slidingMenu;
    private static TextView handerTV;
    //保存SharedPreferences的name和key
    public static final String HANDER_IMAGE_NAME = "HANDER_IMAGE_NAME";
    public static final String HANDER_IMAGE_KEY = "HANDER_IMAGE_KEY";
    public static final String HANDER_NAME_KEY = "HANDER_NAME_KEY";
    private static SharedPreferences HanderImg_sp;
    //设置文字的字体大小
    private static SharedPreferences TextSize_sp;
    public static final String TEXTSIZE_KEY = "TEXTSIZE_KEY";//key
    public static final String TEXTSIZE_INTEGER = "TEXTSIZE_INTEGER";//保存int值的key
    public static final int TEXTSIZE_MAX_BIG = 27;//特大
    public static final int TEXTSIZE_BIG = 24;//大
    public static final int TEXTSIZE_CENTRE = 20;//中
    public static final int TEXTSIZE_SMALL = 17;//小
    private MyBroadCaseReceiver myBroadCaseReceiver;
    private TextView pingdaoguanli;
    private boolean isConnect;//判断是否是在有移动数据网络状态
    private MyAdapter adapter;
    private Dao dao;
    private ArrayList<ChannelBean> bean = null;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> nameList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //大于19的时候申请动态权限
        MyRequestPermissions();
        x.view().inject(this);
        //注册广播,监听网络
        RegisterReceiver();


        //创建操作数据库的对象
        dao = new Dao(this);
        //判断数据库是否为空,如果为空添加数据,否则查询数据库
        if (dao.select().size() == 0) {
            bean = new ArrayList<>();
            for (int i = 0; i < title.length; i++) {
                if (i < 5) {
                    dao.add(title[i], 0);// 0代表true
                    bean.add(new ChannelBean(title[i], true));
                } else {
                    dao.add(title[i], 1);// 1代表false
                    bean.add(new ChannelBean(title[i], false));
                }
            }
        } else {
            bean = dao.select();
        }

        //保存顶部头像的路径
        HanderImg_sp = getSharedPreferences(HANDER_IMAGE_NAME, MODE_PRIVATE);
        //设置文字的字体大小
        TextSize_sp = getSharedPreferences(TEXTSIZE_KEY, MODE_PRIVATE);

        //初始化View和T添加Fragment
        initView();
        //初始化侧拉菜单
        initSlidingMenu();

        //设置头部图片
        setImage(HanderImg_sp.getString(HANDER_IMAGE_KEY, "https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1503584645543&di" +
                "=961db653c55cd2afcb7fd15f8dcb68f5&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg" +
                ".com%2Fit%2Fu%3D763968628%2C2435880126%26fm%3D214%26gp%3D0.jpg"), handerimg);
        //设置头部的用户昵称
        handerTV.setText(HanderImg_sp.getString(HANDER_NAME_KEY, "欢迎您!"));
    }

    //大于19的时候申请动态权限
    private void MyRequestPermissions() {
        if (Build.VERSION.SDK_INT >= 19) {
            String[] mPermissionList = new String[]{
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Manifest.permission.GET_TASKS,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                    Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
                    Manifest.permission.VIBRATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }

    //注册广播,监听网络
    private void RegisterReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        myBroadCaseReceiver = new MyBroadCaseReceiver();
        registerReceiver(myBroadCaseReceiver, filter);
    }


    //初始化侧拉菜单
    private void initSlidingMenu() {
        slidingMenu = new SlidingMenu(MainActivity.this);
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        slidingMenu.setOffsetFadeDegree(0.4f);
        slidingMenu.attachToActivity(MainActivity.this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        slidingMenu.setBehindOffset(250);
        slidingMenu.setMenu(R.layout.framelayout_fragment);
        slidingMenu.setSecondaryMenu(R.layout.slidingmenu_right);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framelayout, new SlidingMent_Left())
                .commit();
        //查找右侧拉菜单控件
        LinearLayout weixin_login = (LinearLayout) slidingMenu.findViewById(R.id.weixin_Login);
        LinearLayout sina_weibo = (LinearLayout) slidingMenu.findViewById(R.id.sina_weibo);
        LinearLayout tengxun_weibo = (LinearLayout) slidingMenu.findViewById(R.id.tengxun_weibo);
        LinearLayout right_renren = (LinearLayout) slidingMenu.findViewById(R.id.right_renren);
        LinearLayout reight_kaixin = (LinearLayout) slidingMenu.findViewById(R.id.reight_kaixin);

        weixin_login.setOnClickListener(this);
        sina_weibo.setOnClickListener(this);
        tengxun_weibo.setOnClickListener(this);
        right_renren.setOnClickListener(this);
        reight_kaixin.setOnClickListener(this);
    }


    //初始化View和T添加Fragment
    private void initView() {
        //顶部的头像
        handerimg = (ImageView) findViewById(R.id.hander_Img);
        //顶部的名称
        handerTV = (TextView) findViewById(R.id.handerTV);
        //tablayout最后边的+号,频道管理
        pingdaoguanli = (TextView) findViewById(R.id.pingdaoguanli);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        pingdaoguanli.setOnClickListener(this);
        handerimg.setOnClickListener(this);
        handerTV.setOnClickListener(this);
        //创建临时添加所有Fragment的集合
        list = new ArrayList<>();
        //"头条", "社会", "国内", "国际", "娱乐", "体育", "军事","科技", "财经","时尚"
        list.add(new TouTiao_Fragment());
        list.add(new SheHui_Fragment());
        list.add(new GuoNei_Fragment());
        list.add(new GuoJi_Fragment());
        list.add(new YuLe_Fragment());
        list.add(new TiYu_Fragment());
        list.add(new JunShi_Fragment());
        list.add(new KeJi_Fragment());
        list.add(new CaiJing_Fragment());
        list.add(new ShiShang_Fragment());
        //创建真正添加到页面的Fragment的集合
        fragments = new ArrayList<>();
        //存放tablayout标题名字的集合
        nameList = new ArrayList<>();
        //管理频道和Tablayout的数据相同
        addTabLayout();
        //ViewPager设置适配器
        adapter = new MyAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }

    //管理频道和Tablayout的数据相同
    private void addTabLayout() {
        fragments.clear();
        nameList.clear();
        for (int i = 0; i < bean.size(); i++) {
            if (bean.get(i).isSelect()) {
                String name = bean.get(i).getName();
                for (int y = 0; y < title.length; y++) {
                    if (name.equals(title[y])) {
                        fragments.add(list.get(y));
                        nameList.add(name);
                    }
                }
              /*  //"头条", "社会", "国内", "国际", "娱乐", "体育", "军事","科技", "财经","时尚"
                switch (name) {
                    case "头条":
                        fragments.add(new TouTiao_Fragment());
                        break;
                    case "社会":
                        fragments.add(new SheHui_Fragment());
                        break;
                    case "国内":
                        fragments.add(new GuoNei_Fragment());
                        break;
                    case "国际":
                        fragments.add(new GuoJi_Fragment());
                        break;
                    case "娱乐":
                        fragments.add(new YuLe_Fragment());
                        break;
                    case "体育":
                        fragments.add(new TiYu_Fragment());
                        break;
                    case "军事":
                        fragments.add(new JunShi_Fragment());
                        break;
                    case "科技":
                        fragments.add(new KeJi_Fragment());
                        break;
                    case "财经":
                        fragments.add(new CaiJing_Fragment());
                        break;
                    case "时尚":
                        fragments.add(new ShiShang_Fragment());
                        break;
                }
            }*/

            }
        }
    }

    //第三方友盟登录的接口回调
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
            Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_LONG).show();
            String iconurl = data.get("iconurl");
            String name = data.get("name");
            handerTV.setText(name);

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(MainActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.weixin_Login: //微信登录
                UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this,
                        SHARE_MEDIA.WEIXIN, authListener);
                break;
            case R.id.sina_weibo://右侧拉菜单 新浪微博登录
                UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this,
                        SHARE_MEDIA.SINA, authListener);
                break;
            case R.id.tengxun_weibo://右侧拉菜单 腾讯微博登录,暂时没有实现功能
                UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this,
                        SHARE_MEDIA.TENCENT, authListener);
                break;
            case R.id.right_renren://右侧拉菜单 人人网登录,暂时没有实现功能
                UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this,
                        SHARE_MEDIA.RENREN, authListener);
                break;
            case R.id.reight_kaixin://右侧拉菜单 开心网登录,暂时没有实现功能
                UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this,
                        SHARE_MEDIA.KAKAO, authListener);
                break;
            case R.id.pingdaoguanli://跳转到第三方频道管理
                //查询数据库
                bean = dao.select();
                //使用ChannelActivity调用他的方法,添加数据
                MyChannalActivity.startChannelActivity(MainActivity.this, bean);

                break;
            case R.id.hander_Img://点击头像显示或者关闭左侧拉菜单
                slidingMenu.toggle();
                break;
            case R.id.handerTV://点击顶部的昵称显示或者关闭右侧拉菜单
                slidingMenu.showSecondaryMenu();
                break;
        }
    }

    //viewpager 适配器
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        //注销销毁的方法,防止页面划过去,再划回来的时候数据丢失
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return nameList.get(position);
        }
    }


    //自定义方法接收侧拉菜单中间的ListView的Item点击事件,跳转响应界面
    public static void getListViewItem(int position) {
        slidingMenu.toggle();
        viewpager.setCurrentItem(position);
    }

    //自定义方法,在用户登录成功以后调用用户的头像,和昵称
    public static void getUserText(String imgpath, String name) {
        //保存用户头像和用户昵称
        HanderImg_sp.edit().putString(HANDER_IMAGE_KEY, imgpath)
                .putString(HANDER_NAME_KEY, name)
                .commit();
        handerTV.setText(name);
        //设置图片
        setImage(imgpath, handerimg);
    }

    //自定义方法使用xutils加载图片
    public static void setImage(String path, ImageView img) {
        DisplayImageOptions build = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .displayer(new CircleBitmapDisplayer())
                .showImageOnLoading(R.mipmap.hander_img)
                .showImageOnFail(R.mipmap.hander_img)
                .showImageForEmptyUri(R.mipmap.hander_img)
                .build();
        ImageLoader.getInstance().displayImage(path, img, build);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        if (requestCode == ChannelActivity.REQUEST_CODE && resultCode == ChannelActivity
                .RESULT_CODE) {     //频道管理回传的数据,
            String json = data.getStringExtra(ChannelActivity.RESULT_JSON_KEY);
            System.out.println("频道管理回传的数据" + json);
            Gson gson = new Gson();
            List<ChannelBean> channelBeanList = gson.fromJson(json, new
                    TypeToken<List<ChannelBean>>() {
                    }.getType());

            for (int i = 0; i < channelBeanList.size(); i++) {
                int isSelect = 0;
                String name = channelBeanList.get(i).getName();
                boolean select = channelBeanList.get(i).isSelect();
                if (select)
                    isSelect = 0;
                else
                    isSelect = 1;
                //因为数据的id是从1开始的,但是i是从0开始,所以这里i+1
                dao.update(name, isSelect, (i + 1));
            }
            //获取存放Fragment的管理器,在设置适配器的时候传到适配器里面的
            FragmentManager fragmentManager = getSupportFragmentManager();
            //得到容器里面所有的Fragment集合
            List<Fragment> fragments = fragmentManager.getFragments();
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();

            for (Fragment fragment : fragments) {
                beginTransaction.remove(fragment);
            }
//            Iterator<Fragment> iterator = fragments.iterator();
//            while (iterator.hasNext()) {
//                Fragment next = iterator.next();
//                beginTransaction.remove(next);
//            }
            //直接使用commit()这个方法,会造成状态丢失,Fragment在销毁,Activity会出现状态丢失,报错
            //commitAllowingStateLoss() 使用这个方法允许状态丢失,就不会报错
            beginTransaction.commitAllowingStateLoss();//提交的功能
            recreate();

        } else if (resultCode == 301) {//判断回传码,如果相同的话代表用户改变了字体的大小
            recreate();
            overridePendingTransition(R.anim.shape02, R.anim.shape01);
        }
    }

    //广播,用来检测网络
    class MyBroadCaseReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                ConnectivityManager manager = (ConnectivityManager) getSystemService(Context
                        .CONNECTIVITY_SERVICE);
                NetworkInfo info = manager.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    if (ConnectivityManager.TYPE_WIFI == info.getType()) {
                        isConnect = false;
                    } else if (ConnectivityManager.TYPE_MOBILE == info.getType()) {
                        isConnect = true;
                        Toast.makeText(context, "已切换至移动数据网络!", Toast.LENGTH_SHORT).show();
                    }
                } else {//如果断网弹出对话框,点击确定跳转到设置界面
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                    builder.setTitle("提示:");
                    builder.setMessage("当前网络不可用,请检查网络!");
                    builder.setNeutralButton("WIFI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        }
                    });
                    builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                        }
                    });
                    builder.setNegativeButton("取消", null);
                    builder.create().show();
                }
                //保存网络状态
                getSharedPreferences(MobileStyle.TYPE_MOBILE_KEY, Context.MODE_PRIVATE).edit()
                        .putBoolean(MobileStyle.IS_NETWORK, isConnect).commit();

            }
        }

    }

    //注销广播
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadCaseReceiver);
    }
}

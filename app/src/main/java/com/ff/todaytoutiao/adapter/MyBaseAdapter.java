package com.ff.todaytoutiao.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ff.todaytoutiao.R;
import com.ff.todaytoutiao.bean.MenuInfo;
import com.ff.todaytoutiao.MainActivity;
import com.ff.todaytoutiao.WebViewActivity;
import com.limxing.xlistview.view.XListView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 时间: 2017/8/13
 * 类作用:页面的xlistview的适配器
 */

public class MyBaseAdapter extends BaseAdapter {
    private List<MenuInfo.ResultBean.DataBean> list;
    private Context context;
    private XListView xlistview;
    private PopupWindow popupWindow;
    private TextView pop_deleteview;
    private ImageView pop_colose;

    public MyBaseAdapter(List<MenuInfo.ResultBean.DataBean> list, Context context, XListView
            xlistview) {
        this.list = list;
        this.context = context;
        this.xlistview = xlistview;
    }

    //判断是下拉刷新,还是上啦加载,增加数据;true就是下拉刷新,false就是上啦加载
    public void add(List<MenuInfo.ResultBean.DataBean> data, boolean b) {
        for (MenuInfo.ResultBean.DataBean bean : data) {
            if (b)
                list.add(0, bean);
            else
                list.add(bean);
        }
    }

    @Override
    public int getCount() {
        return list.size() != 0 ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder0 holder0 = null;
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        switch (type) {
            case 0:
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.item_img01, null);
                    holder0 = new ViewHolder0();
                    holder0.tv = (TextView) convertView.findViewById(R.id.item_img01_text);
                    holder0.data_name = (TextView) convertView.findViewById(R.id.data_name01);
                    holder0.img = (ImageView) convertView.findViewById(R.id.item_img01_img);
                    holder0.pop_Button = (TextView) convertView.findViewById(R.id.pop_Button);
                    convertView.setTag(holder0);
                } else {
                    holder0 = (ViewHolder0) convertView.getTag();
                }
                //设置文字的字体大小为默认的"中"=20sp
                holder0.tv.setTextSize(context.getSharedPreferences(MainActivity
                        .TEXTSIZE_KEY, context.MODE_PRIVATE).getInt(MainActivity
                        .TEXTSIZE_INTEGER, MainActivity.TEXTSIZE_CENTRE));
                holder0.tv.setText(list.get(position).getTitle());
                holder0.data_name.setText("" + list.get(position).getAuthor_name() + "  " +
                        list.get(position).getDate());
                setImage(list.get(position).getThumbnail_pic_s(), holder0.img);
                holder0.pop_Button.setOnClickListener(new MyPopupWindow(position));
                break;
            case 1:
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.item_img02, null);
                    holder1 = new ViewHolder1();
                    holder1.tv = (TextView) convertView.findViewById(R.id.item_img02_text);
                    holder1.data_name = (TextView) convertView.findViewById(R.id.data_name02);
                    holder1.img1 = (ImageView) convertView.findViewById(R.id.item_img02_img01);
                    holder1.img2 = (ImageView) convertView.findViewById(R.id.item_img02_img02);
                    holder1.pop_Button = (TextView) convertView.findViewById(R.id.pop_Button);
                    convertView.setTag(holder1);
                } else {
                    holder1 = (ViewHolder1) convertView.getTag();
                }
                //设置文字的字体大小为默认的"中"=20sp
                holder1.tv.setTextSize(context.getSharedPreferences(MainActivity
                        .TEXTSIZE_KEY, context.MODE_PRIVATE).getInt(MainActivity
                        .TEXTSIZE_INTEGER, MainActivity.TEXTSIZE_CENTRE));

                holder1.tv.setText(list.get(position).getTitle());
                holder1.data_name.setText("" + list.get(position).getAuthor_name() + "  " +
                        list.get(position).getDate());
                setImage(list.get(position).getThumbnail_pic_s().trim(), holder1.img1);
                setImage(list.get(position).getThumbnail_pic_s02(), holder1.img2);
                holder1.pop_Button.setOnClickListener(new MyPopupWindow(position));

                break;
            case 2:
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.item_img03, null);
                    holder2 = new ViewHolder2();
                    holder2.tv = (TextView) convertView.findViewById(R.id.item_img03_text);
                    holder2.data_name = (TextView) convertView.findViewById(R.id.data_name03);
                    holder2.img1 = (ImageView) convertView.findViewById(R.id.item_img03_img01);
                    holder2.img2 = (ImageView) convertView.findViewById(R.id.item_img03_img02);
                    holder2.img3 = (ImageView) convertView.findViewById(R.id.item_img03_img03);
                    holder2.pop_Button = (TextView) convertView.findViewById(R.id.pop_Button);
                    convertView.setTag(holder2);
                } else {
                    holder2 = (ViewHolder2) convertView.getTag();
                }
                //设置文字的字体大小为默认的"中"=20sp
                holder2.tv.setTextSize(context.getSharedPreferences(MainActivity
                        .TEXTSIZE_KEY, context.MODE_PRIVATE).getInt(MainActivity
                        .TEXTSIZE_INTEGER, MainActivity.TEXTSIZE_CENTRE));

                holder2.tv.setText(list.get(position).getTitle());
                holder2.data_name.setText("" + list.get(position).getAuthor_name() + "  " +
                        list.get(position).getDate());
                setImage(list.get(position).getThumbnail_pic_s(), holder2.img1);
                setImage(list.get(position).getThumbnail_pic_s02(), holder2.img2);
                setImage(list.get(position).getThumbnail_pic_s03(), holder2.img3);
                holder2.pop_Button.setOnClickListener(new MyPopupWindow(position));

                break;
        }
        //item的点击事件,跳转到另外一个Activity使用webview加载页面
        xlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long
                    id) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("item_url", list.get(position - 1).getUrl());
                context.startActivity(intent);
            }
        });

        return convertView;
    }


    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getThumbnail_pic_s02() == null && list.get(position)
                .getThumbnail_pic_s03() == null) {
            //代表就是只有一张图片
            return 0;
        } else if (list.get(position).getThumbnail_pic_s02() != null && list.get(position)
                .getThumbnail_pic_s03() == null) {
            //代表两张图片
            return 1;
        } else {//代表三张图片
            return 2;
        }
    }

    class ViewHolder0 {
        TextView tv;
        TextView data_name;
        ImageView img;
        TextView pop_Button;
    }

    class ViewHolder1 {
        TextView tv;
        TextView data_name;
        ImageView img1;
        ImageView img2;
        TextView pop_Button;
    }

    class ViewHolder2 {
        TextView tv;
        TextView data_name;
        ImageView img1;
        ImageView img2;
        ImageView img3;
        TextView pop_Button;
    }

    public static void setImage(String path, ImageView img) {
        DisplayImageOptions build = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .showImageOnLoading(R.mipmap.loading)
                .showImageOnFail(R.mipmap.ic_empty)
                .showImageForEmptyUri(R.mipmap.ic_empty)
                .build();
        ImageLoader.getInstance().displayImage(path, img, build);
    }

    //自定义类实现点击事件的接口,在这里定义那个"+"号的点击事件,弹出popupwindow弹窗
    class MyPopupWindow implements View.OnClickListener {
        private int position;
        private int x;
        private int y;

        public MyPopupWindow(int position) {
            this.position = position;
            //初始化popupwindow布局
            initPop();
        }

        @Override
        public void onClick(View v) {
            int[] outlocation = new int[2];
            //获取当前点击的位置,x y 坐标
            v.getLocationOnScreen(outlocation);
            x = outlocation[0];
            y = outlocation[1];
            //显示popwindow
            showPop(v, position, x, y);
        }

        private void initPop() {
            View view = View.inflate(context, R.layout.popupwindow, null);
            //删除的TextView
            pop_deleteview = (TextView) view.findViewById(R.id.pop_delete);
            //关闭的一张图片
            pop_colose = (ImageView) view.findViewById(R.id.pop_close);
            //创建对象和布局,宽高自适应
            popupWindow = new PopupWindow(view, ViewPager.LayoutParams.WRAP_CONTENT, ViewPager
                    .LayoutParams.WRAP_CONTENT);
            //设置动画样式
            popupWindow.setAnimationStyle(R.style.popAnimation);
            //获取焦点
            popupWindow.setFocusable(true);
            //设置外部可以点击
            popupWindow.setOutsideTouchable(true);
            //设置一个空背景
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
        }

        private void showPop(View view, final int position, int x, int y) {
            //显示popupwindow
            popupWindow.showAtLocation(view, 0, x, y);
            pop_deleteview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //删除这条数据
                    list.remove(position);
                    //刷新
                    notifyDataSetChanged();
                    //关闭popupwindow弹窗
                    if (popupWindow.isShowing())
                        popupWindow.dismiss();
                }
            });
            pop_colose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (popupWindow.isShowing())
                        popupWindow.dismiss();
                }
            });
        }
    }


}

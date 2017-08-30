package com.ff.todaytoutiao;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.andy.library.ChannelBean;
import com.ff.todaytoutiao.dao.Dao;

import java.util.ArrayList;

/**
 * 时间: 2017/8/19
 * 类作用:
 */

public class LiXian_Activity extends Activity {

    private RadioButton xiazai;
    private TextView gouback;
    private ListView listview;
    private Dao dao;
    private ArrayList<ChannelBean> selectList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lixianxiazai);
        initView();
        dao = new Dao(this);
        selectList = dao.select();
        listview.setAdapter(new MyBaseAdapter());
        //返回按钮
        gouback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initView() {
        xiazai = (RadioButton) findViewById(R.id.lixianxiazai);
        gouback = (TextView) findViewById(R.id.lx_goback);
        listview = (ListView) findViewById(R.id.lixian_listview);
    }

    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return selectList.size() != 0 ? selectList.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return selectList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = View.inflate(LiXian_Activity.this, R.layout.xiazai_item, null);
                holder = new ViewHolder();
                holder.tv = (TextView) convertView.findViewById(R.id.item_name);
                holder.checkBox = (CheckBox) convertView.findViewById(R.id.isChecked);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv.setText(selectList.get(position).getName());

            return convertView;
        }
    }

    class ViewHolder {
        TextView tv;
        CheckBox checkBox;

    }
}

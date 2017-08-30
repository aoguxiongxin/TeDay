package com.ff.todaytoutiao.viewpager_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ff.todaytoutiao.R;
import com.ff.todaytoutiao.bean.MenuInfo;
import com.ff.todaytoutiao.adapter.MyBaseAdapter;
import com.google.gson.Gson;
import com.limxing.xlistview.view.XListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * 时间: 2017/8/9
 * 类作用:体育
 */

public class TiYu_Fragment extends Fragment implements XListView.IXListViewListener {

    private View view;
    private XListView xlistview;
    private String path = "http://v.juhe" +
            ".cn/toutiao/index?type=tiyu&key=6dde6de11cc04328c65963b2951dc8b5";
    private boolean boo;
    private MyBaseAdapter adapter;
    private List<MenuInfo.ResultBean.DataBean> beanList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.fragment_tiyu, null);
        System.out.println("体育==============");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        xlistview = (XListView) view.findViewById(R.id.tiyu_xlv);
        xlistview.setPullLoadEnable(true);
        xlistview.setXListViewListener(this);
        getData(path);

    }

    private void getData(String path) {
        RequestParams params = new RequestParams(path);
        //断点续传
        params.setAutoResume(true);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                MenuInfo info = gson.fromJson(result, MenuInfo.class);
                beanList = info.getResult().getData();
                if (adapter == null) {
                    adapter = new MyBaseAdapter(beanList, getContext(),xlistview);
                    xlistview.setAdapter(adapter);
                } else {
                    adapter.add(beanList, boo);
                    adapter.notifyDataSetChanged();
                }

               /* //item的点击事件,跳转到另外一个Activity使用webview加载页面
                xlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long
                            id) {
                        Intent intent = new Intent(getActivity(), WebViewActivity.class);
                        intent.putExtra("item_url", beanList.get(position).getUrl());
                        getActivity().startActivity(intent);
                    }
                });*/
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });

    }

    @Override
    public void onRefresh() {
        getData(path);
        boo = true;
        xlistview.stopRefresh(true);
    }

    @Override
    public void onLoadMore() {
        getData(path);
        boo = false;
        xlistview.stopLoadMore();
    }
}

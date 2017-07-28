package com.baway.fuzhiyan.fuzhiyan20170728;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;



/*
* author:付智焱
* time:2017-7-28 14:38:35
*
* 类用途：加载主页面的布局。。显示数据
*
* */
public class MainActivity extends AppCompatActivity {
    private ListView recyclerView;
    private ListAdapter myAdapter;
    private List<UserBean.DataBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (ListView) findViewById(R.id.recyclerView);

        initData();

    }

    private void initData() {
    RequestParams params=new RequestParams("http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=20&gender=2&ts=1871746850&page=1");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
               UserBean bean= gson.fromJson(result,UserBean.class);
                list=bean.getData();
                myAdapter = new ListAdapter(MainActivity.this, list);
                recyclerView.setAdapter(myAdapter);
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



//

}



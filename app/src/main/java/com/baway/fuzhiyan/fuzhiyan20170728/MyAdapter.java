package com.baway.fuzhiyan.fuzhiyan20170728;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 * time:2017-7-28 15:24:44
 * author:付智焱
 * 类用途：listView适配器，适配数据
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<UserBean.DataBean> list = new ArrayList<>();

    public MyAdapter(Context context, List<UserBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {

        holder.userName.setText(list.get(position).getUserName());
        holder.userAge.setText(list.get(position).getUserAge());
        holder.occupation.setText(list.get(position).getOccupation());
        holder.introduction.setText(list.get(position).getIntroduction());
        Glide.with(context).load(list.get(position).getUserImg()).into(holder.userImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView userAge;
        private TextView occupation;
        private TextView introduction;
        private ImageView userImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.text_userName);
            userAge = (TextView) itemView.findViewById(R.id.text_userAge);
            occupation = (TextView) itemView.findViewById(R.id.text_occupation);
            introduction = (TextView) itemView.findViewById(R.id.text_introduction);
            userImage = (ImageView) itemView.findViewById(R.id.userImage);
        }

    }
}

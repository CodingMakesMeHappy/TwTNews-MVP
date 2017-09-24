package com.example.hp.twtnews_mvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hp.twtnews_mvp.R;
import com.example.hp.twtnews_mvp.model.ListBean;
import com.example.hp.twtnews_mvp.view.ContentActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ListAdapter extends RecyclerView.Adapter {
    private int NO_PIC = 0;
    private int NORMAL = 1;
    private ListBean listBean;
    private Context context;

    public ListAdapter(ListBean listBean, Context context) {
        this.listBean = listBean;
        this.context = context;
    }

    public class NoPicViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.list_picLessItem_subject)
        TextView list_picLessItem_subject;
        @Bind(R.id.list_picLessItem_summary)
        TextView list_picLessItem_summary;

        public NoPicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.list_item_pic)
        ImageView list_item_pic;
        @Bind(R.id.list_item_subject)
        TextView list_item_subject;
        @Bind(R.id.list_item_summary)
        TextView list_item_summary;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == NORMAL) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            return new ListViewHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_picless, parent, false);
            return new NoPicViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int positionFinal = position;
        if (getItemViewType(positionFinal) == NORMAL) {

            ListViewHolder listViewHolder = (ListViewHolder) holder;
            listViewHolder.list_item_subject.setText(listBean.data.get(positionFinal).subject);
            listViewHolder.list_item_summary.setText(listBean.data.get(positionFinal).summary);


            if (listBean.data.get(positionFinal).pic.substring(1, 5).equals("post")) {
                Glide.with(context)
                        .load("https://news.twt.edu.cn" + listBean.data.get(positionFinal).pic)
                        .into(listViewHolder.list_item_pic);
            } else {
                Glide.with(context)
                        .load(listBean.data.get(positionFinal).pic)
                        .into(listViewHolder.list_item_pic);
            }
            listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startContentActivity(positionFinal);
                }
            });
        } else {
            NoPicViewHolder noPicViewHolder = (NoPicViewHolder) holder;
            noPicViewHolder.list_picLessItem_subject.setText(listBean.data.get(positionFinal).subject);
            noPicViewHolder.list_picLessItem_summary.setText(listBean.data.get(positionFinal).summary);
            noPicViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startContentActivity(positionFinal);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listBean.data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (listBean.data.get(position).pic.equals("")) {
            return NO_PIC;
        }
        return NORMAL;
    }

    private void startContentActivity(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("index", listBean.data.get(position).index);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(context, ContentActivity.class);
        context.startActivity(intent);
    }
}

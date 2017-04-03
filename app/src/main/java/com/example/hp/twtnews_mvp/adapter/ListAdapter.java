package com.example.hp.twtnews_mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.twtnews_mvp.R;
import com.example.hp.twtnews_mvp.model.ListBean;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ListAdapter extends RecyclerView.Adapter {

    private ListBean listBean;
    private Context context;

    public ListAdapter(ListBean listBean, Context context) {
        this.listBean = listBean;
        this.context = context;
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
        view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int positionFinal = position;
        ListViewHolder listViewHolder = (ListViewHolder) holder;
        listViewHolder.list_item_subject.setText(listBean.data.get(positionFinal).subject);
        listViewHolder.list_item_summary.setText(listBean.data.get(positionFinal).summary);
    }

    @Override
    public int getItemCount() {
        return listBean.data.size();
    }
}

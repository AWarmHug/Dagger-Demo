package com.warm.dagger_demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.warm.dagger_demo.R;
import com.warm.dagger_demo.bean.Data;

import java.util.List;

/**
 * Created by warm on 17/7/25.
 */

public class DataAdapter extends BaseRecyAdapter<Data> {

    public DataAdapter(List<Data> list) {
        super(list);
    }

    @Override
    protected void onBind(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).tvTitle.setText(list.get(position).getDesc());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,parent,false));
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle= (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}

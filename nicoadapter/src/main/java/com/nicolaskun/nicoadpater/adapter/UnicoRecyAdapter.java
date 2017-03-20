package com.nicolaskun.nicoadpater.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by unicolas on 2017/3/9.
 */

public abstract class UnicoRecyAdapter<T> extends RecyclerView.Adapter<UnicoViewsHolder> {

    private List<T> list;
    private Context context;
    private int layoutId;
    private LayoutInflater inflater;

    public UnicoRecyAdapter(Context context, List<T> list, int layoutId) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;

    }

    @Override
    public UnicoViewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(layoutId, parent, false);
        UnicoViewsHolder holder = new UnicoViewsHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(UnicoViewsHolder holder, final int position) {
        final T t = list.get(position);
        convert(holder, t, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickObtain(v, t, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public abstract void convert(UnicoViewsHolder holder, T item, int position);

    /**
     * 条目 点击事件  非必重写
     * 需要的时候就重写
     */
    public void itemClickObtain(View view, T item, int position) {
        //
    }

}

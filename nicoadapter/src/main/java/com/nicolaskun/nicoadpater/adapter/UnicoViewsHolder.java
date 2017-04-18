package com.nicolaskun.nicoadpater.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by unicolas on 2017/3/9.
 */

public class UnicoViewsHolder extends RecyclerView.ViewHolder {

    private View contentView;
    public UnicoViewsHolder(View itemView) {
        super(itemView);
        this.contentView = itemView;
        itemView.setTag(this);
    }

    public <R extends View> R getView(int resId) {
        View view = contentView.findViewById(resId);
        return ((R) view);
    }

    public UnicoViewsHolder setTvTxt(int resId, String txt) {
        TextView tv = (TextView) getView(resId);
        tv.setText(txt);
        return this;
    }

    public UnicoViewsHolder setImage(int resId, String url) {
        ImageView iv = (ImageView) getView(resId);
        return this;
    }


}

package com.nicolaskun.nicoadpater.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by unicolas on 2016-6-6.
 * adapter's ViewHolder
 */
public class ViewsHolder {
    private final SparseArray<View> mViews;
    private View contentView;
    private int position;
    private Context context;
    public ViewsHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.context = context;
        this.position = position;
        this.mViews = new SparseArray<>();
        contentView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        contentView.setTag(this);
    }

    /**
     * get a ViewsHoldler
     */
    public static ViewsHolder get(Context context,
                                  View convertView,
                                  ViewGroup parent,
                                  int layoutId,
                                  int position) {
        if (convertView == null) {
            return new ViewsHolder(context, parent, layoutId, position);
        }
        return (ViewsHolder) convertView.getTag();
    }

    /**
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = contentView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return contentView;
    }

    public ViewsHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    public ViewsHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    public ViewsHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

}

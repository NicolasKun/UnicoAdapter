package com.nicolaskun.unicoadapter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by unicolas on 2017/3/20.
 */

public abstract class BaseFragment extends Fragment {

    public Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(layoutId(), null);
        init(view);
        return view;
    }

    public abstract int layoutId();

    public abstract void init(View view);
}

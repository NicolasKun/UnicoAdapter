package com.nicolaskun.unicoadapter.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.nicolaskun.nicoadpater.adapter.UnicoRecyAdapter;
import com.nicolaskun.nicoadpater.adapter.UnicoViewsHolder;
import com.nicolaskun.unicoadapter.R;
import com.nicolaskun.unicoadapter.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unicolas on 2017/3/20.
 * RecyclerView通用adapter演示
 */
public class FragmentRecycler extends BaseFragment {

    private RecyclerView recyclerView;
    private List<TestBean> list = new ArrayList<>();
    private UnicoRecyAdapter<TestBean> unicoRecyAdapter;

    public static FragmentRecycler instance() {
        FragmentRecycler fragment = new FragmentRecycler();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int layoutId() {
        return R.layout.fm_layout_recycler;
    }

    @Override
    public void init(View view) {
        recyclerView = ((RecyclerView) view.findViewById(R.id.flr_recycler_view));

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        unicoRecyAdapter = new UnicoRecyAdapter<TestBean>(context, list, R.layout.item_test_layout) {
            @Override
            public void convert(UnicoViewsHolder holder, TestBean item, int position) {
                String s = item.getZan() + "次赞";
                holder.setTvTxt(R.id.item_tl_likes, s);
                holder.setTvTxt(R.id.item_tl_signture, item.getSignture());
                holder.setTvTxt(R.id.item_tl_name, item.getName());
            }

            /**
             * //FIXME 此方法按需重写
             * @param view     itemView
             * @param item     条目内容
             * @param position   点击条目的position
             */
            @Override
            public void itemClickObtain(View view, TestBean item, int position) {
                super.itemClickObtain(view, item, position);
                Toast.makeText(context, item.getSignture(), Toast.LENGTH_SHORT).show();
            }
        };

        recyclerView.setAdapter(unicoRecyAdapter);


        loadData();
    }

    private void loadData() {
        for (int i = 0; i < 21; i++) {
            list.add(new TestBean(i + 1, "ICEY" + i, "我是ICEY " + i));
        }

        unicoRecyAdapter.notifyDataSetChanged();
    }
}

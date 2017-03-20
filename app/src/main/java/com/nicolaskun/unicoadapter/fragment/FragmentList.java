package com.nicolaskun.unicoadapter.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.nicolaskun.nicoadpater.adapter.GeneralAdapter;
import com.nicolaskun.nicoadpater.adapter.ViewsHolder;
import com.nicolaskun.unicoadapter.R;
import com.nicolaskun.unicoadapter.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unicolas on 2017/3/20.
 * Listview通用Adapter演示
 */
public class FragmentList extends BaseFragment {

    private static final String TAG = "FragmentList";

    private ListView listView;

    private List<TestBean> list = new ArrayList<>();
    private GeneralAdapter<TestBean> generalAdapter;

    public static FragmentList instance() {
        FragmentList fragment = new FragmentList();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int layoutId() {
        return R.layout.fm_layout_list;
    }

    @Override
    public void init(View view) {
        listView = ((ListView) view.findViewById(R.id.fll_list_view));

        generalAdapter = new GeneralAdapter<TestBean>(context,
                list, R.layout.item_test_layout) {
            @Override
            public void convert(ViewsHolder holder, TestBean item, int position) {
                String s = item.getZan() + "次赞";
                holder.setText(R.id.item_tl_likes, s);
                holder.setText(R.id.item_tl_signture, item.getSignture());
                holder.setText(R.id.item_tl_name, item.getName());
            }
        };
        listView.setAdapter(generalAdapter);

        loadData();
    }

    private void loadData() {
        for (int i = 0; i < 24; i++) {
            list.add(new TestBean(i + 1, "ICEY" + i, "我是ICEY " + i));
        }

        generalAdapter.notifyDataSetChanged();
    }
}

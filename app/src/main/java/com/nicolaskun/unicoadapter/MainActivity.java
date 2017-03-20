package com.nicolaskun.unicoadapter;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nicolaskun.unicoadapter.fragment.FragmentList;
import com.nicolaskun.unicoadapter.fragment.FragmentRecycler;

/**
 * Created by unicolas on 2017/3/20.
 * position : Beijing Xizhimen Street, China
 * 本案例简单封装了Listview与RecyclerView的适配器
 */
public class MainActivity extends AppCompatActivity {

    private FragmentList fragmentList;
    private FragmentRecycler fragmentRecycler;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFm();
    }

    private void initFm() {
        fragmentList = FragmentList.instance();
        fragmentRecycler = FragmentRecycler.instance();
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.am_fm_layout, fragmentList)
                .add(R.id.am_fm_layout, fragmentRecycler)
                .commit();

        fm.beginTransaction()
                .show(fragmentList)
                .hide(fragmentRecycler)
                .commit();
    }

    public void cut(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.am_btn_list:
                fm.beginTransaction()
                        .show(fragmentList)
                        .hide(fragmentRecycler)
                        .commit();
                break;
            case R.id.am_btn_recycler:
                fm.beginTransaction()
                        .show(fragmentRecycler)
                        .hide(fragmentList)
                        .commit();
                break;
        }
    }


}

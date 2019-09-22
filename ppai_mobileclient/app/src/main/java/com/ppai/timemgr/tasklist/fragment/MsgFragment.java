package com.ppai.timemgr.tasklist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

 import com.ppai.timemgr.tasklist.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.ppai.timemgr.tasklist.adapter.MsgContentFragmentAdapter;

/**
 * 消息
 * <p>在这个界面中实现类似今日头条的头部tab</p>
 */
public class MsgFragment extends Fragment {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private MsgContentFragmentAdapter adapter;
    private List<String> names;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_msg, container, false);
        ButterKnife.bind(this, view);

        adapter = new MsgContentFragmentAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // 更新适配器数据
        adapter.setList(names);
        return view;
    }

    private void initData() {
        names = new ArrayList<>();
        names.add("所有");
        names.add("优先");
        names.add("重要");
        names.add("工作");
        names.add("生活");
        names.add("家庭");
        names.add("归档");
        names.add("其它");
    }
}

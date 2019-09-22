package com.ppai.timemgr.tasklist.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ppai.timemgr.tasklist.R;
import com.ppai.timemgr.tasklist.TaskDetailActivity;
import com.ppai.timemgr.tasklist.TaskDetailFragment;
import com.ppai.timemgr.tasklist.bean.TaskEntity;
import com.ppai.timemgr.tasklist.bean.TasksContainer;

import java.util.List;

/**
 * 消息内容页
 */
public class MsgContentFragment extends Fragment {
    @BindView(R.id.txt_content)
    TextView tvContent;

    private String name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        name = bundle.getString("name");
        if (name == null) {
            name = "参数非法";
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_msg_content, container, false);
        ButterKnife.bind(this, view);
        tvContent.setText(name);
        View inflate = inflater.inflate(R.layout.item_list, null);
        ((RecyclerView) inflate).setAdapter(new TasksRecylerViewAdapter(this, TasksContainer.ITEMS, false));

        return inflate;
    }


    public static class TasksRecylerViewAdapter
            extends RecyclerView.Adapter<TasksRecylerViewAdapter.ViewHolder> {

        private final Fragment mParentActivity;
        private final List<TaskEntity> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskEntity item = (TaskEntity) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(TaskDetailFragment.ARG_ITEM_ID, item.getId());
                    TaskDetailFragment fragment = new TaskDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, TaskDetailActivity.class);
                    intent.putExtra(TaskDetailFragment.ARG_ITEM_ID, item.getId());

                    context.startActivity(intent);
                }
            }
        };

        TasksRecylerViewAdapter(Fragment parent,
                                List<TaskEntity> items,
                                boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).getId());
            holder.mContentView.setText(mValues.get(position).getContent());

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }

}

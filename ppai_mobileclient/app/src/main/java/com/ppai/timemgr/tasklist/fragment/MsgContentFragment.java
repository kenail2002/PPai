package com.ppai.timemgr.tasklist.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ppai.timemgr.tasklist.R;
import com.ppai.timemgr.tasklist.TaskDetailActivity;
import com.ppai.timemgr.tasklist.TaskDetailFragment;
import com.ppai.timemgr.tasklist.bean.TaskEntity;
import com.ppai.timemgr.tasklist.bean.TasksContainer;

import java.lang.reflect.Field;
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
        final RecyclerView cv1 = (RecyclerView) inflate;
        cv1.setAdapter(new TasksRecylerViewAdapter(this, TasksContainer.ITEMS, false));
        cv1.addOnItemTouchListener(new OnRecyclerItemClickListener(cv1) {

            @SuppressLint("RestrictedApi")
            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {
//                Snackbar.make(cv1, "你在长按着任务呢", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                //创建弹出式菜单对象（最低版本11）
                PopupMenu popup = new PopupMenu(cv1.getContext(), cv1);//第二个参数是绑定的那个view
                //获取菜单填充器
                MenuInflater inflater = popup.getMenuInflater();
                //填充菜单
                inflater.inflate(R.menu.menu_edit_task, popup.getMenu());
                //绑定菜单项的点击事件
                popup.setOnMenuItemClickListener(this);
                //显示(这一行代码不要忘记了)
                Field field = null;
                try {
                    field = popup.getClass().getDeclaredField("mPopup");
                    field.setAccessible(true);

                    MenuPopupHelper helper = (MenuPopupHelper) field.get(popup);
                    y = y - cv1.getHeight();//如果y取的是触摸点的位置，可能需要作此处理，经测试android5.1的设备会弹窗在屏幕之外
                    helper.show((int) x, (int) y);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            @Override

            public void onItemClick(RecyclerView.ViewHolder vh) {

                //单击事件

            }

        });

        return inflate;
    }

    private static class TasksRecylerViewAdapter
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

    private class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener, PopupMenu.OnMenuItemClickListener {

        float x = 0;
        float y = 0;
        private GestureDetectorCompat mGestureDetector;
        private RecyclerView recyclerView;

        public OnRecyclerItemClickListener(RecyclerView recyclerView) {

            this.recyclerView = recyclerView;

            mGestureDetector = new GestureDetectorCompat(recyclerView.getContext(), new ItemTouchHelperGestureListener());

        }


        @Override

        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            mGestureDetector.onTouchEvent(e);
            x = e.getX();
            y = e.getY();

            return false;

        }


        @Override

        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            mGestureDetector.onTouchEvent(e);

        }


        @Override

        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {


        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            // TODO Auto-generated method stub
            switch (item.getItemId()) {
                case R.id.newTaks:
                    Snackbar.make(recyclerView, "新建任务", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                case R.id.editTask:
                    Snackbar.make(recyclerView, "修改任务", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                case R.id.deleteTask:
                    Snackbar.make(recyclerView, "删除任务", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                default:
                    break;
            }
            return false;
        }

        public void onLongClick(RecyclerView.ViewHolder vh) {
        }

        public void onItemClick(RecyclerView.ViewHolder vh) {
        }

        private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {


            @Override

            public boolean onSingleTapUp(MotionEvent e) {

                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());

                if (child != null) {

                    RecyclerView.ViewHolder vh = recyclerView.getChildViewHolder(child);

                    onItemClick(vh);

                }

                return true;

            }


            @Override

            public void onLongPress(MotionEvent e) {

                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());

                if (child != null) {

                    RecyclerView.ViewHolder vh = recyclerView.getChildViewHolder(child);

                    onLongClick(vh);

                }

            }

        }

    }

}

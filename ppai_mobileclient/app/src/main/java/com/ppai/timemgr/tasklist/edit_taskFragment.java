package com.ppai.timemgr.tasklist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.ppai.timemgr.tasklist.bean.TaskEntity;
import com.ppai.timemgr.tasklist.bean.TasksContainer;

/**
 * A placeholder fragment containing a simple view.
 */
public class edit_taskFragment extends AppCompatActivity {

    public edit_taskFragment() {
    }

    @Override
    protected void onCreate(Bundle bd) {
        // TODO Auto-generated method stub
        super.onCreate(bd);
        setContentView(R.layout.fragment_edit_task);
        Button   butt_o = (Button)findViewById(R.id.my_lovely_butt);
        butt_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText1 =(EditText) findViewById (R.id.title111);
                String title=editText1.getText().toString();
                String content=((EditText) findViewById(R.id.content112)).getText().toString();
                TasksContainer.addItem(new TaskEntity(title,content).setId());
            Log.d("edit_taskFragment","你输入的信息是："+title +",详情："+content);
//                Snackbar.make(view, "你输入的信息是："+editText1.getText().toString(), Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                finish();
            }
        });

    }
}

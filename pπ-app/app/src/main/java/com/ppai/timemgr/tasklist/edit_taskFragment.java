package com.ppai.timemgr.tasklist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
//                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
               finish();
            }
        });

    }
}

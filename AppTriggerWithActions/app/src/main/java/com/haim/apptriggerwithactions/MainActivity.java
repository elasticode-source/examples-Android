package com.haim.apptriggerwithactions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.elasticode.model.ElasticodeAction;
import com.elasticode.model.ElasticodeSessionParams;
import com.elasticode.provider.Elasticode;
import com.elasticode.provider.callback.ElasticodeResponse;
import com.elasticode.view.ElasticodeOnClickListener;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {


    private final static String TAG = MainActivity.class.getSimpleName();
    private Elasticode elasticode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Elasticode api key that you can find in Dashboard -> acoount page
        elasticode = Elasticode.getInstance(this, "your-api-key-here", elasticodeObserver);
        // Creating the session params object, the 'bool' parameter is for development/production mode
        ElasticodeSessionParams params = new ElasticodeSessionParams(false, this);


        // Define an app trigger, you need to add the appTrigger from the dashboard first
        params.data.defineAppTrigger("appTriggerWithActions");


        // Creating an ElasticodeAction
        ElasticodeAction action1 = new ElasticodeAction("action1", new ElasticodeOnClickListener() {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Log.d(TAG, "action1 triggered");
            }
        });
        ElasticodeAction action2 = new ElasticodeAction("action2", new ElasticodeOnClickListener() {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Log.d(TAG, "action2 triggered");
            }
        });


        // Adding actions to elasticode, you need to select the action from the studio
        elasticode.addActions(action1, action2);


        // Setting session params, ready is mandatory
        elasticode.setSessionParams(params);
        elasticode.ready();


        final Button show = (Button) findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Show the app trigger
                elasticode.showAppTrigger("appTriggerWithActions");
             }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        elasticode.setNewIntent(intent);
    }

    private Observer elasticodeObserver = new Observer() {
        @Override
        public void update(Observable observable, Object data) {
            if (data instanceof ElasticodeResponse) {
                ElasticodeResponse response = (ElasticodeResponse) data;
                if (response.getError() != null) {
                    Log.d(TAG, "Error: " + response.getError());
                }else{
                    switch (response.getType()) {
                        case SESSION_STARTED:
                            // Elasticode in sync
                            break;
                    }
                }
            }
        }
    };}

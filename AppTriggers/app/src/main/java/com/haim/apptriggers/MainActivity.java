package com.haim.apptriggers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.elasticode.model.ElasticodeSessionParams;
import com.elasticode.provider.Elasticode;
import com.elasticode.provider.callback.ElasticodeResponse;

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
        ElasticodeSessionParams params = new ElasticodeSessionParams(false,this);

        // Define the app triggers, you need to add the appTriggers from the dashboard first
        params.data.defineAppTrigger("appTrigger1");
        params.data.defineAppTrigger("appTrigger2");
        params.data.defineAppTrigger("appTrigger3");


        // Setting session params, ready is mandatory
        elasticode.setSessionParams(params);
        elasticode.ready();




        final Button show1 = (Button) findViewById(R.id.show1);
        show1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Show the app trigger
                elasticode.showAppTrigger("appTrigger1");
            }
        });
        final Button show2 = (Button) findViewById(R.id.show2);
        show2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Show the app trigger
                elasticode.showAppTrigger("appTrigger2");
            }
        });
        final Button show3 = (Button) findViewById(R.id.show3);
        show3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Show the app trigger
                elasticode.showAppTrigger("appTrigger3");
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

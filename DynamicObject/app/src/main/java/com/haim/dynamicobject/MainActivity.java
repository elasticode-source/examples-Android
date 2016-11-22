package com.haim.dynamicobject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.elasticode.model.ElasticodeDObjType;
import com.elasticode.model.ElasticodeSessionParams;
import com.elasticode.provider.Elasticode;
import com.elasticode.provider.callback.ElasticodeResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {


    private final static String TAG = MainActivity.class.getSimpleName();
    private Elasticode elasticode;
    String[] stringArr = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // the DynamicObject defaultValue
        stringArr[0] = "value1";
        stringArr[1] = "value2";
        stringArr[2] = "value3";

        // Elasticode api key that you can find in Dashboard -> acoount page
        elasticode = Elasticode.getInstance(this, "your-api-key-here", elasticodeObserver);
        // Creating the session params object, the 'bool' parameter is for development/production mode
        ElasticodeSessionParams params = new ElasticodeSessionParams(false,MainActivity.this);

        // define dynamicObject
        params.data.defineDynamicObject("DynamicObject1", ElasticodeDObjType.STRING,"value1");
        params.data.defineDynamicObject("DynamicObject2", ElasticodeDObjType.ARRAY_OF_STRING,stringArr);

        // Setting session params, ready is mandatory
        elasticode.setSessionParams(params);
        elasticode.ready();



        final Button visit1 = (Button) findViewById(R.id.visit1);
        visit1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Visit dynamicObject 1, visit can be called only after 'valueFor'
                elasticode.visitDynamicObject("DynamicObject1");
            }
        });

        final Button visit2 = (Button) findViewById(R.id.visit2);
        visit2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Visit dynamicObject 2, visit can be called only after 'valueFor'
                elasticode.visitDynamicObject("DynamicObject2");
            }
        });

        final Button value1 = (Button) findViewById(R.id.value1);
        value1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Value for dynamic object 1
                Object o1 = elasticode.valueForDynamicObject("DynamicObject1");
                Log.d(TAG,"value is -> " + o1);

            }
        });

        final Button value2 = (Button) findViewById(R.id.value2);
        value2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Value for dynamic object 1
                Object o2 = elasticode.valueForDynamicObject("DynamicObject2");
                System.out.println(Arrays.toString((Object[]) o2));
            }
        });

        final Button goal1 = (Button) findViewById(R.id.goal1);
        goal1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Goal reached for case 1
                elasticode.goalReached("DynamicObject1");
            }
        });

        final Button goal2 = (Button) findViewById(R.id.goal2);
        goal2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Goal reached for case 2
                elasticode.goalReached("DynamicObject2");
            }
        });

        final Button share = (Button) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final HashMap<String,Object> map = new HashMap<String, Object>();
                map.put("name","david");
                // Share user information, you can put your own parameters
                elasticode.shareUserInfo(map);
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

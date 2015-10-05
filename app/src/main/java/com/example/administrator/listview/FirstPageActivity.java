package com.example.administrator.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class FirstPageActivity extends Activity {

    Button button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        final Intent intent = new Intent(this, MainActivity.class);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                //Date today = new Date();
                //ArrayList<String> listitems = new ArrayList<String>();
                //listitems.add("my");
                //listitems.add("name");

                //List list = new List("mylist123","mylist",today,today,listitems);
                //Date date = new Date();
               // list.setList_creation_date(date);
                //list.setList_name("List-"+date);

            }
        });
    }


}

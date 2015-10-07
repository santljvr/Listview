package com.example.administrator.listview;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class FirstPageActivity extends Activity implements OnClickListener {

    Button button2,button3;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.button2) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.button3)
        {
           // Toast.makeText(this,"Work in progress", Toast.LENGTH_SHORT).show();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            ListFragmentView list_fragment = new ListFragmentView();
            transaction.add(R.id.FirstPage,list_fragment, "FragmentList");
            transaction.commit();

        }
    }
}

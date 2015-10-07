package com.example.administrator.listview;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.listview.adapter.Customadapter;
import com.example.administrator.listview.dbhelper.Dbhelper;
import com.example.administrator.listview.model.List;

import java.util.ArrayList;


public class MainActivity extends Activity  {

    ListView listview;
    EditText listItem, listName;

    Customadapter adapter;
    List list;
    ArrayList<List.ListItem> list_items;
    List.ListItem listitem;
    Dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Dbhelper(this);
        list = new List();
        list_items = new ArrayList<>();
        listitem = list.new ListItem();

        listName = (EditText) findViewById(R.id.editText);
        listItem = (EditText) findViewById(R.id.editText2);
        adapter = new Customadapter(this, list_items);
        listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);

    }

    public void additems(View v) {
        if (listItem.getText().toString().equalsIgnoreCase("") || TextUtils.isEmpty(listItem.getText().toString())) {
            Toast.makeText(this, "Please add List Item", Toast.LENGTH_LONG).show();

        } else {
            listitem.setIsChecked(false);
            listitem.setListItemName(listItem.getText().toString());
            db.putListItemData(listitem.getListItemName(), list.getListname(), listitem.getIsChecked());

            /*setting up array of list items*/
            list_items.add(listitem);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "listitem created by name: "+listitem.getListItemName(), Toast.LENGTH_LONG).show();
        }
    }

    public void addlistname(View v) {
        if (listName.getText().toString().equalsIgnoreCase("") || TextUtils.isEmpty(listName.getText().toString())) {
            Toast.makeText(this, "Please add list name", Toast.LENGTH_LONG).show();
        } else {
            list.setListname(listName.getText().toString());
            db.putListData(list.getListname());
            Toast.makeText(this, "list created by name: "+ list.getListname(), Toast.LENGTH_LONG).show();

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.customm_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add) {
            Toast.makeText(this,"this is",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.delete) {

            Toast.makeText(this,"this is",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



   /* public void delete(View v) {
        if(v.getId()==R.id.button6){
            for(int i=0; i<list_items.size();i++){
                if(list_items.get(i).getIsChecked()==true)
                    list_items.remove(i);
            }
        }
    }*/
}

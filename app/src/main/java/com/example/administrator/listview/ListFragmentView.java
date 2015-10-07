package com.example.administrator.listview;

import android.app.Fragment;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.listview.dbhelper.Dbhelper;
import com.example.administrator.listview.model.List;

import java.util.ArrayList;


public class ListFragmentView extends Fragment {

    ListView listview;
    Dbhelper db;
    ListViewAdapter adapter;
    ArrayList<List> list1;
   // ArrayAdapter<String> adapter;

   // TextView text;

    public ListFragmentView() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        db= new Dbhelper(getActivity());
        View view = null;

        view = inflater.inflate(R.layout.fragment_blank, container, false);



        // TextView text = (TextView) view.findViewById(R.id.textView3);



        listview = (ListView) view.findViewById(R.id.listView2);
        list1= db.getAllListRecords();

        adapter = new ListViewAdapter(getActivity().getApplicationContext(), list1);


        listview.setAdapter(adapter);

            return view;
    }

   public class ListViewAdapter extends BaseAdapter{

       Context context;

       ArrayList<List> list;


       ListViewAdapter(Context mContext, ArrayList<List> list){
            this.context=mContext;
           this.list = list;
       }

       @Override
       public int getCount() {
           return list.size();
       }

       @Override
       public Object getItem(int position) {
           return position;
       }

       @Override
       public long getItemId(int position) {
           return position;
       }

       @Override
       public View getView(int position, View convertView, ViewGroup parent) {
           if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
               convertView = inflater.inflate(R.layout.frag_layout,parent,false);
               TextView textView = (TextView) convertView.findViewById(R.id.textView3);
               textView.setText(""+list.get(position).getListname());
           }
           return convertView;
       }
   }
}

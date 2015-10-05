package com.example.administrator.listview.adapter;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.listview.R;
import com.example.administrator.listview.model.List;

import java.util.ArrayList;

/**
 * Created by Administrator on 01-10-2015.
 */
public class Customadapter extends BaseAdapter {

    Context mcontext;
    ArrayList<List.ListItem> list;


    public Customadapter(Context context, ArrayList<List.ListItem> list) {
        super();
        this.mcontext = context;
        this.list = list;
    }

    public class Holder {

        public Holder() {
        }

        TextView textView;
        CheckBox checkBox;
        EditText editText;

    }

    Holder holder = new Holder();


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {


            LayoutInflater inflater = (LayoutInflater) mcontext.
                    getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            holder.textView = (TextView) convertView.findViewById(R.id.srno);
            holder.editText = (EditText) convertView.findViewById(R.id.listname);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);


            convertView.setTag(holder);

            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (holder.checkBox.isChecked()) {
                        list.get(position).setIsChecked(true);
                    } else {
                        list.get(position).setIsChecked(false);
                    }
                }
            });


        } else {

            holder = (Holder) convertView.getTag();
        }

        holder.textView.setText(""+position);
        holder.editText.setText(" " + list.get(position).getListItemName());
       // holder.checkBox.setChecked(false);
        return convertView;
    }


}

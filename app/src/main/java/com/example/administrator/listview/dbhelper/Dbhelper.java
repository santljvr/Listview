package com.example.administrator.listview.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrator.listview.model.List;

import java.util.ArrayList;

/**
 * Created by Administrator on 27-09-2015.
 */
public class Dbhelper extends SQLiteOpenHelper {

    public static final String DB_Name="ListDb";

    /*List Table*/

    public static final String Table_Name1="ListTable";
    public static final String COL1="list_id";
    public static final String COL2="list_name";

    /*List Item Table*/

    public static final String Table_Name2="ListItemTable";
    public static final String COL3="list_item_id";
    public static final String COL4="list_item_name";
    public static final String COL5="list_name_fk";
    public static final String COL6="isChecked";

    List list = new List();
    List.ListItem listItem;
    ArrayList<List.ListItem> listofitems;

    //List.ListItem listItem;

    public Dbhelper(Context context) {
        super(context, DB_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createListTable = "CREATE TABLE ListTable (list_id INTEGER PRIMARY KEY AUTOINCREMENT, list_name TEXT UNIQUE)";
        db.execSQL(createListTable);

        String createListItemTable = "CREATE TABLE ListItemTable (list_item_id INTEGER PRIMARY KEY AUTOINCREMENT, list_item_name TEXT, " +
                "list_name_fk TEXT, isChecked BOOLEAN, FOREIGN KEY(list_name_fk) REFERENCES ListItemTable(list_name))";

        db.execSQL(createListItemTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name1);
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name2);
        onCreate(db);
    }

    public boolean putListData(String listname){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(COL2, listname);
        db.insert(Table_Name1, null, contentValues);
        return true;
    }


    public boolean putListItemData(String listItemName, String listname, Boolean ischecked){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4,listItemName);
        contentValues.put(COL5,listname);
        contentValues.put(COL6, ischecked);
        db.insert(Table_Name2,null,contentValues);
        return true;
    }

    public List getListRecord(String listname) {

        SQLiteDatabase db = this.getReadableDatabase();
        String listQuery;
        listQuery = "SELECT * FROM " + Table_Name1 + " WHERE " + COL2 + "=?";
        Cursor cursor;

        cursor = db.rawQuery(listQuery, new String[]{listname.toString()});

        if (cursor != null) {
            cursor.moveToFirst();
            list.setListname(cursor.getString(1));
            db.close();
            return list;
        }   else {
            db.close();
            return null;
        }

    }

    public ArrayList<List.ListItem> getListItemRecord(String listname) {

        SQLiteDatabase db = this.getReadableDatabase();

        String listItemQuery;
        listItemQuery = "SELECT * FROM " + Table_Name2 + " WHERE " + COL5 + "=?";
        Cursor cursor2;

        cursor2 = db.rawQuery(listItemQuery, new String[]{listname.toString()});
        listofitems= new ArrayList<>();

        if (cursor2 != null) {
            while ((cursor2.moveToNext())) {
                listItem = list.new ListItem();
                listItem.setListItemName(cursor2.getString(1));
                listItem.setIsChecked(Boolean.parseBoolean(cursor2.getString(3)));
                listofitems.add(listItem);

            }
        }
        db.close();
        return listofitems;
    }

}

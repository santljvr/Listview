package com.example.administrator.listview.model;

import java.util.ArrayList;

/**
 * Created by Administrator on 03-10-2015.
 */
public class List {

    public List(){}

    public ListItem listItem;

    private String listname;
    private ArrayList<ListItem> itemsList;

    public ListItem getListItem() {
        return listItem;
    }

    public void setListItem(ListItem listItem) {
        this.listItem = listItem;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public String getListname() {
        return listname;
    }

    public ArrayList<ListItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<ListItem> itemsList) {
        this.itemsList = itemsList;
    }


    public class ListItem{

        public ListItem(){}

        private String listItemName;
        private Boolean isChecked;

        public void setListItemName(String listItemName) {
            this.listItemName = listItemName;
        }

        public String getListItemName() {
            return listItemName;
        }

        public void setIsChecked(Boolean isChecked) {
            this.isChecked = isChecked;
        }

        public Boolean getIsChecked() {
            return isChecked;
        }
    }
}

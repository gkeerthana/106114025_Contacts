package com.appdev.keerthana.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;


class customadapter extends BaseAdapter {
    String[] person;
    int[] pic;
    Context context;
    public customadapter(Contacts activity_contacts, String[] people, int[] pics) {
        person=people;
        pic=pics;
        context=activity_contacts;
    }

    @Override
    public int getCount() {
        return person.length;
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
        LayoutInflater inflater = LayoutInflater.from(context);
        View CustomView = inflater.inflate(R.layout.contacts_listview, parent, false);
        ImageView imageView = (ImageView) CustomView.findViewById(R.id.imageView);
        TextView textView = (TextView) CustomView.findViewById(R.id.textView);

        textView.setText(person[position]);
        imageView.setImageResource(pic[position]);
        return CustomView;
    }
};

package com.appdev.keerthana.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;


public class Contacts extends Activity {

    String[] people = {"Rachel", "Ross", "Phoebe", "Joey", "Chandler", "Monica", "ZooZoo"};
    int[] pics = {R.drawable.rachel, R.drawable.ross, R.drawable.phoebe,R.drawable.joey, R.drawable.chandler, R.drawable.monica, R.drawable.canstock14674129};
    ListView listView;
    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        adapter = new customadapter(this, people, pics);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    public void onToggleClicked(View view) {
        String temp;
        int temp1;
        if(((ToggleButton) view).isChecked()) {
            for(int i=0;i<people.length;i++)
                for(int j=i+1;j<people.length;j++)
                {
                    if(people[j].compareTo(people[i])<0);
                    {
                        temp = people[j];
                        people[j]=people[i];
                        people[i]=temp;
                        temp1 = pics[j];
                        pics[j]=pics[i];
                        pics[i]=temp1;

                    }
                }
        }
        else {
            for(int i=0;i<people.length;i++)
                for(int j=i+1;j<people.length;j++)
                {
                    if(people[j].compareTo(people[i])>0)
                    {
                        temp = people[j];
                        people[j]=people[i];
                        people[i]=temp;
                        temp1 = pics[j];
                        pics[j]=pics[i];
                        pics[i]=temp1;

                    }
                }

        }


        listView.setAdapter(new customadapter(this, people, pics));
    }

    public void onButtonClicked(final View view) {
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text = (EditText) findViewById(R.id.editText);
                String searchText = text.getText().toString();
                int k = 1;
                for (int i = 0; i < people.length; i++) {
                    if (people[i].compareTo(searchText) == 0) {
                        Toast.makeText(getApplicationContext(),
                                "Contact " + searchText + " found!", Toast.LENGTH_LONG).show();
                        k = 0;
                    }
                }
                if (k == 1) {
                    Toast.makeText(getApplicationContext(),
                            "Missing", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

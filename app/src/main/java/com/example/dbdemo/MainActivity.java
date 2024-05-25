package com.example.dbdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbdemo.adapter.RecyclerViewAdapter;
import com.example.dbdemo.data.MyDbHandler;
import com.example.dbdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private  ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//RecyclerView Initialization
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        MyDbHandler db = new MyDbHandler(MainActivity.this);
//Create Contect
        Contact avi = new Contact();
        avi.setPhoneNumber("9898989898");
        avi.setName("Avi");
//Add To Contact
        db.addContact(avi);

        contactArrayList = new ArrayList<>();


        List<Contact> contactList = db.getAllContact();
        for(Contact contact: contactList){


            Log.d("dbavi", "Id: " + contact.getId() + "\n" +
                       "Name: " + contact.getName() + "\n" +
                       "Phone Number: " + contact.getPhoneNumber() + "\n");
            contactArrayList.add(contact);
        }
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        Log.d("dbavi", "Bro You Have " + db.getCount() + " Contacts  in your database");
    }
}
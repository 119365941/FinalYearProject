package com.example.environment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserLoginActivity extends AppCompatActivity {

    //Initialise variables and database connections.
    private TextView textviewWelcome, textviewName;

    private DatabaseReference rootDatabaseref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        //Adds variables to the layout when the emulator loads.
        textviewWelcome = findViewById(R.id.textviewWelcome);
        textviewName = findViewById(R.id.textviewName);

        //Connection to the database when the emulator loads.
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("Users");

    }

}

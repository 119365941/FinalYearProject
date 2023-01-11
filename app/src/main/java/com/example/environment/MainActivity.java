package com.example.environment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //Initialised variables for use in the methods.
    private EditText inputID, inputName;
    private Button btnRead, btnSave, btnLogin;
    private TextView textViewID, textViewName;
    //Database connections
    //Reference: https://www.youtube.com/watch?v=hXuI0nLWKTE&list=PLYx38U7gxBf3pmsHVTUwRT_lGON6ZIBHi&index=5
    //I code from the video referenced above to connect the Firebase database.
    private DatabaseReference rootDatabaseref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Added elements to the emulator upon load.
        inputID = findViewById(R.id.inputID);
        inputName = findViewById(R.id.inputName);

        //btnRead = findViewById(R.id.btnRead);
        btnSave = findViewById(R.id.btnSave);
        btnLogin = findViewById(R.id.btnLogin);

     //   textViewID = findViewById(R.id.textViewID);
     //   textViewName = findViewById(R.id.textViewName);

        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("Users");

    /*    btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootDatabaseref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Person person = snapshot.getValue(Person.class);
                        textViewID.setText("" + person.getId());
                        textViewName.setText(person.getName());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        }); */

        /* When the Save button is clicked, variables are initialised and changed to strings.
           Text in textviews is assigned to the variables.
           Used the push() function to push data from the variables to the Database as new records.*/
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(inputID.getText().toString());
                String name = inputName.getText().toString();

                //Adds the values for ID and Name to the database as the ID and Name values for the Object User.
                //Code Reference https://www.youtube.com/watch?v=c9W6dQQQuMI&list=PLYx38U7gxBf3pmsHVTUwRT_lGON6ZIBHi&index=13
                String key = rootDatabaseref.push().getKey();
                rootDatabaseref.child(key).child("ID").setValue(id);
                rootDatabaseref.child(key).child("Name").setValue(name);

            }
        });

        //Opens the UserLoginActivity when the Login button is clicked
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserLoginActivity();
            }
        });
    }
        //Used to start the UserLoginActivity so as it can be accessed when the Login button is clicked.
        public void openUserLoginActivity(){
            Intent intent = new Intent(this, UserLoginActivity.class);
            startActivity(intent);

        }

    }
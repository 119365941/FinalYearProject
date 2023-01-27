package com.example.environment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    //Declaring elements
    private ImageView bgapp, clover;
    private LinearLayout splashtext, hometext, menus;
    private Animation frombottom;

    ImageButton btnMedicine, btnCalendar, btnSettings, btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);

        //Adding elements to the activity
        bgapp = (ImageView) findViewById(R.id.bgapp);
        clover = (ImageView) findViewById(R.id.clover);
        splashtext = (LinearLayout) findViewById(R.id.splashtext);
        hometext = (LinearLayout) findViewById(R.id.hometext);
        menus = (LinearLayout) findViewById(R.id.menus);
        btnCalendar = (ImageButton) findViewById(R.id.btnCalendar);
        btnMedicine = (ImageButton) findViewById(R.id.btnMedicine);
        btnSettings = (ImageButton) findViewById(R.id.btnSettings);
        btnProfile = (ImageButton) findViewById(R.id.btnProfile);


        //Code taken from a Youtube video by Design with Hassan, can be found at the following link
        //https://www.youtube.com/watch?v=k_OJt71wEbc

        bgapp.animate().translationY(-1200).setDuration(800).getStartDelay();
        clover.animate().alpha(0).setDuration(800).getStartDelay();
        splashtext.animate().translationY(140).alpha(0).setDuration(800).getStartDelay();
        hometext.startAnimation(frombottom);
        menus.startAnimation(frombottom);


        //Calls openMedicineActivity when the button is clicked.
        btnMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedicineActivity();
            }
        });

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openProfileActivity();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //Used to start the MedicineActivity so as it can be accessed when the Login button is clicked.
    public void openMedicineActivity(){
        System.out.println("Logged in...");
        Intent intent = new Intent(this, MedicineActivity.class);
        startActivity(intent);

    }

    //Used to start the ProfileActivity so as it can be accessed when the Profile button is clicked.
    public void openProfileActivity(){
        System.out.println("Logged in...");
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);

    }

}
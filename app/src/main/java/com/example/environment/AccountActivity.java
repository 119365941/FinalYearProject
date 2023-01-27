package com.example.environment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    //Declaring elements
    private ImageView bgapp, clover;
    private LinearLayout splashtext, hometext, menus;
    private Animation frombottom;
    private ImageButton btnUser, btnCarer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //Adding elements to the activity
        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        bgapp = (ImageView) findViewById(R.id.bgapp);
        clover = (ImageView) findViewById(R.id.clover);
        //splashtext = (LinearLayout) findViewById(R.id.splashtext);
        hometext = (LinearLayout) findViewById(R.id.hometext);
        menus = (LinearLayout) findViewById(R.id.menus);
        bgapp.animate().translationY(-1200).setDuration(800).getStartDelay();
        clover.animate().alpha(0).setDuration(800).getStartDelay();
        //splashtext.animate().translationY(140).alpha(0).setDuration(800).getStartDelay();
        hometext.startAnimation(frombottom);
        menus.startAnimation(frombottom);
        btnCarer = (ImageButton) findViewById(R.id.btnCarer);
        btnUser = (ImageButton) findViewById(R.id.btnUser);

        System.out.println("test");

        //Calls the openUserActivity method when the btnUser is clicked
        btnUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openUserActivity();
            }
        });

        //Calls the openCareActivity method when the btnCarer is clicked
        btnCarer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openCarerActivity();
            }
        });

    }

    //Used to start the UserLoginActivity so as it can be accessed when the User Imagebutton is clicked.
    public void openUserActivity(){
        System.out.println("Logged in...");
        Intent intentUser = new Intent(this, UserActivity.class);
        startActivity(intentUser);

    }

    //Used to start the CarerLoginActivity so as it can be accessed when the Carer Imagebutton is clicked.
    public void openCarerActivity(){
        System.out.println("Logged in...");
        Intent intent = new Intent(this, CarerActivity.class);
        startActivity(intent);

    }
}

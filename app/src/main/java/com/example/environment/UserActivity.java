package com.example.environment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    private ImageView imageView3;
    private View view2, topView;
    private TextView topText, forgotPassword, textView7, gotoRegister;
    private EditText inputEmail, inputPassword;
    private Button btnLogin;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

        System.out.println("Working...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


    }
}

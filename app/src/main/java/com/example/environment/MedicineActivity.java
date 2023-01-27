package com.example.environment;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MedicineActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declaring elements
    private ImageView bgapp, clover;
    private LinearLayout hometext, menus;
    private Animation frombottom;

    private Spinner spinnerMedication, spinnerDosage, spinnerAmount, spinnerTime;

    private DatabaseReference rootDatabaseref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        //The following code is taken from a Youtube video by Design with Hassan.
        //It can be found at the following link: https://www.youtube.com/watch?v=k_OJt71wEbc
        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        //Adding elements to the View
        bgapp = (ImageView) findViewById(R.id.bgapp);
        clover = (ImageView) findViewById(R.id.clover);
        hometext = (LinearLayout) findViewById(R.id.hometext);
        menus = (LinearLayout) findViewById(R.id.menus);


        //Adding spinnners to the View
        spinnerMedication = findViewById(R.id.spinnerMedication);
        spinnerDosage = findViewById(R.id.spinnerDosage);
        spinnerAmount = findViewById(R.id.spinnerAmount);
        spinnerTime = findViewById(R.id.spinnerTime);

        //Connecting to the database
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("Users");

        //The following code is taken from a Youtube video by Design with Hassan.
        //It can be found at the following link: https://www.youtube.com/watch?v=k_OJt71wEbc
        bgapp.animate().translationY(-1200).setDuration(800).getStartDelay();
        clover.animate().alpha(0).setDuration(800).getStartDelay();
        hometext.startAnimation(frombottom);
        menus.startAnimation(frombottom);

        //Populating spinner/dropdown box with data from the medicationHypertension array.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.medicationCholesterol, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMedication.setAdapter(adapter);

        spinnerMedication.setOnItemSelectedListener(this);

        //Populating spinner/dropdown box with data from the medicationHypertension array.
        ArrayAdapter<CharSequence> adapterDosage = ArrayAdapter.createFromResource(this, R.array.dosageCholesterol, android.R.layout.simple_spinner_item);
        adapterDosage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDosage.setAdapter(adapterDosage);

        spinnerDosage.setOnItemSelectedListener(this);

        //Populating spinner/dropdown box with data from the medicationHypertension array.
        ArrayAdapter<CharSequence> adapterAmount = ArrayAdapter.createFromResource(this, R.array.amountCholesterol, android.R.layout.simple_spinner_item);
        adapterAmount.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAmount.setAdapter(adapterAmount);

        spinnerAmount.setOnItemSelectedListener(this);

        //Populating spinner/dropdown box with data from the medicationHypertension array.
        ArrayAdapter<CharSequence> adapterTime = ArrayAdapter.createFromResource(this, R.array.timeCholesterol, android.R.layout.simple_spinner_item);
        adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(adapterTime);

        spinnerTime.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

package com.example.tai.tdeecalculatordemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class TDEEResultDemo extends AppCompatActivity {
    double bmi,bmr,tdee;
    int userkcal;
    TextView userbmi,usercalrec,bmirec,tdeeinfo;
    HealthRecommendations user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdeeresult_demo);
        getSupportActionBar().setTitle("Results");
        Intent intentextras = getIntent();
        Bundle extrabundles = intentextras.getExtras();
        bmi = extrabundles.getDouble("bmi");
        bmr = extrabundles.getDouble("bmr");
        tdee = extrabundles.getDouble("tdee");
        userkcal = (int) tdee;
        user = new HealthRecommendations(bmi,userkcal);
        userbmi = (TextView) findViewById(R.id.userbmi);
        usercalrec = (TextView) findViewById(R.id.usercalrec);
        bmirec = (TextView) findViewById(R.id.bmirec);
        tdeeinfo = (TextView) findViewById(R.id.tdeeinfo);
    }
    protected void onStart(){
        super.onStart();
        userbmi.setText("" + bmi);
        usercalrec.setText(user.calorieRecommendation());
        bmirec.setText(user.healthyBMI());
        tdeeinfo.setText(user.calorieRecommendationString());
    }
}

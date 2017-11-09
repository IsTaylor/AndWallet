package com.example.owner.andwallet;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intentExpense = new Intent();
        intentExpense.setClass(MainActivity.this, ExpenseScreen.class);

        Button btnExpense = (Button) findViewById(R.id.btnExpense);
        btnExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentExpense);
                //intentDetails.putExtra(KEY_DATA, etData.getText().toString());
                //DataManager.getInstance().setData(etData.getText().toString());
            }
        });

        Button btnSummary = (Button) findViewById(R.id.btnSummary);
        btnSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSummary = new Intent();
                intentSummary.setClass(MainActivity.this, Summary.class);
                startActivity(intentSummary);
            }
        });

        LinearLayout layoutMain = (LinearLayout) findViewById(R.id.layoutMain);

        AnimationDrawable animationDrawable = (AnimationDrawable) layoutMain.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

    }


}

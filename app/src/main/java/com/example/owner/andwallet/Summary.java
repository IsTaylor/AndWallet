package com.example.owner.andwallet;


import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Summary extends AppCompatActivity {

    @BindView(R.id.tvIncome)
    TextView tvIncome;
    @BindView(R.id.tvOutcome)
    TextView tvOutcome;
    @BindView(R.id.tvTotal)
    TextView tvTotal;
    @BindView(R.id.layoutSummary)
    LinearLayout layoutSummary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        ButterKnife.bind(this);

        tvIncome.setText(Integer.toString(SummaryData.getInstance().getIncome()));
        tvOutcome.setText(Integer.toString(SummaryData.getInstance().getOutcome()));
        tvTotal.setText(getString(R.string.total_is, Integer.toString(SummaryData.getInstance().getTotal())));

        AnimationDrawable animationDrawable = (AnimationDrawable) layoutSummary.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }


}

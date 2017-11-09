package com.example.owner.andwallet;

import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExpenseScreen extends AppCompatActivity {

    @BindView(R.id.layoutContent)
    LinearLayout layoutContent;
    @BindView(R.id.layoutExpense)
    LinearLayout layoutExpense;
    @BindView(R.id.etTitle)
    EditText etTitle;
    @BindView(R.id.etAmount)
    EditText etAmount;
    @BindView(R.id.tbInOut)
    ToggleButton tbInOut;
    @BindView(R.id.tvBalance)
    TextView tvBalance;


    private int balance = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_screen);


        ButterKnife.bind(this);

        AnimationDrawable animationDrawable = (AnimationDrawable) layoutExpense.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                layoutContent.removeAllViewsInLayout();
                SummaryData.getInstance().reset();
                balance = 0;
                String text = getString(R.string.current_balance, balance);
                tvBalance.setText(text);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btnSave)
    public void savePressed(Button btnSave) {

        if (!TextUtils.isEmpty(etTitle.getText())) {
            if (!TextUtils.isEmpty(etAmount.getText())) {

                if (tbInOut.isChecked()) {
                    balance = balance - Integer.parseInt(etAmount.getText().toString());
                    SummaryData.getInstance().addOutcome(Integer.parseInt(etAmount.getText().toString()));
                } else {
                    balance = balance + Integer.parseInt(etAmount.getText().toString());
                    SummaryData.getInstance().addIncome(Integer.parseInt(etAmount.getText().toString()));
                }

                String text = getString(R.string.current_balance, balance);

                tvBalance.setText(text);

                final View expenseRow = getLayoutInflater().inflate(
                        R.layout.layout_expense_row,
                        null, false);

                TextView tvItem = expenseRow.findViewById(R.id.tvItem);
                tvItem.setText(etTitle.getText().toString());

                TextView tvCost = expenseRow.findViewById(R.id.tvCost);
                tvCost.setText(etAmount.getText().toString());

                ImageView ivExpense = expenseRow.findViewById(R.id.ivExpense);
                if (tbInOut.isChecked()) {
                    ivExpense.setImageResource(R.mipmap.down_arrow);
                }

                layoutContent.addView(expenseRow, 0);
            } else {
                etAmount.setError(getString(R.string.empty_field_error));
            }
        } else {
            etTitle.setError(getString(R.string.empty_field_error));
        }

    }
}

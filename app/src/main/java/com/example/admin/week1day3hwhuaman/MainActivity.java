package com.example.admin.week1day3hwhuaman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainAcivityTag";
    Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5,
            btnNum6, btnNum7, btnNum8, btnNum9,
            btnDecimal,
            btnsignPercentage,
            btnEquals, btnAddition, btnSubtraction, btnMultiplication, btnDivision;
    TextView tvDisplayValue;
    String inputValue = "";
    String firstValue, signSymbol;
    Boolean readyToCalculate = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        btnNum0 = (Button) findViewById(R.id.num0);
        btnNum1 = (Button) findViewById(R.id.num1);
        btnNum2 = (Button) findViewById(R.id.num2);
        btnNum3 = (Button) findViewById(R.id.num3);
        btnNum4 = (Button) findViewById(R.id.num4);
        btnNum5 = (Button) findViewById(R.id.num5);
        btnNum6 = (Button) findViewById(R.id.num6);
        btnNum7 = (Button) findViewById(R.id.num7);
        btnNum8 = (Button) findViewById(R.id.num8);
        btnNum9 = (Button) findViewById(R.id.num9);
        btnDecimal = (Button) findViewById(R.id.decimal);
        btnsignPercentage = (Button) findViewById(R.id.signPercentage);

        btnEquals = (Button) findViewById(R.id.signEquals);
        btnAddition = (Button) findViewById(R.id.signAddition);
        btnSubtraction = (Button) findViewById(R.id.signSubtraction);
        btnDivision = (Button) findViewById(R.id.signDivision);
        btnMultiplication = (Button) findViewById(R.id.signMultiplication);

        tvDisplayValue = (TextView) findViewById(R.id.displayView);
    }


    public void updateDisplayView(View view) {
        switch (view.getId()) {
            case R.id.num0:
                Toast.makeText(getApplicationContext(), btnNum0.getText(), Toast.LENGTH_SHORT).show();
                updateEquation(btnNum0.getText().toString());
                break;
            case R.id.num1:
                Toast.makeText(getApplicationContext(), btnNum1.getText(), Toast.LENGTH_SHORT).show();
                updateEquation(btnNum1.getText().toString());
                break;
            case R.id.num2:
                Toast.makeText(getApplicationContext(), btnNum2.getText(), Toast.LENGTH_SHORT).show();
                updateEquation(btnNum2.getText().toString());
                break;
            case R.id.num3:
                Toast.makeText(getApplicationContext(), btnNum3.getText(), Toast.LENGTH_SHORT).show();
                updateEquation(btnNum3.getText().toString());
                break;
            case R.id.num4:
                Toast.makeText(getApplicationContext(), btnNum4.getText(), Toast.LENGTH_SHORT).show();
                updateEquation(btnNum4.getText().toString());
                break;
            case R.id.num5:
                Toast.makeText(getApplicationContext(), btnNum5.getText(), Toast.LENGTH_SHORT).show();
                updateEquation(btnNum5.getText().toString());
                break;
            case R.id.num6:
                Toast.makeText(getApplicationContext(), btnNum6.getText(), Toast.LENGTH_SHORT).show();
                updateEquation(btnNum6.getText().toString());
                break;
            case R.id.num7:
                Toast.makeText(getApplicationContext(), btnNum7.getText(), Toast.LENGTH_SHORT).show();
                updateEquation(btnNum7.getText().toString());
                break;
            case R.id.num8:
                Toast.makeText(getApplicationContext(), btnNum8.getText(), Toast.LENGTH_SHORT).show();
                updateEquation(btnNum8.getText().toString());
                break;
            case R.id.num9:
                Toast.makeText(getApplicationContext(), btnNum9.getText(), Toast.LENGTH_SHORT).show();
                updateEquation(btnNum9.getText().toString());
                break;
            case R.id.decimal:
                Toast.makeText(getApplicationContext(), btnDecimal.getText() + "", Toast.LENGTH_SHORT).show();
                String checkDecimal = tvDisplayValue.getText().toString();
                if (!checkDecimal.contains("."))
                    updateEquation(btnDecimal.getText().toString());
                break;

            case R.id.signPosNeg:
                String updateSignPosNeg = "" + (-1) * (Double.parseDouble(tvDisplayValue.getText().toString()));
                tvDisplayValue.setText(updateSignPosNeg);
                break;
            case R.id.signPercentage:
                String updateSgnPercentage = "" +  (Double.parseDouble(tvDisplayValue.getText().toString()))/100;
                tvDisplayValue.setText(updateSgnPercentage);
                btnsignPercentage.setEnabled(false);
                break;

            case R.id.Clear:
                clearView();
                break;

            case R.id.signEquals:
                evalutate();
                break;
            case R.id.signDivision:
                signUsed(btnDivision.getText().toString());
                break;
            case R.id.signMultiplication:
                signUsed(btnMultiplication.getText().toString());
                break;
            case R.id.signAddition:
                signUsed(btnAddition.getText().toString());
                break;
            case R.id.signSubtraction:
                signUsed(btnSubtraction.getText().toString());
                break;
        }

    }

    private void clearView() {
        tvDisplayValue.setText("");
        readyToCalculate = false;
        signSymbol = "";
        btnMultiplication.setEnabled(true);
        btnSubtraction.setEnabled(true);
        btnAddition.setEnabled(true);
        btnDivision.setEnabled(true);
    }

    public void signUsed(String signView) {

        if (readyToCalculate != true) {
            firstValue = tvDisplayValue.getText().toString();
            signSymbol = signView;
            tvDisplayValue.setText("");
            readyToCalculate = true;
            btnMultiplication.setEnabled(false);
            btnSubtraction.setEnabled(false);
            btnAddition.setEnabled(false);
            btnDivision.setEnabled(false);
            btnsignPercentage.setEnabled(true);
        }
    }

    public void evalutate() {
        if (readyToCalculate == true) {
            double a = Double.parseDouble(firstValue);
            double b = Double.parseDouble(inputValue);
            double c = 0;
            if (signSymbol.equals("+"))
                c = a + b;
            if (signSymbol.equals("-"))
                c = a - b;
            if (signSymbol.equals("X"))
                c = a * b;
            if (signSymbol.equals("/"))
                c = a / b;

            tvDisplayValue.setText(String.valueOf(c));
            readyToCalculate = false;
            signSymbol = "";
            btnMultiplication.setEnabled(true);
            btnSubtraction.setEnabled(true);
            btnAddition.setEnabled(true);
            btnDivision.setEnabled(true);
            btnsignPercentage.setEnabled(true);
        }

    }

    private void updateEquation(String enteredString) {

        inputValue = enteredString;

        inputValue = tvDisplayValue.getText().toString() + enteredString;
        tvDisplayValue.setText(inputValue);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}


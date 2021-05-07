package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView editText, tvResult;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAdd, bSub, bDiv, bMulti, bEqual, bAC,bMode, bDel;

    String sign = "";
    int number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        tvResult = findViewById(R.id.tvResult);
        b0= findViewById(R.id.b0);
        b1= findViewById(R.id.b1);
        b2= findViewById(R.id.b2);
        b3= findViewById(R.id.b3);
        b4= findViewById(R.id.b4);
        b5= findViewById(R.id.b5);
        b6= findViewById(R.id.b6);
        b7= findViewById(R.id.b7);
        b8= findViewById(R.id.b8);
        b9= findViewById(R.id.b9);

        bAdd= findViewById(R.id.bAdd);
        bSub= findViewById(R.id.bSub);
        bDiv= findViewById(R.id.bDiv);
        bMulti= findViewById(R.id.bMulti);
        bEqual= findViewById(R.id.bEqual);
        bAC = findViewById(R.id.bAC);
        bDel = findViewById(R.id.bDel);
        bMode = findViewById(R.id.bMode);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);

        bAdd.setOnClickListener(this);
        bSub.setOnClickListener(this);
        bMulti.setOnClickListener(this);
        bDiv.setOnClickListener(this);
        bEqual.setOnClickListener(this);
        bAC.setOnClickListener(this);
        bDel.setOnClickListener(this);
        bMode.setOnClickListener(this);

    }
    // Task 1: This function allows to split digits with spaces in group of 3 digits
    public static String withLargeIntegers(double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        DecimalFormat df = new DecimalFormat("###,###", symbols);
        return df.format(value);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b0:
                tvResult.append("0");
                break;
            case R.id.b1:
                tvResult.append("1");
                break;
            case R.id.b2:
                tvResult.append("2");
                break;
            case R.id.b3:
                tvResult.append("3");
                break;
            case R.id.b4:
                tvResult.append("4");
                break;
            case R.id.b5:
                tvResult.append("5");
                break;
            case R.id.b6:
                tvResult.append("6");
                break;
            case R.id.b7:
                tvResult.append("7");
                break;
            case R.id.b8:
                tvResult.append("8");
                break;
            case R.id.b9:
                tvResult.append("9");
                break;
            case R.id.bAdd:
                if (!tvResult.getText().toString().isEmpty()){
                    sign = "+";
                    number1 = Integer.parseInt(tvResult.getText().toString().replaceAll("\\s", ""));
                    tvResult.setText("");
                    editText.setText(number1+sign);
                }
                break;
            case R.id.bSub:
                if (!tvResult.getText().toString().isEmpty()){
                    sign = "-";
                    number1 = Integer.parseInt(tvResult.getText().toString().replaceAll("\\s", ""));
                    tvResult.setText("");
                    editText.setText(number1+sign);
                }
                break;
            case R.id.bMulti:
                if (!tvResult.getText().toString().isEmpty()){
                    sign = "*";
                    number1 = Integer.parseInt(tvResult.getText().toString().replaceAll("\\s", ""));
                    tvResult.setText("");
                    editText.setText(number1+sign);
                }
                break;
            case R.id.bDiv:
                if (!tvResult.getText().toString().isEmpty()){
                    sign = "/";
                    number1 = Integer.parseInt(tvResult.getText().toString().replaceAll("\\s", ""));
                    tvResult.setText("");
                    editText.setText(number1+sign);
                }
                break;
            case R.id.bMode:
                if (!tvResult.getText().toString().isEmpty()){
                    sign = "%";
                    number1 = Integer.parseInt(tvResult.getText().toString().replaceAll("\\s", ""));
                    tvResult.setText("");
                    editText.setText(number1+sign);
                }
                break;
            case R.id.bAC:
                tvResult.setText("");
                editText.setText("");
                break;
            case R.id.bDel:
                String str = tvResult.getText().toString();
                if (str.length() >=1 ) {
                    str = str.substring(0, str.length() - 1);
                    tvResult.setText(str);
                } else if (str.length() <=1 ) {
                    tvResult.setText("0");
                }
                break;
            case R.id.bEqual:
                if (!tvResult.getText().toString().isEmpty()){
                    number2 = Integer.parseInt(tvResult.getText().toString());
                    if (sign.equals("+")) {
                        int result = number1 + number2;
                        editText.setText(number1 + " " + sign + " " + number2);
                        tvResult.setText(withLargeIntegers(result));
                    }
                    if (sign.equals("-")) {
                        int result = number1 - number2;
                        editText.setText(number1 + " " + sign + " " +number2);
                        tvResult.setText(withLargeIntegers(result));
                    }
                    if (sign.equals("*")) {
                        int result = number1 * number2;
                        editText.setText(number1 + " " + sign + " " +number2);
                        tvResult.setText(withLargeIntegers(result));

                    }
                    if (sign.equals("/")) {
                        int result = number1 / number2;
                        editText.setText(number1 + " " + sign + " " +number2);
                        tvResult.setText(withLargeIntegers(result));
                    }
                    if (sign.equals("%")) {
                        int result = number1 % number2;
                        editText.setText(number1 + " " + sign + " " +number2);
                        tvResult.setText(withLargeIntegers(result));
                    }
                }
                break;
        }
    }
}
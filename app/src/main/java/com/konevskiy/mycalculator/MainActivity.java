package com.konevskiy.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String inputError = "Incorrect input";
    private TextView prevResult;
    private TextView operand;
    private Button operandPlus;
    private Button operandMinus;
    private Button operandMult;
    private Button operandDiv;
    private Button calculateButton;
    private EditText input_number;
    private TextView resultText;

    private Button mcButton;
    private Button msButton;
    private Button mrButton;
    private Button mPlusButton;
    private Button mMinusButton;

    private double a;
    private double b;
    private double memory = 0;
    enum operationNumber
    {
        Plus,
        Minus,
        Mult,
        Div
    }
    operationNumber currentOperation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        prevResult = (TextView) findViewById(R.id.prevResult);
        input_number = (EditText) findViewById(R.id.input_number);

        resultText = (TextView) findViewById(R.id.textResult);

        operand = (TextView) findViewById(R.id.operand);
        operandPlus = (Button) findViewById(R.id.operandPlus);
        operandPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation =  operationNumber.Plus;
                if (prevResult.getText().toString().isEmpty()) {
                    prevResult.setText(input_number.getText().toString());
                    input_number.setText("");
                }
                operand.setText("+");
                calculateButton.setEnabled(true);
            }
        });

        operandMinus = (Button) findViewById(R.id.operandMinus);
        operandMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation =  operationNumber.Minus;
                if (prevResult.getText().toString().isEmpty()) {
                    prevResult.setText(input_number.getText().toString());
                    input_number.setText("");
                }
                operand.setText("-");
                calculateButton.setEnabled(true);
            }
        });

        operandMult = (Button) findViewById(R.id.operandMult);
        operandMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation =  operationNumber.Mult;
                if (prevResult.getText().toString().isEmpty()) {
                    prevResult.setText(input_number.getText().toString());
                    input_number.setText("");
                }
                operand.setText("*");
                calculateButton.setEnabled(true);
            }
        });

        operandDiv = (Button) findViewById(R.id.operandDiv);
        operandDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation =  operationNumber.Div;
                if (prevResult.getText().toString().isEmpty()) {
                    prevResult.setText(input_number.getText().toString());
                    input_number.setText("");
                }
                operand.setText("/");
                calculateButton.setEnabled(true);
            }
        });

        calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setEnabled(false);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Double.valueOf(prevResult.getText().toString());
                    b = Double.valueOf(input_number.getText().toString());
                    switch (currentOperation) {
                        case Plus:
                            resultText.setText(String.valueOf(a + b));
                            prevResult.setText(String.valueOf(a + b));
                            break;
                        case Minus:
                            resultText.setText(String.valueOf(a - b));
                            prevResult.setText(String.valueOf(a - b));
                            break;
                        case Mult:
                            resultText.setText(String.valueOf(a * b));
                            prevResult.setText(String.valueOf(a * b));
                            break;
                        case Div:
                            resultText.setText(String.valueOf(a / b));
                            prevResult.setText(String.valueOf(a / b));
                            break;
                    }
                    input_number.setText("");
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),inputError,Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        mcButton = (Button) findViewById(R.id.mcButton);
        mcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory = 0;
            }
        });

        msButton = (Button) findViewById(R.id.msButton);
        msButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    memory = Double.valueOf(resultText.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),inputError,Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        mrButton = (Button) findViewById(R.id.mrButton);
        mrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_number.setText(String.valueOf(memory));
            }
        });

        mPlusButton = (Button) findViewById(R.id.mPlusButton);
        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    memory += Double.valueOf(input_number.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),inputError,Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        mMinusButton = (Button) findViewById(R.id.mMinusButton);
        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    memory -= Double.valueOf(input_number.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),inputError,Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}

package com.example.calculation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button0, button1, button2, button3,  button4, button5, button6, button7, button8, button9,buttonDoc,buttonClear,buttonAdd,buttonMin,buttonMul,buttonDiv,buttonEqual;
    private EditText editTextResult;
    private float valueOne;
    private boolean isAdd, isSub, isMul, isDiv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDoc = (Button) findViewById(R.id.buttonDoc);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonMin = (Button) findViewById(R.id.buttonMin);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        editTextResult = (EditText) findViewById(R.id.editTextResult);

        button0.setOnClickListener(v -> setNumber("0"));
        button1.setOnClickListener(v -> setNumber("1"));
        button2.setOnClickListener(v -> setNumber("2"));
        button3.setOnClickListener(v -> setNumber("3"));
        button4.setOnClickListener(v -> setNumber("4"));
        button5.setOnClickListener(v -> setNumber("5"));
        button6.setOnClickListener(v -> setNumber("6"));
        button7.setOnClickListener(v -> setNumber("7"));
        button8.setOnClickListener(v -> setNumber("8"));
        button9.setOnClickListener(v -> setNumber("9"));
        buttonDoc.setOnClickListener(v -> setNumber("."));




        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextResult.getText().toString().isEmpty()) {
                    valueOne = Float.parseFloat(editTextResult.getText().toString());
                    isAdd = true;
                    editTextResult.setText("");
                }
            }
        });

        // Subtraction button
        buttonMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextResult.getText().toString().isEmpty()) {
                    valueOne = Float.parseFloat(editTextResult.getText().toString());
                    isSub = true;
                    editTextResult.setText(editTextResult.getText().toString() + "-");
                }
            }
        });

        // Multiplication button
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextResult.getText().toString().isEmpty()) {
                    valueOne = Float.parseFloat(editTextResult.getText().toString());
                    isMul = true;
                    editTextResult.setText(editTextResult.getText().toString() + "*");
                }
            }
        });

        // Division button
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextResult.getText().toString().isEmpty()) {
                    valueOne = Float.parseFloat(editTextResult.getText().toString());
                    isDiv = true;
                    editTextResult.setText(editTextResult.getText().toString() + "/");
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(!editTextResult.getText().toString().isEmpty()) {
                Float valueTwo = Float.parseFloat(editTextResult.getText().toString());
                if (isAdd) {
                    editTextResult.setText(valueOne + valueTwo + "");
                    isAdd = false;
                }
                if (isSub) {
                    editTextResult.setText(valueOne - valueTwo + "");
                    isSub = false;
                }
                if (isMul) {
                    editTextResult.setText(valueOne * valueTwo + "");
                    isMul = false;
                }
                if (isDiv) {
                    if (valueTwo!= 0) {
                        editTextResult.setText(valueOne / valueTwo + "");
                        isDiv = false;
                    } else {
                        editTextResult.setText("Error: Division by zero");
                    }
                    isDiv = false;
                }
            }
        }});

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextResult.setText(null);
                valueOne = 0;
                isAdd = false;
                isSub = false;
                isMul = false;
                isDiv = false;
            }
        });



    }
    private void setNumber(String number) {
        String currentValue = editTextResult.getText().toString();
        editTextResult.setText(currentValue + number);
    }
}

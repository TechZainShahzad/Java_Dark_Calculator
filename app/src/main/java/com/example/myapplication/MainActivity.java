package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button div;
    private Button mul;
    private Button plus;
    private Button min;
    private Button equal;
    private Button CLR;
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.One);
        two = findViewById(R.id.Two);
        three = findViewById(R.id.Three);
        four = findViewById(R.id.Four);
        five = findViewById(R.id.Five);
        six = findViewById(R.id.Six);
        seven = findViewById(R.id.Seven);
        eight = findViewById(R.id.Eight);
        nine = findViewById(R.id.Nine);
        zero = findViewById(R.id.Zero);
        div = findViewById(R.id.Divv);
        mul = findViewById(R.id.Mull);
        plus = findViewById(R.id.Pluss);
        min = findViewById(R.id.Minus);
        equal = findViewById(R.id.Equall);
        textView = findViewById(R.id.subView);
        textView2 = findViewById(R.id.textView2);
        CLR = findViewById(R.id.CLR);
        textView.setText(""); // Remove initial "0" display
    }

    String concat = "";
    String concatination = "0";
    String op = "=";
    String temp = "";

    public void CLR(View view) {
        textView.setText(""); // Clear the display
        textView2.setText("0");
        concat = "";
        concatination = "0";
        op = null;
    }

    public void handleNumberInput(String num) {
        if (concat.equals("0")) {
            concat = num;
        } else {
            concat = concat + num;
        }
        textView.setText(concat);
        concatination = concat;
    }

    public void Onee(View view) {
        handleNumberInput("1");
    }

    public void Twoo(View view) {
        handleNumberInput("2");
    }

    public void Threee(View view) {
        handleNumberInput("3");
    }

    public void Fourr(View view) {
        handleNumberInput("4");
    }

    public void Fivee(View view) {
        handleNumberInput("5");
    }

    public void Sixx(View view) {
        handleNumberInput("6");
    }

    public void Sevenn(View view) {
        handleNumberInput("7");
    }

    public void Eightt(View view) {
        handleNumberInput("8");
    }

    public void Ninee(View view) {
        handleNumberInput("9");
    }

    public void Zeroo(View view) {
        handleNumberInput("0");
    }

    public void handleOperation(String operation) {
        textView2.setText(concat);
        temp = concat;
        concat = "0";
        concatination = "0";
        textView.setText("0");
        op = operation;
    }

    public void Pluss(View view) {
        handleOperation("+");
    }

    public void Minuss(View view) {
        handleOperation("-");
    }

    public void Mull(View view) {
        handleOperation("*");
    }

    public void Divv(View view) {
        handleOperation("/");
    }

    public void Equall(View view) {
        if (!temp.isEmpty() && !concat.isEmpty()) {
            double num1 = Double.parseDouble(temp);
            double num2 = Double.parseDouble(concat);
            double result = 0.0;

            switch (op) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        // Handle division by zero
                        textView.setText("Error");
                        return;
                    }
                    break;
                case "=":
                    result = num2;
                    break;
            }

            if (isWholeNumber(result)) {
                // Display as integer
                textView2.setText(String.format("%.0f", result));
                textView.setText(String.format("%.0f", result));
                concat = String.format("%.0f", result);
            } else {
                // Display with two decimal places
                textView2.setText(String.format("%.2f", result));
                textView.setText(String.format("%.2f", result));
                concat = String.format("%.2f", result);
            }
        }
    }

    private boolean isWholeNumber(double number) {
        return number == (int) number;
    }
}

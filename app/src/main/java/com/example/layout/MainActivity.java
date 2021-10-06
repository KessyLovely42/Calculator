package com.example.layout;

import androidx.annotation.RequiresApi;
import  androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private EditText display;
    private TextView resultDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.numberDisplay);
        resultDisplay = findViewById(R.id.resultView);

        display.setShowSoftInputOnFocus(false);


//        display.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(getString(R.string.numberDisplay).equals(display.getText().toString())){
//                    display.setText("");
//                }
//            }
//        });
    }

    public void updateDisplay(String strToAdd){
        String displayString = display.getText().toString();
        int caretPosition = display.getSelectionStart();
        String leftString = displayString.substring(0,caretPosition);
        String rightString = displayString.substring(caretPosition);
        display.setText(leftString + strToAdd + rightString);
//        int newCaretPosition = caretPosition +1;
        display.setSelection(caretPosition+1);
    }

    public void zeroBtn(View view){
        updateDisplay("0");
    }

    public void oneBtn(View view){
        updateDisplay("1");
    }

    public void twoBtn(View view){
        updateDisplay("2");
    }

    public void threeBtn(View view){
        updateDisplay("3");
    }

    public void fourBtn(View view){
        updateDisplay("4");
    }

    public void fiveBtn(View view){
        updateDisplay("5");
    }

    public void sixBtn(View view){
        updateDisplay("6");
    }

    public void sevenBtn(View view){
        updateDisplay("7");
    }

    public void eightBtn(View view){
        updateDisplay("8");
    }

    public void nineBtn(View view){
        updateDisplay("9");
    }

    public void clrBtn(View view){
        display.setText("");
        resultDisplay.setText("");
    }

    public void backSpaceBtn(View view){
        String displayString = display.getText().toString();
        int caretPosition = display.getSelectionStart();
        String leftString = displayString.substring(0,caretPosition-1);
        String rightString = displayString.substring(caretPosition);
        display.setText(leftString + rightString);
        display.setSelection(leftString.length());
    }

    public void dotBtn(View view){
        updateDisplay(".");
    }

    public void addBtn(View view){
        updateDisplay("+");
    }
    public void subBtn(View view){
        updateDisplay("-");
    }
    public void divBtn(View view){
        updateDisplay("/");
    }
    public void mulBtn(View view){
        updateDisplay("*");
    }
    public void plusMinusBtn(View view){
        int cursorPosition = display.getSelectionStart();
        String displayText = display.getText().toString();
        int letterAvailability = displayText.indexOf('-');

        if(letterAvailability>-1){
            String str = displayText.substring(1,displayText.length());
            display.setText(str);
            display.setSelection(str.length());

        }
        else {


//            StringBuilder text = new StringBuilder(displayText);
//            text.insert(1,"-");
            display.setText("-"+displayText);
            display.setSelection(cursorPosition+1);

        }
    }
    public void perBtn(View view){
        updateDisplay("%");
    }

    public void equalsBTN(View view){
        String exp =display.getText().toString();

        exp = exp.replaceAll("÷", "/");
        exp = exp.replaceAll("×", "*");

        Expression mathExp = new Expression(exp);

        String result = String.valueOf(mathExp.calculate());

        display.setText("");
        resultDisplay.setText(exp+"="+result);
    }
}
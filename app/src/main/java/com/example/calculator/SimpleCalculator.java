package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleCalculator extends AppCompatActivity {


    public String pressedKeys = new String("");
    float number1 = 0;
    float number2 = 0;
    float result = 0;
    int sign = 0;  // on switch case

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putString("MyString", pressedKeys);
        savedInstanceState.putFloat("MyNumber", number1);
        savedInstanceState.putInt("MySign", sign);
        // etc.

        super.onSaveInstanceState(savedInstanceState);
    }

//onRestoreInstanceState

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        //super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        String myString = savedInstanceState.getString("MyString");
        float number = savedInstanceState.getFloat("MyNumber");
        int signx = savedInstanceState.getInt("MySign");
        number1 = number;
        sign = signx;
        if(myString != null) {
            pressedKeys = myString;
            showScreen();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);

        if(savedInstanceState != null) {
            super.onRestoreInstanceState(savedInstanceState);
        }



        /*
        1 - add                 5 - plus_min            9 - equals
        2 - sub                 6 - cancel
        3 - multiply            7 - backspace
        4 - divide              8 - dot
         */

        Button oneButton = (Button) findViewById(R.id.oneButton);
        Button twoButton = (Button) findViewById(R.id.twoButton);
        Button threeButton = (Button) findViewById(R.id.threeButton);
        Button fourButton = (Button) findViewById(R.id.fourButton);
        Button fiveButton = (Button) findViewById(R.id.fiveButton);
        Button sixButton = (Button) findViewById(R.id.sixButton);
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        Button eightButton = (Button) findViewById(R.id.eightButton);
        Button nineButton = (Button) findViewById(R.id.nineButton);
        Button zeroButton = (Button) findViewById(R.id.zeroButton);
        Button dotButton = (Button) findViewById(R.id.dotButton);
        Button equalsButton = (Button) findViewById(R.id.equalsButton);
        Button addButton = (Button) findViewById(R.id.addButton);
        Button subButton = (Button) findViewById(R.id.subButton);
        Button multiplyButton = (Button) findViewById(R.id.multiplyButton);
        Button divideButton = (Button) findViewById(R.id.divideButton);
        Button backspaceButton = (Button) findViewById(R.id.backspaceButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        Button plus_minButton = (Button) findViewById(R.id.plus_minButton);

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               pressedKeys = pressedKeys + "1";
                showScreen();
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedKeys = pressedKeys + "2";
                showScreen();
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedKeys = pressedKeys + "3";
                showScreen();
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedKeys = pressedKeys + "4";
                showScreen();
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedKeys = pressedKeys + "5";
                showScreen();
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedKeys = pressedKeys + "6";
                showScreen();
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedKeys = pressedKeys + "7";
                showScreen();
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedKeys = pressedKeys + "8";
                showScreen();
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedKeys = pressedKeys + "9";
                showScreen();
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedKeys = pressedKeys + "0";
                showScreen();
            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    number2 = Float.parseFloat(pressedKeys);
                    pressedKeys = "";

                    switch(sign) {
                        case 1:
                        {
                            result = (number1) + (number2);
                            showResult(result);
                            break;
                        }
                        case 2:
                        {
                            result = number1 - number2;
                            showResult(result);
                            break;
                        }
                        case 3:
                        {
                            result = number1 * number2;
                            showResult(result);
                            break;
                        }
                        case 4:
                        {
                            if(number2 == 0) {
                                number1 = 0;
                                number2 = 0;
                                toastShow(1);


                            } else {
                                result = number1 / (number2);
                                showResult(result);
                            }
                            break;
                        }
                    }

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumbers();
                sign = 1;
            }
        });

        subButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumbers();
                sign = 2;
            }
        }));

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumbers();
                sign = 3;
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumbers();
                sign = 4;
            }
        });

        plus_minButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String minus = "-";

                if(pressedKeys.startsWith(minus) == true) {
                   pressedKeys = pressedKeys.substring(1);
                } else {
                    pressedKeys = minus.concat(pressedKeys);
                }

                showScreen();
                sign = 5;
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1 = 0;
                number2 = 0;
                pressedKeys = "";
                showScreen();
            }
        });

        backspaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pressedKeys.length() != 0) {
                    pressedKeys = pressedKeys.substring(0, pressedKeys.length()-1);
                    showScreen();
                }
            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pressedKeys.length() == 0) {
                    pressedKeys = pressedKeys + "0.";
                }

                if(pressedKeys.contains(".") == false) {
                    pressedKeys = pressedKeys + ".";
                }

                showScreen();
            }
        });


        /*
        1 - add                 5 - plus_min            9 - equals
        2 - sub                 6 - cancel
        3 - multiply            7 - backspace
        4 - divide              8 - dot
         */
    }

    private void toastShow(int value) {

        String divideError = "You divided by 0!";
        String sqrtError = "You can't square root by a negative number";
        String lnError = "You can't determine the logarithm of a negative number";
        String errorString = "Error";
        String chosenString = "";

        switch(value) {
            case 1: {
                chosenString = divideError;
                break;
            }
            case 2: {
                chosenString = sqrtError;
                break;
            }
            case 3: {
                chosenString = lnError;
                break;
            }
            case 4: {
                chosenString = errorString;
                break;
            }

        }

        pressedKeys = "";
        showScreen();

        Toast toast=Toast.makeText(getApplicationContext(),chosenString,Toast.LENGTH_LONG);
        ViewGroup group = (ViewGroup) toast.getView();
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(30);
        toast.show();
    }

    private void setNumbers() {
        if(pressedKeys.length() == 0) {
            number1 = 0;
        } else {
            number1 = Float.parseFloat(pressedKeys);
        }

        pressedKeys = "";
    }

    private void showScreen() {
        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText(pressedKeys);
    }

    private void showResult(float result) {
        String resultS = Float.toString(result);
        if(resultS.contains(".0") && resultS.endsWith("0")) {
            resultS = resultS.substring(0, resultS.length()-2);
        }
        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText(resultS);
        number1 = 0;
        number2 = 0;
        pressedKeys = String.valueOf(resultS);
    }


}

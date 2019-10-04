package me.kindeep.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Calculator calc;
    NumberField numberField;
    TextView display;
    SuperCalculator superCalc;
    StateManager currState;

//    Boolean numberField.toClear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initiate();
    }

    private void initiate() {
        calc = Calculator.getInstance();
        numberField = NumberField.getInstance();
        superCalc = SuperCalculator.getInstance();
        currState = StateManager.getInstance();

        if (currState.getState() == StateManager.State.NML) {
            setContentView(R.layout.activity_main);
            display = findViewById(R.id.resultTextView);
            bindNmlEventListeners();
            numberField.update(display);
        } else if (currState.getState() == StateManager.State.FUN) {
            setContentView(R.layout.activity_main_super);
            display = findViewById(R.id.resultTextView);
            bindFunEventListeners();
            funDisplayUpdate();
        }
    }


    void afterOperatorClickResolve() {
        boolean success = numberField.setValue(calc.getLastOperand());
        if (!success)
            Toast.makeText(this, "Invalid Operation", Toast.LENGTH_SHORT).show();
//        numberField.clearVal();
        display.setText(numberField.getValueString());
        numberField.toClear = true;
    }

    void afterOperatorClick() {
        if (numberField.getValue() != null) calc.setCurrOperand(numberField.getValue());
    }

    void button0Click() {
        Log.e("Wut",
                "Why");
        numberButtonClick();
        numberField.button0();
        numberField.update(display);
    }

    void button1Click() {
        numberButtonClick();
        numberField.button1();
        numberField.update(display);
    }

    void button2Click() {
        numberButtonClick();
        numberField.button2();
        numberField.update(display);
    }

    void button3Click() {
        numberButtonClick();
        numberField.button3();
        numberField.update(display);
    }

    void button4Click() {
        numberButtonClick();
        numberField.button4();
        numberField.update(display);
    }

    void button5Click() {
        numberButtonClick();
        numberField.button5();
        numberField.update(display);
    }

    void button6Click() {
        numberButtonClick();
        numberField.button6();
        numberField.update(display);
    }

    void button7Click() {
        numberButtonClick();
        numberField.button7();
        numberField.update(display);
    }

    void button8Click() {
        numberButtonClick();
        numberField.button8();
        numberField.update(display);
    }

    void button9Click() {
        numberButtonClick();
        numberField.button9();
        numberField.update(display);
    }

    void buttonDotClick() {
        numberButtonClick();
        numberField.buttonDot();
        numberField.update(display);
    }

    void numberButtonClick() {
        if (numberField.toClear) {
            Log.e("wut", "Clear val");
            numberField.clearVal();
            numberField.toClear = false;
        }
    }

    void buttonMultiplyClick() {
        afterOperatorClick();
        calc.setOperator(Operators.MULTIPLY);
        afterOperatorClickResolve();
    }

    void buttonMinusClick() {
        afterOperatorClick();
        calc.setOperator(Operators.MINUS);
        afterOperatorClickResolve();

    }

    void buttonPlusClick() {
        afterOperatorClick();
        calc.setOperator(Operators.PLUS);
        afterOperatorClickResolve();

    }

    void buttonDivideClick() {
        afterOperatorClick();
        calc.setOperator(Operators.DIVIDE);
        afterOperatorClickResolve();

    }

    void buttonEqualClick() {
        Log.e("www0", "" + calc);

        afterOperatorClick();
        Log.e("www1", "" + calc);

        calc.evaluate();
        Log.e("www2", "" + calc);

        afterOperatorClickResolve();
        Log.e("www", "" + calc);

        numberField.toClear = false;
    }


    void buttonAClick() {
        Log.e("What", calc.toString());
        calc.reset();
        numberField.clearVal();
        numberField.update(display);
    }

    void buttonCClick() {
        if (calc.operator == null) {

            numberField.delete();
            numberField.update(display);

        } else {
            calc.clearOperator();
        }
    }

    void funButtonClick(SuperCalculator.ButtonType btn) {
        try {
            superCalc.buttonPress(btn);
        }
        catch (SuperCalculator.InvalidInputException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        funDisplayUpdate();
    }

    void funDisplayUpdate() {
        display.setText(superCalc.getEvalString());
    }

    void bindFunEventListeners() {
        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.ZERO);
            }
        });
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.ONE);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.TWO);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.THREE);

            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.FOUR);
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.FIVE);

            }
        });
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.SIX);

            }
        });
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.SEVEN);

            }
        });
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.EIGHT);

            }
        });
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.NINE);

            }
        });
        findViewById(R.id.buttonDot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.DOT);

            }
        });
        findViewById(R.id.buttonDivide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.DIVIDE);

            }
        });
        findViewById(R.id.buttonMultiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.MULTIPLY);

            }
        });
        findViewById(R.id.buttonPlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.PLUS);

            }
        });
        findViewById(R.id.buttonMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.MINUS);

            }
        });
        findViewById(R.id.buttonEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.EQUALS);

            }
        });
        findViewById(R.id.buttonA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.CLEARALL);

            }
        });
        findViewById(R.id.buttonC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.DELETE);
            }
        });
        findViewById(R.id.buttonBracketClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.CLOSEBRACKET);
            }
        });
        findViewById(R.id.buttonBracketOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funButtonClick(SuperCalculator.ButtonType.OPENBRACKET);
            }
        });
        findViewById(R.id.toggleButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton toggle = findViewById(R.id.toggleButton);
                if (!toggle.isChecked()) {
                    currState.setState(StateManager.State.NML);
                    initiate();
                }
            }
        });
    }


    void bindNmlEventListeners() {
        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button0Click();
            }
        });
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1Click();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button2Click();
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button3Click();
                ;
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button4Click();
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button5Click();
            }
        });
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button6Click();
            }
        });
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button7Click();
            }
        });
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button8Click();
            }
        });
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button9Click();
            }
        });
        findViewById(R.id.buttonDot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDotClick();
            }
        });
        findViewById(R.id.buttonDivide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDivideClick();
            }
        });
        findViewById(R.id.buttonMultiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonMultiplyClick();
            }
        });
        findViewById(R.id.buttonPlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonPlusClick();
            }
        });
        findViewById(R.id.buttonMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonMinusClick();
            }
        });
        findViewById(R.id.buttonEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonEqualClick();
            }
        });
        findViewById(R.id.buttonA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonAClick();
            }
        });
        findViewById(R.id.buttonC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCClick();
            }
        });
        findViewById(R.id.toggleButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton toggle = findViewById(R.id.toggleButton);
                if (toggle.isChecked()) {
                    currState.setState(StateManager.State.FUN);
                    initiate();
                }
            }
        });
    }

}

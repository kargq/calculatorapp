package me.kindeep.calculator;

import android.graphics.Path;

import androidx.annotation.NonNull;

enum Operators {
    MULTIPLY, DIVIDE, PLUS, MINUS
}

public class Calculator {

    private static Calculator instance = null;

    private Calculator() {

    }

    public static Calculator getInstance() {
        if (instance == null) {
            return new Calculator();
        } else {
            return instance;
        }
    }

    Double lastOperand = null;
    Double currOperand = null;
    Operators operator = null;

    private void operator() {

    }

    public void setOperator(Operators a) {
        evaluate();
        if (lastOperand != null) {
            operator = a;
        }
    }

    public void evaluate() {
        if (currOperand != null) {
            if (lastOperand != null) {
                if (operator != null) {
                    switch (operator) {
                        case PLUS:
                            lastOperand = lastOperand + currOperand;
                            break;
                        case MINUS:
                            lastOperand = lastOperand - currOperand;
                            break;
                        case MULTIPLY:
                            lastOperand = lastOperand * currOperand;
                            break;
                        case DIVIDE:
                            lastOperand = lastOperand / currOperand;
                            break;
                        default:
                            break;
                    }
                }
                else {
                    lastOperand = currOperand;
                }
                currOperand = null;
                operator = null;
            } else {
                lastOperand = currOperand;
                currOperand = null;
            }
        }
    }


    public void setCurrOperand(Double val) {
        currOperand = val;
    }

    @NonNull
    @Override
    public String toString() {
        return "lastOperand: " + lastOperand + "currOperand: " + currOperand;
    }

    public void reset() {
        currOperand = null;
        lastOperand = null;
        operator = null;
    }

    public Double getCurrOperand() {
        return currOperand;
    }

    public Double getLastOperand() {
        return lastOperand;
    }

    public String getCurrOperandString() {
        return currOperand == null ? "" : currOperand + "";
    }

    public String getLastOperandString() {
        return lastOperand == null ? "" : lastOperand + "";
    }

}

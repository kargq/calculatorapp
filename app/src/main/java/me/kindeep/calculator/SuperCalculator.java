package me.kindeep.calculator;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import android.util.Log;

public class SuperCalculator {


    private static final SuperCalculator instance = new SuperCalculator();

    public static SuperCalculator getInstance() {
        return instance;
    }

    public enum ButtonType {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, PLUS, MINUS, MULTIPLY, DIVIDE, DOT, EQUALS
    }

    private Context context;
    private Scriptable scope;
    private String toEval;

    private SuperCalculator() {
        context = Context.enter();
        context.setOptimizationLevel(-1);
        scope = context.initStandardObjects();
    }

    private String evalString(String input) {
        Object result = context.evaluateString(scope, input, "<cmd>", 1, null);
        Log.d("JAVASCRIPT", "" + result);
        return result.toString();
    }

    public void buttonPress(ButtonType opt) {
        if (opt == ButtonType.ZERO) {
            toEval += "0";
        } else if (opt == ButtonType.ONE) {
            toEval += "1";
        } else if (opt == ButtonType.TWO) {
            toEval += "2";
        } else if (opt == ButtonType.THREE) {
            toEval += "3";
        } else if (opt == ButtonType.FOUR) {
            toEval += "4";
        } else if (opt == ButtonType.FIVE) {
            toEval += "5";
        } else if (opt == ButtonType.SIX) {
            toEval += "6";
        } else if (opt == ButtonType.SEVEN) {
            toEval += "7";
        } else if (opt == ButtonType.EIGHT) {
            toEval += "8";
        } else if (opt == ButtonType.NINE) {
            toEval += "9";
        } else if (opt == ButtonType.MINUS) {
            toEval += "-";
        } else if (opt == ButtonType.PLUS) {
            toEval += "+";
        } else if (opt == ButtonType.DIVIDE) {
            toEval += "/";
        } else if (opt == ButtonType.MULTIPLY) {
            toEval += "*";
        } else if (opt == ButtonType.EQUALS) {
            toEval += "=";
        } else if (opt == ButtonType.DOT) {
            toEval += ".";
        }
    }

    /**
     * @return
     * @throws InvalidInputException
     */
    public Double evaluate() throws InvalidInputException {
        Double result = null;
        try {
            result = Double.parseDouble(evalString(toEval));
        } catch (Exception e) {
            reset();
            Log.e("SUPERCALC", "ERROR WITH EVAL" + e.toString());
            throw new InvalidInputException();
        }
        reset();
        return result;
    }

    public void reset() {
        toEval = "";
    }


    class InvalidInputException extends RuntimeException {
    }
}

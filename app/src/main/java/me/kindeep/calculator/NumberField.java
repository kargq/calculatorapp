package me.kindeep.calculator;


import android.widget.TextView;
import android.widget.Toast;

public class NumberField {

    Boolean toClear = false;
    //    List<Integer> num;
    String num;
    //    int pointPos = -1;
//    TextView textView;
    private static NumberField instance = null;


    private NumberField() {
//        num = new ArrayList<>();
        num = "";
//        update();
    }

    static NumberField getInstance() {
        if (instance == null) {
            instance = new NumberField();
        }
        return instance;
    }

//    void updateTextView(TextView view) {
//        textView = view;
//    }


    int getPointPos() {
        return num.indexOf('.');
    }

    void button0() {
        num = num + "0";
//        update();
    }


    void button1() {
        num = num + "1";
//        update();

    }

    void button2() {
        num = num + "2";
//        update();

    }

    void button3() {
        num = num + "3";
//        update();

    }

    void button4() {
        num = num + "4";

//        update();

    }

    void button5() {
        num = num + "5";
//        update();

    }

    void button6() {
        num = num + "6";
//        update();

    }

    void button7() {
        num = num + "7";
//        update();

    }

    void button8() {
        num = num + "8";
//        update();

    }

    void button9() {
        num = num + "9";
//        update();

    }

    void buttonDot() {

        if (getPointPos() > 0) {
            StringBuilder bld = new StringBuilder(num);
            bld.delete(getPointPos(), getPointPos() + 1);
            num = bld.toString();
        }

        num = num + ".";
//        update();

    }

    Double getValue() {
//        if (num.size() == 0) return null;
//        int intVal = 0;
//        int rad = 1;
//        for (int i = 0; i < num.size(); i++) {
//            int index = num.size() - i - 1;
//            intVal = intVal + num.get(index) * rad;
//            rad = rad * 10;
//        }
//
//        if (pointPos <= num.size() && pointPos >= 0) {
//            int pow = pointPos - num.size();
//            return intVal * Math.pow(10, pow);
//        } else {
//            return (double) intVal;
//        }
        try {
            return Double.parseDouble(num);

        } catch (NumberFormatException e) {
            return null;
        }
    }

    void delete() {
        if (num.length() > 0) {
            StringBuilder bld = new StringBuilder(num);
            bld.delete(num.length() - 1, num.length());
            num = bld.toString();
        }
    }

    String getValueString() {
        if (num.equals("")) {
            return "0";
        } else {
            return num;
        }
    }

    void clearVal() {
        num = "";
    }

    boolean setValue(Double val) {
        if (val == null || val.isInfinite() || val.isNaN()) {
            num = "";
            return false;
//            if (textView != null)
//                Toast.makeText(textView.getContext(), "INVALID OPERATION", Toast.LENGTH_SHORT).show();
        } else {
            clearVal();
            num = val.toString();
            return true;
        }
//        update(textView);
    }

    void update(TextView textView) {
        if (textView != null) textView.setText(getValueString());
    }

}

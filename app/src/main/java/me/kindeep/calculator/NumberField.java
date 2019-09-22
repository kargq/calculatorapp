package me.kindeep.calculator;

import android.util.Log;
import android.widget.TextView;

import androidx.core.app.NavUtils;

import java.util.ArrayList;
import java.util.List;

public class NumberField {

    List<Integer> num;
    int pointPos = -1;
    TextView textView ;

    private NumberField() {
        update();
    }


    NumberField(TextView view) {
        num = new ArrayList<>();
        textView = view;
        update();
    }

    void button0() {
        num.add(0);
        update();
    }


    void button1() {
        num.add(1);
        update();

    }

    void button2() {
        num.add(2);
        update();

    }

    void button3() {
        num.add(3);
        update();

    }

    void button4() {
        num.add(4);
        update();

    }

    void button5() {
        num.add(5);
        update();

    }

    void button6() {
        num.add(6);
        update();

    }

    void button7() {
        num.add(7);
        update();

    }

    void button8() {
        num.add(8);
        update();

    }

    void button9() {
        num.add(9);
        update();

    }

    void buttonDot() {
        update();

        pointPos = num.size();
    }

    Double getValue() {
        if (num.size() == 0) return null;
        int intVal = 0;
        int rad = 1;
        for (int i = 0; i < num.size(); i++) {
            int index = num.size() - i - 1;
            intVal = intVal + num.get(index) * rad;
            rad = rad * 10;
        }

        if (pointPos <= num.size() && pointPos >= 0) {
            int pow = pointPos - num.size();
            return intVal * Math.pow(10, pow);
        } else {
            return (double) intVal;
        }
    }

    void delete() {
        if (num.size() == pointPos) {
            pointPos = -1;
        } else {
            num.remove(num.size() - 1);

        }
    }

    String getValueString() {
        String res = "";
        if (pointPos == 0) {
            res = res + "0";
        }
        for (int i = 0; i < num.size(); i++) {
            if (i == pointPos) {
                res = res + ".";
            }
            res = res + num.get(i);
        }
        if (pointPos == num.size()) {
            res = res + ".";
        }
        return res;
    }

    void clearVal() {
        num = new ArrayList<>();
        pointPos = -1;
    }

    void setValue(Double val) {
        clearVal();
        if (val == null) {
        }
        else {
            int count = 0;
            for (Character c : val.toString().toCharArray()) {
                switch (c) {
                    case '0':
                        num.add(0);
                        break;
                    case '1':
                        num.add(1);
                        break;
                    case '2':
                        num.add(2);
                        break;
                    case '3':

                        num.add(3);
                        break;
                    case '4':
                        num.add(4);
                        break;
                    case '5':
                        num.add(5);
                        break;
                    case '6':
                        num.add(6);
                        break;
                    case '7':
                        num.add(7);
                        break;
                    case '8':
                        num.add(8);
                        break;
                    case '9':
                        num.add(9);
                        break;
                    case '.':
                        pointPos = count;
                        break;
                }
                count++;
            }
        }
    }

    void update(){
        textView.setText(getValueString());


    }

}

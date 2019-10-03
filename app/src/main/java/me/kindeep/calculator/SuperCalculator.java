package me.kindeep.calculator;
import javax.script.*;

public class SuperCalculator {

    private static SuperCalculator instance = null;

    private SuperCalculator() {
        ScriptEngineManager
    }

    public SuperCalculator getInstance() {
        if (instance == null)
            instance = new SuperCalculator();
        return instance
    }


}

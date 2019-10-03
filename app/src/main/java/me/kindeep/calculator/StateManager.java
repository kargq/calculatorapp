package me.kindeep.calculator;

class StateManager {
    private static final StateManager ourInstance = new StateManager();

    static StateManager getInstance() {
        return ourInstance;
    }

    enum State {
        FUN, NML
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private State state = State.NML;



    private StateManager() {
    }


}

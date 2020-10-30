package models;

import simulator.PetriNet;

public class Location extends PetriNetObject {

    private int tokens;

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public boolean decreaseTokens() {
        if (tokens == 0) {
            return false;
        } else {
            return true;
        }
    }
    public void addTokens(){
        tokens++;
    }
}

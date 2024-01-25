package com.example.comp336_proj1;

public class VertexLED {

    LED led;
    VertexLED previous;
    int num;
    boolean visited;

    public VertexLED(LED led, int number) {
        super();
        this.led = led;
        this.num = number;
    }

    public LED getLED() {
        return led;
    }


    public void setLED(LED led) {
        this.led = led;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "VertexLED{\t"+led+"\t}";
    }

}

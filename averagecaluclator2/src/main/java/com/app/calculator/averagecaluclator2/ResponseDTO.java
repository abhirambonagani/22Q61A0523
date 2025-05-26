package com.app.calculator.averagecaluclator2;

import java.util.List;

public class ResponseDTO {

    private List<Integer> windowPreState ;
    private List<Integer> windowCurrState;
    private double avg;
    public List<Integer> getWindowPreState() {
        return windowPreState;
    }
    public List<Integer> getWindowCurrState() {
        return windowCurrState;
    }
    public ResponseDTO(List<Integer> windowPreState, List<Integer> windowCurrState, double avg) {
        this.windowPreState = windowPreState;
        this.windowCurrState = windowCurrState;
        this.avg = avg;
    }
    public double getAvg() {
        return avg;
    }
    

}

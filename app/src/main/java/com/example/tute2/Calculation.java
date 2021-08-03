package com.example.tute2;

public class Calculation {
    protected float convertCelciusToFahrenhite(Float value){
        Float ans = (value * 9/5) + 32;
        return ans;
    }
    protected float convertFahrenhiteToCelcius(Float value){
        Float ans = (value - 32) * 5/9;
        return ans;
    }


}

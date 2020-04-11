package com.example.coronavirushelplines;

public class StatesModel {
   private String number, state, hotlineOne, hotlineTwo, region;

    public StatesModel(){}


    public StatesModel(String number, String state, String region, String hotlineOne, String hotlineTwo) {
        this.number = number;
        this.state = state;
        this.hotlineOne = hotlineOne;
        this.hotlineTwo = hotlineTwo;
        this.region = region;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHotlineOne() {
        return hotlineOne;
    }

    public void setHotlineOne(String hotlineOne) {
        this.hotlineOne = hotlineOne;
    }

    public String getHotlineTwo() {
        return hotlineTwo;
    }

    public void setHotlineTwo(String hotlineTwo) {
        this.hotlineTwo = hotlineTwo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}

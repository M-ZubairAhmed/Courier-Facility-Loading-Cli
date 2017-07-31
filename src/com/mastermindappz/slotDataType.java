package com.mastermindappz;

public class slotDataType {
//    private int index;
    private int code;
    private int weight;

    public slotDataType( int code, int weight) {
//        this.index = index;
        this.code = code;
        this.weight = weight;
    }

//    public int getIndex() {
//        return index;
//    }

    public int getCode() {
        return code;
    }

    public int getWeight() {
        return weight;
    }

//    public void setIndex(int index) {
//        this.index = index;
//    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

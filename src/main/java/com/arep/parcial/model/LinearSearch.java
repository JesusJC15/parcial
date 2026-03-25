package com.arep.parcial.model;

public class LinearSearch {

    public String operation;
    public int[] inputList;
    public int value;
    public int output;

    public LinearSearch(String operation, int[] inputList, int value, int output) {
        this.operation = operation;
        this.inputList = inputList;
        this.value = value;
        this.output = output;
    }

    public LinearSearch(LinearSearch linearSearch){
        this.operation = linearSearch.operation;
        this.inputList = linearSearch.inputList;
        this.value = linearSearch.value;
        this.output = linearSearch.output;
    }

    public LinearSearch(){
        
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int[] getInputList() {
        return inputList;
    }

    public void setInputList(int[] inputList) {
        this.inputList = inputList;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

}

package com.arep.parcial.model;

public class BinarySearch {

    public String operation;
    public int[] inputList;
    public int value;
    public int output;

    public BinarySearch(String operation, int[] inputList, int value, int output) {
        this.operation = operation;
        this.inputList = inputList;
        this.value = value;
        this.output = output;
    }

    public BinarySearch(BinarySearch binarySearch){
        this.operation = binarySearch.operation;
        this.inputList = binarySearch.inputList;
        this.value = binarySearch.value;
        this.output = binarySearch.output;
    }

    public BinarySearch(){
        
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

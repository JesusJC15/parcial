package com.arep.parcial.service;

import org.springframework.stereotype.Service;

import com.arep.parcial.model.LinearSearch;

@Service
public class LinearSearchService {

    private LinearSearch linearSearch;
    private int output;

    public LinearSearch getLinearSearch(int[] inputList, int value) {
            linearSearch = new LinearSearch();
            linearSearch.setOperation("linearSearch");
            linearSearch.setInputList(inputList);
            linearSearch.setValue(value);
            linearSearch.setOutput(getLinearSearchOutput(inputList, value));
    
            return linearSearch;
        }

    private int getLinearSearchOutput(int[] inputList, int value){
        for (int i = 0; i < inputList.length; i++) {
            if (inputList[i] == value) {
                return output = i;
            }
        }
        return output = -1;
    }
}

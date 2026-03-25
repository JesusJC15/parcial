package com.arep.parcial.service;

import org.springframework.stereotype.Service;

import com.arep.parcial.model.BinarySearch;

@Service
public class BinarySearchService {

    private BinarySearch binarySearch;
    private int output;

    public BinarySearch getBinarySearch(int[] inputList, int value) {
        binarySearch = new BinarySearch();
        binarySearch.setOperation("binarySearch");
        binarySearch.setInputList(inputList);
        binarySearch.setValue(value);
        binarySearch.setOutput(getBinarySearchOutput(inputList, value));

        return binarySearch;
    }

    private int getBinarySearchOutput(int[] inputList, int value) {
        int left = 0;
        int right = inputList.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (inputList[mid] == value) {
                output = mid;
                return output;
            }

            if (inputList[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        output = -1;

        return output;
    }
}

package com.arep.parcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arep.parcial.model.BinarySearch;
import com.arep.parcial.model.LinearSearch;
import com.arep.parcial.service.BinarySearchService;
import com.arep.parcial.service.LinearSearchService;


@RestController
public class MathController {

    @Autowired
    private BinarySearchService binarySearchService;

    @Autowired
    private LinearSearchService linearSearchService;

    @GetMapping("/linearsearch")
    public LinearSearch getLinearSearch(@RequestParam(name = "list") int[] list, @RequestParam(name = "value") int value) {
        return new LinearSearch(linearSearchService.getLinearSearch(list, value));
    }

    @GetMapping("/binarysearch")
    public BinarySearch getBinarySearch(@RequestParam(name = "list") int[] list, @RequestParam(name = "value") int value) {
        return new BinarySearch(binarySearchService.getBinarySearch(list, value));
    }
    
}

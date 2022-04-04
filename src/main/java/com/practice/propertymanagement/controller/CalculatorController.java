package com.practice.propertymanagement.controller;

import com.practice.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1/addValue")
public class CalculatorController {
    @GetMapping("/add")
    public Double add(@RequestParam("num1") Double c,@RequestParam("num2") Double b)
    {
        return c + b;
    }
    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO)
    {
        Double result = null ;
        result = calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()* calculatorDTO.getNum4() ;
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/div")
    public ResponseEntity<Double> division(@RequestBody CalculatorDTO calculatorDTO)
    {
        Double result = null ;
        result = calculatorDTO.getNum1()/calculatorDTO.getNum2();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }



}

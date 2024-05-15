/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.service.PartaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/partai")
public class PartaiController {

    @Autowired
    private PartaiService partaiService;

    @GetMapping
    public List<Partai> getAllPartai() {
        return partaiService.getAllPartai();
    }

    @PostMapping
    public ResponseEntity<Partai>  addPartai(@RequestBody Partai partai) {
        try {
        Partai savedPartai= partaiService.addPartai(partai);
        return new ResponseEntity<>(savedPartai, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
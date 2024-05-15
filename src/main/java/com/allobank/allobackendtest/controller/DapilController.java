/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.service.DapilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dapil")
public class DapilController {

    @Autowired
    private DapilService dapilService;

    @GetMapping
    public List<Dapil> getAllDapil() {
        return dapilService.getAllDapil();
    }

    @PostMapping
    public Dapil addDapil(@RequestBody Dapil dapil) {
        return dapilService.addDapil(dapil);
    }
}
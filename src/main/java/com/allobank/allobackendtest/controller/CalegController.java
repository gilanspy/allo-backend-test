/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.service.CalegService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author alay_
 */

@RestController
@RequestMapping("/api/caleg")
public class CalegController {
    
   @Autowired
    private CalegService calegService;

    @GetMapping
    public List<Caleg> getCalegList(
            @RequestParam(required = false) UUID idPartai,
            @RequestParam(required = false) UUID idDapil,
            @RequestParam(required = false) String sortBy
    ) {
        if (sortBy != null && !sortBy.isEmpty()) {
            return calegService.getCalegSortedByNomorUrut(sortBy);
        } else if (idPartai != null && idDapil != null) {
            return calegService.getCalegByPartaiAndDapil(idDapil,idPartai);
        } else {
            return calegService.getAllCaleg();
        }
    }
    
      @PostMapping
    public Caleg addCaleg(@RequestBody Caleg caleg) {
        return calegService.addCaleg(caleg);
    }
    
}

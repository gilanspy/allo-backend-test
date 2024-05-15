/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.service.implemen;

import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.repository.PartaiRepository;
import com.allobank.allobackendtest.service.PartaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class PartaiServiceImpl implements PartaiService {

    private static final Logger logger = LoggerFactory.getLogger(PartaiService.class);
    
    @Autowired
    private PartaiRepository partaiRepository;

    @Override
    public List<Partai> getAllPartai() {
        return partaiRepository.findAll();
    }

    @Override
    public Partai addPartai(Partai partai) {
           logger.info("Saving partai: {}", partai);
        return partaiRepository.save(partai);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.service.implemen;

import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.WilayahDapil;
import com.allobank.allobackendtest.repository.DapilRepository;
import com.allobank.allobackendtest.service.DapilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DapilServiceImpl implements DapilService {

    @Autowired
    private DapilRepository dapilRepository;

    @Override
    public List<Dapil> getAllDapil() {
        return dapilRepository.findAll();
    }

    @Override
    public Dapil addDapil(Dapil dapil) {
       if (dapil.getWilayahDapilList() != null) {
            for (WilayahDapil wilayahDapil : dapil.getWilayahDapilList()) {
                wilayahDapil.setDapil(dapil);
            }
        }
        return dapilRepository.save(dapil);
    }
}
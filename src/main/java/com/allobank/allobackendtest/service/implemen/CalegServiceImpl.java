/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.service.implemen;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.repository.CalegRepository;
import com.allobank.allobackendtest.repository.DapilRepository;
import com.allobank.allobackendtest.repository.PartaiRepository;
import com.allobank.allobackendtest.service.CalegService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author alay_
 */
@Service
public class CalegServiceImpl implements CalegService {

    @Autowired
    private CalegRepository calegRepository;
    
     @Autowired
    private PartaiRepository partaiRepository;

    @Autowired
    private DapilRepository dapilRepository;

    @Override
    public List<Caleg> getAllCaleg() {
        return calegRepository.findAll();
    }

    @Override
    public List<Caleg> getCalegByPartaiAndDapil(UUID idPartai, UUID idDapil) {
             return calegRepository.findByPartaiIdAndDapilId(idPartai, idDapil);
    }

    @Override
    public List<Caleg> getCalegSortedByNomorUrut(String sortBy) {
        
        
          if (!sortBy.equalsIgnoreCase("asc") && !sortBy.equalsIgnoreCase("desc")) {
        throw new IllegalArgumentException("Sort direction must be 'asc' or 'desc'");
    }
    Sort.Direction direction = Sort.Direction.fromString(sortBy.toUpperCase());
    Sort sort = Sort.by(direction, "nomorUrut");
    return calegRepository.findAll(sort);
    }
    
     @Override
    public Caleg addCaleg(Caleg caleg) {
            Partai partai = partaiRepository.findById(caleg.getPartai().getId()).orElse(null);
        if (partai == null) {
            throw new IllegalArgumentException("ID partai tidak valid: " + caleg.getPartai().getId());
        }

        Dapil dapil = dapilRepository.findById(caleg.getDapil().getId()).orElse(null);
        if (dapil == null) {
            throw new IllegalArgumentException("ID dapil tidak valid: " + caleg.getDapil().getId());
        }

        return calegRepository.save(caleg);
    
    }
    
}

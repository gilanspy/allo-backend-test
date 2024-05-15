/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.Caleg;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author alay_
 */


    public interface CalegService {
    List<Caleg> getAllCaleg();
    List<Caleg> getCalegByPartaiAndDapil(UUID idPartai, UUID idDapil);
    List<Caleg> getCalegSortedByNomorUrut(String sortby);
     Caleg addCaleg(Caleg caleg);
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.Dapil;
import java.util.List;
import java.util.UUID;

public interface DapilService {
    List<Dapil> getAllDapil();
    Dapil addDapil(Dapil dapil);
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.model.Partai;
import java.util.List;
import java.util.UUID;

public interface PartaiService {
    List<Partai> getAllPartai();
    Partai addPartai(Partai partai);
}
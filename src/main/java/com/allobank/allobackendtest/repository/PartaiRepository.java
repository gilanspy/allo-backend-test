/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.repository;

import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alay_
 */
@Repository
public interface PartaiRepository extends JpaRepository<Partai, UUID> {

}
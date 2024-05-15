/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.repository;

import com.allobank.allobackendtest.model.Caleg;
import java.util.List;
import java.util.UUID;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alay_
 */

@Repository
@DependsOn({"DapilRepository", "PartaiRepository"})
public interface CalegRepository extends JpaRepository<Caleg, UUID> {
     List<Caleg> findByPartaiIdAndDapilId(UUID idPartai, UUID idDapil);
    
}

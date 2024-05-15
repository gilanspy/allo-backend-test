/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.repository;

import com.allobank.allobackendtest.model.*;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alay_
 */
@Repository
public interface DapilRepository extends JpaRepository<Dapil, UUID> {

}
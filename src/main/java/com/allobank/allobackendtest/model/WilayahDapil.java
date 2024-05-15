/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allobank.allobackendtest.model;

/**
 *
 * @author alay_
 */
import lombok.Data;
import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "wilayah_dapil")
public class WilayahDapil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "dapil_id", referencedColumnName = "id")
    private Dapil dapil;
    
    private String namaWilayah;
    
    // Jika ada atribut lain yang perlu disimpan
    // private String atribut lain;
}

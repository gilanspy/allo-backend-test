package com.allobank.allobackendtest.model;

import lombok.Data;
import javax.persistence.Entity;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "dapil")
public class Dapil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(name = "nama_dapil")
    private String namaDapil;
    
    private String provinsi;
    
    // Definisikan relasi dengan entitas WilayahDapil
    @OneToMany(mappedBy = "dapil", cascade = CascadeType.ALL)
    private List<WilayahDapil> wilayahDapilList;
    
    private int jumlahKursi;
}
package com.allobank.allobackendtest.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;
import javax.persistence.Column;

@Data
@Entity
@Table(name = "partai")
public class Partai {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(name = "nama_partai")
    private String namaPartai;
    
    @Column(name = "nomor_urut")
    private Integer nomorUrut;
}
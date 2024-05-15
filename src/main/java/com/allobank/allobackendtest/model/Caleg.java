package com.allobank.allobackendtest.model;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.Entity;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "caleg")
public class Caleg implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

      @ManyToOne
    @JoinColumn(name = "dapil_id") // Nama kolom untuk join dengan tabel Dapil
    private Dapil dapil;

      @ManyToOne
    @JoinColumn(name = "partai_id") // Nama kolom untuk join dengan tabel Partai
    private Partai partai;

    @Column(name = "nomor_urut") // Nama kolom untuk atribut nomorUrut
    private Integer nomorUrut;

    @Column(name = "nama") // Nama kolom untuk atribut nama
    private String nama;

    @Enumerated(EnumType.STRING) // Menentukan tipe pemetaan untuk enum JenisKelamin
    @Column(name = "jenis_kelamin") // Nama kolom untuk atribut jenisKelamin
    private JenisKelamin jenisKelamin;
}
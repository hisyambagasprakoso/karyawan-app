package com.hisamprakoso.karyawanapp.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author : hisam
 * @since : 4/4/22
 */
@Data
@Entity(name = "alamat")
@Table(name = "alamat", indexes = {
        @Index(columnList = "nama", name = "nama_alamat_idx"),
        @Index(columnList = "alamat", name = "alamat_alamat_idx") })

public class Alamat {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    @Column(nullable = false)
    private String nama;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    private String alamat;

    // @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_karyawan")
    // private List<Karyawan> listKaryawan = new ArrayList<>();
    private Karyawan karyawan;

}

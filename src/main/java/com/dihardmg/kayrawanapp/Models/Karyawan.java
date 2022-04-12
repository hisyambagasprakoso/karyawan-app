package com.dihardmg.kayrawanapp.Models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : hisam
 * @since : 4/4/22
 */
@Data
@ToString(exclude = "listAlamat")
@Entity
@Table(name = "karyawan", indexes = {
                @Index(columnList = "nama", name = "nama_karyawan_idx"),
                @Index(columnList = "keterangan", name = "ket_karyawan_idx")
})
public class Karyawan {

        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid2")
        private String id;

        @NotEmpty
        @NotNull
        @Size(min = 3, max = 255)
        @Column(nullable = false)
        private String nama;

        @NotEmpty
        @Size(max = 255)
        @Column(nullable = false)
        private String keterangan;

        @OneToMany(mappedBy = "karyawan", cascade = CascadeType.REFRESH, orphanRemoval = true)
        private List<Alamat> listAlamat = new ArrayList<>();

        public String getNama() {
                return nama;
        }

        public String getKeterangan() {
                return keterangan;
        }

        public String getId() {
                return id;
        }

        public void setNama(String nama) {
                this.nama = nama;
        }

        public void setKeterangan(String keterangan) {
                this.keterangan = keterangan;
        }

        public void setId(String id) {
                this.id = id;
        }

}

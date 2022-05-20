package com.hisamprakoso.karyawanapp.entity;

// import java.sql.Time;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.Index;
import javax.persistence.Table;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "meeting")
@Table(name = "meeting")
public class Meeting {

    @Id
    // @NotEmpty
    // @NotNull
    @GeneratedValue
    private Integer id;
    @NotEmpty
    @NotNull
    private String nm_meeting;
    @NotEmpty
    @NotNull
    private String tgl;
    // @GeneratedValue
    // private String timestamp;
    // @NotEmpty
    // @NotNull
    private String deskripsi;
    @NotEmpty
    @NotNull
    private String divisi;
    @NotEmpty
    @NotNull
    // @Temporal(TemporalType.TIMESTAMP)
    private String mulai;
    @NotEmpty
    @NotNull
    private String selesai;
    @NotEmpty
    @NotNull
    private String platform;
    @NotEmpty
    @NotNull
    private String link;

}

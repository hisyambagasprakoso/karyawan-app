package com.hisamprakoso.karyawanapp.entity;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

}

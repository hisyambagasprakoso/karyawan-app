package com.hisamprakoso.karyawanapp.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "salary")
@Table(name = "salary")

public class Salary {
    @Id
    @NotEmpty
    @NotNull
    @GeneratedValue
    private String id;
    @NotEmpty
    @NotNull
    private String salary;
    @NotEmpty
    @NotNull
    private String total_salary;
    @NotEmpty
    @NotNull
    private String bank_account;
    private String description;
    @NotEmpty
    @NotNull
    private String b_kes;
    @NotEmpty
    @NotNull
    private String b_ker;
    @NotEmpty
    @NotNull
    private String insurance;
    private String glasses;
    @NotEmpty
    @NotNull
    private String payroll_date;
    @NotEmpty
    @NotNull
    private String payroll_time;
    private String transportation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_karyawan")
    // private List<Karyawan> listKaryawan = new ArrayList<>();
    private Karyawan karyawan;

}

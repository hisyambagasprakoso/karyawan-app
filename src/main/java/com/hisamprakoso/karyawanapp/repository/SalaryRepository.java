package com.hisamprakoso.karyawanapp.repository;

import java.util.List;

// import com.hisamprakoso.karyawanapp.entity.Alamat;
import com.hisamprakoso.karyawanapp.entity.Karyawan;
import com.hisamprakoso.karyawanapp.entity.Salary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends CrudRepository<Salary, Integer> {

    // List<Salary> findByKaryawan(Karyawan karyawan);

    Salary findById(Integer id);
}

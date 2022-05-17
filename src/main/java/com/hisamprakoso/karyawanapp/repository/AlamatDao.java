package com.hisamprakoso.karyawanapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.hisamprakoso.karyawanapp.entity.Alamat;
import com.hisamprakoso.karyawanapp.entity.Karyawan;

/**
 * @author : hisam
 * @since : 4/4/22
 */
@Repository
public interface AlamatDao extends PagingAndSortingRepository<Alamat, String> {
    List<Alamat> findByKaryawan(Karyawan karyawan);

    Page<Alamat> findByNamaContainingIgnoreCase(String nama, Pageable pageable);
}

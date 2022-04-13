package com.hisamprakoso.kayrawanapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.hisamprakoso.kayrawanapp.Models.Alamat;
import com.hisamprakoso.kayrawanapp.Models.Karyawan;

/**
 * @author : hisam
 * @since : 4/4/22
 */
@Repository
public interface AlamatDao extends PagingAndSortingRepository<Alamat, String> {
    List<Alamat> findByKaryawan(Karyawan karyawan);

    Page<Alamat> findByNamaContainingIgnoreCase(String nama, Pageable pageable);
}
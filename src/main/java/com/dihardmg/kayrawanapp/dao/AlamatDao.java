package com.dihardmg.kayrawanapp.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.dihardmg.kayrawanapp.Models.Alamat;
import com.dihardmg.kayrawanapp.Models.Karyawan;

/**
 * @author : Otorus
 * @since : 1/10/18
 */
@Repository
public interface AlamatDao extends PagingAndSortingRepository<Alamat, String> {
    List<Alamat> findByKaryawan(Karyawan karyawan);

    Page<Alamat> findByNamaContainingIgnoreCase(String nama, Pageable pageable);
}
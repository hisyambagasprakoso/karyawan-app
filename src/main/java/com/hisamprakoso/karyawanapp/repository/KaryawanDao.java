package com.hisamprakoso.karyawanapp.repository;

import com.hisamprakoso.karyawanapp.entity.Karyawan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : hisam
 * @since : 4/4/22
 */
@Repository
public interface KaryawanDao extends PagingAndSortingRepository<Karyawan, String> {
    Page<Karyawan> findByNamaContainingIgnoreCase(String nama, Pageable pageable);
}

package com.hisamprakoso.karyawanapp.repository;

// import java.util.List;

import com.hisamprakoso.karyawanapp.entity.Meeting;
// import org.springframework.data.repository.PagingAndSortingRepository;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// public class MeetingRepository {
//     Page<Meeting> findByNamaPage(String nama, Pageable pageable);
// }
@Repository
public interface MeetingRepository extends CrudRepository<Meeting, String> {

    // Object findById(long id);
    // List<Meeting> findByName(String nm_meeting);
}

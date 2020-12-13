package com.harbour.webapp.repositories;

import com.harbour.webapp.entities.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail,Long>{
}

package com.vsr.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsr.mail.model.Details;
@Repository
public interface DetailsRepository extends JpaRepository<Details, Long>{

}

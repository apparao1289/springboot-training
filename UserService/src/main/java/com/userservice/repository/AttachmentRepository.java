package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer>{

}

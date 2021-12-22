package com.springboot.microservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceRepository extends JpaRepository<DatabaseSequence, Integer>{

}

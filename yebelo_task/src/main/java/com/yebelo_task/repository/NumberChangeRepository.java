package com.yebelo_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yebelo_task.model.NumberChange;

public interface NumberChangeRepository extends JpaRepository<NumberChange,Long> {

	NumberChange findBycategoryCode(Long categoryCode);

}

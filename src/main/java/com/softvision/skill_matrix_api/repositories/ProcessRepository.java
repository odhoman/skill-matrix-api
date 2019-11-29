package com.softvision.skill_matrix_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.softvision.skill_matrix_api.model.Process;

public interface ProcessRepository extends JpaRepository<Process, Long> {

}

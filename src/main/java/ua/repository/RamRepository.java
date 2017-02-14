package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Ram;

public interface RamRepository extends JpaRepository<Ram, Integer>, JpaSpecificationExecutor<Ram>{


}

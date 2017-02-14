package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Komputer;

public interface KomputerRepository extends JpaRepository<Komputer, Integer>, JpaSpecificationExecutor<Komputer>  {

	@Query("SELECT ai FROM Komputer ai "
			+ "LEFT JOIN FETCH ai.videoadapter "
			+ "LEFT JOIN FETCH ai.hdd "
			+ "LEFT JOIN FETCH ai.ram "
			+ "LEFT JOIN FETCH ai.processor WHERE ai.id=:id")
//			+ "LEFT JOIN FETCH p.typeprocessor "
//			+ "LEFT JOIN FETCH p.coreprocessor 
	Komputer findOne(@Param("id") int id);
	
	
	
	
}

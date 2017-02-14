package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.TypeProcessor;

public interface TypeProcessorRepository extends JpaRepository<TypeProcessor, Integer>, JpaSpecificationExecutor<TypeProcessor>{


	default void delete(String name){
		delete(findByName(name));
	}

	TypeProcessor findByName(String name);
	
	@Modifying
	@Query("DELETE FROM TypeProcessor c WHERE c.name=:name")
	void deleteByName(@Param("name") String name);


}

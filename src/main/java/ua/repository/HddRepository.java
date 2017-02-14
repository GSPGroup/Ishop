package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Hdd;

public interface HddRepository extends JpaRepository<Hdd, Integer>, JpaSpecificationExecutor<Hdd>{


//	default void delete(String name){
//		delete(findByName(name));
//	}
//
//	Hdd findByName(String name);
//	
//	@Modifying
//	@Query("DELETE FROM Hdd c WHERE c.name=:name")
//	void deleteByName(@Param("name") String name);
//

}

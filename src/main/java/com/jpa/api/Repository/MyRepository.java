package com.jpa.api.Repository;

import com.jpa.api.Entity.testing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface MyRepository extends CrudRepository<testing,Integer> {
    @Query("select u from testing u WHERE u.id =:n")
    public testing findByUserId (@Param("n") int id);
}

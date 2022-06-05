package com.investree.tugasinvestree.repository;

import com.investree.tugasinvestree.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("SELECT c FROM User c where c.id = :id")
    User getbyID(
            @Param("id") Long id
    );

    @Query("select c from User c where c.username = :username")
    User getByUsername(
            @Param("username") String username
    );

}

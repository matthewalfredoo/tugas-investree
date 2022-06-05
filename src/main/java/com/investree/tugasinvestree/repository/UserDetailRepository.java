package com.investree.tugasinvestree.repository;

import com.investree.tugasinvestree.model.UserDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends PagingAndSortingRepository<UserDetail, Long> {

}

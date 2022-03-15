package com.group1.theBookSpot.repository;


import com.group1.theBookSpot.entity.Items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailsRepository extends CrudRepository<Items, Long> {


}

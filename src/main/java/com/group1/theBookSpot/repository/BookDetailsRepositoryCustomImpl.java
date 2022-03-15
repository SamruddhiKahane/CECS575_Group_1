package com.group1.theBookSpot.repository;

import com.group1.theBookSpot.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookDetailsRepositoryCustomImpl implements BookDetailsRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Items> getPaginatedBooksList(Integer offset, Integer limit) {
        return entityManager.createQuery("SELECT p FROM Items p",
                Items.class).setMaxResults(limit).setFirstResult(offset).getResultList();
    }

}

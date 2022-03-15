package com.group1.theBookSpot.repository;

import com.group1.theBookSpot.entity.Items;

import java.util.List;

interface BookDetailsRepositoryCustom {
    public List<Items> getPaginatedBooksList(Integer offset,Integer limit);

}

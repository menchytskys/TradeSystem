package com.pet.tradesystem.repository;

import com.pet.tradesystem.domain.Purchase;

import java.util.List;

public interface PurchaseRepository extends AppRepository<Purchase, Integer>  {


    List<Purchase> findPurchasesByUserIdOrdered(Integer userPrimaryKey, String nullableSortingOrder);
}

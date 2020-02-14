package com.pet.tradesystem.util;

import com.pet.tradesystem.domain.Product;
import com.pet.tradesystem.domain.Purchase;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductUtils {

    public static List<Product> getProducts(List<Purchase> purchaseList) {
        return purchaseList.stream()
                .map(Purchase::getProducts)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}

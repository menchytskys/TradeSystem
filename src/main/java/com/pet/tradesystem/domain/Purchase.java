package com.pet.tradesystem.domain;

import java.util.List;

public class Purchase implements AppEntity {

    private int id;

    private int userId;

    private List<Product> products;

    public Purchase() {
    }

    public Purchase(int id, int userId, List<Product> products) {
        this.id = id;
        this.userId = userId;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (id != purchase.id) return false;
        if (userId != purchase.userId) return false;
        return products != null ? products.equals(purchase.products) : purchase.products == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Purchase{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}

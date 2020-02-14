package com.pet.tradesystem.domain;

import java.util.List;

public class Order implements AppEntity {

    private int id;

    private int userId;

    private List<Purchase> purchases;

    public Order() {
    }

    public Order(int id, int userId, List<Purchase> purchases) {
        this.id = id;
        this.userId = userId;
        this.purchases = purchases;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
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

        Order order = (Order) o;

        if (id != order.id) return false;
        if (userId != order.userId) return false;
        return purchases != null ? purchases.equals(order.purchases) : order.purchases == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (purchases != null ? purchases.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", purchases=").append(purchases);
        sb.append('}');
        return sb.toString();
    }
}

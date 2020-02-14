package com.pet.tradesystem.repository.rowMapper;

import com.pet.tradesystem.domain.Product;
import com.pet.tradesystem.domain.Purchase;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseMapper implements RowMapper<Purchase> {
    @Override
    public Purchase mapRow(ResultSet resultSet, int i) throws SQLException {
        Purchase purchase = new Purchase();
        purchase.setId(resultSet.getInt("id"));
        purchase.setUserId(resultSet.getInt("user_Id"));
        Product product = new Product();
        product.setId(resultSet.getInt("good_id"));
        product.setName(resultSet.getString("name"));
        product.setImage(resultSet.getBytes("picture"));
        product.setDeliveryStatus(resultSet.getBoolean("delivery_status"));
        purchase.getProducts().add(product);

        return purchase;
    }
}

package com.pet.tradesystem.repository.rowMapper;

import com.pet.tradesystem.domain.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setUserId(resultSet.getInt("user_id"));

        return order;
    }
}

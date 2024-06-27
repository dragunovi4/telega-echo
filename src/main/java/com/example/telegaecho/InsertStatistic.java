package com.example.telegaecho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.example.telegaecho.StatService.*;

public class InsertStatistic {
    private void insertStat() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String insertQuery = "INSERT INTO billiards(data, roman, kirill) VALUES (?, ?, ?);";

            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);

            //updateFieldValue(preparedStatement, "daught", daught2);

            System.out.println("Счет добавлен");
        } catch (SQLException e) {
            System.out.println("SQL exception: " + e.getMessage());
        }
    }

    private void updateFieldValue(PreparedStatement preparedStatement, String data, int roman, int kirill) throws SQLException {
        preparedStatement.setString(1, data);
        preparedStatement.setInt(2, roman);
        preparedStatement.setInt(2, kirill);
        preparedStatement.executeUpdate();
    }
}

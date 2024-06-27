package com.example.telegaecho;

import java.sql.*;

public class StatService {
    private int romanWins, kirillWins = 0;
    static String url = "jdbc:postgresql://localhost:5432/billiard";
    static String user = "masterrezki";
    static String password = "masterrezki";

    public String collectionStatistics() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps1 = conn.prepareStatement("select sum(roman) as Roman, sum(kirill) as Kirill from billiards;");
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                romanWins = rs1.getInt("Roman");
                kirillWins = rs1.getInt("Kirill");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return getAdditionalInfo();
    }

    private String getAdditionalInfo() {
        return "Количество победных партий Романа: " + romanWins + "\n" + "Количество победных партий Кирилла: " + kirillWins;
    }

//    private void updateDatabase() {
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            //String updateQuery = "UPDATE sys_extras SET value = ? WHERE key = ?";
//            String updateQuery = "INSERT INTO billiards(data, roman, kirill) VALUES (?, ?, ?);";
//
//            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
//
//            updateFieldValue(preparedStatement, "daught", daught2);
//            updateFieldValue(preparedStatement, "single", single2);
//            updateFieldValue(preparedStatement, "franch", franch2);
//            updateFieldValue(preparedStatement, "evotor", evotor2);
//
//            System.out.println("Счет добавлен");
//        } catch (SQLException e) {
//            System.out.println("SQL exception: " + e.getMessage());
//        }
//    }
//
//    private void updateFieldValue(PreparedStatement preparedStatement, String data, int roman, int kirill) throws SQLException {
//        preparedStatement.setString(1, data);
//        preparedStatement.setInt(2, roman);
//        preparedStatement.setInt(2, kirill);
//        preparedStatement.executeUpdate();
//    }
}

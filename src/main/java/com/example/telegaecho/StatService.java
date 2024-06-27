package com.example.telegaecho;

import java.sql.*;

public class StatService {
    private int romanWins, kirillWins = 0;
    private double percentageRoman, percentageKirill = 0;
    static String url = "jdbc:postgresql://localhost:5432/billiard";
    static String user = "masterrezki";
    static String password = "masterrezki";

    private void clearStatistics() {
        romanWins = 0;
        kirillWins = 0;
        percentageRoman = 0.0;
        percentageKirill = 0.0;
    }

    public String collectionStatistics() {
        clearStatistics();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps1 = conn.prepareStatement("select sum(roman) as Roman, sum(kirill) as Kirill from billiards;");
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                romanWins = rs1.getInt("Roman");
                kirillWins = rs1.getInt("Kirill");
            }

            int sum = romanWins + kirillWins;
            if (sum != 0) {
                percentageRoman = ((double) romanWins / sum) * 100;
                percentageKirill = ((double) kirillWins / sum) * 100;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return getAdditionalInfo();
    }

    private String getAdditionalInfo() {
        return "Количество победных партий Романа: " + romanWins + " (" + String.format("%.1f", percentageRoman) + " %)" + "\n"
                + "Количество победных партий Кирилла: " + kirillWins + " (" + String.format("%.1f", percentageKirill) + " %)";
    }
}


package com.example.telegaecho;

import java.sql.*;

public class PostgresExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/billiard";
        String user = "masterrezki";
        String password = "masterrezki";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            int romanWins = 0;
            int kirillWins = 0;

            PreparedStatement statementRoman = connection.prepareStatement("select sum(roman) as Roman from billiards;");
            ResultSet resultRoman = statementRoman.executeQuery();


            if (resultRoman.next()) {
                romanWins = resultRoman.getInt("Roman");
            }

            PreparedStatement statementKirill = connection.prepareStatement("select sum(kirill) as Kirill from billiards;");
            ResultSet resultKirill = statementKirill.executeQuery();

            if (resultKirill.next()) {
                kirillWins = resultKirill.getInt("Kirill");
            }

            System.out.println("Количество выигранных партий у Романа: " + romanWins);
            System.out.println("Количество выигранных партий у Кирилла: " + kirillWins);

        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
    }
}

package com.Database;

/**
 * @author dgbttn
 */

import java.sql.*;
import java.util.LinkedList;

import com.util.TypeUtils;


public class DatabaseControl implements Database {
    private static String DB_URL = "jdbc:mysql://localhost:3306/testjdbc";
    private static String USER_NAME = "root";
    private static String PASSWORD = "0918273645";

    private static Connection connection = null;

    DatabaseControl() {}

    private Connection getConnectToDatabase() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failed!");
            ex.printStackTrace();
        }
        return conn;
    }

    @Override
    public void ConnectToDatabase() {
        connection = getConnectToDatabase();
    }

    @Override
    public void Disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable(String tableName, LinkedList<String> columnName, LinkedList<String> columnType)  {
        if (columnName.size()!=columnType.size()) {
            System.out.println("Table " + tableName + "is invalid!");
            return;
        }

        try {
            Statement stmt = connection.createStatement();
            String name, type;
            name = columnName.get(0);
            type = TypeUtils.getType(columnType.get(0));

            String Command = "CREATE TABLE IF NOT EXISTS `" + tableName + "` ( ";

            if (type==null) {
                System.out.println("Type " + type + "is invalid");
                return;
            }

            Command += "\n `" + name + "` "+ type + "(30) NOT NULL UNIQUE ";
            Command += (type == "VARCHAR")? "COLLATE utf8_vietnamese_ci": "";

            for (int i=1; i<columnName.size(); i++) {
                name = columnName.get(i);
                type = TypeUtils.getType(columnType.get(i));
                if (type==null) {
                    System.out.println("Type " + type + "is invalid");
                    return;
                }

                Command += ", \n `" + name + "` " + type + "(30) NOT NULL ";
                Command += (type == "VARCHAR")? "COLLATE utf8_vietnamese_ci": "";
            }

            Command += ") \n ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci; ";
            //System.out.println(Command);

            stmt.executeUpdate(Command);
            System.out.println("Create Table Successfully!");

        } catch (SQLException e) {
            System.out.println("Create Statement Failed!");
            e.printStackTrace();
        }

    }


}
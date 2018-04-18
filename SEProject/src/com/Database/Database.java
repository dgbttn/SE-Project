package com.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author dgbttn
 */

public interface Database {
    public static final Database instance = new DatabaseControl();

    public static Database getInstance() {
        return instance;
    }

    public void ConnectToDatabase();

    public void Disconnect();

    public void createTable(String tableName, LinkedList<String> columnName, LinkedList<String> columnType);
}
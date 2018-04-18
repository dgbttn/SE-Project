package com.test;

import com.Database.Database;
import com.Database.DatabaseControl;

import java.util.LinkedList;

/**
 * @author dgbttn
 */

public class testDatabase {
    public static void main(String[] args) {
        LinkedList<String> columnName = new LinkedList<>();
        LinkedList<String> columnType = new LinkedList<>();

        columnName.add("id");
        columnName.add("name");
        columnType.add("Số");
        columnType.add("Tự do");

        DatabaseControl DB = (DatabaseControl) Database.getInstance();
        DB.ConnectToDatabase();
        DB.createTable("Biểu mẫu mới", columnName, columnType);
        DB.Disconnect();
    }
}
package Lesson_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AutomaticInsertData {
    private static Connection connection;
    private static Statement stmt;
    public static final String fileName = "d:/Java/Java3/src/main/java/Lesson_2/DZ_update.txt";

    public static void main(String[] args) throws IOException, SQLException {

        try {
            connect();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        insertTab("students", fileName);

//        selectTab("name", "students");// 4

        disconnect();
    }

    public static void connect() throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:mainBD.db");
        stmt = connection.createStatement();
    }

    // метод добавления инфо в таблицу.
    public static void insertTab (String nameTab, String file) throws SQLException, FileNotFoundException {
        Scanner in = new Scanner(new File(file));
        StringBuilder data = new StringBuilder(); // читаем текст
        int i = 0;
        while (in.hasNext())
            data.append(in.nextLine()).append("\n"); //разбиваем текст на строки
        String[] arr = data.toString().split(" "); // массив из значений
        stmt.execute("INSERT INTO " + nameTab + " (name, score) VALUES ('" + arr[1] + "', '" + arr[2] + "');");
        System.out.println("Данные добавленны");
        i++;

    }


    public static void selectTab (String column, String nameTab) throws SQLException {

        ResultSet rs = stmt.executeQuery("SELECT " + column + " FROM " + nameTab + " ;");
        while(rs.next()) {
            System.out.println(rs.getString(column));
        }
    }


    public static void disconnect() {
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
/*Обновить данные по студентам в базе
Исходные данные
id name score
1  Bob1  55
2  Bob2  56
3  Bob3  65
4  Bob4  66
 */
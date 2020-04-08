package Lesson_2;

import java.sql.*;

public class Methods {

    private static Connection connection;
    private static Statement stmt;


    public static void main (String[] args) throws SQLException {

        try {
            connect();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

        createTab("students", "id","name","score"); // 1

        insertTab("students", "Artem", "200");// 2
        insertTab("students", "Den", "150");// 2
        insertTab("students", "Igor", "160");// 2
        insertTab("students", "Maks", "50");// 2
        insertTab("students", "Nadya", "80");// 2

        updateTab("students", "score = 0" );// 3

        selectTab("name", "students");// 4

        deleteTab("students", "name = 'Maks'");// 5


        disconnect();
    }

    public static void connect() throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:mainBD.db");
        stmt = connection.createStatement();
    }

    // 1. метод создания таблицы.
    public static void createTab (String nameTab, String idColumn, String nameColumn, String scoreColumn) throws SQLException {

        stmt.execute("CREATE TABLE if not exists '" + nameTab + "' ('" + idColumn + "' INTEGER PRIMARY KEY AUTOINCREMENT, '" + nameColumn + "' TEXT, '" + scoreColumn + "' TEXT);");
        System.out.println("Таблица добавлена");

    }

    // 2. метод добавления инфо в таблицу.
    public static void insertTab (String nameTab, String name, String score) throws SQLException {

        stmt.execute("INSERT INTO " + nameTab + " (name, score) VALUES ('" + name + "', '" + score + "');");
        System.out.println("Данные добавленны");

    }
    // 3. метод обновления данных.
    public static void updateTab (String nameTab, String columnValue) throws SQLException {

        stmt.execute("UPDATE '" + nameTab + "' SET " + columnValue + ";");
        System.out.println("Данные обновлены");

    }
    // 4. метод вывода инфо из таблицы.
    public static void selectTab (String column, String nameTab) throws SQLException {

        ResultSet rs = stmt.executeQuery("SELECT " + column + " FROM " + nameTab + " ;");
        while(rs.next()) {
            System.out.println(rs.getString(column));
        }


    }
    // 5. метод удаления данных из таблицы.
    public static void deleteTab (String nameTab, String value) throws SQLException {

        stmt.execute("DELETE FROM " + nameTab + " WHERE " + value + ";");
        System.out.println("Данные удалены");

    }



    public static void disconnect() {
         try {
             connection.close();
         }catch (SQLException e){
             e.printStackTrace();
         }
    }




}
//1. Сделать методы для работы с БД (CREATE, UPDATE, DELETE, INSERT, SELECT)

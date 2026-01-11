package org.example.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class JdbcMultipleErrors {
    static String urlDB = "jdbc:h2:./appdb;AUTO_SERVER=TRUE";


    public static void main(String[] args) throws SQLException {

        try (
                Connection conn = DriverManager.getConnection(urlDB, "sa", "");
                Statement stmt = conn.createStatement()
        ) {
            System.out.println("Connexion établie à la base H2");

            // Requête sur une table inexistente
            try {
                stmt.executeQuery("SELECT * FROM INEXISTENTE_TABLE");
            } catch (SQLException e) {
                System.err.println("Erreur 1 : table inexistente");
                printSQLExceptionChain(e);
            }



            try {
                stmt.executeUpdate("INSERT INTO TEST_ERRORS (ID, NOM) VALUES ( 1, 'BLOB' )");
            } catch (SQLException e) {
                System.err.println("Erreur 2 : violation de clé primaire");
                printSQLExceptionChain(e);
            }

            try {
                stmt.executeQuery("SELECT * FORM TEST_ERREORS");
            } catch (SQLException e) {
                System.err.println("Erreur 3 : syntaxe SQL invalide");
                printSQLExceptionChain(e);
            }
        } catch (SQLException e) {
            System.err.println("Erreur de connexion ou autre erreur globale");
            printSQLExceptionChain(e);
        }

        System.out.println("Fin du programme");
    }

    private static void printSQLExceptionChain(SQLException e) {
        while (Objects.nonNull(e)) {
            System.err.println("Message : " + e.getMessage());
            System.err.println("SQLState : " + e.getSQLState());
            System.err.println("Code erreur : " + e.getErrorCode());
            System.err.println("--------------------------");
            e = e.getNextException();
        }
    }
}

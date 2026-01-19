package org.example.exception;

import java.sql.*;
import java.util.Objects;

public class JdbcErrorDemo {

    static String urlDB = "jdbc:h2:./appdb;AUTO_SERVER=TRUE";

    public static void main(String[] args) {
        // Essayons d'exécuter une requête sur une table inexistante pour provoquer une erreur
        String faultyQuery = "SELECT * FROM TABLE_INEXISTENTE";

        try (Connection conn = DriverManager.getConnection(urlDB, "sa", "");
             Statement stmt = conn.createStatement()
        ) {
            System.out.println("Connexion établie à la base H2");
            // Exécution de la requête volontirement incorrete
            ResultSet rs = stmt.executeQuery(faultyQuery);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {

            System.err.println("Une erreur JDBC s'est produite");
            System.err.println("Message : " + e.getMessage());
            System.err.println("SQLState : " + e.getSQLState());
            System.err.println("Code erreur : " + e.getErrorCode());

            // Affichage de toutes les exceptions echaînées
            SQLException next = e.getNextException();
            while (Objects.nonNull(next)) {
                System.err.println("----- Exception suivante ------");
                System.err.println("Message : " + next.getMessage());
                System.err.println("SQLState : " + next.getSQLState());
                System.err.println("Code erreur : " + next.getErrorCode());
            }
        }
        System.out.println("Fin du programme");

    }
}

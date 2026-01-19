package org.example.rowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.Objects;

public class JdbcRowSetDemo {

    public static void main(String[] args) {
        // Base H2 en mode fichier (crée automatiquement)
        String urlDB = "jdbc:h2:./appdb;AUTO_SERVER=TRUE";
        String user = "sa";
        String password = "";

        try {
            JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
            rs.setUrl(urlDB);
            rs.setUsername(user);
            rs.setPassword(password);

            // SELECT
            rs.setCommand("SELECT * FROM PERSONNES where id = ?");
            rs.setInt(1, 101);
            rs.execute();


            System.out.println("Lecture via JdbcRowSet : ");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("ID") + " : " +
                                rs.getString("NOM_PERSONNE") + " " +
                                rs.getString("PRENOM_PERSONNE")
                );
            }

        } catch (SQLException e) {
            while (Objects.nonNull(e)) {
                System.err.println("Message : " + e.getMessage());
                System.err.println("SQLState : " + e.getSQLState());
                System.err.println("Code erreur : " + e.getErrorCode());
                System.err.println("--------------------------");
                e = e.getNextException();
            }
        } catch (NullPointerException e) {
            System.err.println("=== NullPointerException ===");
            System.err.println("Type exception : " + e.getClass().getName());
            System.err.println("Message        : " + e.getMessage());
            System.err.println("Cause          : " + (e.getCause() != null ? e.getCause() : "Aucune cause"));

            // Affichage partiel de la pile pour identifier l'origine
            StackTraceElement[] stack = e.getStackTrace();
            System.err.println("StackTrace (top 3 appels) :");
            for (int i = 0; i < Math.min(3, stack.length); i++) {
                System.err.println("\tat " + stack[i]);
            }
        }

    }

}

package org.example.rowset;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.Objects;

public class CachedRowSetemo {

    public static void main(String[] args) {
        // Base H2 en mode fichier (crée automatiquement)
        String urlDB = "jdbc:h2:./appdb;AUTO_SERVER=TRUE";
        String user = "sa";
        String password = "";

        try (CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet()) {
            crs.setUrl(urlDB);
            crs.setUsername(user);
            crs.setPassword(password);

            // SELECT
            crs.setCommand("SELECT * FROM PERSONNES where id = ?");
            crs.setInt(1, 101);
            crs.execute();


            System.out.println("Lecture via JdbcRowSet : ");
            while (crs.next()) {
                System.out.println(
                        crs.getInt("ID") + " : " +
                                crs.getString("NOM_PERSONNE") + " " +
                                crs.getString("PRENOM_PERSONNE")
                );
            }

            // Sérialisation
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personnes.ser"))) {
                oos.writeObject(crs);
            } catch (IOException e) {
                throw new RuntimeException(e);
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

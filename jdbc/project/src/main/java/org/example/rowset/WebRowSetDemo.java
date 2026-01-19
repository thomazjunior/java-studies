package org.example.rowset;

import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.FileWriter;
import java.sql.SQLException;

public class WebRowSetDemo {

    public static void main(String[] args) {

        String urlDB = "jdbc:h2:./appdb;AUTO_SERVER=TRUE";
        String user = "sa";
        String password = "";

        try {
            WebRowSet wrs = RowSetProvider.newFactory().createWebRowSet();

            wrs.setUrl(urlDB);
            wrs.setUsername(user);
            wrs.setPassword(password);

            wrs.setCommand("SELECT ID, NOM_PERSONNE, PRENOM_PERSONNE FROM PERSONNES");
            wrs.execute();

            System.out.println("Lecture WebRowSet :");
            while (wrs.next()) {
                System.out.println(
                        wrs.getInt("ID") + " - " +
                                wrs.getString("NOM_PERSONNE") + " " +
                                wrs.getString("PRENOM_PERSONNE")
                );
            }

            // Écriture en XML
            try (FileWriter writer = new FileWriter("personnes.xml")) {
                wrs.writeXml(writer);
            }

            System.out.println("\nDonnées exportées en XML : personnes.xml");

        } catch (SQLException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}

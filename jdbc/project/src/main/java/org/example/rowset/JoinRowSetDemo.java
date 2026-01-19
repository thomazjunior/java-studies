package org.example.rowset;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class JoinRowSetDemo {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:h2:./appdb;AUTO_SERVER=TRUE";
        String user = "sa";
        String password = "";

        // ===== RowSet PERSONNES =====
        CachedRowSet personnes = RowSetProvider.newFactory().createCachedRowSet();
        personnes.setUrl(url);
        personnes.setUsername(user);
        personnes.setPassword(password);
        personnes.setCommand("SELECT ID, NOM_PERSONNE FROM PERSONNES");
        personnes.execute();

        // ===== RowSet ADRESSES =====
        CachedRowSet adresses = RowSetProvider.newFactory().createCachedRowSet();
        adresses.setUrl(url);
        adresses.setUsername(user);
        adresses.setPassword(password);
        adresses.setCommand("SELECT PERSONNE_ID, VILLE, PAYS FROM ADRESSES");
        adresses.execute();

        // ===== JOIN EN MÉMOIRE =====
        JoinRowSet join = RowSetProvider.newFactory().createJoinRowSet();
        join.addRowSet(personnes, "ID");
        join.addRowSet(adresses, "PERSONNE_ID");

        // ===== LECTURE =====
        System.out.println("Résultat du JoinRowSet :");
        while (join.next()) {
            System.out.println(
                    join.getInt("ID") + " | " +
                            join.getString("NOM_PERSONNE") + " | " +
                            join.getString("VILLE") + " | " +
                            join.getString("PAYS")
            );
        }
    }
}

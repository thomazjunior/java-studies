package org.example.rowset;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.Predicate;
import java.sql.SQLException;

public class FilteredRowSetDemo {

    public static void main(String[] args) {

        String urlDB = "jdbc:h2:./appdb;AUTO_SERVER=TRUE";
        String user = "sa";
        String password = "";

        try {
            FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet();

            frs.setUrl(urlDB);
            frs.setUsername(user);
            frs.setPassword(password);

            // 1️⃣ Chargement complet (sans filtre)
            frs.setCommand("SELECT ID, NOM_PERSONNE, PRENOM_PERSONNE FROM PERSONNES");
            frs.execute();

            // 2️⃣ Définition du filtre Java
            frs.setFilter(new Predicate() {

                @Override
                public boolean evaluate(Object value, int column) throws SQLException {
                    return true; // pas utilisé ici
                }

                @Override
                public boolean evaluate(Object value, String columnName) throws SQLException {
                    return true; // pas utilisé ici
                }

                @Override
                public boolean evaluate(javax.sql.RowSet rs) {
                    try {
                        int id = rs.getInt("ID");
                        String nom = rs.getString("NOM_PERSONNE");

                        return id > 5 && nom.startsWith("D");

                    } catch (SQLException e) {
                        return false;
                    }
                }
            });

            // 3️⃣ Lecture des lignes filtrées
            System.out.println("Résultat filtré :");
            while (frs.next()) {
                System.out.println(
                        frs.getInt("ID") + " - " +
                                frs.getString("NOM_PERSONNE") + " " +
                                frs.getString("PRENOM_PERSONNE")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

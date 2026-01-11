package org.example.preparedStatement;

import java.sql.*;

public class Main {

    // Base H2 en mode fichier (crée automatiquement)
    static String DBurl = "jdbc:h2:./appdb;AUTO_SERVER=TRUE";

    private static void affiche(String message) {
        System.out.println(message);
    }

    private static void arret(String message) {
        System.err.println(message);
        System.exit(99);
    }

    public static void main(String[] args) {
        Connection con = null;
        ResultSet resultats = null;
        String requete = "";


        affiche("connexion à la base de données");
        try {
            con = DriverManager.getConnection(DBurl, "sa", "");
            PreparedStatement recherchePersonne = con.prepareStatement(
                    "SELECT * FROM PERSONNES WHERE NOM_PERSONNE = ?"
            );


            recherchePersonne.setString(1, "nom3");
            resultats = recherchePersonne.executeQuery();
            affiche("parcous de données retournées");
            boolean encore = resultats.next();
            while (encore) {
                System.out.println(
                        resultats.getInt(1) + " : " +
                                resultats.getString(2) +
                                " " +
                                resultats.getString(3) + " (" +
                                resultats.getDate(4) + ")"
                );
                encore = resultats.next();
            }
        } catch (SQLException e) {
            arret(e.getMessage());
        }
    }
}

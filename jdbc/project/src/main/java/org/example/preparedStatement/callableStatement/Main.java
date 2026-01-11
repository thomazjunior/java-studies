package org.example.preparedStatement.callableStatement;

import java.sql.*;

public class Main {


    public static void main(String[] args) {

        String DBurl = "jdbc:h2:./appdb;AUTO_SERVER=TRUE";

        try (Connection con = DriverManager.getConnection(DBurl, "sa", "");
             Statement stmt = con.createStatement()) {

            // Création table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS PERSONNES (
                    ID INT AUTO_INCREMENT PRIMARY KEY,
                    NOM_PERSONNE VARCHAR(100),
                    PRENOM_PERSONNE VARCHAR(100),
                    DATE_NAISSANCE DATE
                )
            """);


            // Création de la procédure
            stmt.executeUpdate(
                    """
                            CREATE ALIAS IF NOT EXISTS AffichePersonnesParNom AS $$
                            ResultSet affiche(Connection conn, String nom) throws SQLException {
                                PreparedStatement ps = conn.prepareStatement("SELECT * FROM PERSONNES WHERE NOM_PERSONNE = ?");
                                ps.setString(1, nom);
                                return ps.executeQuery();
                            }
                            $$;
                            """
            );

            // Appel de la procédure
            try (CallableStatement cs = con.prepareCall("{CALL AffichePersonnesParNom(?)}")) {
                cs.setString(1, "nom3");
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    System.out.println(
                            rs.getInt("ID") + " : " +
                                    rs.getString("NOM_PERSONNE") + " " +
                                    rs.getString("PRENOM_PERSONNE") + " (" +
                                    rs.getDate("DATE_NAISSANCE") + ")"
                    );
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

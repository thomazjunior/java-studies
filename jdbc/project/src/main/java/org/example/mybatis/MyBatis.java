package org.example.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.mapper.PersonneMapper;
import org.example.mybatis.model.Personne;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatis {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonneMapper mapper = session.getMapper(PersonneMapper.class);

          /*  // Création de 100 personnes
            for (int i = 0; i < 100; i++) {
                Personne p = new Personne();
                p.setNomPersonne("nom" + (i % 5));
                p.setPrenomPersonne("prenom" + i);
                p.setDateNaissance(LocalDate.of(1990, 1, (i % 28) + 1));
                mapper.insert(p);
            }

            System.out.println("100 personnes insérées");*/

            // Consultation
            List<Personne> personnes = mapper.findByNom("nom3");
            System.out.println("Résultat findByNom(\"nom3\") :");
            personnes.forEach(p -> {
                System.out.println(
                        p.getId() + " " +
                                p.getNomPersonne() + " " +
                                p.getPrenomPersonne()
                );
            });
        }

    }
}

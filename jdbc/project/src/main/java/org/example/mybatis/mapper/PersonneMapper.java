package org.example.mybatis.mapper;

import org.example.mybatis.model.Personne;

import java.util.List;

// remplace PreparedStatement
public interface PersonneMapper {

    void insert(Personne personne);
    List<Personne> findByNom(String nom);

}

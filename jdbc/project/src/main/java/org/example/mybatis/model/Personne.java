package org.example.mybatis.model;

import lombok.Data;

import java.time.LocalDate;

// équivalent d'une ligne SQL -> ResultSet
@Data
public class Personne {
    private Integer id;
    private String nomPersonne;
    private String prenomPersonne;
    private LocalDate dateNaissance;
}


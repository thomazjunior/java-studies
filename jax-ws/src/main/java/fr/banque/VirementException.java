package fr.banque;

import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "virementException")
public class VirementException extends Exception {

    private String codeErreur;
    private String description;

    public VirementException() {
        super();
    }

    public VirementException(String message, String codeErreur) {
        super(message);
        this.codeErreur = codeErreur;
        this.description = message;
    }

    public VirementException(String message, String codeErreur, Throwable cause) {
        super(message, cause);
        this.codeErreur = codeErreur;
        this.description = message;
    }

    // Getters et Setters
    public String getCodeErreur() {
        return codeErreur;
    }

    public void setCodeErreur(String codeErreur) {
        this.codeErreur = codeErreur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
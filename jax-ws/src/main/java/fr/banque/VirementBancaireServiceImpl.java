package fr.banque;
import java.math.BigDecimal;
import java.util.UUID;
import jakarta.jws.WebService;
import javax.ejb.Stateless;

@Stateless
@WebService(
        serviceName = "VirementBancaireService",
        portName = "VirementBancairePort",
        targetNamespace = "http://banque.fr/",
        endpointInterface = "fr.banque.VirementBancaireService"
)

public class VirementBancaireServiceImpl implements VirementBancaireService {

    @Override
    public ResultatVirement effectuerVirement(VirementRequest request)
            throws VirementException {

        // Validation des données
        validerRequest(request);

        // Simulation de traitement
        // Dans une application réelle, vous accéderiez à la base de données

        // Génération d'une référence unique
        String reference = generateReference();

        // Simulation de virement réussi
        ResultatVirement resultat = new ResultatVirement();
        resultat.setReference(reference);
        resultat.setStatut("SUCCES");
        resultat.setMontant(request.getMontant());
        resultat.setCompteSource(request.getCompteSource());
        resultat.setCompteDestination(request.getCompteDestination());

        // Logique métier supplémentaire ici...

        return resultat;
    }

    private void validerRequest(VirementRequest request) throws VirementException {
        if (request == null) {
            throw new VirementException("Requête invalide", "ERR001");
        }

        if (request.getCompteSource() == null || request.getCompteSource().isEmpty()) {
            throw new VirementException("Compte source requis", "ERR002");
        }

        if (request.getCompteDestination() == null || request.getCompteDestination().isEmpty()) {
            throw new VirementException("Compte destination requis", "ERR003");
        }

        if (request.getMontant() == null || request.getMontant().compareTo(BigDecimal.ZERO) <= 0) {
            throw new VirementException("Montant invalide", "ERR004");
        }

        // Validation supplémentaire...
    }

    private String generateReference() {
        return "VIR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
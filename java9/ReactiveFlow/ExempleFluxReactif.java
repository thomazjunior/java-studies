package java9.ReactiveFlow;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

class TransformateurDeChaine extends SubmissionPublisher<String> implements Flow.Processor<Integer, String> {
    private Flow.Subscription abonnement;

    @Override
    public void onSubscribe(Flow.Subscription abonnement) {
        this.abonnement = abonnement;
        abonnement.request(1); // Demande du premier élément
    }

    @Override
    public void onNext(Integer element) {
        System.out.println("[Transformateur] Traitement de l'élément : " + element);
        submit("Transformé : " + (element * 10)); // Transformer la donnée
        abonnement.request(1); // Demande du prochain élément
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("[Transformateur] Erreur : " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("[Transformateur] Traitement terminé.");
        close(); // Fermer le processeur
    }
}

// Abonné personnalisé (Consomme les données)
class AbonneImpression implements Flow.Subscriber<String> {
    private Flow.Subscription abonnement;

    @Override
    public void onSubscribe(Flow.Subscription abonnement) {
        this.abonnement = abonnement;
        abonnement.request(1); // Demande du premier élément
    }

    @Override
    public void onNext(String element) {
        System.out.println("[Abonné] Reçu : " + element);
        try {
            TimeUnit.MILLISECONDS.sleep(500); // Simuler un délai de traitement
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        abonnement.request(1); // Demande du prochain élément
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("[Abonné] Erreur : " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("[Abonné] Fin de la réception des données.");
    }
}

// Classe principale pour démontrer l'API Flow
public class ExempleFluxReactif {
    public static void main(String[] args) {
        // Créer un éditeur
        SubmissionPublisher<Integer> editeur = new SubmissionPublisher<>();

        // Créer un processeur
        TransformateurDeChaine processeur = new TransformateurDeChaine();

        // Créer un abonné
        AbonneImpression abonne = new AbonneImpression();

        // Connecter l'éditeur au processeur, et le processeur à l'abonné
        editeur.subscribe(processeur);
        processeur.subscribe(abonne);

        // Publier quelques éléments
        System.out.println("[Principal] Publication des éléments...");
        for (int i = 1; i <= 5; i++) {
            editeur.submit(i);
        }

        // Fermer l'éditeur après l'envoi des éléments
        editeur.close();

        // Attendre la fin du traitement des abonnés
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

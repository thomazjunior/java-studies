# Design Patterns - Patrons de Création

## Qu'est-ce qu'un patron de création ?
Les patrons de création sont des modèles de conception qui permettent de contrôler la création des objets afin que cette création soit :

- Flexible
- Maintenable
- Indépendante de la classe concrète
- Conforme aux règles métier

## Les principaux patrons de création

| Patron              | Objectif                                                           | Exemple bancaire                                                | Exemple en code simplifié                                                              |
|---------------------|--------------------------------------------------------------------|-----------------------------------------------------------------|----------------------------------------------------------------------------------------|
| Singleton           | Assurer qu’une classe n’ait qu’une seule instance                  | Gestionnaire central de transactions                            | TransactionManager.getInstance().enregistrerTransaction(paiement);                     |
| Factory Method      | Déléguer la création d’un objet à une sous-classe ou méthode       | Créer un MoyenPaiement spécifique                               | MoyenPaiement moyen = MoyenPaiementFactory.creer(TypeMoyenPaiement.CARTE);             |
| Abstract Factory    | Créer des familles d’objets liés sans spécifier la classe concrète | Créer à la fois Paiement + Remise selon le canal (CB, Virement) | BankFactory factory = new CBFactory(); factory.creerPaiement(); factory.creerRemise(); |
| Builder             | Construire un objet complexe étape par étape                       | Création d’une Transaction complète avec paiements multiples    | Transaction t = new Transaction.Builder().withId("TX-001").addPaiement(p1).build();    |
| Prototype           | Créer un nouvel objet en copiant un existant                       | Cloner un paiement récurrent                                    | Paiement clone = paiementPrototype.clonePaiement();                                    |

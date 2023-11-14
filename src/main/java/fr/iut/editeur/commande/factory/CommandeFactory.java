package fr.iut.editeur.commande.factory;

import fr.iut.editeur.commande.*;
import fr.iut.editeur.document.Document;

public class CommandeFactory {

    private static CommandeFactory instance;

    public static CommandeFactory getInstance() {
        if(instance == null) {
            instance = new CommandeFactory();
        }
        return instance;
    }

    private CommandeFactory() {}

    /**
     * @param name       nom de la commande
     * @param document   document sur lequel la commande va s'appliquer
     * @param parameters paramètres de la commande
     * @return la commande correspondante
     */
    public Commande createCommand(String name, Document document, String[] parameters) {
        switch (name) {
            case "ajouter" -> {
                return new CommandeAjouter(document, parameters);
            }
            case "remplacer" -> {
                if (parameters.length < 4) {
                    String[] newParameters = new String[4];
                    newParameters[0] = parameters[0];
                    newParameters[1] = parameters[1];
                    newParameters[2] = parameters[2];
                    newParameters[3] = "";

                    return new CommandeRemplacer(document, newParameters);
                }
                return new CommandeRemplacer(document, parameters);
            }
            case "majuscule" -> {
                return new CommandeMajuscule(document, parameters);
            }
            case "effacer" -> {
                return new CommandeEffacer(document, parameters);
            }
            case "clear" -> {
                return new CommandeClear(document, parameters);
            }
            default -> {
                return null;
            }
        }
    }

}

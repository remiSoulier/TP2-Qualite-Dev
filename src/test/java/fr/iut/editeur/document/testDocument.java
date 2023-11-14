package fr.iut.editeur.document;
import fr.iut.editeur.commande.Commande;
import fr.iut.editeur.commande.factory.CommandeFactory;
import fr.iut.editeur.commande.invoker.CommandeInvoker;
import org.junit.Test;

public class testDocument {
    @Test
    public void ajouter(){
        Document document = new Document();
        CommandeInvoker invoker = CommandeInvoker.getInstance();
        CommandeFactory factory = CommandeFactory.getInstance();
        String input = "ajouter;hello world";
        String[] parameters = input.split(";");
        String nomCommande = parameters[0];
        Commande commande = factory.createCommand(nomCommande, document, parameters);
        invoker.executer(commande);
        assert(document.toString().equals("hello world"));

    }

    @Test
    public void remplacer(){
        Document document = new Document();
        CommandeInvoker invoker = CommandeInvoker.getInstance();
        CommandeFactory factory = CommandeFactory.getInstance();
        String input = "ajouter;hello world";
        String[] parameters = input.split(";");
        String nomCommande = parameters[0];
        Commande commande = factory.createCommand(nomCommande, document, parameters);
        invoker.executer(commande);
        input = "remplacer;0;5;goodbye";
        parameters = input.split(";");
        nomCommande = parameters[0];
        commande = factory.createCommand(nomCommande, document, parameters);
        invoker.executer(commande);
        assert(document.toString().equals("goodbye world"));
    }
}

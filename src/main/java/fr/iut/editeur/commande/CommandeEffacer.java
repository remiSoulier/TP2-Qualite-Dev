package fr.iut.editeur.commande;
import fr.iut.editeur.document.Document;
public class CommandeEffacer extends CommandeDocument {
    public CommandeEffacer(Document document, String[] parameters) {
        super(document, parameters);
    }
    @Override
    public void executer() {
        if(parameters.length < 3) {
            System.err.println("Format attendu : effacer;nombre");
            return;
        }
        int debut;
        if (parameters[1].equals("debut")){
            debut = 0;
        }
        else{
            debut = Integer.parseInt(parameters[1]);
        }
        int fin;
        if (parameters[2].equals("fin")){
            fin = this.document.getTexte().length();
        }
        else{
            fin = Integer.parseInt(parameters[2]);
        }
        this.document.effacer(debut,fin);
        super.executer();
    }
}


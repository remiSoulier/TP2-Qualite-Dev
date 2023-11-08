package fr.iut.editeur.document;

public class Document {

    private String texte;

    public Document() {
        this.texte = "";
    }
	
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void ajouter(String texte) {
        this.texte += texte;
    }

    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + remplacement + rightPart;
    }

    public void majuscule(int debut, int fin) {
        String cible=texte.substring(debut,fin).toUpperCase();
        remplacer(debut,fin,cible);
    }

    public void effacer(int debut, int fin) {
        remplacer(debut,fin,"");
    }

    @Override
    public String toString() {
        return this.texte;
    }
}

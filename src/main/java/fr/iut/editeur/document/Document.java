package fr.iut.editeur.document;

public class Document {

    private String texte;


    public Document() {
        this.texte = "";
    }

    /**
     *
     * @return texte du document
     */
    public String getTexte() {
        return texte;
    }

    /**
     *
     * @param texte texte du document
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }

    /**
     *
     * @param texte texte à ajouter au document
     */
    public void ajouter(String texte) {
        this.texte += texte;
    }

    /**
     *
     * @param start début de la sélection
     * @param end fin de la sélection
     * @param remplacement texte de remplacement
     */
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + remplacement + rightPart;
    }

    /**
     *
     * @param debut début de la sélection
     * @param fin fin de la sélection
     */
    public void majuscule(int debut, int fin) {
        String cible=texte.substring(debut,fin).toUpperCase();
        remplacer(debut,fin,cible);
    }

    /**
     *
     * @param debut début de la sélection
     * @param fin fin de la sélection
     */
    public void effacer(int debut, int fin) {
        remplacer(debut,fin,"");
    }


    /**
     * Efface tout le texte du document
     */
    public void clear() {
        this.texte = "";

    }

    /**
     *
     * @return texte du document sous forme de chaîne de caractères
     */
    @Override
    public String toString() {
        return this.texte;
    }
}

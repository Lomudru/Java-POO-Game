package model;

/**
 * La classe Tresor qui est une sous-classe de la classe ObjetDuJeu
 */
public class Tresor extends ObjetDuJeu{
    private int valeur;
    private int quantite;

    public Tresor(String nom, int rarete, String description, int nombreDutilisation, boolean consomable, int valeur, int quantite) {
        super(nom, rarete, description, nombreDutilisation, consomable);
        this.valeur = valeur;
        this.quantite = quantite;
    }

    public int getValeur() {
        return valeur;
    }
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    /**
     * La methode brillier qui fait brillier l'objet
     */
    public void brillier(){
        System.out.println("Le tresor brille");
    }
}

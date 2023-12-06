package model;

/**
 * La classe Potion qui est une sous-classe de ObjetDuJeu
 */
public class Potion extends ObjetDuJeu{
    private String effet;
    private int duree;

    public Potion(String nom, int rarete, String description, int nombreDutilisation, boolean consomable, String effet, int duree) {
        super(nom, rarete, description, nombreDutilisation, consomable);
        this.effet = effet;
        this.duree = duree;
    }

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
    /**
     * La methode appliquerEffet qui applique l'effet de la potion
     */
    public void appliquerEffet(){
        System.out.println("L'effet de la potion a été appliquer");
    }
}

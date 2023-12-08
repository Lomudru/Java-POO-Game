package model;
/**
 * La classe Gobelin est une sous-classe de la classe ennemi
 */
public class Gobelin extends Ennemi{
    private String environement;

    public Gobelin(String nom, int pointsDeVie, int force, String race, ObjetDuJeu[] inventaire, String type, int loot, String environement) {
        super(nom, pointsDeVie, force, race, inventaire, type, loot);
        this.environement = environement;
    }

    public String getEnvironement() {
        return environement;
    }
    public void setEnvironement(String environement) {
        this.environement = environement;
    }
    /**
     * La methode vol permet au gobelin de voler le joueur
     */
    public void vol(){
        System.out.println("Le gobelin vol le joueur");
    }
}

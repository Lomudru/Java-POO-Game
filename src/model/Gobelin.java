package model;
/**
 * La classe Gobelin est une sous-classe de la classe ennemi
 */
public class Gobelin extends Ennemi{
    private String environement;
    public Gobelin(String nom, int pointsDeVie, int force, String race, String type, int loot, String environement) {
        super(nom, pointsDeVie, force, race, type, loot);
        this.environement = environement;
    }

    @Override
    public void attaquer(Object ennemi) {
        super.attaquer(ennemi);
        setPointsDeVie(getPointsDeVie() - 5);
        setForce(getForce() + 5);
    }
    @Override
    public void defendre() {
        super.defendre();
        setPointsDeVie(getPointsDeVie() + 5);
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

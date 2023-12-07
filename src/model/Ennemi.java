package model;

/**
 * La classe Ennemi est une sous-classe de la classe Personnage
 */
public class Ennemi extends Personnage implements Interactuable {
    private String type;
    private int loot;

    public Ennemi(String nom, int pointsDeVie, int force, String race, String type, int loot) {
        super(nom, pointsDeVie, force, race);
        this.type = type;
        this.loot = loot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    /**
     * Override de la methode attaquer
     */
    @Override
    public void attaquer(Object ennemi){
        super.attaquer(ennemi);
        setPointsDeVie(getPointsDeVie() + 10);
        setForce(getForce() + 10);
    }
    /**
     * Override de la methode defendre
     */
    @Override
    public void defendre() {
        super.defendre();
        setPointsDeVie(getPointsDeVie() + 5);
    }
    /**
     * Override de la methode mort
     */
    @Override
    public void mort(){
        System.out.println("L'ennemi est mort");
    }

    @Override
    public void interaction(Object nom) {
        System.out.println("L'ennemi interagit avec " + getNom());
    }
}


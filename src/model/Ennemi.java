package model;
/**
 * La classe Ennemi est une sous-classe de la classe Personnage
 */
public class Ennemi extends Personnage {
    private String type;
    private String loot;

    public Ennemi(String nom, int pointsDeVie, int force, String race, String type, String loot) {
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

    public String getLoot() {
        return loot;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }

    /**
     * Override de la methode attaquer
     */
    @Override
    public void attaquer(){
        System.out.println("L'ennemi attaque");
    }
    /**
     * Override de la methode defendre
     */
    @Override
    public void defendre(){
        System.out.println("L'ennemi se defend");
    }
    /**
     * Override de la methode mort
     */
    @Override
    public void mort(){
        System.out.println("L'ennemi est mort");
    }

}

package model;

/**
 * La classe slime est une sous-classe de la classe ennemi
 */
public class Slime extends Ennemi {
    private String couloeur;
    private String element;

    public Slime(String nom, int pointsDeVie, int force, String race, String type, int loot, String couloeur, String element) {
        super(nom, pointsDeVie, force, race, type, loot);
        this.couloeur = couloeur;
        this.element = element;
    }

    public String getCouloeur() {
        return couloeur;
    }
    public void setCouloeur(String couloeur) {
        this.couloeur = couloeur;
    }
    public String getElement() {
        return element;
    }
    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public void attaquer(Object ennemi) {
        super.attaquer(ennemi);
        setPointsDeVie(getPointsDeVie() + 5);
        setForce(getForce() - 5);
    }
    @Override
    public void defendre() {
        super.defendre();
        setPointsDeVie(getPointsDeVie() + 10);
    }
    /**
     * La classe regen qui fait en sorte de régénérer la vie du slime
     */
    public void regen(){
        System.out.println("Le slime se régénère");
    }

}

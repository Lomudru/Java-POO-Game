package model;

public class Slime extends Ennemi {
    private String couloeur;
    private String element;

    public Slime(String nom, int pointsDeVie, int force, String race, String type, String loot, String couloeur, String element) {
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

    public void regen(){
        System.out.println("Le slime se régénère");
    }

}

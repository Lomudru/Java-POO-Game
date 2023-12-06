package model;

public class slime extends Ennemi {
    private String couloeur;
    private String element;

    public slime(String nom, int pointsDeVie, int force, String race, String classe, String type, String loot, String couloeur, String element) {
        super(nom, pointsDeVie, force, race, classe, type, loot);
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

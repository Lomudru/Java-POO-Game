package model;

public class Ennemi extends Personnage {
    private String type;
    private String loot;

    public Ennemi(String nom, int pointsDeVie, int force, String type, String loot) {
        super(nom, pointsDeVie, force);
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

    @Override
    public void attaquer(){
        System.out.println("L'ennemi attaque");
    }
    @Override
    public void defendre(){
        System.out.println("L'ennemi se defend");
    }
    public void mort(){
        System.out.println("L'ennemi est mort");
    }

}

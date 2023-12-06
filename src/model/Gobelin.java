package model;

public class gobelin extends Ennemi{
    private String environement;

    public gobelin(String nom, int pointsDeVie, int force, String race, String classe, String type, String loot, String environement) {
        super(nom, pointsDeVie, force, race, classe, type, loot);
        this.environement = environement;
    }

    public String getEnvironement() {
        return environement;
    }
    public void setEnvironement(String environement) {
        this.environement = environement;
    }

    public void vol(){
        System.out.println("Le gobelin vol le joueur");
    }
}

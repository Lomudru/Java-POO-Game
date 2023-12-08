package model;

public class Personnage implements Interactuable {
    private String nom;
    private int pointsDeVie;
    private int force;
    private String race;
    private ObjetDuJeu[] inventaire;

    public Personnage(String nom, int pointsDeVie, int force, String race, ObjetDuJeu[] inventaire) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
        this.race = race;
        this.inventaire = inventaire;
    }

    public ObjetDuJeu[] getInventaire() {
        return inventaire;
    }

    public void setInventaire(ObjetDuJeu[] inventaire) {
        this.inventaire = inventaire;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int attaquer(Ennemi ennemi) {
        System.out.println("Il Attaque");
        return 0;
    }

    public void defendre() {
        System.out.println("Il se défend");
    }

    public void mort() {
        System.out.println("Le personnage meurt");
    }

    @Override
    public void interaction(Object nom) {
        System.out.println("interaction avec " + getNom());
    }

}

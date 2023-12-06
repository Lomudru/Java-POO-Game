package model;

public class Personnage implements Interactuable {
    private String nom;
    private int pointsDeVie;
    private int force;
    private String race;

    public Personnage(String nom, int pointsDeVie, int force, String race) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
        this.race = race;
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

    public void attaquer(){
        System.out.println("Il Attaque");
    }
    public void defendre(){
        System.out.println("Il se défend");
    }
    public void mort(){
        System.out.println("Le personnage meurt");
    }

    /**
     * Méthode pour faire interagir le personnage
     */
    @Override
    public void interaction(String nom){ System.out.println("Le " + this.nom + " interagit."); }
}

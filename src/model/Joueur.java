package model;

import java.util.ArrayList;

/**
 * La classe Joueur qui est un sous-classe de la classe Personnage
 */
public class Joueur extends Personnage{
    private String classe;
    private String passif;
    private ArrayList<String> inventaire;
    private int argent;

    public Joueur(String nom, int pointsDeVie, int force, String race, String classe, String passif, ArrayList<String> inventaire, int argent) {
        super(nom, pointsDeVie, force, race);
        this.classe = classe;
        this.passif = passif;
        this.inventaire = inventaire;
        this.argent = argent;
    }

    public String getClasse() {
        return classe;
    }
    public void setClasse(String classe) {
        this.classe = classe;
    }
    public String getPassif() {
        return passif;
    }
    public void setPassif(String passif) {
        this.passif = passif;
    }
    public ArrayList<String> getInventaire() {
        return inventaire;
    }
    public void setInventaire(ArrayList<String> inventaire) {
        this.inventaire = inventaire;
    }
    public int getArgent() {
        return argent;
    }
    public void setArgent(int argent) {
        this.argent = argent;
    }

    @Override
    public void attaquer(Object ennemi) {
        super.attaquer(ennemi);
        setPointsDeVie(getPointsDeVie() + 20);
        setForce(getForce() + 10);
    }
    @Override
    public void defendre() {
        super.defendre();
        setPointsDeVie(getPointsDeVie() + 10);
    }

    /**
     * La methode déplacer qui permet au joueur de se déplacer
     */
    public void deplacer(){
        System.out.println("Le joueur se deplace");
    }
}

package model;
import java.util.ArrayList;

/**
 * La classe Joueur qui est un sous-classe de la classe Personnage
 */
public class Joueur extends Personnage{
    private String classe;
    private String passif;
    private int argent;

    public Joueur(String nom, int pointsDeVie, int force, String race, String classe, String passif, ObjetDuJeu[] inventaire , int argent) {
        super(nom, pointsDeVie, force, race, inventaire);
        this.classe = classe;
        this.passif = passif;
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
    public int getArgent() {
        return argent;
    }
    public void setArgent(int argent) {
        this.argent = argent;
    }

    @Override
    public int attaquer(Ennemi ennemi) {
        int FinalAttack = this.getForce();
        if (super.getInventaire().length > 0){
            for (int i = 0; i < super.getInventaire().length; i++){
                if (super.getInventaire()[i].getNom().equals("Epée")){
                    FinalAttack += 2;
                }
            }
        }
        ennemi.setPointsDeVie(ennemi.getPointsDeVie() - FinalAttack);
        return FinalAttack;
    }
    @Override
    public void defendre() {
        System.out.println("Vous vous Défendez");
    }

    /**
     * La methode déplacer qui permet au joueur de se déplacer
     */
    public void deplacer(){
        System.out.println("Le joueur se deplace");
    }
}

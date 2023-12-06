package model;

public class Joueur extends Personnage {
    private String classe;
    private String passif;
    private String statistique;

    public Joueur(String nom, int pointsDeVie, int force, String race, String classe, String passif, String statistique) {
        super(nom, pointsDeVie, force, race);
        this.classe = classe;
        this.passif = passif;
        this.statistique = statistique;
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
    public String getStatistique() {
        return statistique;
    }
    public void setStatistique(String statistique) {
        this.statistique = statistique;
    }

    public void deplacer(){
        System.out.println("Le joueur se deplace");
    }
    public void interaction(){
        System.out.println("Le joueur interragit avec quelque chose");
    }
}

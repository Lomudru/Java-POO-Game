package model;

/**
 * La classe Arme qui est une sous-classe de la classe ObjetDuJeu
 */
public class Arme extends ObjetDuJeu {
    private String type;
    private int durabilite;
    private int degat;
    private String passif;
    private int porte;
    private boolean equipe;

    public Arme(String nom, int rarete, String description, int nombreDutilisation, boolean consomable, String type, int durabilite, int degat, String passif, int porte, boolean equipe) {
        super(nom, rarete, description, nombreDutilisation, consomable);
        this.type = type;
        this.durabilite = durabilite;
        this.degat = degat;
        this.passif = passif;
        this.porte = porte;
        this.equipe = equipe;
    }

    public boolean isEquipe() {
        return equipe;
    }

    public void setEquipe(boolean equipe) {
        this.equipe = equipe;
    }

    public int getPorte() {
        return porte;
    }
    public void setPorte(int porte) {
        this.porte = porte;
    }
    public String getPassif() {
        return passif;
    }
    public void setPassif(String passif) {
        this.passif = passif;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getDurabilite() {
        return durabilite;
    }
    public void setDurabilite(int durabilite) {
        this.durabilite = durabilite;
    }
    public int getDegat() {
        return degat;
    }
    public void setDegat(int degat) {
        this.degat = degat;
    }

    /**
     * La methode effetSecondaire qui fait utiliser le passif de l'arme
     */
    public void effetSecondaire(){
        System.out.println("L'arme utilise son passif");
    }
    /**
     * La methode casser qui fait casser l'arme
     */
    public void casser(){
        System.out.println("L'arme se casse");
    }
}

package model;

/**
 * La classe abstraite ObjetDuJeu
 */
public abstract class ObjetDuJeu implements Interactuable{
    private String nom;
    private int rarete;
    private String description;
    private int nombreDutilisation;
    private boolean consomable;

    public ObjetDuJeu(String nom, int rarete, String description, int nombreDutilisation, boolean consomable) {
        this.nom = nom;
        this.rarete = rarete;
        this.description = description;
        this.nombreDutilisation = nombreDutilisation;
        this.consomable = consomable;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getRarete() {
        return rarete;
    }
    public void setRarete(int rarete) {
        this.rarete = rarete;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getNombreDutilisation() {
        return nombreDutilisation;
    }
    public void setNombreDutilisation(int nombreDutilisation) {
        this.nombreDutilisation = nombreDutilisation;
    }
    public boolean isConsomable() {
        return consomable;
    }
    public void setConsomable(boolean consomable) {
        this.consomable = consomable;
    }
    /**
     * La methode disaparaitre qui fait disparaitre l'objet
     */
    public void disparaitre(){
        System.out.println("L'objet disparait");
    }
    /**
     * La methode disaparaitre qui fait apparaitre l'objet
     */
    public void apparaitre(){
        System.out.println("L'objet apparait");
    }

    @Override
    public void interaction(Object nom) {
        System.out.println("interaction avec " + getNom());
    }
}

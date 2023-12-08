package model;

/**
 * La classe Ennemi est une sous-classe de la classe Personnage
 */
public class Ennemi extends Personnage implements Interactuable {
    private String type;
    private int loot;

    public Ennemi(String nom, int pointsDeVie, int force, String race, ObjetDuJeu[] inventaire, String type, int loot) {
        super(nom, pointsDeVie, force, race, inventaire);
        this.type = type;
        this.loot = loot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    /**
     * Override de la methode attaquer
     */
    public int attaquer(Joueur joueur){
        int FinalAttack = this.getForce();
        if (super.getInventaire().length > 0){
            for (int i = 0; i < super.getInventaire().length; i++){
                if (super.getInventaire()[i].getNom().equals("Epée")){
                    FinalAttack += 2;
                }
            }
        }
        joueur.setPointsDeVie(joueur.getPointsDeVie() - FinalAttack);
        return FinalAttack;
    }
    /**
     * Override de la methode defendre
     */
    @Override
    public void defendre() {
        System.out.println("Le monstre se défend");
    }
    /**
     * Override de la methode mort
     */
    @Override
    public void mort(){
        System.out.println("L'ennemi est mort");
    }

    @Override
    public void interaction(Object nom) {
        System.out.println("L'ennemi interagit avec " + getNom());
    }
}


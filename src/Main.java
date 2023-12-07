import model.*;

import java.time.temporal.Temporal;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void emplacement(Joueur joueur){
        Scanner clavier = new Scanner(System.in);
        System.out.println("Que voulez faire ? \n Jouer \n Boutique \n Inventaire");
        String emplacement = clavier.next();
        while (!"Jouer".equals(emplacement) && !"Boutique".equals(emplacement) && !"Inventaire".equals(emplacement)) {
            System.out.println("Faite un choix existant \n Jouer \n Boutique \n Inventaire");
            emplacement = clavier.next();
        }
        if ("Jouer".equals(emplacement)) {
            Ennemi monster = null;
            int espece = (int) (Math.random() * 2);
            if (espece == 0) {
                int randomSlime = (int) (Math.random() * 3);
                String couleur;
                String element;
                if (randomSlime == 0) {
                    couleur = "Vert";
                    element = "Terre";
                } else if (randomSlime == 1) {
                    couleur = "Rouge";
                    element = "Feu";
                } else if (randomSlime == 2) {
                    couleur = "Bleu";
                    element = "Eau";
                } else {
                    couleur = "GOD";
                    element = "GOD";
                }
                Slime slime = new Slime("Slime de " + element, 10, 5, "Slime", "Monstre", 10, couleur, element);
                System.out.println("Vous combater un " + slime.getNom());
                monster = slime;
            } else if (espece == 1) {
                int randomGobelin = (int) (Math.random() * 3);
                String environement = "GOD";
                if (randomGobelin == 0) {
                    environement = "Plaines";
                } else if (randomGobelin == 1) {
                    environement = "Montagnes";
                } else if (randomGobelin == 2) {
                    environement = "Grottes";
                }
                Gobelin gobelin = new Gobelin("Gobelin des " + environement, 10, 5, "Gobelin", "Monstre", 10, environement);
                System.out.println("Vous combater un " + gobelin.getNom());
                monster = gobelin;
            }
            while (joueur.getPointsDeVie() > 0 && monster.getPointsDeVie() > 0) {
                System.out.println("Votre Vie : " + joueur.getPointsDeVie());
                System.out.println("Vie du monstre : " + monster.getPointsDeVie());
                System.out.println("Que voulez vous faire ? \n 1. Attaquer \n 2. Se Défendre \n 3. Ouvrir l'inventaire");
                String action = clavier.next();
                while (!"1".equals(action) && !"2".equals(action) && !"3".equals(action)) {
                    System.out.println("Veilliez choissir une action  ( marquer le nombre )");
                    action = clavier.next();
                }
                int monstreAction = (int) (Math.random() * 3);
                if ("1".equals(action)) {
                    if (monstreAction == 1){
                        System.out.println("Le monstre se defend");
                    }else {
                        joueur.attaquer(monster);
                    }
                } else if ("2".equals(action)) {
                    joueur.defendre();
                } else if ("3".equals(action)) {
                    if (joueur.getInventaire().length > 0){
                        for (int i = 0; i < joueur.getInventaire().length; i++){
                            System.out.println(joueur.getInventaire()[i].getNom() + " : " + joueur.getInventaire()[i].getDescription());
                        }
                    }else {
                        System.out.println("Votre inventaire est vide");
                    }
                }
                if (monstreAction == 0){
                    System.out.println("Le montre vous attaque");
                    if ("2".equals(action)){
                        System.out.println("Vous parer l'attaque");
                    }else {
                        monster.attaquer(joueur);
                    }
                } else if (monstreAction == 1) {
                    monster.defendre();
                } else if (monstreAction == 2){
                    System.out.println("Le monstre se repose");
                }
                if (monster.getPointsDeVie() <= 0){
                    System.out.println("Vous avez tuer le monstre");
                    System.out.println("Vous gagnez " + monster.getLoot() + " GOLD");
                    joueur.setArgent(joueur.getArgent() + monster.getLoot());
                    System.out.println("Vous avez " + joueur.getArgent() + " GOLD");
                    joueur.setPointsDeVie(20);
                }
            }
        } else if ("Boutique".equals(emplacement)) {
            Arme epee = new Arme("Epée", 1, "Ajoute +2 en attaque", 99, false, "Arme", 25, 2, "Aucun", 3, false);
            Arme bouclier = new Arme("Bouclier", 1, "Ajoute +5 en defense", 99, false, "Bouclier", 25, 0, "Aucun", 0, false);
            Potion potionDeVie = new Potion("Potion de vie", 1, "Régénère 5 point de vie", 1, true, "+5", 0);
            System.out.println("Bienvenue dans la boutique, choissisez un atricle et casser vous :");
            System.out.println("1. " + epee.getNom() + "  10 GOLD");
            System.out.println("2. " + bouclier.getNom() + "  10 GOLD");
            System.out.println("3. " + potionDeVie.getNom() + "  10 GOLD");
            String choix = clavier.next();
            while (!"1".equals(choix) && !"2".equals(choix) && !"3".equals(choix)) {
                System.out.println("Veilliez choissir un article ( marquer le nombre )");
                choix = clavier.next();
            }
            if ("1".equals(choix)){
                if (joueur.getArgent() >= 10){
                    ObjetDuJeu[] tempInv = {epee};
                    joueur.setInventaire(tempInv);
                    System.out.println("Vous avez acheter une Epee");
                    joueur.setArgent(joueur.getArgent() - 10);
                }else {
                    System.out.println("Vous n'avez pas assez d'argent pour payer");
                    System.out.println("Vous avez " + joueur.getArgent() + " GOLD");
                }
            }
        } else if ("Inventaire".equals(emplacement)) {
            System.out.println("Vous etes dans votre inventaire");
            if (joueur.getInventaire().length > 0){
                for (int i = 0; i < joueur.getInventaire().length; i++){
                    System.out.println(joueur.getInventaire()[i].getNom() + " : " + joueur.getInventaire()[i].getDescription());
                }
            }else {
                System.out.println("Votre inventaire est vide");
            }
        }
    }
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Bienvenue");
        System.out.println("Saissisez votre nom :");
        String name = clavier.next();
        System.out.println("Choissisez un classe entre : \n Guerrier \n Archer \n Tank");
        String classe = clavier.next();
        while (!"Guerrier".equals(classe) && !"Archer".equals(classe) && !"Tank".equals(classe)) {
            System.out.println("Veuillier choissir une classe qui existe");
            classe = clavier.next();
        }
        System.out.println("Choissiser une race \n Humain \n Nain \n Elfe");
        String race = clavier.next();
        while (!"Humain".equals(race) && !"Nain".equals(race) && !"Elfe".equals(race)) {
            System.out.println("Veuillier choissir une race qui existe");
            race = clavier.next();
        }
        ObjetDuJeu[] inv = {};
        Joueur joueur = new Joueur(name, 20, 2, race, classe, "Vitalite", inv, 0);
        System.out.println("Votre Personnage a été créer");
        while (joueur.getPointsDeVie() > 0){
            emplacement(joueur);
        }
    }
}
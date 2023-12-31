import model.*;
import java.io.*;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    /**
     * Méthode qui permet de faire des actions dans le jeu.
     *
     * @param joueur
     */

    public static void emplacement(Joueur joueur) {
        /** -> Commence par afficher les informations basiques du joueur (PV et Gold). */
        System.out.println("Vous avez " + joueur.getPointsDeVie() + " PV");
        System.out.println("Vous avez " + joueur.getArgent() + " GOLD");
        /**
         * -> Initialise le booléen save à true par défaut et devient faux si le joueur meurt (permettra de supprimer
         * le fichier de sauvegarde)
         */
        boolean save = true;
        /**
         *  -> Le joueur rentre l'action qu'il souhaite effectuer.
         */
        Scanner clavier = new Scanner(System.in);
        System.out.println("Que voulez vous faire ? \n Jouer \n Boutique \n Inventaire");
        String emplacement = clavier.next();
        /**
         * Vérifie que l'utilisateur rentre bien une option valable et lui redemande de rentrer son choix tant qu'il
         * n'est pas bon.
         */
        while (!"Jouer".equals(emplacement) && !"Boutique".equals(emplacement) && !"Inventaire".equals(emplacement)) {
            System.out.println("Faites un choix existant ! \n Jouer \n Boutique \n Inventaire");
            emplacement = clavier.next();
        }
        /**
         * -> Jouer lance le combat. Lorque le combat se lance, un ennemi est généré aléatoirement avec un item.
         */
        if ("Jouer".equals(emplacement)) {
            Ennemi monster = null;
            int espece = (int) (Math.random() * 2);
            int Weapon = (int) (Math.random() * 2);
            Arme epee = new Arme("Epée", 1, "Ajoute +2 en attaque", 99, false, "Arme", 25, 2, "Aucun", 3, false);
            Arme bouclier = new Arme("Bouclier", 1, "Ajoute +5 en défense", 99, false, "Bouclier", 25, 0, "Aucun", 0, false);
            ObjetDuJeu[] invMonstre = {null};
            if (Weapon == 0) {
                invMonstre[0] = epee;
            } else if (Weapon == 1) {
                invMonstre[0] = bouclier;
            }
            if (espece == 0) {
                int randomSlime = (int) (Math.random() * 3);
                String couleur;
                String element;
                int vie = 20;
                int force = 5;
                if (randomSlime == 0) {
                    couleur = "Vert";
                    element = "Terre";
                    vie += 10;
                } else if (randomSlime == 1) {
                    couleur = "Rouge";
                    element = "Feu";
                    force += 5;
                } else if (randomSlime == 2) {
                    couleur = "Bleu";
                    element = "l'Eau";
                } else {
                    couleur = "GOD";
                    element = "GOD";
                }
                Slime slime = new Slime("Slime de " + element, vie, force, "Slime", invMonstre, "Monstre", 10, couleur, element);
                System.out.println("Vous combattez un " + slime.getNom());
                monster = slime;
            } else if (espece == 1) {
                int randomGobelin = (int) (Math.random() * 3);
                String environement = "GOD";
                int vie = 10;
                int force = 11;
                if (randomGobelin == 0) {
                    environement = "Plaines";
                } else if (randomGobelin == 1) {
                    environement = "Montagnes";
                    vie += 10;
                } else if (randomGobelin == 2) {
                    environement = "Grottes";
                    force += 5;
                }
                Gobelin gobelin = new Gobelin("Gobelin des " + environement, vie, force, "Gobelin", invMonstre, "Monstre", 10, environement);
                System.out.println("Vous combater un " + gobelin.getNom());
                monster = gobelin;
            }
            /**
             *  Boucle de jeu. Tant que le joueur et le monstre sont en vie, le combat continuera.
             */
            while (joueur.getPointsDeVie() > 0 && monster.getPointsDeVie() > 0) {
                /**
                 * Affiche la vie du joueur et du monstre, et propose les options de combat. Le joueur rentre l'action
                 * qu'il souhaite effectuer.
                 */
                System.out.println("Votre vie : " + joueur.getPointsDeVie());
                System.out.println("Vie du " + monster.getNom() + " : " + monster.getPointsDeVie());
                System.out.println("Que voulez vous faire ? \n 1. Attaquer \n 2. Se défendre \n 3. Ouvrir l'inventaire");
                String action = clavier.next();
                while (!"1".equals(action) && !"2".equals(action) && !"3".equals(action)) {
                    System.out.println("Veuillez choisir une action (marquer le nombre)");
                    action = clavier.next();
                }
                /**
                 * Détermine l'action du monstre et effectue le tour.
                 */
                int monstreAction = (int) (Math.random() * 3);
                /**
                 * Tour du joueur.
                 * Le joueur attaque.
                 */
                if ("1".equals(action)) {
                    if (monstreAction == 1) {
                        System.out.println("Le monstre se défend");
                    } else {
                        joueur.attaquer(monster);
                    }
                    /**
                     * Le joueur se défend.
                     */
                } else if ("2".equals(action)) {
                    joueur.defendre();
                    /**
                     * Le joueur ouvre son inventaire.
                     */
                } else if ("3".equals(action)) {
                    if (joueur.getInventaire().length > 0) {
                        for (int i = 0; i < joueur.getInventaire().length; i++) {
                            System.out.println(joueur.getInventaire()[i].getNom() + " : " + joueur.getInventaire()[i].getDescription());
                        }
                    } else {
                        System.out.println("Votre inventaire est vide");
                    }
                }
                /**
                 * Tour du monstre.
                 * Le monstre attaque.
                 */
                if (monstreAction == 0) {
                    System.out.println("Le montre vous attaque");
                    if ("2".equals(action)) {
                        System.out.println("Vous parez l'attaque");
                    } else {
                        monster.attaquer(joueur);
                    }
                    /**
                     * Le monstre se défend.
                     */
                } else if (monstreAction == 1) {
                    monster.defendre();
                /**
                 * Le monstre ne fait rien.
                 */
                } else if (monstreAction == 2) {
                    System.out.println("Le monstre se repose");
                }
                /**
                 * Si le monstre n'a plus de PV, il meurt, le joueur gagne de l'argent et son argent s'affiche.
                 */
                if (monster.getPointsDeVie() <= 0) {
                    System.out.println("Vous avez tué le monstre");
                    if ("Humain".equals(joueur.getRace())) {
                        System.out.println("Vous gagnez " + monster.getLoot() + " GOLD. Malheureusement, les humains sont " +
                                "sujets à la TVA. Vous gagnez donc en fait " + monster.getLoot() / 2 + " GOLD !");
                        joueur.setArgent(joueur.getArgent() + monster.getLoot() / 2);
                    } else {
                        System.out.println("Vous gagnez " + monster.getLoot() + " GOLD");
                        joueur.setArgent(joueur.getArgent() + monster.getLoot());
                    }
                    System.out.println("Vous avez " + joueur.getArgent() + " GOLD");
                }
                /**
                 * Si le joueur n'a plus de PV, il meurt et la partie est finie.
                 */
                if (joueur.getPointsDeVie() <= 0) {
                    System.out.println("Le monstre vous a tué. EZ");
                    System.out.println("Votre sauvegarde est supprimée.");
                    /**
                     * Suppression de la sauvegarde.
                     */
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("save.txt"));
                        writer.write("");
                        writer.close();
                        save = false;
                    } catch (Exception e) {
                        System.out.println("Erreur avec la sauvegarde");
                    }
                }
            }
        }
        /**
         * -> Boutique ouvre la boutique.
         * Les objets sont générés et le joueur rentre le numéro de l'item qu'il souhaite acheter.
         */
        else if ("Boutique".equals(emplacement)) {
            Arme epee = new Arme("Epée", 1, "Ajoute +2 en attaque", 99, false, "Arme", 25, 2, "Aucun", 3, false);
            Arme bouclier = new Arme("Bouclier", 1, "Ajoute +10 en pv", 99, false, "Bouclier", 25, 0, "Aucun", 0, false);
            Potion potionDeVie = new Potion("Potion de vie", 1, "Régénère 5 point de vie immédiatement apres l'achat", 1, true, "+5", 0);
            System.out.println("Bienvenue dans la boutique. Vous avez " + joueur.getArgent() + " GOLD. Choisissez un article et cassez vous <3 !");
            System.out.println("1. " + epee.getNom() + "  10 GOLD ( " + epee.getDescription() +" )");
            System.out.println("2. " + bouclier.getNom() + "  10 GOLD ( " + bouclier.getDescription() + " )");
            System.out.println("3. " + potionDeVie.getNom() + "  5 GOLD ( " + potionDeVie.getDescription() + " )" );
            System.out.println("4. Quitter");
            String choix = clavier.next();
            while (!"1".equals(choix) && !"2".equals(choix) && !"3".equals(choix) && !"4".equals(choix)) {
                System.out.println("Veuillez choisir un article (marquez le nombre) !");
                choix = clavier.next();
            }
            /**
             * Si le joueur a assez de GOLD, l'achat est effectué et l'objet est placé dans l'inventaire. Sinon, un
             * message d'erreur s'affiche.
             */
            if ("1".equals(choix)) {
                if (joueur.getArgent() >= 10) {
                    ObjetDuJeu[] tempInv = {epee};
                    joueur.setInventaire(tempInv);
                    System.out.println("Vous avez acheté une Épée !");
                    joueur.setArgent(joueur.getArgent() - 10);
                } else {
                    System.out.println("Vous n'avez pas assez d'argent pour payer ! Sale pauvre !");
                    System.out.println("Vous avez " + joueur.getArgent() + " GOLD");
                }
            } else if ("2".equals(choix)) {
                if (joueur.getArgent() >= 10) {
                    ObjetDuJeu[] tempInv = {bouclier};
                    joueur.setInventaire(tempInv);
                    System.out.println("Vous avez acheté un Bouclier !");
                    joueur.setPointsDeVie(joueur.getPointsDeVie() + 10);
                    joueur.setArgent(joueur.getArgent() - 10);
                } else {
                    System.out.println("Vous n'avez pas assez d'argent pour payer ! Sale pauvre !");
                    System.out.println("Vous avez " + joueur.getArgent() + " GOLD");
                }
            } else if ("3".equals(choix)) {
                if (joueur.getArgent() >= 5) {
                    joueur.setPointsDeVie(joueur.getPointsDeVie() + 5);
                    System.out.println("Vous avez acheté une Potion. Vous la consommez et régénerez 5 PV. Vous avez " +
                            "maintenant " + joueur.getPointsDeVie() + " PV.");
                    joueur.setArgent(joueur.getArgent() - 5);
                } else {
                    System.out.println("Vous n'avez pas assez d'argent pour payer ! Sale pauvre !");
                    System.out.println("Vous avez " + joueur.getArgent() + " GOLD");
                }
            } else if ("4".equals(choix)) {
                System.out.println("Vous quitter la boutique");
            }
            /**
             * Inventaire affiche l'inventaire du joueur.
             */
        } else if ("Inventaire".equals(emplacement)) {
            System.out.println("Vous êtes dans votre inventaire !");
            if (joueur.getInventaire().length > 0) {
                for (int i = 0; i < joueur.getInventaire().length; i++) {
                    System.out.println(joueur.getInventaire()[i].getNom() + " : " + joueur.getInventaire()[i].getDescription());
                }
            } else {
                System.out.println("Votre inventaire est vide !");
            }
        }
        /**
         * Après chaque action (Combat, boutique, inventaire), la partie est sauvegardée.
         */
        if (save) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("save.txt"));
                writer.write("Nom : " + joueur.getNom());
                writer.write(";\nClasse : " + joueur.getClasse());
                writer.write(";\nRace : " + joueur.getRace());
                writer.write(";\nArgent : " + joueur.getArgent());
                writer.write(";\nVie : " + joueur.getPointsDeVie());
                writer.write(";\nForce : " + joueur.getForce());
                writer.close();
                System.out.println("Sauvegarde effectuée !");
            } catch (Exception e) {
                System.out.println("Erreur avec la sauvegarde.");
            }
        }
    }

    /**
     * Méthode principale : lance l'initialisation du joueur et le fait jouer tant qu'il est vivant.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        String result = "";
        Joueur joueur = null;
        /**
         * Si un fichier sauvegarde existe, il est lu ligne par ligne et écrit dans la variable result.
         */
        try {
            File file = new File("save.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("Il y a eu une erreur lors de la lecture du fichier de sauvegarde.");
        }
        /**
         * Si aucun fichier sauvegarde n'a été trouvé, le joueur initialise son personnage.
         */
        if (result == "") {
            System.out.println("Bienvenue");
            System.out.println("Saissisez votre nom :");
            String name = clavier.next();
            System.out.println("Choisissez une classe : \n - Guerrier \n - Archer \n - Tank");
            String classe = clavier.next();
            while (!"Guerrier".equals(classe) && !"Archer".equals(classe) && !"Tank".equals(classe)) {
                System.out.println("Veuillez choisir une classe qui existe.");
                classe = clavier.next();
            }
            System.out.println("Choisissez une race : \n - Humain \n - Nain \n - Elfe");
            String race = clavier.next();
            while (!"Humain".equals(race) && !"Nain".equals(race) && !"Elfe".equals(race)) {
                System.out.println("Veuillez choisir une race qui existe.");
                race = clavier.next();
            }
            ObjetDuJeu[] inv = {};
            int life = 20;
            int strenght = 2;
            int argent = 0;
            if ("François".equals(name)) {
                strenght += 100;
            }
            if ("Guerrier".equals(classe)) {
                life += 5;
                strenght += 5;
            } else if ("Archer".equals(classe)) {
                life -= 5;
                strenght += 7;
            } else if ("Tank".equals(classe)) {
                life += 20;
                strenght += 1;
            }

            if ("Humain".equals(race)) {
                life += 5;
                strenght += 1;
                argent -= 10;
            } else if ("Nain".equals(race)) {
                strenght += 6;
                argent += 10;
            } else if ("Elfe".equals(race)) {
                life += 10;
                strenght += 2;
            }
            joueur = new Joueur(name, life, strenght, race, classe, "Vitalite", inv, argent);
            System.out.println("Votre Personnage a été créé !");
            /**
             * Si un fichier sauvergarde a été trouvé, les infos sont rangées dans un array et utilisées pour initialiser
             * le joueur.
             */
        } else {
            String[] resultArray = result.split(";");
            for (int i = 0; i < resultArray.length; i++) {
                String[] temp = resultArray[i].split(" : ");
                resultArray[i] = temp[temp.length - 1];
            }
            ObjetDuJeu[] inv = {};
            joueur = new Joueur(resultArray[0], Integer.parseInt(resultArray[4]), Integer.parseInt(resultArray[5]), resultArray[2], resultArray[1], "Vitalite", inv, Integer.parseInt(resultArray[3]));
            System.out.println("Bienvenue " + joueur.getNom() + " ! ");
        }
        if ("François".equals(joueur.getNom())) {
            System.out.println("Par votre grand charisme, vous gagnez 100 points de force ! Vous avez donc : " + joueur.getForce());
        }
        if("Rick".equals(joueur.getNom())){
            redirectToWebPage("https://www.youtube.com/watch?v=xvFZjo5PgG0");
        }
        while (joueur.getPointsDeVie() > 0) {
            emplacement(joueur);
        }
    }

    private static void redirectToWebPage(String url) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
                URI uri = new URI(url);
                desktop.browse(uri);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            // Handle the exception (e.g., log, display an error message, etc.)
        }
    }
}
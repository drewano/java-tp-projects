/**
 * Point d'entrée du programme de gestion simplifiée de médiathèque.
 * Cette classe gère l'interface console : menu, saisie utilisateur, etc.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //Initialisation de la médiathèque et du scanner
        Scanner scanner = new Scanner(System.in);
        Mediatheque mediatheque = new Mediatheque();

        boolean quitter = false;
        while (!quitter) {
            afficherMenu();
            System.out.print("Votre choix : ");

            //Gestion des erreurs de saisie
            int choix;
            try {
                choix = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Vous devez saisir un nombre entier. Veuillez réessayer.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (choix) {
                case 1:
                    //Ajouter un nouveau media
                    ajouterNouveauMedia(scanner, mediatheque);
                    break;
                case 2:
                    //Afficher la médiathèque
                    System.out.println("--- Contenu de la médiathèque ---");
                    mediatheque.afficherMediatheque();
                    System.out.println("---------------------------------");
                    break;
                case 3:
                    //Afficher le prix total des DVD
                    System.out.println("Prix total des DVD : " + mediatheque.calculerPrixTotalDVD());
                    break;
                case 4:
                    //Afficher le prix total des CD
                    System.out.println("Prix total des CD : " + mediatheque.calculerPrixTotalCD());
                    break;
                case 5:
                    //Afficher le prix total des Livres
                    System.out.println("Prix total des Livres : " + mediatheque.calculerPrixTotalLivre());
                    break;
                case 6:
                    //Afficher le prix total de la médiathèque
                    System.out.println("Prix total de la médiathèque : " + mediatheque.calculerPrixTotal());
                    break;
                case 7:
                    //Quitter
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }
    //Affiche le menu de l'application
    private static void afficherMenu() {
        System.out.println("1. Ajouter un nouveau media");
        System.out.println("2. Afficher la médiathèque");
        System.out.println("3. Afficher le prix total des DVD");
        System.out.println("4. Afficher le prix total des CD");
        System.out.println("5. Afficher le prix total des Livres");
        System.out.println("6. Afficher le prix total de la médiathèque");
        System.out.println("7. Quitter");
    }
    //Ajoute un nouveau media à la médiathèque
    private static void ajouterNouveauMedia(Scanner scanner, Mediatheque mediatheque) {
        System.out.println("Quel type de media voulez-vous ajouter ?");
        System.out.println("1. DVD\n2. Livre\n3. CD");
        System.out.print("Votre choix : ");

        //Gestion des erreurs de saisie pour le choix du type de media
        int choix;
        try {
            choix = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Vous devez saisir un nombre entier. Retour au menu principal.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        //Saisie des informations du media
        switch (choix) {
            case 1:
                //Ajout d'un DVD
                System.out.print("Titre DVD : ");
                String titreDVD = scanner.nextLine();
                System.out.print("Nom du réalisateur : ");
                String nomRealisateur = scanner.nextLine();
                System.out.print("Durée (en minutes) : ");
                //Gestion des erreurs de saisie pour la durée
                int duree;
                try {
                    duree = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Erreur : La durée doit être un nombre entier. Opération annulée.");
                    scanner.nextLine();
                    return;
                }
                System.out.print("Prix TTC : ");
                double prixDVD;
                try {
                    prixDVD = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Erreur : Le prix doit être un nombre (décimal). Opération annulée.");
                    scanner.nextLine();
                    return;
                }
                DVD dvd = new DVD(titreDVD, prixDVD, nomRealisateur, duree);
                mediatheque.ajouterMedia(dvd);
                System.out.println("DVD ajouté avec succès.");
                break;

            //Ajout d'un livre
            case 2:
                //Ajout d'un livre
                System.out.print("Titre du Livre : ");
                String titreLivre = scanner.nextLine();
                System.out.print("Nom de l'auteur : ");
                String nomAuteur = scanner.nextLine();
                System.out.print("Nombre de pages : ");
                //try and catch
                int nbPages;
                try {
                    nbPages = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Erreur : Le nombre de pages doit être un nombre entier. Opération annulée.");
                    scanner.nextLine();
                    return;
                }
                System.out.print("Prix TTC : ");
                //try and catch
                double prixLivre;
                try {
                    prixLivre = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Erreur : Le prix doit être un nombre (décimal). Opération annulée.");
                    scanner.nextLine();
                    return;
                }

                Livre livre = new Livre(titreLivre, prixLivre, nomAuteur, nbPages);
                mediatheque.ajouterMedia(livre);
                System.out.println("Livre ajouté avec succès.");
                break;

            //Ajout d'un CD
            case 3:
                //Ajout d'un CD
                System.out.print("Titre du CD : ");
                String titreCD = scanner.nextLine();
                System.out.print("Nom de l'interprète : ");
                String nomInterprete = scanner.nextLine();
                System.out.print("Nombre de chansons : ");
                //try and catch
                int nbChansons;
                try {
                    nbChansons = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Erreur : Le nombre de chansons doit être un nombre entier. Opération annulée.");
                    scanner.nextLine();
                    return;
                }
                System.out.print("Prix TTC : ");
                //try and catch
                double prixCD;
                try {
                    prixCD = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Erreur : Le prix doit être un nombre (décimal). Opération annulée.");
                    scanner.nextLine();
                    return;
                }
                CD cd = new CD(titreCD, prixCD, nomInterprete, nbChansons);
                mediatheque.ajouterMedia(cd);
                System.out.println("CD ajouté avec succès.");
                break;

            //Choix invalide
            default:
                System.out.println("Choix invalide.");
                break;
        }
    }
}
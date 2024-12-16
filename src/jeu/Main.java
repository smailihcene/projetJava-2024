/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author houda
 */
public class Main {

    public static void main(String[] args) {
        PlateauDeJeu plateau = new PlateauDeJeu();
        Scanner scanner = new Scanner(System.in);
        List<Joueur> joueurs = new ArrayList<>();

        // Demander le nombre de joueurs
        System.out.print("Entrez le nombre de joueurs (1 à 4) : ");
        int nombreDeJoueurs = scanner.nextInt();
        while (nombreDeJoueurs < 1 || nombreDeJoueurs > 4) {
            System.out.print("Nombre invalide ! Veuillez entrer entre 2 et 4 : ");
            nombreDeJoueurs = scanner.nextInt();
        }

        // Initialiser les joueurs
        for (int i = 1; i <= nombreDeJoueurs; i++) {
            joueurs.add(new Joueur(plateau, i)); // Identifiant pour chaque joueur
        }

        System.out.println("Déplacez les joueurs pour atteindre la sortie !");
        int joueurActuel = 0;

        // Boucle principale du jeu
        while (true) {
            Joueur joueur = joueurs.get(joueurActuel);
            System.out.println("\nC'est le tour du joueur " + joueur.getId());
            plateau.afficherPlateau(joueurs);

            System.out.println("Déplacer (z: haut , s: bas, d: droite, q: gauche) :");
            char direction = scanner.next().charAt(0);

            if (joueur.deplacer(direction)) {
                // Vérifier si le joueur a atteint la sortie
                if (plateau.estSortie(joueur.getX(), joueur.getY())) {
                    System.out.println("Félicitations Joueur " + joueur.getId() + " ! Vous avez atteint la sortie !");
                    break;
                }
            }

            // Passer au joueur suivant
            joueurActuel = (joueurActuel + 1) % joueurs.size();
        }

        scanner.close();

    }

}

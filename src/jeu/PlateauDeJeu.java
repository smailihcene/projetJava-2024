/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeu;

import java.util.List;

/**
 *
 * @author alexi
 */
public class PlateauDeJeu {

    public int[][] plateau;
    private static final int colonne = 17;
    private static final int ligne = 11;
    private static final int caseDecor = 0;
    private static final int caseJeu = 1;
    private static final int caseSortie = 2;
    private static final int caseEntree = -1;
    private static final int caseFlaque = -2; // prq ces donnes ?
    private static final int caseBloc = 3; // sa aussi

    public PlateauDeJeu() {
        System.out.println("Initialisation du plateau avec dimensions : " + ligne + " x " + colonne);
        plateau = new int[ligne][colonne]; // Initialisation du tableau
        initialisationPlateau(); // Appel de la méthode pour initialiser le plateau
    }

    public void initialisationPlateau() {
        // Initialisation de toutes les cases à caseJeu
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                plateau[i][j] = caseJeu;
            }
        }

        // Définir les cases décor et spéciales
        for (int i = 0; i < ligne; i++) {
            plateau[i][0] = caseDecor;
        }

        for (int i = 13; i < colonne; i++) {
            plateau[0][i] = caseDecor;
        }

        for (int i = 14; i < colonne; i++) {
            plateau[1][i] = caseDecor;
        }

        for (int i = 15; i < colonne; i++) {
            plateau[2][i] = caseDecor;
        }

        for (int i = 16; i < colonne; i++) {
            plateau[3][i] = caseDecor;
        }

        for (int i = 7; i < ligne; i++) {
            plateau[i][1] = caseDecor;
        }

        for (int i = 8; i < ligne; i++) {
            plateau[i][2] = caseDecor;
        }

        for (int i = 9; i < ligne; i++) {
            plateau[i][3] = caseDecor;
        }

        for (int i = 10; i < ligne; i++) {
            plateau[i][4] = caseDecor;
        }

        plateau[0][0] = caseSortie; // Case de sortie
        plateau[10][16] = caseEntree; // Case d'entrée
        // Case de bloc
        plateau[8][15] = caseBloc;
        plateau[7][12] = caseBloc;
        plateau[5][14] = caseBloc;
        plateau[3][13] = caseBloc;
        plateau[9][9] = caseBloc;
        plateau[9][6] = caseBloc;
        plateau[7][5] = caseBloc;
        plateau[5][9] = caseBloc;
        plateau[6][7] = caseBloc;
        plateau[4][8] = caseBloc;
        plateau[2][3] = caseBloc;
        // Case de flaque de sang (carrée)
        plateau[3][10] = caseFlaque;
        plateau[3][9] = caseFlaque;
        plateau[2][10] = caseFlaque;
        plateau[2][9] = caseFlaque;
        // Case de flaque de sang (ligne)
        plateau[8][8] = caseFlaque;
        plateau[8][7] = caseFlaque;
        plateau[8][6] = caseFlaque;
        plateau[8][5] = caseFlaque;

    }

    public void afficherPlateau(List<Joueur> joueurs) {
        // Affichage du plateau avec la position des joueurs
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                boolean joueurTrouve = false;

                // Vérifier si un joueur est sur cette case
                for (Joueur joueur : joueurs) {
                    if (joueur.getX() == i && joueur.getY() == j) {
                        System.out.print(joueur.getId() + " "); // Affiche l'identifiant du joueur
                        joueurTrouve = true;
                        break;
                    }
                }

                if (!joueurTrouve) {
                    if (plateau[i][j] == caseSortie) {
                        System.out.print("S "); // Affiche la sortie
                    } else if (plateau[i][j] == caseEntree) {
                        System.out.print("E "); // Affiche l'entrée
                    } else if (plateau[i][j] == caseDecor) {
                        System.out.print("D "); // Affiche le décor
                    } else if (plateau[i][j] == caseFlaque) {
                        System.out.print("F "); // Affiche les flaques de sang
                    } else if (plateau[i][j] == caseBloc) {
                        System.out.print("B "); // Affiche un bloc
                    } else {
                        System.out.print(". "); // Affiche une case normale
                    }
                }
            }
            System.out.println();
        }
    }

    public boolean estPositionValide(int x, int y) {
        // Vérifier si la position est dans les limites et non une case décor
        return x >= 0 && x < ligne && y >= 0 && y < colonne && plateau[x][y] != caseDecor;
    }

    public boolean estSortie(int x, int y) {
        return plateau[x][y] == caseSortie;
    }

    public boolean estFlaque(int x, int y) {
        // Vérifie si une case correspond à une flaque de sang
        return (x >= 0 && x < ligne && y >= 0 && y < colonne && plateau[x][y] == caseFlaque);
    }

    public boolean estBloc(int x, int y) {
        // Vérifie si une case correspond à un bloc
        return (x >= 0 && x < ligne && y >= 0 && y < colonne && plateau[x][y] == caseBloc);
    }
}

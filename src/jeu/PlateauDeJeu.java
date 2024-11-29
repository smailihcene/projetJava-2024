/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeu;

/**
 *
 * @author alexi
 */
public class PlateauDeJeu {
    private int[][] plateau;
    private static final int colonne = 17; 
    private static final int ligne = 11;   
    private static final int caseDecor = 0;
    private static final int caseJeu = 1;
    private static final int caseSortie = 2;
    private static final int caseEntree = -1;
    
     public PlateauDeJeu() {
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


        // Définir les cases de la première colonne comme caseDecor
        for (int i = 0; i < ligne; i++) {
            plateau[i][0] = caseDecor;
        }


        // Définir les cases décor dans les colonnes à partir de la ligne 1
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
        plateau[10][16] = caseEntree; // Case d'entrée (indices corrigés)
    }


    public void afficherPlateau() {
        // Affichage du plateau
        for (int i = 0; i < ligne; i++) { 
            for (int j = 0; j < colonne; j++) { 
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println(); 
        }
    }
}

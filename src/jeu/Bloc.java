/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeu;

/**
 *
 * @author cheim
 */
public class Bloc {

    private PlateauDeJeu plateau;

    public Bloc(PlateauDeJeu plateau) {
        this.plateau = plateau;
    }

    /**
     * Permet de pousser un bloc dans une direction donnée.
     *
     * @param joueur Le joueur qui pousse le bloc.
     * @param direction La direction dans laquelle pousser (Position.HAUT,
     * Position.BAS, Position.GAUCHE, Position.DROITE).
     */
    public void pousser(Joueur joueur, int direction) {
        int joueurX = joueur.getX();
        int joueurY = joueur.getY();

        // Calculer la position du bloc, qui est supposée être la même que celle du joueur
        int blocX = joueurX;
        int blocY = joueurY;

        // Calculer la position de la case où le bloc sera poussé (case cible)
        int cibleX = blocX;
        int cibleY = blocY;

        // Calculer la nouvelle position cible du bloc en fonction de la direction
        switch (direction) {
            case Position.HAUT: // Haut
                cibleX -= 1;
                break;
            case Position.BAS: // Bas
                cibleX += 1;
                break;
            case Position.GAUCHE: // Gauche
                cibleY -= 1;
                break;
            case Position.DROITE: // Droite
                cibleY += 1;
                break;
            default:
                System.out.println("Direction invalide ! Utilisez Position.HAUT, Position.BAS, Position.GAUCHE ou Position.DROITE.");
                return;
        }

        // Vérifier si la case cible est valide et vide (non occupée par un autre bloc, décor, etc.)
        if (plateau.estPositionValide(cibleX, cibleY) && plateau.plateau[cibleX][cibleY] == 1) {
            // La case cible est valide et vide, on peut y déplacer le bloc
            plateau.plateau[blocX][blocY] = 1; // La case d'origine du bloc devient une case normale
            plateau.plateau[cibleX][cibleY] = 3; // La case cible devient un bloc

            System.out.println("Le joueur " + joueur.getId() + " pousse le bloc vers (" + cibleX + ", " + cibleY + ")");
        } else {
            // La case cible est invalide ou déjà occupée
            System.out.println("Le bloc ne peut pas être poussé dans cette direction !");
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeu;

/**
 *
 * @author cheim
 */
public class Flaque {

    private PlateauDeJeu plateau;

    public Flaque(PlateauDeJeu plateau) {
        this.plateau = plateau;
    }

    /**
     * Méthode pour gérer le glissement du joueur sur une flaque de sang. Le
     * joueur glisse dans la direction donnée jusqu'à une case valide.
     *
     * @param joueur Le joueur en train de glisser.
     * @param direction La direction initiale.
     */
    public void glisser(Joueur joueur, char direction) {
        int x = joueur.getX();
        int y = joueur.getY();

        switch (direction) {
            case 'z': // Haut
                while (plateau.estFlaque(x - 1, y)) {
                    x--; // Continue de glisser sur la flaque
                }
                // S'arrêter à la première case valide après la flaque
                if (plateau.estPositionValide(x - 1, y)) {
                    x--; // Arrêter le glissement ici
                }
                break;

            case 's': // Bas
                while (plateau.estFlaque(x + 1, y)) {
                    x++; // Continue de glisser sur la flaque
                }
                // S'arrêter à la première case valide après la flaque
                if (plateau.estPositionValide(x + 1, y)) {
                    x++; // Arrêter le glissement ici
                }
                break;

            case 'q': // Gauche
                while (plateau.estFlaque(x, y - 1)) {
                    y--; // Continue de glisser sur la flaque
                }
                // S'arrêter à la première case valide après la flaque
                if (plateau.estPositionValide(x, y - 1)) {
                    y--; // Arrêter le glissement ici
                }
                break;

            case 'd': // Droite
                while (plateau.estFlaque(x, y + 1)) {
                    y++; // Continue de glisser sur la flaque
                }
                // S'arrêter à la première case valide après la flaque
                if (plateau.estPositionValide(x, y + 1)) {
                    y++; // Arrêter le glissement ici
                }
                break;

            default:
                System.out.println("Direction invalide !");
                return;
        }

        // Le joueur s'arrête après avoir glissé et atteint la première case valide après la flaque
        joueur.setPosition(x, y);
        System.out.println("Le joueur " + joueur.getId() + " a glissé jusqu'à (" + x + ", " + y + ")");

    }
}

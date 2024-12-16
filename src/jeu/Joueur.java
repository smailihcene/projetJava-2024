/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeu;

/**
 *
 * @author cheim
 */
public class Joueur {

    private int x, y; // Position actuelle du joueur
    private PlateauDeJeu plateau;
    private int id; // Identifiant du joueur

    public Joueur(PlateauDeJeu plateau, int id) {
        this.plateau = plateau;
        this.id = id;
        this.x = 10; // Position d'entrée (ligne)
        this.y = 16; // Position d'entrée (colonne)
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean deplacer(char direction) {
        int nouveauX = x, nouveauY = y;

        // Calculer la position cible
        switch (direction) {
            case 'z':
                nouveauX--;
                break;
            case 's':
                nouveauX++;
                break;
            case 'q':
                nouveauY--;
                break;
            case 'd':
                nouveauY++;
                break;
            default:
                System.out.println("Direction invalide !");
                return false;
        }

        // Vérifier si la case cible contient un bloc
        if (plateau.estBloc(nouveauX, nouveauY)) {
            int blocX = nouveauX;
            int blocY = nouveauY;

            // Calculer la position où le bloc sera poussé
            switch (direction) {
                case 'z':
                    blocX--;
                    break;
                case 's':
                    blocX++;
                    break;
                case 'q':
                    blocY--;
                    break;
                case 'd':
                    blocY++;
                    break;
            }

            // Vérifier si la position de poussée est valide
            if (plateau.estPositionValide(blocX, blocY) && plateau.plateau[blocX][blocY] == 1) {
                // Déplacer le bloc
                plateau.plateau[nouveauX][nouveauY] = 1; // La case où était le bloc devient normale
                plateau.plateau[blocX][blocY] = 3; // La nouvelle case devient un bloc

                // Déplacer le joueur
                x = nouveauX;
                y = nouveauY;

                System.out.println("Joueur " + id + " pousse le bloc vers (" + blocX + ", " + blocY + ")");
                return true;
            } else {
                System.out.println("Impossible de pousser le bloc ! Case cible invalide ou occupée.");
                return false;
            }
        }

        // Vérifier si le déplacement est possible sans bloc
        if (plateau.estPositionValide(nouveauX, nouveauY)) {
            x = nouveauX;
            y = nouveauY;
            System.out.println("Joueur " + id + " déplacé en (" + x + ", " + y + ")");

            // Vérifier si le joueur se trouve sur une flaque et gérer le glissement
            if (plateau.estFlaque(x, y)) {
                Flaque flaque = new Flaque(plateau);
                flaque.glisser(this, direction);
            }
            return true;
        } else {
            System.out.println("Déplacement impossible pour le joueur " + id + ".");
            return false;
        }
    }
}

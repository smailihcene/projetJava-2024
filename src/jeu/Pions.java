/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeu;

/**
 *
 * @author alexi
 */
public class Pions {
    private final String id;
    private int x, y;
    private int valeurFaceBlanche;
    private int valeurFaceNoire;
    private boolean faceBlancheActive;
    private boolean estsorti;

    public Pions(String id, int valeurFaceBlanche, int valeurFaceNoire) {
        this.id = id;
        //les différentes faces du pions:
        this.valeurFaceBlanche = valeurFaceBlanche;
        this.valeurFaceNoire = valeurFaceNoire;
        this.faceBlancheActive = true;
    }

    //On regarde la valeur de la face du pion 
    public int getValeurDeplacement() {
        
        return faceBlancheActive ? valeurFaceBlanche : valeurFaceNoire;
    }

    public void retournerFace() {
        //faoire un if chaque tour 
        faceBlancheActive = !faceBlancheActive;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getId() {
        return id;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author houda
 */
public class Tuile extends Jeu{
    //
    private int valeur; //le nbr de cases à parcourir ou nbr de proies à dévorer une ou deux 
    private boolean estProie;  //si la tuile est une carte pour dévorer une ou deux proies 
    private static ArrayList<Tuile> pile; // Pile des tuiles pour pioche en static car il n'y a qu'une seule pile pour les tuiles 

    //constructeur
    public Tuile(int valeur , boolean estProie) {
        this.valeur = valeur;
        this.estProie = estProie;
         
    }
    
    //ça indique si la tuile piochéé est une proie
    public boolean estProie(){
        return estProie; //true si la tuile indique une proie sinon False
    }
    //on retourne la valeur de la tuile 
    private int getValeur() {
            return valeur; 
        }
    
    public ArrayList<Tuile> getPile(){
        return pile; 
    }
    
    //méthode pour initialiser les pile en static car la pile est partagé avec toutes les tuiles 
    public static void initPile(){
        pile = new ArrayList<>();  //on créer une nouvelle pile 

        // Tuiles normales
        int[] valeursNormales = {5, 7, 7,8, 8, 10};
        for (int valeur : valeursNormales) {
            Tuile tuile = new Tuile (valeur, false);//donc une tuile normale n'est pas une proie
            pile.add(tuile); 
        }
        //on ajoute directement les tuile dans le tas 
        // Tuiles spéciales; les proies
        int[] valeursProies = {1, 2};
        for (int valeur : valeursProies) {
            Tuile tuile = new Tuile(valeur, true);
            pile.add(tuile); 
        }
        melangerPile();  //on mélange alétoirement les tuiles 
    }
    
    //méthode pour mélanger les tuiles dans la pile
    public static void melangerPile(){
        if (pile != null) { // on vérifie si la pile n'est pas vide
            do {
                Collections.shuffle(pile); // Mélange aléatoire
            } while (pile.get(0).estProie()); // on remélanger les tuiles si la première tuile est une proie ou deux proies
        }
    
    }
    
    
    //méthode pour piocher les tuiles 
    public static Tuile piocherTuile(){
       if(pile.isEmpty()){
           throw new IllegalStateException("La pile de tuiles est vide"); 
       }
     return pile.remove(0); //on pioche la premier tuile du tas 
    }
    
    @Override
    public String toString() {
        if (estProie) {
            return (valeur == 1) ? "Une proie" : valeur + " proies";
        } else {
            return valeur + " pas";
        }
    }
    
//    //tester le code 
//   public static void main(String[] args) {
//        Tuile.initPile(); //on appelle la méthode pour créer et remplir la pile 
//    
//    // Afficher les tuiles dans la pile
//        System.out.println("Tuiles dans la pile :");
//        Tuile.pile.forEach(System.out::println);
//    }
   
    
   
   
}

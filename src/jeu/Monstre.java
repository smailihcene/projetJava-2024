/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeu;

/**
 *
 * @author cheim
 */
public class Monstre {

    private String monstre;
    private String monstre;
    private int x,y;
    private String direction;
    private static ArrayList<Tuile> tuiles;
           
    
    public Monstre(int x, int y, String direction){
        this.x=x;
        this.y=y;
        this.direction=direction;
    }


    //essayez voir si ça fonctionne perso moi non je cherche l'erreur
    public deplacement(Plateau plateau){
        int mouvement=piocherTuiles();
        while(mouvement>0){
            List<Pion>pionsvisibles=trouverProiesVisibles(pions, plateau);
            
            if(!proiesVisibles.isEmpty()){
                Pion cible=choisirProie(proiesVisibles);
                seDirigerVers(cible,plateau);
            }else{
                continuerToutDRoit(plateau);
            }
            mouvement--;
            }
        }
    }

// fonction qui permet de chercher devant lui ou ses côtés les proies
    public List<Pion>trouverProiesVisible(List<Pion>, pions, Plateau plateau){
        List<Pion>proies=new ArrayList<>();
        int [][] directions={ 
            {0, -1}, //nord
            {1,0}, //est
            {0,1}, //sud
            {-1,0} //ouest
        };
        for(int i=-1;i<=1,i++){
            int directionIndex=(getDirectionIndex() + i + 4) % 4;
            int dx = directions[directionIndex][0];
            int dy = directions[directionIndex][1];

            int currentX = x;
            int currentY = y;

            while (plateau.estDansLesLimites(currentX, currentY)) {
                currentX += dx;
                currentY += dy;
                if (!plateau.estLibre(currentX, currentY)) break;

                Pion pion = plateau.getPion(currentX, currentY);
                if (pion != null) {
                    proies.add(pion);
                    break;
                }
            }
        }
        return proies;
    }

//direction du tableau 
    private int getDirectionIndex() {
        switch (direction) {
            case "NORD": return h;
            case "EST": return d;
            case "SUD": return b;
            case "OUEST": return g;
            default: throw new IllegalStateException("Direction invalide");
        }
    }
//lorqu'il voit plusieurs proies, il cherche à faire un choix
    private Pion choisirProie(List<Pion> proies) {
        Pion cible = null;
        int distanceMin = Integer.MAX_VALUE;

        for (Pion proie : proies) {
            int distance = Math.abs(x - proie.getX()) + Math.abs(y - proie.getY());
            if (distance < distanceMin) {
                distanceMin = distance;
                cible = proie;
            }
        }

        return cible;
    }

//fonction pour qu'il se dirige vers la cible la plus près
    private void seDirigerVers(Pion cible, Plateau plateau) {
        if (cible.getX() > x) {
            direction = "EST";
            x++;
        } else if (cible.getX() < x) {
            direction = "OUEST";
            x--;
        } else if (cible.getY() > y) {
            direction = "SUD";
            y++;
        } else if (cible.getY() < y) {
          direction = "NORD";
            y--;
        }

    }

//dévorer
}

package miniprojet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Miniprojet {

    public static void main(String[] args) {
        
        String[] couleurs = {"a", "b", "c", "d", "e", "f", "g", "h"};

       
        ArrayList<String> combinaison = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            combinaison.add(couleurs[random.nextInt(couleurs.length)]);
        }

       
        Scanner scanner = new Scanner(System.in);

        boolean gagne = false; 
        int essai = 0; 
        System.out.println(combinaison.toString());

        
        while (!gagne) {
            essai++; 
            
            ArrayList<String> tableau = new ArrayList<>();

            
            System.out.println("Essai " + essai + ": Veuillez entrer 4 valeurs parmi : a, b, c, d, e, f, g, h");

            
            for (int i = 0; i < 4; i++) {
                System.out.print("Valeur " + (i + 1) + " : ");
                tableau.add(scanner.nextLine());
            }

            
            int exact = 0;
            int bonneValeur = 0;

         
            ArrayList<String> copieCombinaison = new ArrayList<>(combinaison);

            
            for (int i = 0; i < 4; i++) {
                if (tableau.get(i).equals(copieCombinaison.get(i))) {
                    exact++;
                    tableau.set(i, null); 
                    copieCombinaison.set(i, null); 
                }
            }

           
            for (String valeur : tableau) {
                if (valeur != null && copieCombinaison.contains(valeur)) {
                    bonneValeur++;
                    copieCombinaison.set(copieCombinaison.indexOf(valeur), null); // Marquer comme utilisée
                }
            }

            
            System.out.println("Nombre de valeurs exactes : " + exact);
            System.out.println("Nombre de bonnes valeurs : " + bonneValeur);

            if (exact == 4) {
                System.out.println("Félicitations ! Vous avez gagné !");
                gagne = true; // L'utilisateur a gagné
            } else {
                System.out.println("Essayez encore !");
            }
        }

        
        System.out.println("La combinaison était : " + combinaison);
        System.out.println("Nombre total d'essais : " + essai);
    }
}




        
    
    


    
    


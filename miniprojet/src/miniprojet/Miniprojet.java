/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author eloi
 */
public class Miniprojet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Définir les couleurs possibles
        String[] couleurs = {"a", "b", "c", "d", "e", "f", "g", "h"};

        // Créer un tableau dynamique
        ArrayList<String> Combinaison = new ArrayList<>();

        // Générateur de nombres aléatoires
        Random random = new Random();

        // Ajouter 4 couleurs aléatoires
        for (int i = 0; i < 4; i++) {
            // Générer un index aléatoire entre 0 et la longueur du tableau de couleurs
            int indexAleatoire = random.nextInt(couleurs.length);

            // Ajouter la couleur correspondante au tableau dynamique
            Combinaison.add(couleurs[indexAleatoire]);
        }

         // Créer un tableau pour stocker les valeurs
        ArrayList<String> tableau = new ArrayList<>();

        // Créer un Scanner pour lire l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de saisir 4 valeurs
        System.out.println("Veuillez entrer 4 valeurs :");

        // Boucle pour remplir le tableau
        for (int i = 0; i < tableau.size(); i++) {
            System.out.print("Valeur " + (i + 1) + " : ");
            tableau.add(scanner.nextLine()); // Lire la valeur et l'ajouter dans le tableau
        }

        // Afficher les valeurs saisies
        
        for (int i = 0; i <4; i++) {
            
            while(tableau!=Combinaison){
                System.out.println("\nLe tableau entier est : " +tableau.toString());
            System.out.println("\nLe tableau entier n'est pas la bon ");
                for (int j = 0; j <4; j++) {
            System.out.print("Valeur " + (j + 1) + " : ");
            tableau.add(scanner.nextLine());
            
                    
              
            
            }
            
        }
      System.out.println("\nLe tableau entier est : " +tableau.toString()); 
      System.out.println("\nLe tableau aléatoire est : " + Combinaison.toString());
    }
}
}



        
    
    


    
    


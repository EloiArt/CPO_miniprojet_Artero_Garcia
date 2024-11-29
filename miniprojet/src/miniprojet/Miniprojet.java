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

        // Générer une combinaison aléatoire de 4 couleurs
        ArrayList<String> combinaison = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            combinaison.add(couleurs[random.nextInt(couleurs.length)]);
        }

        // Créer un tableau pour stocker les entrées utilisateur
        ArrayList<String> tableau = new ArrayList<>();

        // Créer un Scanner pour lire l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de saisir 4 valeurs
        System.out.println("Veuillez entrer 4 valeurs parmi : a, b, c, d, e, f, g, h");
        System.out.println( combinaison);
        // Lire les valeurs utilisateur
        for (int i = 0; i < 4; i++) {
            System.out.print("Valeur " + (i + 1) + " : ");
            tableau.add(scanner.nextLine());
        }

        // Vérification des résultats
        int exact = 0;
        int bonneValeur = 0;

        // Créer une copie de la combinaison pour manipulation
        ArrayList<String> copieCombinaison = new ArrayList<>(combinaison);

        // Vérifier les positions exactes
        for (int i = 0; i < 4; i++) {
            if (tableau.get(i).equals(copieCombinaison.get(i))) {
                exact++;
                tableau.set(i, null); // Marquer comme utilisée
                copieCombinaison.set(i, null); // Marquer comme utilisée
            }
        }

        // Vérifier les bonnes couleurs restantes
        for (String valeur : tableau) {
            if (valeur != null && copieCombinaison.contains(valeur)) {
                bonneValeur++;
                copieCombinaison.set(copieCombinaison.indexOf(valeur), null); // Marquer comme utilisée
            }
        }

        // Afficher les résultats
        System.out.println("Nombre de valeurs exactes : " + exact);
        System.out.println("Nombre de bonnes valeurs : " + bonneValeur);

        if (exact == 4) {
            System.out.println("Félicitations ! Vous avez gagné !");
        } else {
            System.out.println("Essayez encore ! La combinaison était : " + combinaison);
        }
    } 
    
   
}




        
    
    


    
    


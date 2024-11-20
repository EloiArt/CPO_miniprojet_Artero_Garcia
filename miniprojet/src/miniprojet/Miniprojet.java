/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;
import java.util.Random;

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

        // Afficher le contenu du tableau dynamique
        System.out.println("Tableau dynamique de couleurs aléatoires : " + Combinaison);
    }
}

while false 

        
    
    


    
    


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
        // Tableau intermédiaire
       ArrayList<String> tabInter= new ArrayList<>();
       tabInter=tableau;

        // Créer un Scanner pour lire l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de saisir 4 valeurs
        System.out.println("Veuillez entrer 4 valeurs :");
        System.out.println(Combinaison);

        // Boucle pour remplir le tableau
        for (int i = 0; i <4; i++) {
            System.out.print("Valeur " + (i + 1) + " : ");
            tableau.add(scanner.nextLine()); // Lire la valeur et l'ajouter dans le tableau
        }
    System.out.println("le tableau est "+tableau);
    int exact=0;
 
    
    for(int j=0;j<tableau.size();j++){
        if(tableau.get(j).equals(Combinaison.get(j))){
            exact+=1;
            tabInter.remove(j);
            
           
     
            
        }
        else{
            exact+=0;
            
        }
        
    }
    System.out.println("le nombre de valeurs exact est "+exact);
    
    
    int bonneValeur=0;
    for(int j=0;j<tabInter.size();j++){
        if(tabInter.contains(Combinaison.get(j))){
            bonneValeur +=1;
        }
        else{
            bonneValeur+=0;
        }  
        }
    System.out.println("il y a "+bonneValeur+" bonne valeur");
    
    if (exact==4){
        System.out.println("vous avez gagne youhou !!!");
    }
    }
        
    
   
}




        
    
    


    
    


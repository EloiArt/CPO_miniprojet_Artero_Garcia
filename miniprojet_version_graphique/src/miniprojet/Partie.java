/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author eloi
 */
public class Partie {
    
    private static final String[] COULEURS_POSSIBLES = {"a", "b", "c", "d", "e", "f", "g", "h"};

    public void jouer() {
        PlateauDeJeu plateau = new PlateauDeJeu(COULEURS_POSSIBLES);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le jeu !");
        System.out.println("Trouvez la combinaison secrete.");
        System.out.println("Combinaison secrete (debug) : " + plateau.getCombinaisonSecrete());

        boolean gagne = false;

        while (!gagne) {
            Combinaison tentative = new Combinaison();
            System.out.println("Veuillez entrer 4 valeurs :");

            for (int i = 0; i < 4; i++) {
                System.out.print("Valeur " + (i + 1) + " : ");
                String couleur = scanner.nextLine();
                tentative.ajouterPion(couleur);
            }

            int exact = plateau.verifierCombinaisonExacte(tentative);
            int correctes = plateau.verifierCouleursCorrectes(tentative);

            System.out.println("Le nombre de valeurs exactes est : " + exact);
            System.out.println("Le nombre de couleurs correctes est : " + correctes);

            if (exact == 4) {
                System.out.println("Felicitation, vous avez gagne !");
                gagne = true;
            }
        }

        scanner.close();
    }
}
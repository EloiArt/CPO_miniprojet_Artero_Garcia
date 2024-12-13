/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;

/**
 *
 * @author eloi
 */
public class PlateauDeJeu {
    
 private Combinaison combinaisonSecrete;

 public PlateauDeJeu(String[] couleursPossibles) {
        combinaisonSecrete = new Combinaison();
        combinaisonSecrete.genererAleatoire(couleursPossibles, 4);
    }

    public Combinaison getCombinaisonSecrete() {
        return combinaisonSecrete;
    }

    public int verifierCombinaisonExacte(Combinaison tentative) {
        int exact = 0;
        ArrayList<Integer> aRetirer = new ArrayList<>();

        for (int i = 0; i < tentative.getTaille(); i++) {
            if (tentative.getPion(i).equals(combinaisonSecrete.getPion(i))) {
                exact++;
                aRetirer.add(i);
            }
        }

        // Retirer les pions exacts pour simplifier les comparaisons restantes
        for (int i = aRetirer.size() - 1; i >= 0; i--) {
            int index = aRetirer.get(i);
            tentative.retirerPion(index);
            combinaisonSecrete.retirerPion(index);
        }

        return exact;
    }

    public int verifierCouleursCorrectes(Combinaison tentative) {
    int correctes = 0;
    ArrayList<Pion> copieSecrete = combinaisonSecrete.getPions();

    for (Pion pion : tentative.getPions()) {
        if (copieSecrete.contains(pion)) {
            correctes++;
            copieSecrete.remove(pion); // Retirer pour éviter les doublons
        }
    }

    return correctes;
}
}


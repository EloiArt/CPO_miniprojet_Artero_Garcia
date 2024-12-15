/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author eloi
 */
public class Combinaison {
    
    private ArrayList<Pion> pions;

    public Combinaison() {
        this.pions = new ArrayList<>();
    }

    public void genererAleatoire(String[] couleursPossibles, int taille) {
        Random random = new Random();
        for (int i = 0; i < taille; i++) {
            int indexAleatoire = random.nextInt(couleursPossibles.length);
            pions.add(new Pion(couleursPossibles[indexAleatoire]));
        }
    }

    public void ajouterPion(String couleur) {
        pions.add(new Pion(couleur));
    }

    public ArrayList<Pion> getPions() {
        return new ArrayList<>(pions); // Retourne une copie pour éviter les modifications externes
    }

    public Pion getPion(int index) {
        return pions.get(index);
    }

    public int getTaille() {
        return pions.size();
    }

    @Override
    public String toString() {
        StringBuilder resultat = new StringBuilder();
        for (Pion pion : pions) {
            resultat.append(pion.getCouleur()).append(" ");
        }
        return resultat.toString().trim();
    }
}


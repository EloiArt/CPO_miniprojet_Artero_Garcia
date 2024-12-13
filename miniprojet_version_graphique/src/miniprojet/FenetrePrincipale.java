/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package miniprojet;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author eloi
 */
public class FenetrePrincipale extends javax.swing.JFrame {

    private ArrayList<String> combinaison; // La combinaison générée
    private int tentativeActuelle = 0; // Compteur de tentatives
    private final int nbLignes = 10;
    private final int nbColonnes = 4;
    private JButton[][] boutonsTentatives; // Boutons représentant les tentatives
    private JLabel[] resultatsLabels; // Affichage des résultats de chaque tentative
    private String[] couleurs = {"a", "b", "c", "d", "e", "f", "g", "h"}; // Couleurs possibles

    /**
     * Creates new form FenetrePrincipale
     */
    public FenetrePrincipale() {
        initJeu(); // Génération de la combinaison
        initComponents(); // Initialisation des composants graphiques
        boutonsTentatives = new JButton[nbLignes][nbColonnes]; // Initialisation des boutons
        resultatsLabels = new JLabel[nbLignes]; // Initialisation des résultats
        jPanel1.setLayout(new GridLayout(nbLignes, nbColonnes + 1)); // Ajouter une colonne pour les résultats
 
        // Initialisation de la grille des boutons et des résultats
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                JButton boutonCellule = new JButton();
                boutonCellule.setEnabled(false); // Désactivé par défaut sauf pour la tentative active
                boutonsTentatives[i][j] = boutonCellule;
                jPanel1.add(boutonCellule);
            }
            // Ajouter un JLabel pour les résultats à droite
            JLabel resultatLabel = new JLabel(" ");
            resultatsLabels[i] = resultatLabel;
            jPanel1.add(resultatLabel);
        }
        activerLigne(tentativeActuelle); // Activer la première ligne pour le joueur
    }

    private void initJeu() {
        // Générer une combinaison aléatoire
        combinaison = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            combinaison.add(couleurs[random.nextInt(couleurs.length)]);
        }
        System.out.println("Combinaison générée (debug) : " + combinaison); // Pour debug
    }

    /**
     * Activer une ligne de boutons pour la tentative actuelle
     */
    private void activerLigne(int ligne) {
        for (int j = 0; j < nbColonnes; j++) {
            boutonsTentatives[ligne][j].setEnabled(true);
            boutonsTentatives[ligne][j].addActionListener(new BoutonActionListener(ligne, j));
        }
    }

    /**
     * Désactiver une ligne de boutons après validation
     */
    private void desactiverLigne(int ligne) {
        for (int j = 0; j < nbColonnes; j++) {
            boutonsTentatives[ligne][j].setEnabled(false);
        }
    }

    /**
     * Vérifie la combinaison saisie par l'utilisateur
     */
    private void verifierTentative(ArrayList<String> saisieUtilisateur) {
        int exact = 0;
        int bonneValeur = 0;

        // Créer une copie de la combinaison pour manipulation
        ArrayList<String> copieCombinaison = new ArrayList<>(combinaison);

        // Vérifier les positions exactes
        for (int i = 0; i < 4; i++) {
            if (saisieUtilisateur.get(i).equals(copieCombinaison.get(i))) {
                exact++;
                copieCombinaison.set(i, null); // Marquer comme utilisée
                saisieUtilisateur.set(i, null); // Marquer comme utilisée
            }
        }

        // Vérifier les bonnes couleurs restantes
        for (String valeur : saisieUtilisateur) {
            if (valeur != null && copieCombinaison.contains(valeur)) {
                bonneValeur++;
                copieCombinaison.set(copieCombinaison.indexOf(valeur), null); // Marquer comme utilisée
            }
        }

        // Afficher les résultats dans la colonne des résultats
        resultatsLabels[tentativeActuelle].setText("Exact: " + exact + " | Correct: " + bonneValeur);

        // Vérification du résultat
        if (exact == 4) {
            JOptionPane.showMessageDialog(this, "Félicitations ! Vous avez gagné !");
            System.exit(0);
        } else if (tentativeActuelle == nbLignes - 1) {
            JOptionPane.showMessageDialog(this, "Vous avez perdu ! La combinaison était : " + combinaison);
            System.exit(0);
        }

        // Passer à la tentative suivante
        desactiverLigne(tentativeActuelle);
        tentativeActuelle++;
        if (tentativeActuelle < nbLignes) {
            activerLigne(tentativeActuelle);
        }
    }

    /**
     * Classe interne pour gérer les clics sur les boutons
     */
    private class BoutonActionListener implements ActionListener {

        private final int ligne;
        private final int colonne;

        public BoutonActionListener(int ligne, int colonne) {
            this.ligne = ligne;
            this.colonne = colonne;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String saisie = JOptionPane.showInputDialog("Entrez une couleur (a-h) :");
            if (saisie != null && saisie.matches("[a-h]")) {
                boutonsTentatives[ligne][colonne].setText(saisie.toUpperCase());
            } else {
                JOptionPane.showMessageDialog(null, "Saisie invalide ! Entrez une lettre entre a et h.");
            }

            // Vérifier si la ligne est complète
            boolean ligneComplete = true;
            ArrayList<String> saisieUtilisateur = new ArrayList<>();
            for (int j = 0; j < nbColonnes; j++) {
                String texte = boutonsTentatives[ligne][j].getText();
                if (texte == null || texte.isEmpty()) {
                    ligneComplete = false;
                }
                saisieUtilisateur.add(texte.toLowerCase());
            }

            if (ligneComplete) {
                verifierTentative(saisieUtilisateur);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 680, -1));

        jLabel1.setFont(new java.awt.Font("Monaco", 0, 48)); // NOI18N
        jLabel1.setText("MASTERMIND");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}

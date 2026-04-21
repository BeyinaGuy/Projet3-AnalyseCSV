package Guy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnalyseurCSV {

    // Méthode qui lit le fichier CSV et calcule la moyenne, le min et le max par colonne
    public void analyserFichier(String cheminDuFichier) {

        try {
            BufferedReader lecteur = new BufferedReader(new FileReader(cheminDuFichier));
            String ligne;
            int compteurLignes = 0;

            // Tableaux pour stocker les résultats des 3 colonnes
            double[] sommes = new double[3];
            double[] max = {-999999, -999999, -999999};      // Initialisé avec une très petite valeur
            double[] min = {999999, 999999, 999999};         // Initialisé avec une très grande valeur

            // Lecture du fichier ligne par ligne
            while ((ligne = lecteur.readLine()) != null) {
                String[] colonnes = ligne.split(",");

                // Traitement pour chaque colonne de la ligne
                for (int i = 0; i < colonnes.length; i++) {
                    double valeur = Double.parseDouble(colonnes[i]);

                    // Ajout à la somme totale de la colonne
                    sommes[i] = sommes[i] + valeur;

                    // Mise à jour de la valeur maximale si nécessaire
                    if (valeur > max[i]) {
                        max[i] = valeur;
                    }
                    // Mise à jour de la valeur minimale si nécessaire
                    if (valeur < min[i]) {
                        min[i] = valeur;
                    }
                }
                compteurLignes = compteurLignes + 1;  // Incrémentation du nombre de lignes lues
            }

            lecteur.close();

            // Affichage des statistiques finales
            System.out.println("--- RÉSULTATS DE L'ANALYSE ---");
            for (int i = 0; i < 3; i++) {
                // Calcul de la moyenne pour la colonne actuelle
                double moyenne = sommes[i] / compteurLignes;

                // Formatage de la moyenne pour n'avoir que 2 chiffres après la virgule
                String moyenneArrondie = String.format("%.2f", moyenne);

                System.out.println("Colonne " + (i + 1) + " :");
                System.out.println("  Moyenne : " + moyenneArrondie);
                System.out.println("  Minimum : " + min[i]);
                System.out.println("  Maximum : " + max[i]);
                System.out.println("-------------------------");
            }

        } catch (IOException e) {
            System.out.println("Oups ! Impossible de lire le fichier.");
        }
    }
}

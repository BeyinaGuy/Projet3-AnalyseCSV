package Guy;

public class Main {

    // Point d'entrée principal du programme
    public static void main(String[] args) {

        System.out.println("Lancement du programme...");

        // Création de l'objet pour analyser le fichier CSV
        AnalyseurCSV monAnalyseur = new AnalyseurCSV();

        // Lancement de l'analyse sur notre fichier de test
        monAnalyseur.analyserFichier("donnees.csv");

        System.out.println("Analyse terminée !");
    }
}

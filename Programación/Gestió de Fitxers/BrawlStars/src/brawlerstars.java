import org.apache.commons.io.FileUtils;
import java.io.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;



public class brawlerstars {
    public static void main(String[] args) throws IOException {

        System.out.println("1. esborrar carpeta");
        System.out.println("2. crear carpeta");
        System.out.println("3. copiar estructura carpeta");
        System.out.println("4. crear fitxers");
        System.out.println("5. moure/renombrar un fitxer");
        System.out.println("6. Llegeix una lina d un fitxer");
        System.out.println("7. separar un fitxer");
        System.out.println("8. comptar paraulas");
        System.out.println("9. mostrar recompensas d un jugador");
        System.out.println("10. generar un fitxer nou");

        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();

        switch (choix){
            case 1:
                // 1. Supprimer Brawlers
                supprimerBrawlers();
                break;
            case 2:
                // 2. Creer Brawlers
                creerBrawlers();
                break;
            case 3:
                // 3. Copier Structure d'un dossier
                copierStructure();
                break;
            case 4:
                // 4. Creer des fichier dans un dossier
                creerFichier("Brawlers/Tank/Legendary", "Draco.stats");
                creerFichier("Brawlers/Tank/Legendary", "Meg.stats");
                creerFichier("Brawlers/Tank/Epic", "Hank.stats");
                creerFichier("Brawlers/Tank/Epic", "Ash.stats");
                creerFichier("Brawlers/Artillery/Mythic", "Juju.stats");
                creerFichier("Brawlers/Artillery/Mythic", "Sprout.stats");
                creerFichier("Brawlers/Artillery/SuperRare", "Dynamic.stats");
                creerFichier("Brawlers/Assassin/Legendary", "Kenjy.stats");
                break;
            case 5:
                // 5. deplacer ou renommer un fichier
                deplacerFichier("Brawlers/Artillery/Mythic/Juju.stats", "Brawlers/Artillery/Jujubackup.stats");
                break;
            case 6:
                // 6. lire ligne 5
                lireLigne();
                break;
            case 7:
                // 7. Separer un fichier
                separerFichier();
                break;
            case 8:
                // 8. Compter combien de fois le mot 'Super' etait repeter et mentionner les lignes ou se trouve
                compterSuper();
                break;
            case 9:
                // 9. afficher les donnees d'un joueur donne
                afficherDonnee();
                break;
            case 10:
                // 10. generer un nouveau fichier avec les donnees de l'ancien
                genererFichier();
                break;
            default:
                break;
        }
    }

    public static void supprimerBrawlers() {
        try {
            FileUtils.deleteDirectory(new File("Brawlers"));
            System.out.println("Brawlers supprimé.");
        } catch (IOException e) {
            System.out.println("Dossier inexistant, rien à supprimer.");
        }
    }

    public static void creerBrawlers() throws IOException {

        FileUtils.forceMkdir(new File("Brawlers/Tank/Legendary"));
        FileUtils.forceMkdir(new File("Brawlers/Tank/Epic"));
        FileUtils.forceMkdir(new File("Brawlers/Artillery/Mythic"));
        FileUtils.forceMkdir(new File("Brawlers/Artillery/SuperRare"));
        System.out.println("Dossiers créés.");
    }


    public static void copierStructure() throws IOException {
        File dSource = new File("Brawlers/Tank");
        File dDestin = new File("Brawlers/Assassin");

        FileUtils.copyDirectory(dSource, dDestin);
        System.out.println("Assassin créé");
    }

    public static void creerFichier(String chemainD, String nomD) {
        File dssParent = new File(chemainD);

        if (!dssParent.exists()) {
            System.out.println("le dossier parent n'existe pas");
        } else {
            File nouveauFichier = new File(dssParent, nomD);
            try {
                FileUtils.touch(nouveauFichier);
                System.out.println("Le fichier " + nomD + " est creer");
            } catch (IOException e) {
                System.out.println("impossible de creer le fichier: " + nomD + e.getMessage());
            }
        }
    }

    public static void deplacerFichier(String sourceC, String destinC){
        File src = new File(sourceC);
        File dst = new File(destinC);

        // vérifier si le fichier source existe
        if(!src.exists()){
            System.out.println("Le fichier source n'existe pas");
            return;
        }

        // vérifier si le dossier destination existe
        if(!dst.getParentFile().exists()){
            System.out.println("Le dossier destination n'existe pas");
            return;
        }

        try {
            FileUtils.moveFile(src,dst);
            System.out.println("Le fichier a été déplacé avec succès");
        } catch (IOException e) {
            System.out.println("Erreur lors du déplacement du fichier");
        }
    }

    public static void lireLigne(){
        File fichier = new File("Practica/Brawlers.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(fichier));

            String ligne;
            int compteur = 0;

            while ((ligne = br.readLine()) != null){
                if (!ligne.trim().isEmpty()){
                    compteur++;
                    if (compteur==5){
                        String[] mots = ligne.split(" ");
                        System.out.println("Le nombres des mots est "+mots.length);

                        System.out.println("Les mots qui commancent par une majiscule :");
                        for (String m : mots){
                            if (Character.isUpperCase(m.charAt(0))){
                                System.out.println(m);
                            }
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void separerFichier(){
        File fichier = new File("Practica/Brawlers.txt");
        int cmp = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fichier));

            BufferedWriter info = new BufferedWriter(new FileWriter("Practica/BrawlersInfo.txt"));
            BufferedWriter resm = new BufferedWriter(new FileWriter("Practica/BrawlersResum.txt"));

            String ligne;
            while ((ligne=br.readLine())!= null){
                if (!ligne.trim().isEmpty()){
                    cmp++;
                    if (cmp == 1){
                        info.write(ligne);
                        resm.newLine();
                    }
                    else {
                        resm.write(ligne);
                        resm.newLine();
                    }
                }
            }
            br.close();
            info.close();
            resm.close();

            System.out.println("Fichiers séparés avec succès !");

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void compterSuper() {
        File fichier = new File("Practica/Brawlers.txt");
        int comptr = 0;
        int nmligne = 0;
        Set<Integer> fil = new HashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichier));
            String ligne;

            while ((ligne = br.readLine()) != null) {
                nmligne++;

                if (!ligne.trim().isEmpty()) {
                    String[] m = ligne.split(" ");
                    for (String n : m) {
                        if (n.equals("Super")) {
                            comptr++;
                            fil.add(nmligne);
                        }
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //Set<Integer> res = new HashSet<>(fil);
        System.out.println("Le mot Super etait repeter "+comptr+" fois, dans les lignes :\n"+fil);
    }

    public static void afficherDonnee(){
        File fichier = new File("Practica/Rewards.csv");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du joueur!!");
        String nom = scanner.nextLine();

        int coins = 0;
        int gems = 0;
        int brawlers = 0;


        try {
            BufferedReader br = new BufferedReader(new FileReader(fichier));

            String ligne ;

            while ((ligne = br.readLine()) != null) {
                if (!ligne.trim().isEmpty()) {
                    String[] jr = ligne.split(";");
                    if(nom.equals(jr[1])){
                        coins = Integer.parseInt(jr[2]);
                        gems = Integer.parseInt(jr[3]);
                        brawlers = Integer.parseInt(jr[4]);
                    }

                }
            }
            System.out.println("Nom : "+nom+"\nSpecial Coins Earned : "+coins+"\nGems Purchased : "+gems+"\nRare Brawlers Unlocked : "+brawlers);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void genererFichier(){
        File source = new File("Practica/Rewards.csv");
        File destin = new File("Practica/SpecialRewards.csv");

        try {
            BufferedReader br = new BufferedReader(new FileReader(source));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destin));

            String ligne;

            bw.write("Player name;Special Coins Earned;Legendary Brawlers Unlocked;Wins in Special Modes");

            while ((ligne=br.readLine())!= null){
                if (!ligne.trim().isEmpty()){
                    String[] cln = ligne.split(";");

                    if (cln.length>=9){
                        String nom = cln[1];
                        String coin = cln[2];
                        String braw = cln[5];
                        String wins = cln[8];

                        String nouvelLigne = nom+";"+coin+";"+braw+";"+wins+"\n";

                        bw.write(nouvelLigne);

                    }

                }
            }
            br.close();
            bw.close();
            System.out.println("La generation du nouveau fichier est complete!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asilupe;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * 0 = consonne
 * 1 = voyelle
 */
public class Utils {
    
    //outils: genPrefix, genSuffix, genRadical, choose, initFixList
    // contient les outls utilisés dans les autres Class. 
    //prefixes, suffixes: les listes de String contenant l'entièreté des suffixes
    //et prefixes.
    //voyelles: list pour check si la nature des lettres significatives d'un suffixe
    //ou préfixe
    //array constr: les array utilisés pour la fonction genradical (en fait j'ai
    //juste renommé tes variables parce que les noms que tu avais donné étaient
    //déjà utilisés
    
    private static Random rand = new Random();
    private static List<String> prefixes, suffixes, voyelles;
    private static String[] constrvoyelles, constrconsonnes;
    
    
    //ceci est un bloc static. Il se lance dès que une des fonctons statiques de 
    //ce fichier est utilisé.
    //3 listes y sont initialisés, ainsi que les listes de prefixe,suffixe avec
    //avec la fonction initFixLists();
    static {
        voyelles = Arrays.asList(new String[]{"a", "e", "è", "é", "à", "i", "ï", "o", "u", "ë", "y",
                                              "ô", "â", "a"});
        //constrvoyelles = new String[]{"i","ou","u","a","â","an","eau","o","on","é","ai","in","eu","un","e","oi"};
        //constrconsonnes = new String[]{"f","v","s","z","ch","j","l","r","p","b","m","t","d","n","c","gu","gn","y"};
        constrvoyelles = new String[]{"i","u","a","â","an","eau","o","é","e","oi"};
        constrconsonnes = new String[]{"f","v","s","z","j","l","r","p","b","m","t","d","n","c","y"};
        try {
            initFixLists();
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //fonction qui va initialiser les listes de préfixes et de suffixes
    //ceux-ci vont être cherchés dans des fichiers .txt (res/suffixes.txt, 
    // res/prefixes.txt).
    //cette fonction est privée et doit donc uniquement être utilisé dans ce meme
    //fichier. 
    //d'ailleurs, on devrait plus du tout l'utiliser car elle doit etre utilisée
    //une fois par lancmenent du programme. Cela se fait dans le block static
    private static void initFixLists() throws IOException{
        
        InputStream stream = Utils.class.getResourceAsStream("res/prefixes.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        prefixes = Arrays.asList(reader.readLine().split(", "));
        
        stream = Utils.class.getResourceAsStream("res/suffixes.txt");
        reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        suffixes = Arrays.asList(reader.readLine().split(", "));
        
    }
    //fonction prévue pour initialiser une liste ccontenant toutes les strucutres
    //syllabiques... pour l'instant ça ne marvhe pas. Les Structure doivent être
    //initialisés a la main
    public static ArrayList<Structure> initStructures(){
        return null;
    }
    //============================================
    //====================choose()
    //  choose()   Tire une valeur aléatoire dans l'array
    //  String[]    a   l'array dans lequel chercher
    //  Return      String
    public static String choose(String[] a) {
        int i = rand.nextInt(a.length);
        return a[i];
    }
    
    //jai carrément recopié ton code pd alors tu commenteras toi...
    public static ArrayList<String> genRadical(boolean[] bs){
        String sPrevious, s = "";
        ArrayList<String> phonemes = new ArrayList<>();
        
        for (boolean b: bs) {
            do {
                sPrevious = s;
                s = (!b) ? choose(constrvoyelles) : choose(constrconsonnes);
            } while (s.equals(sPrevious));
            phonemes.add(s);
        }
        return phonemes;
    }
    
    //générer un prefixe. b correspond à la nature de la lettre suivant le préfixe
    //dans le radical
    public static String genPrefix(boolean b){ //b = 0 ==> pref ending with 1
        
        ArrayList<String> vpref, cpref;
        vpref = new ArrayList<>();
        cpref = new ArrayList<>();
        for(String s : prefixes){
            if(voyelles.contains(s.substring(s.length()-1))){
                vpref.add(s);
            }
            else {
                cpref.add(s);
            }
        }
        //le code en dessus:
        //crée des listes dans lesquels les dernieres lettres des préfixes sont 
        //des consonnes (cpref) ou des voyelles (vpref)
        
        //choisit un String random dans la bonne liste
        int length = b ? cpref.size(): vpref.size();
        int i = rand.nextInt(length);
        return b ? cpref.get(i): vpref.get(i);
    }
    
    //permet de générer un suffixe à partir de la liste complète des suffixes.
    //la valeur b correspond à la nature de la lettre qui précèderait le suffixe
    //dans le radical (voy/cons)
    public static String genSuffix(boolean b){
        String suf;
        boolean pass;
        do {
            suf = suffixes.get(rand.nextInt(suffixes.size()));
            pass = (voyelles.contains(suf.substring(0, 1)) == b);
        } while(!pass);
        return suf;
    }
}

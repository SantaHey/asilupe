package generator;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Utils {
    
    static SplittableRandom rand = new SplittableRandom();
    static ArrayList<Integer> syllabes = new ArrayList<>();
    static ArrayList<String> voyellesProp = new ArrayList<>();
    static ArrayList<String> consonnesProp = new ArrayList<>();
    
    public static void genTableau() {
        int[] proporSyll = {66,296,377,193,53,12,2,1};
        for (int i = 0;i < proporSyll.length;i++){
            int nbr = proporSyll[i];
                for (int a = 0;a < nbr;a++) {
                    syllabes.add(i+1);
                }
        }
    }
    public static int tirerUneSyllabe(){
        int r = rand.nextInt(syllabes.size());
        return syllabes.get(r);
    }
    
    public static String consVoye() {        
        String c = tirerUneConsonne();
        String v = tirerUneVoyelle();
        
        String cv = c + v;
        
        return cv + (rand.nextBoolean()?tirerUneConsonne():"");
    }
    public static void genSyllabe() {
        for (int i = 0; i < 4; i++) {
            
        }
    }
    
    static String[] consonnes = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","z"};    
    public static void genConsonne() {
        int[] proportions = {40,40,60,30,60,30,15,24,120,40,120,40,12,120,120,120,30,30,15,12};
        for (int i = 0;i < proportions.length;i++){
            int nbr = proportions[i];
            for (int a = 0;a < nbr;a++) {
                consonnesProp.add(consonnes[i]);
            }
        }        
    }
    public static String tirerUneConsonne(){
        int r = rand.nextInt(consonnesProp.size());
        return consonnesProp.get(r);
    }  
    static String[] voyelles = {"a","e","i","o","u","y"};    
    public static void genVoyelle() {
        int[] proportions = {120,120,120,120,120,30};
        for (int i = 0;i < proportions.length;i++){
            int nbr = proportions[i];
            for (int a = 0;a < nbr;a++) {
                voyellesProp.add(voyelles[i]);
            }
        }        
    }
    public static String tirerUneVoyelle(){
        int r = rand.nextInt(voyellesProp.size());
        return voyellesProp.get(r);
    }    
}
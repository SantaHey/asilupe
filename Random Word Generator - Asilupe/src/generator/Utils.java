package generator;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Utils {
    
    static SplittableRandom rand = new SplittableRandom();
    static String sPrevious;

    
    static String[] voyelles = {"i","ou","u","a","â","an","eau","o","on","é","ai","in","eu","un","e","oi"};
    static String[] consonnes = {"f","v","s","z","ch","j","l","r","p","b","m","t","d","n","c","gu","gn","y"};
    
    //========================Fonctions========================
    //====================nom()
    //  nom() ça sert à quoi
    //  Type    arg1    c'est quoi ce truc
    //  Type    arg2    c'est quoi ce truc
    //  Return  String
    public static int nom(int arg1, int arg2) {
        int retu1 = arg1 + arg2;
        return retu1;
    }
    //============================================
    //====================tirer()
    //  tirer()   Tire une valeur aléatoire dans l'array
    //  String[]    a   l'array dans lequel chercher
    //  Return      String
    public static String tirer(String[] a) {
        int i = rand.nextInt(0,a.length);
        return a[i];
    }
    //============================================
    //====================genRadical()
    //  genRadical()   Génère radical
    //  bool     bFinal  0:finit voyelle 1:finit consonne
    //  Return  String
    public static String genRadical(boolean bFinal) {
        String radical = "";
        String s = "";
        String[] strucVoy = {"10","110"};
        String[] strucCon = {"01","011","101","1011","1101"};
        
        String structure = bFinal ? tirer(strucVoy) : tirer(strucCon);
        
        for (char ch: structure.toCharArray()) {
            do {
                sPrevious = s;
                s = (ch == '0') ? tirer(voyelles) : tirer(consonnes);
            } while (s.equals(sPrevious));
            
            radical += s;
        }
        
        
        return radical;
    }
    //============================================
}
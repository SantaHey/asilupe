package generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;

public class Phoneme {


    
    static String[] préVoy = {"ible","iste","ant"};
    static String[] préCon = {"ment","logue","cide"};
    
    static SplittableRandom rand = new SplittableRandom();
    
    //============================================
    //====================genEnd()
    //  genEnd()   Tire le suffixe
    //  boolean bPasDebut   Par quoi finit le radical
    //  Return  String
    public static String genEnd(boolean bPasDebut) {
        String sFin = "";
         
        sFin += bPasDebut ? Utils.tirer(préCon) : Utils.tirer(préVoy);
        
        return sFin;
    }
    //============================================
    
}//FIN Phoneme
package generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;

public class Phoneme {
        
    /*//α
    static ArrayList<String> α = new ArrayList<>();
    public static void genα(){
        HashMap<String, Integer> αPropMap = new HashMap<String, Integer>() {{
            put("a", 89);
            put("à", 10);
            put("â", 1);
        }};
        αPropMap.entrySet().forEach((entry) -> {
            for (int i = 0; i < entry.getValue(); i++) {
                for (int a = 0;a < entry.getValue();a++) {
                    α.add(entry.getKey());
                }
            }
        });
    }//FIN α

    //ə
    static ArrayList<String> ə = new ArrayList<>();
    public static void genə(){
        HashMap<String, Integer> əPropMap = new HashMap<String, Integer>() {{
            put("e", 100);
        }};
        for(HashMap.Entry<String, Integer> entry: əPropMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                for (int a = 0;a < entry.getValue();a++) {
                    ə.add(entry.getKey());
                }
            }
        }
    }//FIN ə

    //ø
    static ArrayList<String> ø = new ArrayList<>();
    public static void genø(){
        HashMap<String, Integer> øPropMap = new HashMap<String, Integer>() {{
            put("eu", 95);
            put("œu", 5);
        }};
        for(HashMap.Entry<String, Integer> entry: øPropMap.entrySet()) {
            for (int a = 0;a < entry.getValue();a++) {
                ø.add(entry.getKey());
            }
        }
    }//FIN ø
    
    static ArrayList[] phonemes = {ə,ø,α};
    public static String tirerUnPhoneme(){
        ArrayList<String> al = phonemes[Utils.rand.nextInt(phonemes.length)];
        return al.get(Utils.rand.nextInt(al.size()));
    }
    //Générer le tableau d'un phonème avec les proportions
    void genProportions(String sNomPhoneme) {
          HashMap<String, Integer> propMap = new HashMap<String, Integer>() {{
            put("a", 89);
            put("à", 10);
            put("â", 1);
        }};
        propMap.entrySet().forEach((entry) -> {
            for (int i = 0; i < entry.getValue(); i++) {
                for (int a = 0;a < entry.getValue();a++) {
                    α.add(entry.getKey());
                }
            }
        });
    }

//===================================TEST========================================

    //==Choix adjectif
    static SplittableRandom rndm = new SplittableRandom();
    
    static public void choisirType() {
        switch (rndm.nextInt(3)) {
            case 0:  System.out.println("Adjectif");
                     break;
            case 1:  System.out.println("Nom");
                     break;
            case 2:  System.out.println("Verbe");
                     break;
        }
    }
    
    static String[][] adjectif = {{"ible","le","eux"}, {"forme","lâtre"}};
    static ArrayList[] adjectifTotal;
    static public void genererListes() {
        for (int i = 0; i < 10; i++) {
            
        }        
    }*/
    
    static String[] préVoy = {"ible","iste","ant"};
    static String[] préCon = {"ment","logue","cide"};
    
    static SplittableRandom rand = new SplittableRandom();
    
    //============================================
    //====================genEnd()
    //  genEnd()   Tire le suffixe
    //  int     iPasDebut   Par quoi finit le radical
    //  Return  String
    public static String genEnd(int iPasDebut) {
        String sFin = "";
        switch(iPasDebut)
        {
            case 0:
                sFin += Utils.tirer(préCon);
                break;
            case 1:
                sFin += Utils.tirer(préVoy);
                break;
        }
        return sFin;
    }
    //============================================
    
}//FIN Phoneme
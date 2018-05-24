package generator;

import java.util.SplittableRandom;

public class main {
    static SplittableRandom rand = new SplittableRandom();
    public static void main(String[] args) {
        //Phoneme.genPhonemes();
        /*String s = "";
        String sa = "";
        Utils.genTableau();
        Utils.genConsonne();
        Utils.genVoyelle();
        for (int i = 0; i < Utils.tirerUneSyllabe(); i++) {
            s += Phoneme.tirerUnPhoneme();
        }
        System.out.println(s);
        
        Phoneme.genererSyllabe();*/
             
        for(int i=0; i < 15;i++){
        int r = rand.nextInt(1);
        
        String s = Utils.genRadical(r);
        s += Phoneme.genEnd(r);
        
        System.out.println(s);
        }
    }
} //END
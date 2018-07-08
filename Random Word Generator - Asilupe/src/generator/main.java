package generator;

import java.util.SplittableRandom;

public class main {
    static SplittableRandom rand = new SplittableRandom();
    public static void main(String[] args) {
        /*Phoneme.genPhonemes();*/
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
        boolean b = rand.nextBoolean();
        
        String s = Utils.genRadical(b);
        s += Phoneme.genEnd(b);
        
        System.out.println(s);
        }
    }
} //END
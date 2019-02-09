package jjeu;

import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

public class Jjeu {
    
    public static void main(String[] args) {
         String[] consonnes = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","z"};
         String[] voyelles = {"a","e","i","o","u","y"};
         
         test();
    }
            
    public static int nbrSyllabes(){
        Random rand = new Random();
        int r = rand.nextInt(1000);
        int[] finalarray;
        int a[] = new int[66];
        int b[] = new int[296];
        int c[] = new int[377];
        int d[] = new int[193];
        int e[] = new int[53];
        int f[] = new int[12];
        int g[] = new int[2];
        int h[] = new int[1];
        Arrays.fill(a, 1);
        Arrays.fill(b, 2);
        Arrays.fill(c, 3);
        Arrays.fill(d, 4);
        Arrays.fill(e, 5);
        Arrays.fill(f, 6);
        Arrays.fill(g, 7);
        Arrays.fill(h, 8);
        int[] ab = ArrayUtils.addAll(a, b);
        int[] ac = ArrayUtils.addAll(ab, c);
        int[] ad = ArrayUtils.addAll(ac, d);
        int[] ae = ArrayUtils.addAll(ad, e);
        int[] af = ArrayUtils.addAll(ae, f);
        int[] ag = ArrayUtils.addAll(af, g);
        int[] ah = ArrayUtils.addAll(ag, h);
        
        finalarray = ah;
        
        return finalarray[r];
        /*fin du code*/
    }
    public static void test(){
        float nbr1 = 0, nbr2 = 0, nbr3 = 0, nbr4 = 0, nbr5 = 0, nbr6 = 0, nbr7 = 0, nbr8 = 0;
        int mult = 2000;
        for(int fs = 0; fs < 1000*mult; fs ++){
            int grospddecodedemerde = nbrSyllabes();
            
            switch (grospddecodedemerde){
                case 1:
                    nbr1++;
                    break;
                case 8:
                    nbr8++;
                    break;
                case 3:
                    nbr3++;
                    break;
                case 6:
                    nbr6++;
                    break;
                case 2:
                    nbr2++;
                    break;
                case 5:
                    nbr5++;
                    break;
                case 4:
                    nbr4++;
                    break;
                case 7:
                    nbr7++;
                    break;
            }
        }        
        System.out.println(nbr1/mult);        
        System.out.println(nbr2/mult);          
        System.out.println(nbr3/mult);          
        System.out.println(nbr4/mult);          
        System.out.println(nbr5/mult);          
        System.out.println(nbr6/mult);          
        System.out.println(nbr7/mult);          
        System.out.println(nbr8/mult);        
    }
}

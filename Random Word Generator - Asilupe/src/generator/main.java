package generator;

public class main {
    
    public static void main(String[] args) {
        String s = "";
        String sa = "";
        Utils.genTableau();
        Utils.genConsonne();
        Utils.genVoyelle();
        for (int i = 0; i < Utils.tirerUneSyllabe(); i++) {
            s += Utils.consVoye();
        }
        s += "-";
        for (int i = 0; i < Utils.tirerUneSyllabe(); i++) {
            s += Utils.consVoye();
        }
        System.out.println(s);       
    }
    
} //END
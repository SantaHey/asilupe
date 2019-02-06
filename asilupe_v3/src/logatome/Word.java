package logatome;

public class Word {
    
    //un Word est un "wrapper" pour une Structure. Son utilité est de simplifier
    //la lecture du code,  et de pouvoir générer plusieurs mots différents à partir
    //de la même structure.
    //sa seule fonction est Build.
    
    private Structure struc;

    public Word(Structure struc) {
        this.struc = struc;
    }
    
    
    //à partir de la Structure struc, variable privée, et des fonctions de Utils,
    //basées sur le Random, cette fontion génère un String qui va être le mot final.
    //PAR CONTRE JE PENSE QUE JAI DU RATER QQCH AVEC LA NATURe DES LETTRES DONC CEST
    //A REVOIR
    public String build(){
        String prefix = "", suffix = "", radical, word;
        boolean pref = struc.getFirstLetter(), suf = struc.getLastLetter();
        if(struc.isPref()){
            prefix = Utils.genPrefix(pref);
        }
        if(struc.isSuf()){
            suffix = Utils.genSuffix(suf);
        }
        radical = Utils.genRadical(struc.getStruct());
        word = prefix + radical  + suffix;
        return word;
    }
    
}

package asilupe;

import java.util.*;

public class Word {
    
    //un Word est un "wrapper" pour une Structure. Son utilité est de simplifier
    //la lecture du code,  et de pouvoir générer plusieurs mots différents à partir
    //de la même structure.
    //sa seule fonction est Build.
    
    private Structure structure;
    private boolean motBien;
    private String prefixe, suffixe, motComplet;
    private ArrayList<String> phonemes;

    public Word() {
        this(new Structure("1010", false, true));
    }
    
    public Word(Structure struc) {
        this.structure = struc;
        this.build();
    }
    
    //à partir de la Structure struc, variable privée, et des fonctions de Utils,
    //basées sur le Random, cette fontion génère un String qui va être le mot final.
    //PAR CONTRE JE PENSE QUE JAI DU RATER QQCH AVEC LA NATURe DES LETTRES DONC CEST
    //A REVOIR
    public void build(){
        //variables
        String radical = "", prefix = "", suffix = "", word;
        boolean pref = structure.getFirstLetter(), suf = structure.getLastLetter();
        ArrayList<String> phonemes = new ArrayList<String>();
        
        //assignation valeurs
        if(structure.getHasPref()){
            prefix = Utils.genPrefix(pref);
            this.prefixe = prefix;
        }
        
        if(structure.getHasSuf()){
            suffix = Utils.genSuffix(suf);
            this.suffixe = suffix;
        }

        phonemes = Utils.genRadical(structure.getStruct());
        this.phonemes = phonemes;
        
        for (String string : phonemes) {
        	radical += string;
        }
        word = prefix + radical + suffix;
        this.motComplet = word;
    }
    
    //les getters pour chaque valeur
    public Structure getStructure() {
        return this.structure;
    }
    public boolean getMotBien() {
        return this.motBien;
    }
    public String getPrefixe() {
        return this.prefixe;
    }
    public String getSuffixe() {
        return this.suffixe;
    }
    public String getMotComplet() {
        return this.motComplet;
    }
    public ArrayList<String> getPhonemes() {
        return this.phonemes;
    }
    //Setters
    public void setStructure(Structure struc) {
        this.structure = struc;
    }
    public void setMotBien(boolean b) {
        this.motBien = b;
    }
}

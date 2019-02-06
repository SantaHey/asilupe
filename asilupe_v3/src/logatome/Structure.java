package logatome;


public class Structure {
    /*Une structure permet de definir les voyelles et les consonnes d'un mot
      voyelle = true, consonne = false
      VARIABLES:
      struct -> boolean array, chaque boolean définit la nature d'une lettre de
                               la radicale
      isPref/isSuf-> boolean, définit s'il y a un préfixe/suffixe respectivement
      lastLetter/firstLetter -> boolean, pour pouvoir enchainer le suffixe/préfixe
                                         sans qu'il y ait 2 consonnes/voyelles qui
                                         se répètent
    */
    
    private boolean[] struct;
    private boolean isPref, isSuf, lastLetter, firstLetter;

    
    //Constuctor si on ne veut pas encore définir si on veut un préfix/suffix
    public Structure(boolean[] struct) {
        this.struct = struct;
        this.lastLetter = this.struct[this.struct.length-1];
        this.firstLetter = this.struct[0];
        
    }
    //Constructor dans lequel s doit contenir des 1 et d'autres lettres 
    //préférablement des 0 pour la lisibilité
    //le String sera alors évalué comme une liste de boolean (1=true, else=false)
    public Structure(String s, boolean isPref, boolean isSuf){
        boolean[] struct = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            struct[i] = s.charAt(i) == '1';
        }
        this.struct = struct;
        this.isPref = isPref;
        this.isSuf = isSuf;
        this.lastLetter = this.struct[this.struct.length-1];
        this.firstLetter = this.struct[0];
        
    }
    //Constructor basique, dans lequel tout est défini, et les variables sont
    //du bon type.
    public Structure(boolean[] struct, boolean isPref, boolean isSuf) {
        this.struct = struct;
        this.isPref = isPref;
        this.isSuf = isSuf;
        this.lastLetter = this.struct[this.struct.length-1];
        this.firstLetter = this.struct[0];
    }
    
    //les getters pour chaque valeur
    public boolean isPref() {
        return isPref;
    }
    public boolean isSuf() {
        return isSuf;
    }
    public boolean getFirstLetter() {
        return firstLetter;
    }
    public boolean getLastLetter(){
        return lastLetter;
    }
    public boolean[] getStruct() {
        return struct;
    }
    //setters pour les valeurs.
    public void setStruct(boolean[] struct) {
        this.struct = struct;
    }
    public void setIsPref(boolean isPref) {
        this.isPref = isPref;
    }
    public void setIsSuf(boolean isSuf) {
        this.isSuf = isSuf;
    }
    
    
}

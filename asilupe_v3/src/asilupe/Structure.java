package asilupe;


public class Structure {
    /*Une structure permet de definir les voyelles et les consonnes d'un mot
      voyelle = true, consonne = false
      VARIABLES:
      struct -> boolean array, chaque boolean définit la nature d'une lettre de
                               la radicale
      hasPref/hasSuf-> boolean, définit s'il y a un préfixe/suffixe respectivement
      lastLetter/firstLetter -> boolean, pour pouvoir enchainer le suffixe/préfixe
                                         sans qu'il y ait 2 consonnes/voyelles qui
                                         se répètent
    */
    
    private boolean[] struct;
    private boolean hasPref, hasSuf, firstLetter, lastLetter;

    
    //Constructor si on ne veut pas encore définir si on veut un préfix/suffix
    public Structure(boolean[] struct) {
        this(struct, false, false);
    }
    //Constructor dans lequel s doit contenir des 1 et d'autres lettres 
    //préférablement des 0 pour la lisibilité
    //le String sera alors évalué comme une liste de boolean (1=true, else=false)
    public Structure(String s, boolean hasPref, boolean hasSuf){
        this(structToBooleans(s), hasPref, hasSuf);
    }
    //Méthode utilisée dans le constructeur au-dessus
    public static boolean[] structToBooleans(String s) {
        boolean[] struct = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            struct[i] = s.charAt(i) == '1';
        }
        return struct;
    }
    
    //Constructor basique, dans lequel tout est défini, et les variables sont
    //du bon type.
    public Structure(boolean[] struct, boolean hasPref, boolean hasSuf) {
        this.struct = struct;
        this.hasPref = hasPref;
        this.hasSuf = hasSuf;
        this.lastLetter = this.struct[this.struct.length-1];
        this.firstLetter = this.struct[0];
    }
    
    //les getters pour chaque valeur
    public boolean[] getStruct() {
        return this.struct;
    }
    public boolean getHasPref() {
        return this.hasPref;
    }
    public boolean getHasSuf() {
        return this.hasSuf;
    }
    public boolean getFirstLetter() {
        return this.firstLetter;
    }
    public boolean getLastLetter(){
        return this.lastLetter;
    }
    //Setters
    public void setStruct(boolean[] struct) {
        this.struct = struct;
    }
    public void setHasPref(boolean hasPref) {
        this.hasPref = hasPref;
    }
    public void setHasSuf(boolean hasSuf) {
        this.hasSuf = hasSuf;
    }
}

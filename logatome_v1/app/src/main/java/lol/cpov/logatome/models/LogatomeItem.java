package lol.cpov.logatome.models;

public class LogatomeItem {
    private String mot;
    private boolean favori;

    public LogatomeItem(String mot, boolean favori){
        this.mot = mot;
        this.favori = favori;
    }

    public String getMot() { return mot; }
    public boolean getFavori() { return favori; }
}

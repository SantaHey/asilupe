package lol.cpov.logatome.models;

public class LogatomeItem {
    private String mot;
    private boolean motBien;

    public LogatomeItem(String mot){
        this.mot = mot;
    }

    public String getMot() { return mot; }
    public boolean getMotBien() { return motBien; }

    public void setMot(String s) { this.mot = s; }
    public void setMotBien(boolean b) { this.motBien = b; }
}

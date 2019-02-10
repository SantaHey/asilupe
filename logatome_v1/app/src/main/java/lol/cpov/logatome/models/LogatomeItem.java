package lol.cpov.logatome.models;

import asilupe.Word;

public class LogatomeItem {
    private Word word;

    public LogatomeItem(Word word){
        this.word = word;
    }

    public Word getWord() { return word; }
    public void setWord(Word w) { this.word = w; }
}

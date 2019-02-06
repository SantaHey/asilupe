package logatome;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
        Structure s = new Structure("1010", false, true);
        
        for(int i = 0; i < 15; i++){
            System.out.println(new Word(s).build());
        }
        
    }
    
}

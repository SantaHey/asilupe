package lol.cpov.logatome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.*;

import asilupe.Word;
import lol.cpov.logatome.adapters.LogatomeItemAdapter;
import lol.cpov.logatome.models.LogatomeItem;

public class MainActivity extends AppCompatActivity {
    Button button = findViewById(R.id.button);
    ListView logatomeListView = findViewById(R.id.logatome_list_view);
    public static boolean[] reponses = {false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<LogatomeItem> logatomeItemList = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            logatomeItemList.add(new LogatomeItem((new Word().getMotComplet())));
        }
        logatomeListView.setAdapter(new LogatomeItemAdapter(this, logatomeItemList));

        if (reponses[0] && reponses[1] && reponses[2]) {
            button.setClickable(true);
        }

    }
}

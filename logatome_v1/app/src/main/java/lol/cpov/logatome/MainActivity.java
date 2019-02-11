package lol.cpov.logatome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.*;

import asilupe.Word;
import lol.cpov.logatome.adapters.LogatomeItemAdapter;
import lol.cpov.logatome.models.LogatomeItem;

public class MainActivity extends AppCompatActivity {
    public Button button;
    ListView logatomeListView;
    List<LogatomeItem> logatomeItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        logatomeListView = findViewById(R.id.logatome_list_view);

        logatomeItemList = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                genererMots();
            }
        });


        genererMots();
    }

    public void testRadios() {
        int nonChecked = 0;
        for (LogatomeItem item : logatomeItemList ) {
            if (item.getWord().getMotBien() == null) {
                nonChecked++;
            }
            if (nonChecked == 0) {
                button.setClickable(true);
            }
        }
    }

    public void genererMots() {
        button.setClickable(false);
        logatomeItemList.clear();

        for(int i = 0; i < 3; i++) {
            logatomeItemList.add(new LogatomeItem(new Word()));
        }
        logatomeListView.setAdapter(new LogatomeItemAdapter(this, logatomeItemList, this));
    }
}

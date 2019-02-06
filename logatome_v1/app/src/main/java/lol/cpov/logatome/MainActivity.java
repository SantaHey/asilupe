package lol.cpov.logatome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import lol.cpov.logatome.adapters.LogatomeItemAdapter;
import lol.cpov.logatome.models.LogatomeItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<LogatomeItem> logatomeItemList = new ArrayList<>();
        logatomeItemList.add(new LogatomeItem("talancule",false));
        logatomeItemList.add(new LogatomeItem("lothard",true));
        logatomeItemList.add(new LogatomeItem("viandasse",false));

        ListView logatomeListView = findViewById(R.id.logatome_list_view);
        logatomeListView.setAdapter(new LogatomeItemAdapter(this, logatomeItemList));
    }
}

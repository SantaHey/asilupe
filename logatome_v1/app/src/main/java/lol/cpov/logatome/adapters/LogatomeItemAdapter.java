package lol.cpov.logatome.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.*;

import java.util.List;

import asilupe.Word;
import lol.cpov.logatome.MainActivity;
import lol.cpov.logatome.R;
import lol.cpov.logatome.models.LogatomeItem;

public class LogatomeItemAdapter extends BaseAdapter {

    private Context context;
    private List<LogatomeItem> logatomeItemList;
    private LayoutInflater inflater;
    private MainActivity mainActivity;

    public LogatomeItemAdapter(Context context, List<LogatomeItem> logatomeItemList, MainActivity mainActivity) {
        this.context = context;
        this.logatomeItemList = logatomeItemList;
        this.inflater = LayoutInflater.from(context);
        this.mainActivity = mainActivity;
    }

    @Override
    public int getCount() {
        return logatomeItemList.size();
    }

    @Override
    public LogatomeItem getItem(int position) {
        return logatomeItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.adapter_logatome, null);

        LogatomeItem currentItem = getItem(i);
        final Word currentWord = currentItem.getWord();
        String mot = currentWord.getMotComplet();



        TextView itemNameView = view.findViewById(R.id.mot);
        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        RadioButton radioBien = view.findViewById(R.id.radioBien);
        RadioButton radioPasBien = view.findViewById(R.id.radioPasBien);

        itemNameView.setText(mot);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (radioGroup.getCheckedRadioButtonId() == R.id.radioBien) {
                    currentWord.setMotBien(true);
                }
                if (radioGroup.getCheckedRadioButtonId() == R.id.radioPasBien) {
                    currentWord.setMotBien(false);
                }

                mainActivity.testRadios();
            }
        });

        return view;
    }
}

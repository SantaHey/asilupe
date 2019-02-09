package lol.cpov.logatome.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.*;

import java.util.List;

import lol.cpov.logatome.MainActivity;
import lol.cpov.logatome.R;
import lol.cpov.logatome.models.LogatomeItem;

public class LogatomeItemAdapter extends BaseAdapter {

    private Context context;
    private List<LogatomeItem> logatomeItemList;
    private LayoutInflater inflater;

    public LogatomeItemAdapter(Context context, List<LogatomeItem> logatomeItemList) {
        this.context = context;
        this.logatomeItemList = logatomeItemList;
        this.inflater = LayoutInflater.from(context);
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

        final LogatomeItem currentItem = getItem(i);
        String mot = currentItem.getMot();

        TextView itemNameView = view.findViewById(R.id.mot);
        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        RadioButton radioBien = view.findViewById(R.id.radioBien);
        RadioButton radioPasBien = view.findViewById(R.id.radioPasBien);

        itemNameView.setText(mot);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (radioGroup.getCheckedRadioButtonId() == R.id.radioBien) {
                    currentItem.setMotBien(true);
                } else {
                    currentItem.setMotBien(false);
                }
            }
        });

        return view;
    }
}

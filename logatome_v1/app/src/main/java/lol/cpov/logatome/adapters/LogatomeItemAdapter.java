package lol.cpov.logatome.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

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
    public Object getItem(int position) {
        return logatomeItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.adapter_logatome, null);

        return view;
    }
}


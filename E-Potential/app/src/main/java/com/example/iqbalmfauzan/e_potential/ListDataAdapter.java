package com.example.iqbalmfauzan.e_potential;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iqbal M Fauzan on 3/8/2016.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class Layouthandler
    {
        TextView No, Soal, Jawaban_1, Jawaban_2,Jawaban_3,Jawaban_4;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        Layouthandler layouthandler;
        if (row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layouthandler = new Layouthandler();
            layouthandler.No = (TextView)row.findViewById(R.id.tvNomer);
            layouthandler.Soal = (TextView)row.findViewById(R.id.tvSoal);
            layouthandler.Jawaban_1 = (TextView)row.findViewById(R.id.tvjawabanA);
            layouthandler.Jawaban_2 = (TextView)row.findViewById(R.id.tvjawabanB);
            layouthandler.Jawaban_3 = (TextView)row.findViewById(R.id.tvjawabanC);
            layouthandler.Jawaban_4 = (TextView)row.findViewById(R.id.tvjawabanD);
            row.setTag(layouthandler);

        }
        else
        {
            layouthandler = (Layouthandler)row.getTag();
        }
        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layouthandler.No.setText(dataProvider.getNomer());
        layouthandler.Soal.setText(dataProvider.getSoal());
        layouthandler.Jawaban_1.setText(dataProvider.getJawaban_1());
        layouthandler.Jawaban_2.setText(dataProvider.getJawaban_2());
        layouthandler.Jawaban_3.setText(dataProvider.getJawaban_3());
        layouthandler.Jawaban_4.setText(dataProvider.getJawaban_4());
        return row;


    }
}

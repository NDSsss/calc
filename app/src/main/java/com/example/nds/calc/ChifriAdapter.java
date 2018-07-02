package com.example.nds.calc;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ChifriAdapter extends ArrayAdapter<String>{
    private static final String[] mContacts = { "0", "1", "2",
            "3", "4", "5", "6", "7", "8",
            "9","." };
    int orient=1;

    Context mContext;

    // Конструктор
    public ChifriAdapter(Context context, int textViewResourceId,int orie) {

        super(context, textViewResourceId, mContacts);
        setOrient(orie);
        // TODO Auto-generated constructor stub
        this.mContext = context;
    }

    void setOrient(int orient){
        this.orient=orient;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        TextView label = (TextView) convertView;

        if (convertView == null) {
            convertView = new TextView(mContext);
            label = (TextView) convertView;
        }
        label.setTextColor(Color.BLUE);
        if(orient==1)
            label.setTextSize(97);
        else
            label.setTextSize(60);
        label.setText(mContacts[position]);
        return (convertView);
    }

    // возвращает содержимое выделенного элемента списка
    public String getItem(int position) {
        return mContacts[position];
    }


}

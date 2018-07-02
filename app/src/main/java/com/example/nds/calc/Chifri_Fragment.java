package com.example.nds.calc;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class Chifri_Fragment extends Fragment implements AdapterView.OnItemSelectedListener{
    @Nullable

    private ChifriAdapter mAdapter;
    private TextView mSelectText;
    public int nazatie=0;
    private String txtviewText,cur_chislo="",devs;
    Funkcii func =new Funkcii();
    double result, saved1,saved2;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView =
                inflater.inflate(R.layout.chifri_fragment, container, false);
        mSelectText = (TextView)getActivity().findViewById(R.id.txtview);
        final GridView g = (GridView) rootView.findViewById(R.id.gridView1);
        int ty =getScreenOrientation();
        mAdapter = new ChifriAdapter(rootView.getContext(), R.layout.activity_main,ty);
        g.setAdapter(mAdapter);
        g.setOnItemSelectedListener(this);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // TODO Auto-generated method stub
                onItemSelected(parent,v,position,id);

            }
        });

        //int layoutDirection = ViewCompat.getLayoutDirection(container);

        //Log.d(getString(R.string.myTag),String.valueOf(layoutDirection));

        Log.d(getString(R.string.myTag),String.valueOf(ty));
        return rootView;
    }

    public int getScreenOrientation()
    {
        Display getOrient = getActivity().getWindowManager().getDefaultDisplay();
        int orientation = Configuration.ORIENTATION_UNDEFINED;
        if(getOrient.getWidth()==getOrient.getHeight()){
            orientation = Configuration.ORIENTATION_SQUARE;
        } else{
            if(getOrient.getWidth() < getOrient.getHeight()){
                orientation = Configuration.ORIENTATION_PORTRAIT;
            }else {
                orientation = Configuration.ORIENTATION_LANDSCAPE;
            }
        }
        return orientation;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        mSelectText=((TextView)getActivity().findViewById(R.id.txtview));
        if(nazatie==0) {
            mSelectText.setText("");
            nazatie = 1;
        }

        if(nazatie==1||nazatie==2) {
        mSelectText.setText(GetTxtViewText()+mAdapter.getItem(position));
        cur_chislo+=mAdapter.getItem(position);
        Log.d(getString(R.string.myTag),cur_chislo);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        ((TextView)getActivity().findViewById(R.id.txtview)).setText("0");
    }


    public void Deystvie_najato(String deystvie) {


        switch (deystvie) {

            case "=":
                Result2(saved1,saved2);
                ((TextView)getActivity().findViewById(R.id.txtview)).setText(String.valueOf(result));
                saved1=result;
                nazatie=2;
                cur_chislo=String.valueOf(saved1);
                break;

            case "C":
                Clearall();
                break;

            default:
                devs=deystvie;
            ((TextView)getActivity().findViewById(R.id.txtview)).setText(((TextView)getActivity().findViewById(R.id.txtview)).getText()+devs);
            break;
        }

        }

    private String GetTxtViewText()
    {
        mSelectText=((TextView)getActivity().findViewById(R.id.txtview));
        txtviewText=mSelectText.getText().toString();
        return txtviewText;
    }

    private double Result2(double a, double b)
    {
        switch (devs){
            case "+":
                result = func.Sum(a,b);
                break;
            case "-":
                result = func.Sub(a,b);
                break;
            case "*":
                result = func.Mul(a,b);
                break;
            case "/":
                result = func.Div(a,b);
                break;
        }
        return result;
    }
    private void Clearall(){
        nazatie=0;
        ((TextView)getActivity().findViewById(R.id.txtview)).setText("0");
        saved1=0;
        saved2=0;
        cur_chislo="0";
        devs="";
    }
    public int getNazatie()
    {
        return nazatie;
    }

    public void setNazatie(int nazatie) {
        this.nazatie = nazatie;
    }

    public double getResult() {
        return result;
    }

    public void setCur_chislo() {
        this.cur_chislo = String.valueOf(result);
    }

    public void makeSaved1(){
        saved1 =Double.parseDouble(cur_chislo);
        cur_chislo="";
        Log.d(getString(R.string.myTag), (String.valueOf(saved1)));
        Log.d(getString(R.string.myTag), ("Nazatie "+String.valueOf(nazatie)));
    }
    public void makeSaved2(){
        saved2 =Double.parseDouble(cur_chislo);
        cur_chislo="";
        Log.d(getString(R.string.myTag), (String.valueOf(saved2)));
        Log.d(getString(R.string.myTag), ("Nazatie "+String.valueOf(nazatie)));
    }
}

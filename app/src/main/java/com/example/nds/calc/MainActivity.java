package com.example.nds.calc;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Deystviya_Fragment.onDeystvieNajatoListener {

    private TextView mSelectText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSelectText = (TextView) findViewById(R.id.txtview);

    }



    @Override
    public void DeystvieNajato(String deystvie) {
        FragmentManager fragmentManager = getFragmentManager();
        Chifri_Fragment chifri_fragment = (Chifri_Fragment)fragmentManager.findFragmentById(R.id.chifri_fragment);
        int naz =chifri_fragment.getNazatie();
        if (chifri_fragment!=null) {
            if(naz==1&&deystvie!="=") {
                chifri_fragment.makeSaved1();
                chifri_fragment.Deystvie_najato(deystvie);
                chifri_fragment.setNazatie(2);
            }
            if(naz==2||naz==0){

                chifri_fragment.makeSaved2();
                if(deystvie=="="){
                    chifri_fragment.Deystvie_najato(deystvie);
                    chifri_fragment.setNazatie(0);
                }
                if(deystvie=="C") {
                    chifri_fragment.Deystvie_najato(deystvie);
                }
                if(deystvie!="="&&deystvie!="C")
                {
                    chifri_fragment.Deystvie_najato("=");
                    chifri_fragment.Deystvie_najato(deystvie);
                    chifri_fragment.setNazatie(2);
                }

            }
        }
    }
}

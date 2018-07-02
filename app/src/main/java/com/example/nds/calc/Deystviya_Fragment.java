package com.example.nds.calc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class Deystviya_Fragment extends Fragment implements AdapterView.OnItemSelectedListener{
    @Nullable

    private DeystviyaAdapter mAdapter2;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView =
                inflater.inflate(R.layout.deystviya_fragment, container, false);
        final GridView g2 = (GridView) rootView.findViewById(R.id.gridView2);
        mAdapter2 = new DeystviyaAdapter(rootView.getContext(),
                R.layout.activity_main);
        g2.setAdapter(mAdapter2);
        g2.setOnItemSelectedListener(this);
        g2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // TODO Auto-generated method stub
                onItemSelected(parent,v,position,id);

            }
        });

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        onDeystvieNajatoListener listener = (onDeystvieNajatoListener)getActivity();
        listener.DeystvieNajato(mAdapter2.getItem(position));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public interface onDeystvieNajatoListener{

        public void DeystvieNajato(String deystvie);
    }
}

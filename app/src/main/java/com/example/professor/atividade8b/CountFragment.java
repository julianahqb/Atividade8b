package com.example.professor.atividade8b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;

public abstract class CountFragment extends Fragment implements Serializable {

    private TextView txtCount;
    private int count;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentView(), container, false);

        txtCount = (TextView) view.findViewById(R.id.txtCount);

        if (savedInstanceState != null) {
            this.count = savedInstanceState.getInt("count");
        }
        txtCount.setText(String.valueOf(count));
        return view;
    }

    public void increment() {
        count++;
        txtCount.setText(String.valueOf(count));
    }


    protected abstract int getFragmentView();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }
}

package com.example.professor.atividade8b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ButtonFragment.OnIncrementListener} interface
 * to handle interaction events.
 */
public class ButtonFragment extends Fragment implements View.OnClickListener {

    private OnIncrementListener listener;

    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        Button button = (Button) view.findViewById(R.id.btnInc);
        button.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onIncrement();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnIncrementListener) {
            listener = (OnIncrementListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnIncrementListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnIncrementListener {
        void onIncrement();
    }
}

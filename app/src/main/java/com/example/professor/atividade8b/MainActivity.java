package com.example.professor.atividade8b;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ButtonFragment.OnIncrementListener {

    private CountFragment count1Fragment;
    private CountFragment count2Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ButtonFragment buttonFragment = new ButtonFragment();
        fragmentTransaction.add(R.id.lay_button, buttonFragment);

        count1Fragment = new Count1Fragment();
        fragmentTransaction.add(R.id.lay_count1, count1Fragment);

        count2Fragment = new Count2Fragment();
        fragmentTransaction.add(R.id.lay_count2, count2Fragment);

        fragmentTransaction.commit();
    }

    @Override
    public void onIncrement() {
        count1Fragment.increment();
        count2Fragment.increment();
    }
}

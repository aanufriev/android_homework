package ru.park.anufriev.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportFragmentManager().findFragmentById(R.id.main_fragment_container) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_fragment_container, new NumberListFragment())
                    .commit();
        }
    }
}
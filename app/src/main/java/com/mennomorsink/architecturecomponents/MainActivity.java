package com.mennomorsink.architecturecomponents;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.mennomorsink.architecturecomponents.data.Counter;
import com.mennomorsink.architecturecomponents.data.CounterRepository;

public class MainActivity extends AppCompatActivity {

    private CounterRepository counterRepository;
    private TextView textLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textLabel = findViewById(R.id.text);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddTapped();
            }
        });
        FloatingActionButton fabGet = findViewById(R.id.fabGet);
        fabGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGetTapped();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        counterRepository = ((MyApplication) getApplication()).getCounterRepository();
    }

    private void onAddTapped() {
        counterRepository.increment();
    }

    private void onGetTapped() {
        counterRepository.getLiveData().observe(this, new Observer<Counter>() {
            @Override
            public void onChanged(@Nullable Counter counter) {
                if (counter != null) {
                    textLabel.setText(getString(R.string.counter, counter.getCount()));
                }
            }
        });
    }
}

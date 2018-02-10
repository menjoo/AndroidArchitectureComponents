package com.mennomorsink.architecturecomponents;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import com.mennomorsink.architecturecomponents.data.Counter;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private TextView textLabel;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        textLabel = findViewById(R.id.text);
        chronometer = findViewById(R.id.chronometer);

        setupChronometer();
        setupAddButton();
        observeCounter();
    }

    private void setupChronometer() {
        if (viewModel.getStartTime() == null) {
            // If the start date is not defined, it's a new ViewModel so set it.
            long startTime = SystemClock.elapsedRealtime();
            viewModel.setStartTime(startTime);
            chronometer.setBase(startTime);
        } else {
            // Otherwise the ViewModel has been retained, set the chronometer's base to the original
            // starting time.
            chronometer.setBase(viewModel.getStartTime());
        }

        chronometer.start();
    }

    private void setupAddButton() {
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.increment();
            }
        });
    }

    private void observeCounter() {
        viewModel.getCounter().observe(this, new Observer<Counter>() {
            @Override
            public void onChanged(@Nullable Counter counter) {
                if (counter != null) {
                    textLabel.setText(getString(R.string.counter, counter.getCount()));
                }
            }
        });
    }
}

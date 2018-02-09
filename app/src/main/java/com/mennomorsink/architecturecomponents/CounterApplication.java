package com.mennomorsink.architecturecomponents;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.mennomorsink.architecturecomponents.data.AppDatabase;
import com.mennomorsink.architecturecomponents.data.CounterRepository;

/**
 * Created by mennomorsink on 09/02/2018.
 */

public class CounterApplication extends Application {

    private AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
    }

    public CounterRepository getCounterRepository() {
        return new CounterRepository(db.counterDao());
    }
}

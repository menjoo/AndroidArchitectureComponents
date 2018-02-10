package com.mennomorsink.architecturecomponents;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.mennomorsink.architecturecomponents.data.AppDatabase;
import com.mennomorsink.architecturecomponents.data.CounterRepository;

public class MyApplication extends Application {

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

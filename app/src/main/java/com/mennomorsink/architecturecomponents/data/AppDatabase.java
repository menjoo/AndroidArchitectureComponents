package com.mennomorsink.architecturecomponents.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Counter.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CounterDao counterDao();
}

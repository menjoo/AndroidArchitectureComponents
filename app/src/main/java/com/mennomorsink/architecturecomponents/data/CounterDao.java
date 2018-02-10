package com.mennomorsink.architecturecomponents.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface CounterDao {

    @Query("SELECT * FROM counter WHERE uid = 1")
    LiveData<Counter> getCounter();

    @Insert
    void create(Counter counter);

    @Update
    void update(Counter counter);
}

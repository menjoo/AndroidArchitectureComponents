package com.mennomorsink.architecturecomponents;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * Created by mennomorsink on 09/02/2018.
 */

@Dao
interface CounterDao {

    @Query("SELECT * FROM counter WHERE uid = :uid")
    Counter findByName(int uid);

    @Insert
    void create(Counter counter);

    @Update
    void update(Counter counter);
}

package com.mennomorsink.architecturecomponents;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mennomorsink on 09/02/2018.
 */

@Entity
public class Counter {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "count")
    private int count;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        count++;
    }
}

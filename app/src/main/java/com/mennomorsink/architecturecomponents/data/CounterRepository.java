package com.mennomorsink.architecturecomponents.data;

import android.arch.lifecycle.LiveData;

public class CounterRepository {

    private LiveData<Counter> counter;
    private CounterDao counterDao;

    public CounterRepository(CounterDao counterDao) {
        this.counterDao = counterDao;
        counterDao.create(new Counter());
        counter = counterDao.getCounter();
    }

    public LiveData<Counter> getCounter() {
        return counter;
    }

    public void increment() {
        Counter c = counter.getValue();
        if (c != null) {
            c.increment();
            counterDao.update(c);
        }
    }
}

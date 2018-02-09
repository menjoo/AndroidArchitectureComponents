package com.mennomorsink.architecturecomponents.data;

/**
 * Created by mennomorsink on 09/02/2018.
 */

public class CounterRepository {

    private Counter counter;
    private CounterDao counterDao;

    public CounterRepository(CounterDao counterDao) {
        this.counterDao = counterDao;
        counter = this.counterDao.findByName(0);
        if (counter == null) {
            counterDao.create(new Counter());
            counter = this.counterDao.findByName(0);
        }
    }

    public int getCount() {
        return counter.getCount();
    }

    public void increment() {
        counter.increment();
        counterDao.update(counter);
    }
}

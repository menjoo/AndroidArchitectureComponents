package com.mennomorsink.architecturecomponents;

/**
 * Created by mennomorsink on 09/02/2018.
 */

class CounterRepository {

    private final Counter counter;
    private CounterDao counterDao;


    CounterRepository(CounterDao counterDao) {
        this.counterDao = counterDao;
        counter = this.counterDao.findByName(0);
        if (counter == null) {
            counterDao.create(new Counter());
        }
    }

    int getCount() {
        return counter.getCount();
    }

    void increment() {
        counter.increment();
        counterDao.update(counter);
    }
}

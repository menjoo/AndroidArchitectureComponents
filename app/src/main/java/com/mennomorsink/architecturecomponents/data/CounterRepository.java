package com.mennomorsink.architecturecomponents.data;

public class CounterRepository {

    private Counter counter;
    private CounterDao counterDao;

    public CounterRepository(CounterDao counterDao) {
        this.counterDao = counterDao;
        counterDao.create(new Counter());
        counter = counterDao.getCounter();
    }

    public Counter getCounter() {
        return counter;
    }

    public void increment() {
        counter.increment();
        counterDao.update(counter);
    }
}

package com.mennomorsink.architecturecomponents;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mennomorsink.architecturecomponents.data.Counter;
import com.mennomorsink.architecturecomponents.data.CounterRepository;

class MainViewModel extends AndroidViewModel {

    private CounterRepository counterRepository;

    private Long mStartTime;

    MainViewModel(Application application) {
        super(application);
        counterRepository = ((MyApplication) application).getCounterRepository();
    }

    LiveData<Counter> getCounter() {
        return counterRepository.getCounter();
    }

    void increment() {
        counterRepository.increment();
    }

    Long getStartTime() {
        return mStartTime;
    }

    void setStartTime(final long startTime) {
        this.mStartTime = startTime;
    }
}

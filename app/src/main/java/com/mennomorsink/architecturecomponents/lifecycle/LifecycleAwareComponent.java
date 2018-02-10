package com.mennomorsink.architecturecomponents.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class LifecycleAwareComponent implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void doStuff() {
        Log.d("Lifecycle listener", "started doing stuff");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void stopDoingStuff() {
        Log.d("Lifecycle listener", "stopped doing stuff");
    }

}

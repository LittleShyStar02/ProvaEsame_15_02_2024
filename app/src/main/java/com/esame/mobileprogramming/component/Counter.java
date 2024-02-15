package com.esame.mobileprogramming.component;

import android.widget.TextView;

import com.esame.mobileprogramming.MainActivity;

public class Counter
{

    private TextView counter;

    private int value;

    public Counter(int counter_id)
    {
        counter = MainActivity.getInstance().findViewById(counter_id);
        value = 0;
        update();
    }

    public void increase()
    {
        value++;
        update();
    }

    public void reset()
    {
        value = 0;
        update();
    }

    public void update()
    {
        counter.setText(String.valueOf(value));
    }

}

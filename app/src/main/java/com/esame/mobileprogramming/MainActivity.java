package com.esame.mobileprogramming;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.esame.mobileprogramming.component.Counter;
import com.esame.mobileprogramming.component.GameField;
import com.esame.mobileprogramming.component.Reset;
import com.esame.mobileprogramming.component.Selector;

public class MainActivity extends AppCompatActivity
{

    private static MainActivity instance;

    private GameField gamefield;
    private Counter counter;

    private Selector selector;
    private Reset reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.instance = this;
        counter = new Counter(R.id.counter);
        gamefield = new GameField((R.id.gamefield));
        selector = new Selector(R.id.selector);
        reset = new Reset(R.id.reset);
        gamefield.play();

    }

    public Selector getSelector()
    {
        return selector;
    }
    public static MainActivity getInstance()
    {
        return instance;
    }

    public Counter getCounter()
    {
        return counter;
    }

    public GameField getGamefield()
    {
        return gamefield;
    }
}
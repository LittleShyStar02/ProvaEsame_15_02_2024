package com.esame.mobileprogramming.component;

import android.widget.Button;

import com.esame.mobileprogramming.MainActivity;

public class Reset
{

    private final Button reset;

    public Reset(int reset_id)
    {
        reset = MainActivity.getInstance().findViewById(reset_id);
        inizializeButton();
    }

    private void inizializeButton()
    {
        reset.setOnClickListener((event) ->
        {
            MainActivity.getInstance().getGamefield().play();
        });
    }

}

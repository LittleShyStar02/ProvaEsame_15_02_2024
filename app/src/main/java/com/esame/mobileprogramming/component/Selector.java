package com.esame.mobileprogramming.component;

import android.widget.Button;
import android.widget.Switch;

import com.esame.mobileprogramming.MainActivity;

public class Selector
{

    private final Switch selector;

    public Selector(int selector_id)
    {
        selector = MainActivity.getInstance().findViewById(selector_id);
        inizializeButton();
    }

    private void inizializeButton()
    {
        selector.setChecked(false);
        selector.setTextOff("R");
        selector.setTextOn("C");
        selector.setOnClickListener((event)->
        {
            if(selector.isChecked())
            {
                selector.setText("C");
            }
            else
            {
                selector.setText("R");
            }
        });

    }

    public String getText()
    {
        return (String) selector.getText();
    }

}

package com.esame.mobileprogramming.component;

import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.esame.mobileprogramming.MainActivity;
import com.esame.mobileprogramming.R;

import java.util.concurrent.ThreadLocalRandom;

public class GameField
{

    private final TableLayout field;
    private final Button bonus;
    private int[][] table;

    public GameField(int field_id)
    {
        field = MainActivity.getInstance().findViewById(field_id);
        bonus = MainActivity.getInstance().findViewById(R.id.bonus);
        bonus.setOnClickListener((event)->
        {
            int type;
            int value;

            type = ThreadLocalRandom.current().nextInt(0, 2);
            value = ThreadLocalRandom.current().nextInt(0, 3);
            switch(type)
            {
                case 0:
                    for(int x = 0;x < 3;x++)
                    {
                        if(x == value)
                        {
                            for(int y = 0;y < 3;y++)
                            {
                                table[x][y] = 0;
                            }
                        }
                    }
                    break;
                case 1:
                    for(int x = 0;x < 3;x++)
                    {
                        if(x == value)
                        {
                            for(int y = 0;y < 3;y++)
                            {
                                table[y][x] = 0;
                            }
                        }
                    }
                    break;
            }
            draw();
            for(int x = 0;x < 15;x++) MainActivity.getInstance().getCounter().increase();
        });
    }

    private void draw() {
        if (field.getChildCount() != 0) field.removeAllViews();
        TableRow row;
        for (int x = 0; x < 3; x++) {
            row = new TableRow(MainActivity.getInstance().getApplicationContext());
            row.setGravity(Gravity.CENTER);

            for (int y = 0; y < 3; y++)
            {
                Button text = new Button(field.getContext());
                text.setLayoutParams(new TableRow.LayoutParams(250,250));
                text.setGravity(Gravity.CENTER);
                text.setBackground(MainActivity.getInstance().getDrawable(R.drawable.box));
                text.setText(String.valueOf(table[x][y]));
                text.setTextSize(36);
                if(MainActivity.getInstance().getSelector().getText().equals("C"))
                {
                    setClickEvent(text,y,table[x][y]);
                }
                if(MainActivity.getInstance().getSelector().getText().equals("R"))
                {
                    setClickEvent(text,x,table[x][y]);
                }
                row.addView(text);
            }
            field.addView(row);
        }

    }

    /*
        Permettiamo di iniziare il gioco
     */
    public void play()
    {
        table = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        swapNumbers(100);
        MainActivity.getInstance().getCounter().reset();
        draw();
    }


    public void setClickEvent(Button button,int value,int number)
    {
        button.setOnClickListener((event) ->
        {
            operate(value,number);
            draw();
            MainActivity.getInstance().getCounter().increase();
        });
    }

    private void operate(int value,int number)
    {
        if(MainActivity.getInstance().getSelector().getText().equals("C"))
        {
            for(int x = 0;x < 3;x++)
            {
                if(x == value)
                {
                    for(int y = 0;y < 3;y++)
                    {
                        table[y][x] = (number + table[y][x])%10;
                    }
                }
            }
        }
        if(MainActivity.getInstance().getSelector().getText().equals("R"))
        {
            for(int x = 0;x < 3;x++)
            {
                if(x == value)
                {
                    for(int y = 0;y < 3;y++)
                    {
                        table[x][y] = (number + table[x][y])%10;
                    }
                }
            }
        }
    }

    private void swapNumbers(int value)
    {
        int posX_1, posX_2, posY_1, posY_2;

        for (int x = 0; x < value; x++) {
            posX_1 = ThreadLocalRandom.current().nextInt(0, 3);
            posY_1 = ThreadLocalRandom.current().nextInt(0, 3);

            posX_2 = ThreadLocalRandom.current().nextInt(0, 3);
            posY_2 = ThreadLocalRandom.current().nextInt(0, 3);

            while (posX_1 == posX_2 && posY_1 == posY_2) {
                posX_2 = ThreadLocalRandom.current().nextInt(0, 3);
                posY_2 = ThreadLocalRandom.current().nextInt(0, 3);
            }

            int tmp = table[posX_1][posY_1];
            table[posX_1][posY_1] = table[posX_2][posY_2];
            table[posX_2][posY_2] = tmp;

        }
    }

}
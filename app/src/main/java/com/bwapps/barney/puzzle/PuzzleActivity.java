package com.bwapps.barney.puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PuzzleActivity extends AppCompatActivity
{
    private TextView boxOne, boxTwo, boxThree;
    private TextView boxFour, boxFive, boxSix;
    private TextView boxSeven, boxEight, boxNine;

    private TextView[] boxes;

    private Button spinButton, insertButton;

    private int[] colourList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        spinButton = (Button) findViewById(R.id.spin_button);

        boxOne = (TextView) findViewById(R.id.box1);
        boxTwo = (TextView) findViewById(R.id.box2);
        boxThree = (TextView) findViewById(R.id.box3);
        boxFour = (TextView) findViewById(R.id.box4);
        boxFive = (TextView) findViewById(R.id.box5);
        boxSix = (TextView) findViewById(R.id.box6);
        boxSeven = (TextView) findViewById(R.id.box7);
        boxEight = (TextView) findViewById(R.id.box8);
        boxNine = (TextView) findViewById(R.id.box9);

        boxes = new TextView[]{boxOne, boxTwo, boxThree, boxFour,
                boxFive, boxSix, boxSeven, boxEight, boxNine};

        Colours.addColours();
        colourList = Colours.getColours();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        boxOne.setBackgroundResource(colourList[0]);
    }

    private void callClear()
    {

    }
}

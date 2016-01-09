package com.bwapps.barney.puzzle;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PuzzleActivity extends AppCompatActivity
{
    private TextView[] boxes;

    private Button spinButton;

    private int[] colourList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        spinButton = (Button) findViewById(R.id.spin_button);

        TextView boxOne = (TextView) findViewById(R.id.box1);
        TextView boxTwo = (TextView) findViewById(R.id.box2);
        TextView boxThree = (TextView) findViewById(R.id.box3);
        TextView boxFour = (TextView) findViewById(R.id.box4);
        TextView boxFive = (TextView) findViewById(R.id.box5);
        TextView boxSix = (TextView) findViewById(R.id.box6);
        TextView boxSeven = (TextView) findViewById(R.id.box7);
        TextView boxEight = (TextView) findViewById(R.id.box8);
        TextView boxNine = (TextView) findViewById(R.id.box9);

        boxes = new TextView[]{boxOne, boxTwo, boxThree, boxFour,
                boxFive, boxSix, boxSeven, boxEight, boxNine};

        Colours.addColours();
        colourList = Colours.getColours();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        for (final TextView box : boxes)
        {
            box.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), String.valueOf(box.getTag()),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        spinButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new CountDownTimer(100, 1000)
                {
                    int animPlayCount = 0;

                    @Override
                    public void onTick(long millisUntilFinished) {}

                    @Override
                    public void onFinish()
                    {
                        Board.fillBoard(boxes, colourList);
                        animPlayCount++;

                        spinButton.setEnabled(false);

                        if (animPlayCount < 10) { start();}
                        else
                        {
                            // final fill
                            Board.fillBoard(boxes, colourList);
                            Result.checkResult(boxes);

                            String resultString = Result.getResultString();

                            Toast.makeText(getBaseContext(),
                                    resultString, Toast.LENGTH_LONG).show();

                            spinButton.setEnabled(true);
                        }
                    }
                }.start();
            }
        });
    }
}

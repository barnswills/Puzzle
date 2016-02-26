package com.bwapps.barney.puzzle;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SlotActivity extends AppCompatActivity
{
    private ImageView[] leftSlot, middleSlot, rightSlot;

    private Button spinButton;

    private int[] slotList;

    private int amountOfSpins = 3;

    private boolean hasPlayerWon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        spinButton = (Button) findViewById(R.id.spin_button);

        ImageView boxOne = (ImageView) findViewById(R.id.box1);
        ImageView boxTwo = (ImageView) findViewById(R.id.box2);
        ImageView boxThree = (ImageView) findViewById(R.id.box3);
        ImageView boxFour = (ImageView) findViewById(R.id.box4);
        ImageView boxFive = (ImageView) findViewById(R.id.box5);
        ImageView boxSix = (ImageView) findViewById(R.id.box6);
        ImageView boxSeven = (ImageView) findViewById(R.id.box7);
        ImageView boxEight = (ImageView) findViewById(R.id.box8);
        ImageView boxNine = (ImageView) findViewById(R.id.box9);

        leftSlot = new ImageView[]{boxOne, boxFour, boxSeven};

        middleSlot = new ImageView[]{boxTwo, boxFive, boxEight};

        rightSlot = new ImageView[]{boxThree, boxSix, boxNine};

        slotList = Slots.getSlotImages();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinSlots(leftSlot);
                spinSlots(middleSlot);
                spinSlots(rightSlot);
            }
        });
    }

    private void spinSlots(final ImageView[] slotSection)
    {
        new CountDownTimer(100, 1000)
        {
            int animPlayCount = 0;

            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish()
            {
                Machine.spinMachineSlot(slotSection, slotList);
                animPlayCount++;

                spinButton.setEnabled(false);

                // plays 10 times
                if (animPlayCount < 10) { start();}
                else
                {
                    spinButton.setEnabled(true);
                    Tags.determineTags(slotSection);

                    amountOfSpins--;

                    if (amountOfSpins <= 0)
                    {
                        Result.checkResult(leftSlot, middleSlot, rightSlot);

                        hasPlayerWon = Result.getHasWon();

                        if (hasPlayerWon)
                        {
                            Toast.makeText(getBaseContext(),
                                    "WINNER!", Toast.LENGTH_SHORT).show();
                        }
                        amountOfSpins = 3;
                    }
                }
            }
        }.start();
    }
}

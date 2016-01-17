package com.bwapps.barney.puzzle;

import android.annotation.TargetApi;
import android.os.Build;
import android.widget.ImageView;

import java.util.Random;


public class Machine
{
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void spinMachineSlot(final ImageView[] slotSection, int[] slotImages)
    {
        // random
        Random random = new Random();
        int randomIndex = random.nextInt(slotImages.length);

        // middle to bottom
        slotSection[2].setBackground(slotSection[1].getBackground());

        // top to middle
        slotSection[1].setBackground(slotSection[0].getBackground());

        // adds random to the top
        slotSection[0].setBackgroundResource(slotImages[randomIndex]);
    }
}

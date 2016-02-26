package com.bwapps.barney.puzzle;

// handles the list of slot images
public class Slots
{
    private static int[] slotImageList = new int[]
            {R.drawable.cherry, R.drawable.diamond, R.drawable.grape,
            R.drawable.orange, R.drawable.raspberry, R.drawable.seven};

    public static int[] getSlotImages()
    {
        return slotImageList;
    }
}

package com.bwapps.barney.puzzle;

public class Colours
{
    private static int[] colourList;

    public static void addColours()
    {
        colourList = new int[]{R.drawable.blue_rect, R.drawable.green_rect,
                                R.drawable.red_rect, R.drawable.white_rect};
    }

    public static int[] getColours()
    {
        return colourList;
    }
}

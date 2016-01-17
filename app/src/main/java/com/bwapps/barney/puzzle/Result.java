package com.bwapps.barney.puzzle;

import android.widget.ImageView;

public class Result
{
    private static boolean hasWon = false;

    public static void checkResult(ImageView[] left, ImageView[] mid, ImageView[] right)
    {
        hasWon = false;

        // splits columns ito rows!
        ImageView[] topRow = new ImageView[]{left[0], mid[0], right[0]};
        ImageView[] midRow = new ImageView[]{left[1], mid[1], right[1]};
        ImageView[] bottomRow = new ImageView[]{left[2], mid[2], right[2]};

        // checks each row
        checkRowContents(topRow);
        if (!hasWon) checkRowContents(midRow);
        if (!hasWon) checkRowContents(bottomRow);
    }

    private static void checkRowContents(ImageView[] row)
    {
        String first = String.valueOf(row[0].getTag());

        if (first.equals(String.valueOf(row[1].getTag())) &&
                first.equals(String.valueOf(row[2].getTag())))
        {
            hasWon = true;
        }
    }

    public static boolean getHasWon()
    {
        return hasWon;
    }
}

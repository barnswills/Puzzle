package com.bwapps.barney.puzzle;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public class Tags
{
    public static void determineTags(ImageView[] slots)
    {
        for (ImageView slot : slots)
        {
            Bitmap bitmap = ((BitmapDrawable)slot.getBackground()).getBitmap();

            slot.setTag(bitmap);
        }
    }
}

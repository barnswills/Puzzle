package com.bwapps.barney.puzzle;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public class Tags
{
    // changes tag to the corresponding image name
    public static void determineTags(ImageView[] slots)
    {
        for (ImageView slot : slots)
        {
            Bitmap bitmap = ((BitmapDrawable)slot.getBackground()).getBitmap();

            slot.setTag(bitmap);
        }
    }
}
